package P45_SDS_PRO_6_8;

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
		System.setIn(new FileInputStream("input/P45_SDS_PRO_6_8.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[][] input = {br.readLine().toCharArray(), br.readLine().toCharArray(), br.readLine().toCharArray()};
		int N = input[0].length;
		int [][] ans = new int[3][N+1];
		char [] mid = new char[N];
//		System.out.println(input[0]);
//		System.out.println(input[1]);
//		System.out.println(input[2]);
		
		for(int i = 0; i < N; i++){
			if(input[0][i] == input[1][i] && input[1][i] == input[2][i]){
				mid[i] = input[0][i];
			}else if(input[0][i] == input[1][i]){
				mid[i] = input[0][i];
				ans[2][i]++;
				ans[2][N]++;
			}else if(input[0][i] == input[2][i]){
				mid[i] = input[0][i];
				ans[1][i]++;
				ans[1][N]++;
			}else if(input[1][i] == input[2][i]){
				mid[i] = input[1][i];
				ans[0][i]++;
				ans[0][N]++;
			}else{
				mid[i] = '?';
			}
		}
//		print(mid);
//		print(ans);
		for(int i = 0; i < N; i++){
			if(mid[i] == '?'){
				int target = 0;
				if(ans[1][N] >= ans[0][N] && ans[1][N] >= ans[2][N]){
					target = 1;
				}
				else if(ans[2][N] >= ans[0][N] && ans[2][N] >= ans[1][N]){
					target = 2;
				}
				for(int j = 0; j < 3; j++){
					if(j != target){
						ans[j][N]++;
					}
				}
			}
		}
		int max = 0;
		for(int i = 0; i < 3; i++){
			max = Math.max(max, ans[i][N]);
		}
//		print(ans);
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

