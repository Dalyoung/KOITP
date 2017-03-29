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
 * DEQUE�� ����ϸ� O(N)�� �ذ� ����.
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
		
		// priority queue�� �ΰ� �����. min��, max��.
		// queue�� num ���� �ش� ���� index�� ���� �����Ѵ�.
		// �����϶� ���� queue�� �ֻ�� ���� �ε����� ����, �������� ����� ��������.
		// index�� ������� �ش� ���� �ּҰ��̳� �ִ밪�� �ƴϸ� queue���� ���� �ʾƵ� �ȴ�.
		// ���߿� �� ���� �ִ볪 �ּҰ� �ɶ� index�� Ȯ���ؼ� ���ָ� �ȴ�.
		
		PriorityQueue<Node> minq = new PriorityQueue<>();
		PriorityQueue<Node> maxq = new PriorityQueue<>();
		long sum = 0;
		// �ʱ� 0~K ��ŭ
		for(int i = 0; i < K; i++){
			minq.add(new Node(arr[i], i));
			maxq.add(new Node(-arr[i], i));
			sum += arr[i];
		}
		bw.write(getString(minq.peek().num, maxq.peek().num, sum) + "\n");
		
		// ������ N ���� �ݺ�
		for(int i = 1; i < N-K+1; i++){
			
			minq.add(new Node(arr[i+K-1], i+K-1));
			maxq.add(new Node(-arr[i+K-1], i+K-1));
			
			// minq�� �ּҰ��� index�� i ���� ���� ��(������ ��� ��) �ش� ���� �����Ѵ�.
			while(true){
				int index = minq.peek().index;
				if(index < i){
					minq.poll();
				}else{
					break;
				}
			}
			// maxq�� �ִ밪�� index�� i ���� ���� ��(������ ��� ��) �ش� ���� �����Ѵ�.
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

