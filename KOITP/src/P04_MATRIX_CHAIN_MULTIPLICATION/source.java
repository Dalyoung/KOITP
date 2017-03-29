package P04_MATRIX_CHAIN_MULTIPLICATION;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/P04_MATRIX_CHAIN_MULTIPLICATION.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [] M = new int[N+1];
		int [][] dp = new int[N+1][N+1];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i <= N; i++){
			M[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i < N; i++){
			for(int j = 1; j <= N-i; j++){
				int min = Integer.MAX_VALUE;
				// j, j+i;
				for(int k = j; k < j+i; k++){
					min = Math.min(dp[j][k] + dp[k+1][j+i] + (M[j-1] * M[k] * M[j+i]), min);
				}
//				System.out.println(j + "," + (j+i));
				dp[j][j+i] = min;
			}
		}
//		print(M);
//		print(dp);
		bw.write(String.valueOf(dp[1][N]) + "\n");
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	public static void print(int [] arr){
		System.out.println(Arrays.toString(arr));
	}
	public static void print(int [][] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
