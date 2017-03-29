package P20_SDS_PRO_10_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	int V, E, S;
	Edge [] edges;
	boolean visit[];
	ArrayList<Integer>[] adj;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P20_SDS_PRO_10_1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String [] input;
		input = br.readLine().split(" ");
		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);
		S = Integer.parseInt(input[2]);
		adj = new ArrayList[V+1];
		visit = new boolean[V+1];
		for(int i = 0; i <= V; i++){
			adj[i] = new ArrayList<Integer>();
		}
		edges = new Edge[E];
		int num1, num2;
		for(int i = 0; i < E; i++){
			input = br.readLine().split(" ");
			num1 = Integer.parseInt(input[0]);
			num2 = Integer.parseInt(input[1]);
			if(num1 > num2){
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}
			edges[i] = new Edge(num1, num2);
		}
		
		Arrays.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				if(o1.from != o2.from){
					return o1.from - o2.from;
				}else{
					return o1.to - o2.to;
				}
			}
		});
		
		for(int i = 0; i < E; i++){
			adj[edges[i].from].add(edges[i].to);
			adj[edges[i].to].add(edges[i].from);
		}
		sb = new StringBuffer();
		
		dfs(S);
		bw.write(sb.append("\n").toString());
		
		for(int i = 0; i <= V; i++){
			visit[i] = false;
		}
		sb = new StringBuffer();
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		visit[S] = true;
		while(!q.isEmpty()){
			int v = q.poll();
			sb.append(String.valueOf(v)).append(" ");
			
			for(int next : adj[v]){
				if(!visit[next]){
					q.add(next);
					visit[next] = true;
				}
			}
		}
		bw.write(sb.append("\n").toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	StringBuffer sb;
	void dfs(int v){
		sb.append(String.valueOf(v)).append(" ");
		visit[v] = true;
		for(int next : adj[v]){
			if(!visit[next]){
				dfs(next);
			}
		}
	}
	class Edge{
		int from;
		int to;
		public Edge(int f, int t){
			this.from = f;
			this.to = t;
		}
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + "]";
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

