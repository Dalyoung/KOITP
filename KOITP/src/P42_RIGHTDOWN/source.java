package P42_RIGHTDOWN;

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
	 *	N-1번 방문한 후의 지도.
	 * N = 100 일때
	 * 
	 * 99 50               25  13 
	 * 49 50/2+(49-1)/2=49 37  24
	 * 25 37               37  31
	 * 
	 * 홀수일때 주의. 짝수일댄 균일하게 간다.
	 * 
	 */
	
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P42_RIGHTDOWN.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int H, W, N;
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[H+2][W+2];
		int map[][] = new int[H+2][W+2];
		for(int i = 1; i <= H; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= W; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		print(arr);
//		N = 100;
		N = 2;
		map[1][1] = N-1;
		for(int i = 1; i < H; i++){
			for(int j = 1; j < W; j++){
				if((map[i][j]&1) == 1){
					if(arr[i][j] == 0){
						map[i+1][j] += map[i][j] / 2 + 1;
						map[i][j+1] += map[i][j] / 2;
					}else{
						map[i+1][j] += map[i][j] / 2;
						map[i][j+1] += map[i][j] / 2 + 1;
					}
				}else{
					map[i][j+1] += map[i][j] / 2;
					map[i+1][j] += map[i][j] / 2;
				}
			}
		}
		
		for(int i = 1; i < H; i++){
			for(int j = 1; j < W; j++){
				if((map[i][j]&1) == 1){
					arr[i][j] = (arr[i][j] + 1) & 1;
				}
			}
		}
		
//		print(map);
//		print(arr);
		int h = 0, w = 0;
		h = 1; w = 1;
		while(h <= H && w <= W){
			if(arr[h][w] == 0){
				arr[h][w] = 1;
				h++;
			}else{
				arr[h][w] = 0;
				w++;
			}
		}
		bw.write(String.valueOf(h) + " " + String.valueOf(w) + "\n");
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

