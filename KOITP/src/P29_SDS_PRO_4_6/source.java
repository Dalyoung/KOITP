package P29_SDS_PRO_4_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 벨만 포드로 풀려면..
 * 가상의 노드를 만들어 모든 노드에 0자리 엣지를 연결한다.
 * distance 배열은 0으로 초기화된다.
 * 
 * 
 *
 */
public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P29_SDS_PRO_4_6.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int T, N, M, W;
		int MAX = 10000000;
		T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++){
			
			String [] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			W = Integer.parseInt(input[2]);
			int [][] map = new int[N+1][N+1];
			for(int i = 1; i <= N; i++){
				Arrays.fill(map[i], MAX);
				map[i][i] = 0;
			}
			int s, e, t;
			
			// 도로 정보.. 양방향
			for(int i = 0; i < M; i++){
				input = br.readLine().split(" ");
				s = Integer.parseInt(input[0]);
				e = Integer.parseInt(input[1]);
				t = Integer.parseInt(input[2]);
				
				map[s][e] = Math.min(map[s][e], t);
				map[e][s] = Math.min(map[e][s], t);
			}
			// 웜홀 정보.. 단방향
			for(int i = 0; i < W; i++){
				input = br.readLine().split(" ");
				s = Integer.parseInt(input[0]);
				e = Integer.parseInt(input[1]);
				t = Integer.parseInt(input[2]);
				
				map[s][e] = Math.min(map[s][e], -t);
			}
//			for(int i = 1; i <= N; i++){
//				print(map[i]);
//			}
			
			for(int k = 1; k <= N; k++){
				for(int i = 1; i <= N; i++){
					for(int j = 1; j <= N; j++){
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}
			
//			for(int i = 1; i <= N; i++){
//				print(map[i]);
//			}
			
			boolean chk = false;
			for(int i = 1; i <= N; i++){
				if(map[i][i] < 0){
					chk = true;
					break;
				}
			}
			if(chk){
				bw.write("YES\n");
			}else{
				bw.write("NO\n");
			}
		}
		
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

