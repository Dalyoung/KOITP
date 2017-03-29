package P15_SLIDING_WINDOWS;

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

/**
 * 
 * DEQUE를 사용하면 O(N)에 해결 가능.
 *
 */
public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	int N, K;
	int arr[];
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P15_SLIDING_WINDOWS.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
//		print(arr);
		
		// priority queue를 두개 만든다. min값, max값.
		// queue에 num 값과 해당 값의 index를 같이 저장한다.
		// 움직일때 마다 queue의 최상단 값의 인덱스를 비교해, 범위에서 벗어나면 빼버린다.
		// index를 벗어나더라도 해당 값이 최소값이나 최대값이 아니면 queue에서 빼지 않아도 된다.
		// 나중에 그 값이 최대나 최소가 될때 index를 확인해서 빼주면 된다.
		
		PriorityQueue<Node> minq = new PriorityQueue<>();
		PriorityQueue<Node> maxq = new PriorityQueue<>();
		long sum = 0;
		// 초기 0~K 만큼
		for(int i = 0; i < K; i++){
			minq.add(new Node(arr[i], i));
			maxq.add(new Node(-arr[i], i));
			sum += arr[i];
		}
		bw.write(getString(minq.peek().num, maxq.peek().num, sum) + "\n");
		
		// 나머지 N 까지 반복
		for(int i = 1; i < N-K+1; i++){
			
			minq.add(new Node(arr[i+K-1], i+K-1));
			maxq.add(new Node(-arr[i+K-1], i+K-1));
			
			// minq의 최소값의 index가 i 보다 작을 때(범위를 벗어날 때) 해당 값을 제거한다.
			while(true){
				int index = minq.peek().index;
				if(index < i){
					minq.poll();
				}else{
					break;
				}
			}
			// maxq의 최대값의 index가 i 보다 작을 때(범위를 벗어날 때) 해당 값을 제거한다.
			while(true){
				int index = maxq.peek().index;
				if(index < i){
					maxq.poll();
				}else{
					break;
				}
			}
			
			sum -= arr[i-1];
			sum += arr[i+K-1];
			bw.write(getString(minq.peek().num, maxq.peek().num, sum) + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public String getString(int min, int max, long sum){
		StringBuffer sb = new StringBuffer();
		sb.append(min);
		sb.append(" ");
		sb.append(-max);
		sb.append(" ");
		sb.append(sum);
		return sb.toString();
	}
	
	public class Node implements Comparable<Node>{
		int num;
		int index;
		public Node(int num, int index) {
			super();
			this.num = num;
			this.index = index;
		}
		@Override
		public String toString() {
			return "[" + num + ", " + index + "]";
		}
		@Override
		public int compareTo(Node n) {
			// TODO Auto-generated method stub
			return this.num - n.num;
		}
		
	}
	
	
	
	public void print(int [] arr){
		System.out.println(Arrays.toString(arr));
	}
	public void print(int [][] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}

