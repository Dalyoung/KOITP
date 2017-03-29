package P38_SET;

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
	
	
	/**
	 * d[i,j] : A배열에서 1~i까지 B배열 1~j 까지 매칭을 했을 때 최소 Cost. i <= j
	 * d[i,j] = min(d[i-1,j-1] + abd(a[i]-b[j])
	 * 
	 */
	int N, M;
	int arr1[], arr2[];
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P38_SET.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr1 = new int[N];
		arr2 = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++){
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++){
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
//		print(arr1);
//		print(arr2);
		
		int dp[][] = new int[N][M];
		dp[0][0] = Math.abs(arr1[0] - arr2[0]);
		for(int i = 1; i < N; i++){
			dp[i][0] = Math.min(dp[i-1][0], Math.abs(arr1[i] - arr2[0]));
		}
		
		for(int j = 1; j < M; j++){
			dp[0][j] = Math.min(dp[0][j-1], Math.abs(arr1[0] - arr2[j]));
		}
		
		for(int i = 1; i < N; i++){
			for(int j = 1; j < M; j++){
				if(i == j){
					dp[i][j] = dp[i-1][j-1] + Math.abs(arr1[i] - arr2[j]);
				}else if(i < j){
					dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j-1] + Math.abs(arr1[i] - arr2[j]));
				}else{
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1] + Math.abs(arr1[i] - arr2[j]));
				}
			}
		}
//		print(dp);
		bw.write(dp[N-1][M-1] + "\n");
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

