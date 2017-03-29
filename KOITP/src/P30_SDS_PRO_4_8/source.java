package P30_SDS_PRO_4_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

// http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220820773477
public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	int MAX = 17;
	int N;
	int p[][];
	int depth[];
	boolean visit[];
	ArrayList<Integer>[] edges;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P30_SDS_PRO_4_8.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		p = new int[MAX+1][N+1];
		depth = new int[N+1];
		visit = new boolean[N+1];
		edges = new ArrayList[N+1];
		for(int i = 1; i <= N; i++){
			edges[i] = new ArrayList<>();
		}
		int f, t;
		String [] input;
		for(int i = 1; i < N; i++){
			input = br.readLine().split(" ");
			f = Integer.parseInt(input[0]);
			t = Integer.parseInt(input[1]);
			
			edges[f].add(t);
			edges[t].add(f);
		}
		
		
		dfs(1, 1); // make parent[0] and depth
		for(int i = 1; i <= MAX; i++){
			for(int j = 1; j <= N; j++){
				if(p[i-1][j] == 0){
					continue;
				}
				
				p[i][j] = p[i-1][p[i-1][j]];
				
			}
		}
		
//		for(int i = 0; i <= 3; i++){
//			print(p[i]);
//		}
//		print(depth);
		long ret = 0;
		for(int i = 1; i <N; i++){
			int u = i; int v = i + 1;
			
			// depth[u] >= depth[v]가 되도록 필요에 따라 u, v를 스왑
			if(depth[u] < depth[v]){
				int temp = u;
				u = v;
				v = temp;
			}
			
			// 깊이 차(diff)를 없애며 u를 이동시킴
			int diff = depth[u] - depth[v];
			for(int j = 0; diff > 0; j++){
				if((diff & 1) == 1){
					u = p[j][u];
				}
				diff >>= 1;
			}
			// u와 v가 다르면 동시에 일정 높이만큼 위로 이동시킴
			if(u != v){
				// 높이 2^17, 2^16, ..., 2^2, 2, 1 순으로 시도
				for(int j = MAX; j >= 0; j--){
					if(p[j][u] != 0 && p[j][u] != p[j][v]){
						u = p[j][u];
						v = p[j][v];
					}
				}
				 // 마지막엔 두 정점 u, v의 부모가 같으므로 한 번 더 올림
				u = p[0][u];
			}
			ret += (long)(depth[i] - depth[u]) + (long)(depth[i+1] - depth[u]);
//			System.out.println(i + "," + (i+1) + "=" + u );
		}
//		print(visit);
		bw.write(ret + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	
	void dfs(int v, int d){
		depth[v] = d;
		visit[v] = true;
		for(int i = 0; i < edges[v].size(); i++){
			if(!visit[edges[v].get(i)]){
				p[0][edges[v].get(i)] = v;
				dfs(edges[v].get(i), d + 1);
			}
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

