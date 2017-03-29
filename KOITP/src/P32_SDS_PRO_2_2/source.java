package P32_SDS_PRO_2_2;

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
	 * 
	 * d[k, n] : k개 수 + N이 되는 경우의 수
	 * d[1, j] = 1 : 한개의 수로 j를 만드는 경우의 수..
	 * d[i, j] = sum(d[i-1, j-x]). i-1개로 j-x를 만드는 경우의 수.
	 *           0 <= x <= j
	 * 
	 */
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P32_SDS_PRO_2_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int [][] dp = new int[K+1][N+1];
		int MOD = 1000000000;
		for(int i = 0; i <= N; i++){
			dp[1][i] = i;
			dp[2][i] = i+1;
		}
		
		for (int i = 3; i <= K; i++)
	    {
	        for (int j = 0; j <= N; j++)
	            for (int k = 0; k <= j; k++){
	            	dp[i][j] = (dp[i][j]+dp[i - 1][j - k])%MOD;
	            }
	    }


		
		for(int i = 0; i <= K; i++){
			print(dp[i]);
		}
		
		bw.write(dp[K][N] + "\n");
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

