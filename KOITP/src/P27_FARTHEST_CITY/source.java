package P27_FARTHEST_CITY;

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
		System.setIn(new FileInputStream("input/P27_FARTHEST_CITY.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int [][] map = new int[N][N];
		int [][] dist = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = map[i][j];
			}
		}
		
		int ret = 0;
		for(int k = 0; k < N; k++){
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
//					System.out.println(i + "," + j + "=[" + i + "," + k + "]+[" + k + "," + j + "]");
				}
			}
		}
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				ret = Math.max(ret, dist[i][j]);
			}
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

