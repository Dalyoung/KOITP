package P31_MILITARY_ROAD_NETWORK;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

// MST. ������ MST�� ������ ����..
// ���� ������ ���� �ٸ�. a + b = x1 + x2
// 1 - �ٸ� ���������� cost�� ���� ���. ��ü �����ؾ� ��.
// 2 - ���� �� �ٸ����� ���� ���� ���? -> �� ���ɼ��� 0. ��?
//
/**
 * Kruskal's Algorithm.
 * cost�� ���� �͵��� �ѹ��� ó��.
 * union find�� �� ���� ���Ѵ�.
 * �� �ܰ谡 ������ ��, ���õ� ���� cost�� union find�� ���� �� ���� ���� ���� ���������� �������� �ʴ�.
 * ���� ��, � ���� ������ �� ���� ���� �� ���� �����͸� �̵�.
 * 
 * ���� ��ȣ�� ������ ����, �� ��ȣ�� �ٸ� �͵��� ���� ����. �� �� ũ�罺Į���� ���õ� ������ �� ��ȣ �ٸ��͵��� ���� ���� ������ unique ���� �ʴ�.
 * 
 * ���θ� �̸� ����. ���� ���� SUM�� ���Ѵ�.
 * �׸��� �ش� �������� ����������..
 * 
 */


public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	int N, M, K;
	long sum = 0;
	int p[];
	Edge [] edges;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P31_MILITARY_ROAD_NETWORK.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String [] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		p = new int[N+1];
		edges = new Edge[M + K];
		for(int i = 1; i <= N; i++){
			p[i] = i;
		}
		
		int f, t, d;
		for(int i = 0; i < M; i++){
			input = br.readLine().split(" ");
			f = Integer.parseInt(input[0]);
			t = Integer.parseInt(input[1]);
			d = Integer.parseInt(input[2]);
			sum += d;
			edges[i] = new Edge(f, t, -d);
		}
		
		for(int i = 0; i < K; i++){
			input = br.readLine().split(" ");
			f = Integer.parseInt(input[0]);
			t = Integer.parseInt(input[1]);
			d = Integer.parseInt(input[2]);
//			sum += d;
			edges[i+M] = new Edge(f, t, d);
		}
		Arrays.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.dist - o2.dist;
			}
		});
//		print(edges);
		
		int n1, n2;
		boolean isUnique = true;
		int j = 0;
		int count = 0;
		int count2 = 0;
		int last = 1000000001;
		for(int i = 0; i < edges.length; i++){
			Edge e = edges[i];
			
			n1 = find(e.from);
			n2 = find(e.to);
			if(n1 != n2){
				p[n1] = n2;
				sum += e.dist;
			}
//			System.out.println(count + ", " + count2);
		}
		
//		print(p);
		bw.write(sum + " " + (isUnique?"unique":"not unique") + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	int find(int v){
		if(v == p[v]){
			return v;
		}
		return p[v] = find(p[v]);
	}
	
	
	public class Edge{
		int from;
		int to;
		int dist;
		
		public Edge(int f, int t, int d){
			this.from = f;
			this.to = t;
			this.dist = d;
		}

		@Override
		public String toString() {
			return "[from=" + from + ", to=" + to + ", dist=" + dist + "]";
		}
		
	}
	
	public void print(char [] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	public void print(int [] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	public void print(long [] arr){
		System.out.println(Arrays.toString(arr));
	}
	public void print(Object [] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	public void print(int [][] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}

