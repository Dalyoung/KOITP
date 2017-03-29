package P43_LONGEST_INCREASING_SUBSEQUENCE;

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
	 * 1. DP 
	 * d[i] = max(d[i], d[j] + 1)
	 * j: 1~i-1, a[j] < a[i]
	 * 
	 * 2. Indexed Tree
	 * Max index tree. 초기 0으로 설정.
	 * 
	 * input : 2 1 3 7 4 5 6
	 * 
	 * 1~x-1까지 트리 확인. 2-1 = 1 ~ 1 까지.
	 * 
	 * 입력을 소트해서 rank를 매긴다.. 1~300000까지 번호를 주기 위해. 1000000000 같은 input이 들어올 수도 있으므로..
	 * 숫자가 같으면 같은 등수
	 * 
	 * 
	 * 
	 * 
	 */
	
	int N;
	int arr[];
	int dp[];
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P43_LONGEST_INCREASING_SUBSEQUENCE.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		dp = new int[N];
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		bw.write(String.valueOf(solveDp()) + "\n");
		bw.write(String.valueOf(solveLB()+1) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	int solveDp(){
		dp[0] = 1;
		for(int i = 1; i < N; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
					dp[i] = dp[j] + 1;
				}
			}
		}
		
//		print(dp);
		return dp[N-1];
	}
	
	int tempArr[];
	int solveLB(){
		tempArr = new int[N];
		tempArr[0] = arr[0];
		int size = 0;
		for(int i = 1; i < N; i++){
			if(tempArr[size] < arr[i]){
				size++;
				
				tempArr[size] = arr[i];
				continue;
			}
			int index = lowerBound(0, size, arr[i]);
			tempArr[index] = arr[i];
		}
		return size;
	}
	
	int lowerBound(int s, int e, int target){
		int m;
		
		while(e-s > 0){
			m = (s+e)/2;
			if(tempArr[m] <= target){
				s = m+1;
			}else{
				e = m;
			}
		}
		return s;
	}
	
	
//	int lowerBound(int s, int e, int target){
//		while(s < e){
//			int m = (s+e)/2;
//			if(tempArr[m] < target){
//				s = m+1;
//			}else{
//				e = m;
//			}
//		}
//		return e+1;
//	}
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

