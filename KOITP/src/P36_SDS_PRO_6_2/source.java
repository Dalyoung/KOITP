package P36_SDS_PRO_6_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * up[i,j] = 단서 1~i, 단서i 가 위쪽배열의 j번째 원소 매칭이 된 수.
 * 
 * up[i, j] = sum(down[i-1, 0~j-1])
 * down[i, j] = sum(up[i-1, 0~j-1]) -- 처음에만 0, 그 후엔 1~j-1
 * 
 *
 */

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	int N, K;
	char [] scroll;
	char [][] bridge;
	int [][][] visit; 
	long count = 0;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P36_SDS_PRO_6_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		scroll = br.readLine().toCharArray();
		K = scroll.length;
		String temp = br.readLine();
		N = temp.length();
		bridge = new char[2][N];
		bridge[0] = temp.toCharArray();
		bridge[1] = br.readLine().toCharArray();
		
		visit = new int[2][N+1][K+1];
		
		for(int i = 0; i < 2; i++){
			for(int j = 0; j <= N; j++){
				Arrays.fill(visit[i][j], -1);
			}
		}

		bw.write(find(0, 0, 0) + find(1, 0, 0) + "\n");
		print(visit[0]);
		print(visit[1]);
//		print(dp);
		bw.flush();
		br.close();
		bw.close();
	}
	
	// scroll 위치, 다리 위치, 위/아래
	int find(int p, int index, int next){
		if(visit[p][index][next] != -1){
			return visit[p][index][next];
		}
		
		if(next >= K){
			return 1;
		}
		if(index >= N){
			return 0;
		}
		
		int ret = 0;

		for(int i = index; i < N; i++){
			if(bridge[p][i] == scroll[next]){
				ret += find( (p+1)&1, i + 1, next + 1);
			}
		}
		return visit[p][index][next] = ret;
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

