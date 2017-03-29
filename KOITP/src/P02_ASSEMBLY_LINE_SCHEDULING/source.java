package P02_ASSEMBLY_LINE_SCHEDULING;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/P02_ASSEMBLY_LINE_SCHEDULING.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int N, e1, e2, x1, x2;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		e1 = Integer.parseInt(st.nextToken());
		e2 = Integer.parseInt(st.nextToken());
		x1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		
		int [][] S = new int[2][N+1];
		int [][] T = new int[2][N];
		
		for(int i = 0; i < 2; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++){
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 2; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j < N; j++){
				T[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int dp[][] = new int[2][N+1];
		int route[][] = new int[2][N+1];
		dp[0][1] = e1 + S[0][1];
		dp[1][1] = e2 + S[1][1];
		for(int i = 2; i <= N; i++){
			if(dp[0][i-1] + S[0][i] < dp[1][i-1] + T[1][i-1] + S[0][i]){
				dp[0][i] = dp[0][i-1] + S[0][i];
				route[0][i] = 1;
			}else{
				dp[0][i] = dp[1][i-1] + T[1][i-1] + S[0][i];
				route[0][i] = 2;
			}
			
			if(dp[1][i-1] + S[1][i] < dp[0][i-1] + T[0][i-1] + S[1][i]){
				dp[1][i] = dp[1][i-1] + S[1][i];
				route[1][i] = 2;
			}else{
				dp[1][i] = dp[0][i-1] + T[0][i-1] + S[1][i];
				route[1][i] = 1;
			}
		}
		
//		bw.write(Arrays.toString(S[0]) + "\n");
//		bw.write(Arrays.toString(S[1]) + "\n");
//		
//		bw.write(Arrays.toString(T[0]) + "\n");
//		bw.write(Arrays.toString(T[1]) + "\n");
//		
//		bw.write(Arrays.toString(dp[0]) + "\n");
//		bw.write(Arrays.toString(dp[1]) + "\n");
		bw.write(Arrays.toString(route[0]) + "\n");
		bw.write(Arrays.toString(route[1]) + "\n");
//		
		bw.write(Math.min(dp[0][N] + x1, dp[1][N] + x2) + "\n");
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}
