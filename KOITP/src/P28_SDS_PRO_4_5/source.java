package P28_SDS_PRO_4_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	int MAX = 50000000;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P28_SDS_PRO_4_5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N, M, X;
		String [] input;
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		X = Integer.parseInt(input[2]);
		
		Vertex [] vs = new Vertex[N+1];
		Vertex [] rvs = new Vertex[N+1];
		ArrayList<Edge> []es = new ArrayList[N+1];
		ArrayList<Edge> []res = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++){
			vs[i] = new Vertex(i);
			rvs[i] = new Vertex(i);
			es[i] = new ArrayList<>();
			res[i] = new ArrayList<>();
		}
		
		int f, t, d;
		for(int i = 0; i < M; i++){
			input = br.readLine().split(" ");
			f = Integer.parseInt(input[0]);
			t = Integer.parseInt(input[1]);
			d = Integer.parseInt(input[2]);
			
			es[f].add(new Edge(t, d));
			res[t].add(new Edge(f, d));
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		vs[X].time = 0;
		pq.add(X);
		
		while(!pq.isEmpty()){
			int cur = pq.poll();
//			vs[cur].visit = true;
			for(Edge e : es[cur]){
//				if(vs[e.to].visit){
//					continue;
//				}
				if(vs[e.to].time > vs[cur].time + e.dist){
					pq.add(e.to);
					vs[e.to].time = vs[cur].time + e.dist;
				}
			}
					
		}
		
		
		pq = new PriorityQueue<>();
		rvs[X].time = 0;
		pq.add(X);
		
		while(!pq.isEmpty()){
			int cur = pq.poll();
//			rvs[cur].visit = true;
			for(Edge e : res[cur]){
//				if(rvs[e.to].visit){
//					continue;
//				}
				if(rvs[e.to].time > rvs[cur].time + e.dist){
					pq.add(e.to);
					rvs[e.to].time = rvs[cur].time + e.dist;
				}
			}
					
		}
		
//		print(vs);
//		print(rvs);
		int max = 0;
		for(int i = 1; i <= N; i++){
//			if(vs[i].visit && rvs[i].visit)
			max = Math.max(vs[i].time + rvs[i].time, max);
		}
		bw.write(max + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	
	public class Vertex{
		int v;
		int time;
		boolean visit;
		public Vertex(int v){
			this.v = v;
			this.visit = false;
			this.time = MAX;
		}
		@Override
		public String toString() {
			return "Vertex [v=" + v + ", time=" + time + ", visit=" + visit + "]";
		}
		
	}
	
	public class Edge{
		int to;
		int dist;
		public Edge(int t, int d){
			this.to = t;
			this.dist = d;
		}
		@Override
		public String toString() {
			return "[to=" + to + ", dist=" + dist + "]";
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

