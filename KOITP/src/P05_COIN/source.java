package P05_COIN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/P05_COIN.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int coins[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			coins[i] = Integer.parseInt(st.nextToken());
		}
		int W = Integer.parseInt(br.readLine());
		int [] dp = new int[W+1];
		
//		for(int i = coins[0], c = 1; i <= W; i += coins[0], c++){
//			dp[i] = c;
//		}
		dp[0] = 0;
		for(int i = 0; i < N; i++){
			dp[coins[i]] = 1;
			for(int j = coins[i] + 1; j <= W; j++){
				if(dp[j-coins[i]] != 0){
					if(dp[j] != 0){
						dp[j] = Math.min(dp[j-coins[i]] + 1, dp[j]);
					}else{
						dp[j] =dp[j-coins[i]] + 1;
					}
				}
			}
		}
		
		print(coins);
		print(dp);
		bw.write(String.valueOf(dp[W]) + "\n");
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
