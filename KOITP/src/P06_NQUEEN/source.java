package P06_NQUEEN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	int N;
	int chk[];
	public void solve() throws Exception {
		//System.setIn(new FileInputStream("input/P06_NQUEEN.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		chk = new int[N+1];
		queen(0);

		bw.write(String.valueOf(count));
		bw.flush();
		br.close();
		bw.close();
	}
	int count = 0;
	public void queen(int n){
		if(check(n)){
			if(n == N){
				count++;
			}else{
				for(int i = 1; i <= N; i++){
					chk[n+1] = i;
					queen(n+1);
				}
			}
		}
	}
	
	public boolean check(int n){
		boolean ret = true;
		for(int i = 1; i < n; i++){
			if(chk[n] == chk[i] || n-i == Math.abs(chk[n] - chk[i])){
				return false;
			}
		}
		return ret;
	}
	public void print(int [] arr){
		System.out.println(Arrays.toString(arr));
	}
	public void print(int [][] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
