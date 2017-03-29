package P35_SDS_PRO_6_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;



public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P35_SDS_PRO_6_1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int map[][] = new int[N+1][N+1];
		int dp[][] = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i == 1){
					dp[i][j] = map[i][j] + dp[i][j-1];
				}
			}
		}
		
		for(int i = 2; i <= N; i++){
			for(int j = 1; j <= N; j++){
				dp[i][j] = Math.max(dp[i-1][j] + map[i][j], dp[i][j-1] + map[i][j]);
			}
		}
		bw.write(dp[N][N] + "\n");
//		print(map);
//		print(dp);
		bw.flush();
		br.close();
		bw.close();
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

