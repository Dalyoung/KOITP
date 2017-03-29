package P17_SDS_PRO_3_5;

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
	
	
	int N, Q;
	int arr[];
	long sum[];
	public void solve() throws Exception {
//		System.setIn(new FileInputStream("input/P17_SDS_PRO_3_5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine().trim());
		Q = Integer.parseInt(br.readLine().trim());
		arr = new int[N+1];
		for(int i = 1; i <= N; i++){
			arr[i] = i;
		}
		sum = new long[4*N];
		initSum(1, 1, N);
		
		String [] input;
		int t, n1, n2;
		for(int i = 0; i < Q; i++){
			input = br.readLine().split(" ");
			t = Integer.parseInt(input[0]);
			n1 = Integer.parseInt(input[1]);
			n2 = Integer.parseInt(input[2]);
			if(t == 1){
				bw.write(String.valueOf(query(1, 1, N, n1, n2)) + "\n");
			}else{
				int diff = n2 - arr[n1];
				arr[n1] = n2;
				update(1, 1, N, n1, diff);
			}
		}
//		System.out.println(Arrays.toString(sum));
//		update(1, 1, N, 5, 2);
//		System.out.println(Arrays.toString(sum));
//		System.out.println(query(1, 1, N, 1, 3));
//		System.out.println(query(1, 1, N, 1, 5));
		bw.flush();
		br.close();
		bw.close();
	}
	
	public long initSum(int node, int start, int end){
		if(start == end){
			sum[node] = arr[start];
			return sum[node];
		}
		int m = (start+end)/2;
		return sum[node] = initSum(2 * node, start, m) + initSum(2 * node + 1, m+1, end);
	}
	
	public void update(int node, int start, int end, int index, long num){
//		print(node, start, end, index, num);
		if(index < start || index > end){
			return;
		}
		sum[node] += num;
		if(start != end){
			int m = (start + end)/2;
			update(2 * node, start, m, index, num);
			update(2 * node + 1, m+1, end, index, num);
		}
	}
	public long query(int node, int start, int end, int left, int right){
//		System.out.println(index + "," + start + "," + end + "," + left + "," + right);
		if(start > right || end < left){
			return 0;
		}
		if(end <= right && start >= left){
			return sum[node];
		}
		int m = (start + end) / 2;
		return query(2 * node, start, m, left, right) + query(2 * node + 1, m + 1, end, left, right);
	}
	public void print(Object ... args){
		System.out.println(Arrays.toString(args));
	}
	
	public void print(int [][] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}

