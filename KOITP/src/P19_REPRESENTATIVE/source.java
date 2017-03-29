package P19_REPRESENTATIVE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	int N, M;
	int arr[];
	long tsum[];
	int tmin[];
	int tmax[];
	public void solve() throws Exception {
//		System.setIn(new FileInputStream("input/P19_REPRESENTATIVE.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		tsum = new long[4*N];
		tmin = new int[4*N];
		tmax = new int[4*N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		initTSum(1, 1, N);
		initTMin(1, 1, N);
		initTMax(1, 1, N);
//		print(arr);
//		print(tsum);
//		print(tmin);
//		print(tmax);
		
		String [] input;
		M = Integer.parseInt(br.readLine().trim());
		int n1, n2;
		for(int i = 0; i < M; i++){
			StringBuffer sb = new StringBuffer();
			input = br.readLine().split(" ");
			n1 = Integer.parseInt(input[0]);
			n2 = Integer.parseInt(input[1]);
			sb.append(String.valueOf(queryTMin(1, 1, N, n1, n2)));
			sb.append(" ");
			sb.append(String.valueOf(queryTMax(1, 1, N, n1, n2)));
			sb.append(" ");
			sb.append(String.valueOf(queryTSum(1, 1, N, n1, n2)));
			sb.append("\n");
			bw.write(sb.toString());
		}
//		System.out.println(queryTSum(1, 1, N, 1, 2));
//		System.out.println(queryTMin(1, 1, N, 4, 5));
//		System.out.println(queryTMax(1, 1, N, 2, 3));
		bw.flush();
		br.close();
		bw.close();
	}
	
	public long initTSum(int node, int start, int end){
		if(start == end){
			return tsum[node] = arr[start];
		}
		int mid = (start + end) / 2;
		return tsum[node] = initTSum(2 * node, start, mid) + initTSum(2 * node + 1, mid + 1, end);
	}
	
	public int initTMin(int node, int start, int end){
		if(start == end){
			return tmin[node] = arr[start];
		}
		int mid = (start + end) / 2;
		return tmin[node] = Math.min(initTMin(2 * node, start, mid), initTMin(2 * node + 1, mid + 1, end));
	}
	
	public int initTMax(int node, int start, int end){
		if(start == end){
			return tmax[node] = arr[start];
		}
		int mid = (start + end) / 2;
		return tmax[node] = Math.max(initTMax(2 * node, start, mid), initTMax(2 * node + 1, mid + 1, end));
	}
	
	public long queryTSum(int node, int start, int end, int left, int right){
		if(end < left || start > right){
			return 0;
		}
		if(start >= left && end <= right){
			return tsum[node];
		}
		int mid = (start + end) / 2;
		return queryTSum(2 * node, start, mid, left, right) + queryTSum(2 * node + 1, mid + 1, end, left, right);
	}
	
	public int queryTMin(int node, int start, int end, int left, int right){
		if(start > right || end < left){
			return 1000000001;
		}
		
		if(start >= left && end <= right){
			return tmin[node];
		}
		int mid = (start + end) / 2;
		return Math.min(queryTMin(2 * node, start, mid, left, right), queryTMin(2 * node + 1, mid + 1, end, left, right));
	}
	
	public int queryTMax(int node, int start, int end, int left, int right){
		if(start > right || end < left){
			return -1;
		}
		
		if(start >= left && end <= right){
			return tmax[node];
		}
		int mid = (start + end) / 2;
		return Math.max(queryTMax(2 * node, start, mid, left, right), queryTMax(2 * node + 1, mid + 1, end, left, right));
	}
	
	
	public void print(int [] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	public void print(long [] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	public void print(int [][] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}

