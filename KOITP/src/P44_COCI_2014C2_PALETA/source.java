package P44_COCI_2014C2_PALETA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws IOException {
		source m = new source();
		m.doit();
	}

	int N, K;
	int MAX_N = 1000005;
	int f[] = new int[MAX_N];
	int dp[] = new int[MAX_N];
	long color[] = new long[MAX_N];
	long mod = 1000000007L;
	public void doit() throws IOException{
		System.setIn(new FileInputStream("input/P44_COCI_2014C2_PALETA.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		color[0] = 1;
		color[1] = K;
		color[2] = ((K-1) * color[1])%mod;
		color[3] = ((K-2) * color[2])%mod;
		
		for(int i = 4; i <= N; i++){
			color[i] = ((K-1)*color[i-2] + (K-2)*color[i-1]) % mod;
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++){
			f[i] = Integer.parseInt(st.nextToken());
		}
//		printArr(color, 0, N+1);
//		printArr(f, 1, N+1);
		long ret = 1;
		int total = 1;
		int pre = 0;
		
		for(int i = 1; i <= N; i++){
			if(dp[i] != 0){
				continue;
			}
			int temp = 0;
			int current = i;
			while(true){
				if(dp[current] != 0){
					if(dp[current] < dp[i]){
						temp = 0;
					}else{
						temp = total - dp[current];
					}
					break;
				}
				else{
					//						total++;
					dp[current] = total++;
					current = f[current];
				}
			}
			pre += temp;
			ret = ret * color[temp] % mod;
		}

		for(int i = 1; i <= N - pre; i++){
			ret = ret * (K-1) % mod;
		}
//		printArr(dp, 1, N+1);
		System.out.println(ret);

		br.close();
	}


	void printArr(int [] arr, int s, int e){
		System.out.print("[");
		for(int i = s; i < e; i++){
			if(i != 0){
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.println("]");
	}
	
	void printArr(long [] arr, int s, int e){
		System.out.print("[");
		for(int i = s; i < e; i++){
			if(i != 0){
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.println("]");
	}

	void printArr(Object [] arr, int s, int e){
		System.out.print("[");
		for(int i = s; i < e; i++){
			if(i != 0){
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.println("]");
	}

}
