package P26_SDS_PRO_4_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	int [] vs;
	boolean [] visit;
	ArrayList<Integer>[] adjs;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P26_SDS_PRO_4_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		int K, N, M;
		String [] input;
		input = br.readLine().split(" ");
		K = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		M = Integer.parseInt(input[2]);
		
		int cows[] = new int[K];
		for(int i = 0; i < K; i++){
			cows[i] = Integer.parseInt(br.readLine());
		}
		vs = new int[N+1];
		visit = new boolean[N+1];
		adjs = new ArrayList[N+1];
		for(int i = 0; i <= N; i++){
			adjs[i] = new ArrayList<>();
		}
		int n1, n2;
		for(int i = 0; i < M; i++){
			input = br.readLine().split(" ");
			n1 = Integer.parseInt(input[0]);
			n2 = Integer.parseInt(input[1]);
			adjs[n1].add(n2);
		}
		
		for(int c = 0; c < K; c++){
			for(int i = 0; i <= N; i++){
				visit[i] = false;
			}
			dfs(cows[c]);
		}
//		print(vs);
		int ret = 0;
		for(int i = 1; i <= N; i++){
			if(vs[i] == K){
				ret++;
			}
		}
		bw.write(ret + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public void dfs(int v){
		vs[v]++;
		visit[v] = true;
		for(int next : adjs[v]){
			if(!visit[next]){
				dfs(next);
			}
		}
	}
	public class Node{
		int x;
		int y;
		public Node(int x, int y){
			this.x = x;
			this.y = y;
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

