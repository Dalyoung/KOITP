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

// Prim's Algorithm
public class source2 {
	public static void main(String[] args) throws Exception {
		source2 s = new source2();
		s.solve();
	}
	
	int N, M;
	public class Vertex{
		int v;
		int dist;
		boolean visit;
		public Vertex(int v){
			this.v = v;
		}
		@Override
		public String toString() {
			return "[v=" + v + ", dist=" + dist + ", visit=" + visit + "]";
		}
		
		
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
	
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P24_SDS_PRO_10_4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		
		Vertex[] vs = new Vertex[N+1];
		ArrayList<Edge>[] es = new ArrayList[N+1];
		StringTokenizer st;
		for(int i = 0; i <= N; i++){
			vs[i] = new Vertex(i);
			es[i] = new ArrayList<Edge>();
		}
		
		int f, t, d;
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine(), " ");
			f = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			es[f].add(new Edge(f, t, d));
			es[t].add(new Edge(t, f, d));
		}
	
//		print(vs);
//		for(int i = 1; i <= N; i++){
//			print(es[i].toArray());
//		}
		
		// Prim's algorithm..
		// PQ에 edge를..
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(M, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				// TODO Auto-generated method stub
				if(e1.dist - e2.dist == 0){
					return e1.from - e2.from;
				}
				return e1.dist - e2.dist;
			}
		});
		
		// 1번이 시작점이 될 수 있게 하나 생성해서 넣는다.
		pq.add(new Edge(1, 1, 0));
		long ret = 0;
		while(!pq.isEmpty()){
			Edge cur = pq.poll();
			if(vs[cur.to].visit){
				continue;
			}
			vs[cur.to].visit = true;
			vs[cur.to].dist = cur.dist;
			ret += cur.dist;
			for(Edge e : es[cur.to]){
				if(!vs[e.to].visit){
					pq.add(e);
				}
			}
//			print(vs);
//			print(pq.toArray());
		}
//		print(vs);
		bw.write(ret + "\n");
		bw.flush();
		br.close();
		bw.close();
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

