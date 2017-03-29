package P24_SDS_PRO_10_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Kruscal's Algorithm
public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
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
	
	int N, M;
	Edge[] edges;
	int [] p;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P24_SDS_PRO_10_4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		p = new int[N+1];
		for(int i = 1; i <= N; i++){
			p[i] = i;
		}
		edges = new Edge[M];
		String [] input;
		int f, t, d;
		for(int i = 0; i < M; i++){
			input = br.readLine().split(" ");
			f = Integer.parseInt(input[0]);
			t = Integer.parseInt(input[1]);
			d = Integer.parseInt(input[2]);
			edges[i] = new Edge(f, t, d);
		}
		
		Arrays.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge arg0, Edge arg1) {
				return arg0.dist - arg1.dist;
			}
		});
//		print(p);
//		print(edges);
		long ret = 0;
		int n1, n2;
		for(int i = 0; i < M; i++){
			n1 = find(edges[i].from);
			n2 = find(edges[i].to);
			if(n1 != n2){
				ret += edges[i].dist;
				union(n1, n2);
			}
		}
//		print(p);
		bw.write(ret + "\n");
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
	
	void union(int n1, int n2){
		n1 = find(n1);
		n2 = find(n2);
		if(n1 == n2){
			return;
		}
		p[n1] = n2;
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

