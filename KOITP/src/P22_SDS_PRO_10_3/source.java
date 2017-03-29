package P22_SDS_PRO_10_3;

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
	
	int N, M;
	int MAX = 2000000;
	Vertex[] vs;
	Vertex[] tsort;
	ArrayList<Edge>[] adjs;
	int count, tcount;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P22_SDS_PRO_10_3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] input;
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		vs = new Vertex[N+1];
		tsort = new Vertex[N+1];
		adjs = new ArrayList[N+1];
		
		tcount = N;
		count = 1;
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
		}
		for(int i = 1; i <= N; i++){
			if(vs[i].dtime == MAX){
				dfs(i);
			}
		}
		
		int index = 1;
		for(int i = 0; i <= N; i++){
			if(tsort[i] != null && tsort[i].v == 1){
				index = i;
				break;
			}
		}
		tsort[index].d = 0;
//		for(int i = 1; i <=N; i++){
//			print(adjs[i].toArray());
//		}
//		print(tsort);
		for(int i = index; i <= N; i++){
			for(Edge e : adjs[tsort[i].v]){
				int cnum = tsort[i].v; // 현재 v 번호
				int tnum = e.to; // 대상 v 번호
				vs[tnum].d = Math.min(vs[tnum].d, vs[cnum].d + e.dist);
				
			}
//			print(tsort);
		}
		bw.write(String.valueOf(vs[N].d!=Long.MAX_VALUE?vs[N].d:-1) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	void dfs(int v){
		vs[v].dtime = count++;
		vs[v].visit = true;
		
		for(Edge e : adjs[v]){
			if(vs[e.to].dtime == MAX){
				dfs(e.to);
			}
		}
		vs[v].ftime = count++;
		tsort[tcount--] = vs[v];
	}
	public class Vertex{
		int v;
		long d;
		boolean visit;
		
		int dtime;
		int ftime;
		public Vertex(int v){
			this.v = v;
			this.d = Long.MAX_VALUE;
			this.dtime = MAX;
		}
		@Override
		public String toString() {
			return "[" + v + ", " + d + ", " + dtime + "/" + ftime + "]";
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

