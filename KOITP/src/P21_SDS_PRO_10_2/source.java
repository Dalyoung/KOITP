package P21_SDS_PRO_10_2;

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
	
	int V, E;
	int MAX = 500000;
	ArrayList<Integer>[] adj;
	Vertex [] vs;
	int ans[];
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P21_SDS_PRO_10_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] input;
		input = br.readLine().split(" ");
		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);
		vs = new Vertex[V+1];
		adj = new ArrayList[V+1];
		ans = new int[V+1];
		ansCount = V;
		for(int i = 0; i <= V; i++){
			vs[i] = new Vertex(i);
			adj[i] = new ArrayList();
		}
		
		int num1, num2;
		for(int i = 0; i < E; i++){
			input = br.readLine().split(" ");
			num1 = Integer.parseInt(input[0]);
			num2 = Integer.parseInt(input[1]);
			adj[num1].add(num2);
		}
		for(int i = 1; i <= V; i++){
			if(vs[i].dtime == MAX){
				dfs(i);
			}
		}
		
		for(int i = 1; i <= V; i++){
			bw.write(String.valueOf(ans[i]) + " ");
		}
		bw.write("\n");
		bw.flush();
		br.close();
		bw.close();
	}
	int count = 1;
	int ansCount;
	void dfs(int v){
		vs[v].dtime = count++;
		for(int next : adj[v]){
			if(vs[next].dtime == MAX){
				dfs(next);
			}
		}
		vs[v].ftime = count++;
		ans[ansCount--] = v;
	}
	public class Vertex{
		int v;
		int dtime;
		int ftime;
		
		public Vertex(int v){
			this.v = v;
			this.dtime = MAX;
			this.ftime = MAX;
		}

		@Override
		public String toString() {
			return "[v=" + v + ", dtime=" + dtime + ", ftime=" + ftime + "]";
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

