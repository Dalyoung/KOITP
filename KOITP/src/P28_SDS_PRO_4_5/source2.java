package P28_SDS_PRO_4_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source2 {
	public static void main(String[] args) throws Exception {
		source2 s = new source2();
		s.solve();
	}
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P28_SDS_PRO_4_5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N, M, X;
		String [] input;
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		X = Integer.parseInt(input[2]);
		X--;
		int map [][] = new int[N][N];
		for(int i = 0; i < N; i++){
			Arrays.fill(map[i], -1);
		}
		for(int i = 0; i < M; i++){
			input = br.readLine().split(" ");
			map[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = Integer.parseInt(input[2]);
		}
		
//		for(int i = 0; i < N; i++){
//			print(map[i]);
//		}
		
		for(int k = 0; k < N; k++){
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(map[i][k] == -1 || map[k][j] == -1 || i == j){
						continue;
					}
					if(map[i][j] == -1){
						map[i][j] = map[i][k] + map[k][j];
					}else{
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}
		}
		
		int ret = 0;
		for(int i = 0; i < N; i++){
			ret = Math.max(ret, map[i][X] + map[X][i]);
		}
		
		for(int i = 0; i < N; i++){
			print(map[i]);
		}
		bw.write(ret + "\n");
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

