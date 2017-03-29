package P28_SDS_PRO_4_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class source4 {
	public static void main(String[] args) throws Exception {
		source4 s = new source4();
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
		int map [][] = new int[N+1][N+1];
		
		Vertex [] vs = new Vertex[N+1];
		ArrayList<Edge> []es = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++){
			Arrays.fill(map[i], MAX);
			
			vs[i] = new Vertex(i);
			es[i] = new ArrayList<>();
		}
		
		
		int f, t, d;
		for(int i = 0; i < M; i++){
			input = br.readLine().split(" ");
			f = Integer.parseInt(input[0]);
			t = Integer.parseInt(input[1]);
			d = Integer.parseInt(input[2]);
			map[f][t] = d;
			
			es[f].add(new Edge(t, d));
		}
		
//		for(int i = 0; i < N; i++){
//			print(map[i]);
//		}
		for(int k = 1; k <=N; k++){
			for(int i = 1; i <= N; i++){
						map[i][X] = Math.min(map[i][X], map[i][k] + map[k][X]);
			}
		}
		
		
		int ret = 0;
//		for(int i = 1; i <= N; i++){
//			ret = Math.max(ret, map[i][X] + map[X][i]);
//		}
		
//		for(int i = 0; i <= N; i++){
//			print(map[i]);
//		}
		
		PriorityQueue<Integer>pq = new PriorityQueue<>(N);
		pq.add(X);
		vs[X].time = 0;
		while(!pq.isEmpty()){
			int num = pq.poll();
			vs[num].visit = true;
			for(Edge e : es[num]){
				if(!vs[e.to].visit){
					vs[e.to].time = Math.min(vs[e.to].time, vs[num].time + e.dist);
					pq.add(e.to);
				}
			}
		}
//		print(vs);
		for(int i = 1; i <= N; i++){
			if(i != X && map[i][X] != MAX){
				ret = Math.max(ret, map[i][X] + vs[i].time);
			}
		}
		bw.write(ret + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	
	
	public class Vertex{
		int v;
		int time = MAX;
		boolean visit;
		public Vertex(int v){
			this.v = v;
			this.visit = false;
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

