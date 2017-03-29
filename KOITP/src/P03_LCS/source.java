package P03_LCS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class source {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/P03_LCS.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str1 = " " + br.readLine();
		String str2 = " " + br.readLine();
		char [] arr1, arr2;
		
		if(str1.length() > str2.length()){
			arr1 = str1.toCharArray();
			arr2 = str2.toCharArray();
		}else{
			arr1 = str2.toCharArray();
			arr2 = str1.toCharArray();
		}
		int N1 = arr1.length;
		int N2 = arr2.length;
		
		int [][] dp = new int[N1][N2];
		int [][] route = new int[N1][N2]; // 1 - 왼쪽, 2 - 위, 3 - 대각
		
		for(int i = 1; i < N1; i++){
			for(int j = 1; j < N2; j++){
				if(arr1[i] == arr2[j]){
					// 같을때
					dp[i][j] = dp[i-1][j-1] + 1;
					route[i][j] = 3;
				}else{
					if(dp[i][j-1] > dp[i-1][j]){
						dp[i][j] = dp[i][j-1];
						route[i][j] = 1;
					}else{
						dp[i][j] = dp[i-1][j];
						route[i][j] = 2;
					}
				}
			}
		}
		
		StringBuffer sb = new StringBuffer("");
		
		int index1 = N1 - 1;
		int index2 = N2 - 1;
		while(index1 > 0 && index2 > 0){
			if(route[index1][index2] == 3){
				sb.append(arr1[index1]);
				index1--;
				index2--;
			}else if(route[index1][index2] == 2){
				index1--;
			}else if(route[index1][index2] == 1){
				index2--;
			}
		}
		bw.write(sb.reverse().toString() + "\n");
		bw.flush();
		br.close();
		bw.close();

	}
	
	public static void print(int [][] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}




//while(1){
//	if(!d[i][j]) break;
//	if(s1[i] == s[j] && d[i][j] == d[i-1][j-1]+1){
//		ans[++cnt] = s1[i];
//		i--;
//		j--;
//	}
//	else if(d[i][j] == d[i-1][j-1]){
//		i--; j--;
//		
//	}else if(d[i][j] == d[i-1][j]){
//		i--;
//	}else if(d[i][j] == d[i][j-1]){
//		j--;
//	}
//}