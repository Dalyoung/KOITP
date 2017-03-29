package P01_ROD_CUTTING;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/P01_ROD_CUTTING.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N + 1];
		int [] route = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++ ){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] dp = new int[N + 1];
		for(int i = 1; i <= N; i++){
			int max = arr[i];
			int index = i;
			for(int j = 1; j <= i; j++){
				if(max < arr[j] + dp[i-j]){
					max = arr[j] + dp[i-j];
					index = j;
				}
			}
			route[i] = index;
			dp[i] = max;
		}
		
		int length = N;
		while(length > 0){
			System.out.println(route[length]);
			length -= route[length];
		}
//		bw.write(Arrays.toString(arr));
//		bw.write(Arrays.toString(dp) + "\n");
//		bw.write(Arrays.toString(route) + "\n");
		bw.write(String.valueOf(dp[N]) + "\n");
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	
}
