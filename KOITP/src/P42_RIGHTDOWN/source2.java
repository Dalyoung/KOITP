package P42_RIGHTDOWN;

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
		map[1][1] = N;
		for(int i = 1; i <= H; i++){
			for(int j = 1; j <= W; j++){
				if(map[i][j] == 0){
					continue;
				}
				if(arr[i][j] == 1){
					if((map[i][j] & 1) == 1){
						map[i][j+1] = map[i][j] / 2;
						if(map[i][j] != 2 && map[i][j] != 0){
							map[i][j+1]++;
						}
						map[i+1][j] = map[i][j] / 2;
					}else{
						map[i][j+1] = map[i][j] / 2;
						map[i+1][j] = map[i][j] / 2;
						if(map[i][j] != 2 && map[i][j] != 0){
							map[i+1][j]++;
						}
					}
				}else{
					if((map[i][j] & 1) == 1){
						map[i][j+1] = map[i][j] / 2;
						map[i+1][j] = map[i][j] / 2;
						if(map[i][j] != 2 && map[i][j] != 0){
							map[i+1][j]++;
						}
					}else{
						map[i][j+1] = map[i][j] / 2;
						if(map[i][j] != 2 && map[i][j] != 0){
							map[i][j+1]++;
						}
						map[i+1][j] = map[i][j] / 2;
					}
				}
			}
		}
//		print(map);
		for(int i = 1; i <= H; i++){
			for(int j = 1; j <= W; j++){
				if((map[i][j] & 1) == 0){
					arr[i][j] = (arr[i][j]+1)&1;
				}
			}
		}
//		print(arr);
		int h = 1, w = 1;
		while(h <= H && w <= W){
			if(arr[h][w] == 1){
				w++;
			}else{
				h++;
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

