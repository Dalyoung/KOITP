package P34_MAX_SUBARRAY;

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
	 * d[i] = MAX(s[i], d[i-1] + s[i]) 
	 * 
	 */
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P34_MAX_SUBARRAY.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[N];
		long dp[] = new long[N];
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long max = -2000001;
		dp[0] = arr[0];
		for(int i = 1; i < N; i++){
			if(dp[i-1] + arr[i] < arr[i]){
				dp[i] = arr[i];
			}else{
				dp[i] = dp[i-1] + arr[i];
			}
			max = Math.max(dp[i], max);
		}
			
		bw.write(max + "\n");
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

