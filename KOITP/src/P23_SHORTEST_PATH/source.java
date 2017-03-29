package P23_SHORTEST_PATH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P23_SHORTEST_PATH.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N, M;
		String [] input;
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		Vertex[] vs = new Vertex[N+1];
		ArrayList<Edge>[] adjs = new ArrayList[N+1];
		for(int i = 0; i <= N; i++){
			vs[i] = new Vertex(i);
			adjs[i] = new ArrayList<>();
		}
		int f, t, d;
		for(int i = 0; i < M; i++){
			input = br.readLine().split(" ");
			f = Integer.parseInt(input[0]);
			t = Integer.parseInt(input[1]);
			d = Integer.parseInt(input[2]);
			adjs[f].add(new Edge(t, d));
			adjs[t].add(new Edge(f, d));
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>(N, new Comparator<Vertex>() {

			@Override
			public int compare(Vertex v1, Vertex v2) {
				return (int)(v1.d - v2.d);
			}
		});
		vs[1].d = 0;
		pq.add(vs[1]);
		while(!pq.isEmpty()){
			Vertex cur = pq.poll();
			cur.visit = true;
			for(Edge e : adjs[cur.v]){
				if(!vs[e.to].visit){
					long temp = cur.d + e.dist;
					if(vs[e.to].d == -1 || temp < vs[e.to].d){
						vs[e.to].d = temp;
						pq.add(vs[e.to]);
					}
				}
			}
		}
		bw.write(String.valueOf(vs[N].d) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	public class Vertex{
		int v;
		long d;
		boolean visit;
		public Vertex(int v){
			this.v = v;
			this.d = -1;
			this.visit = false;
		}
		@Override
		public String toString() {
			return "[" + v + ", " + d + ", " + (visit?1:0) + "]";
		}
		
	}
	
	public class Edge{
		int to;
		long dist;
		public Edge(int to, long dist){
			this.to = to;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return "[" + to + ", " + dist + "]";
		}
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

