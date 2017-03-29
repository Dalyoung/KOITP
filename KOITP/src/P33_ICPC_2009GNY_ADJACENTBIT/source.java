package P33_ICPC_2009GNY_ADJACENTBIT;

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
	
	/**
	 * d[N, K] == 길이 = N 이고 인접한 비트의 수가 K인 것.
	 * d[N, K, 0] - 끝자리가 0인
	 * d[N, K, 1] - 끝자리가 1인
	 * 
	 * d[1, 0, 1] = d[1, 0, 0] = 1
	 * 
	 * d[i, j, 1] = d[i-1, j, 0] + d[i-1, j-1, 1]
	 * d[i, j, 0] = d[i-1, j, 0] + d[i-1, j, 1]
	 */
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P33_ICPC_2009GNY_ADJACENTBIT.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T, N, K;
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++){
			String [] input = br.readLine().split(" ");
			N = Integer.parseInt(input[1]);
			K = Integer.parseInt(input[2]);
			
			long dp[][][] = new long[2][K+1][N+1];
			dp[0][0][1] = 1;
			dp[1][0][1] = 1;
			for(int k = 0; k <= K; k++){
				for(int n = 2; n <= N; n++){
					dp[0][k][n] = dp[0][k][n-1] + dp[1][k][n-1];
					if(k == 0){
						dp[1][k][n] = dp[0][k][n-1];
					}else{
						dp[1][k][n] = dp[0][k][n-1] + dp[1][k-1][n-1];
					}
				}
			}
			
//			for(int i = 0; i <= K; i++){
//				print(dp[0][i]);
//			}
//			System.out.println("----");
//			for(int i = 0; i <= K; i++){
//				print(dp[1][i]);
//			}
//			System.out.println("------------------------------");
			bw.write(tc + " " + (dp[0][K][N] + dp[1][K][N]) + "\n");
			
		}
		
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

