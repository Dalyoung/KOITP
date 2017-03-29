package P17_SDS_PRO_3_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class source2 {
	public static void main(String[] args) throws Exception {
		
		source2 s = new source2();
		s.solve();
	}
	
	/**
	 * 완전이진트리인 경우 초기화를 반복문으로 가능.
	 * 단 완전이진트리를 만들기 위해 dummy 데이터를 만들어야 한다.
	 * 1 2 3 4 5 인 경우, 1 2 3 4 5 0 0 0 으로..(5가 2제곱 보다 크므로, 2의3승 개로 맞춰야한다.
	 * 초기화를 for문으로?
	 * 2로 나눠가며 데이터를 업데이트 해준다..
	 * 
	 */
//	int M = 131072;
	int ind[];
	int N, Q, M;
	public void solve() throws Exception{
		System.setIn(new FileInputStream("input/P17_SDS_PRO_3_5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		Q = Integer.parseInt(br.readLine());
		M = 1;
		int count = 0;
		while(M < N){
			M <<= 1;
			count++;
		}
		M = 1;
		for(int i = 0; i < count; i++){
			M <<= 1; 
		}
		ind = new int[2*M];
		for(int i = 1; i <= N; i++){
			update(i, i);
		}
		String [] input;
		int t, n1, n2;
		for(int i = 0; i < Q; i++){
			input = br.readLine().split(" ");
			t = Integer.parseInt(input[0]);
			n1 = Integer.parseInt(input[1]);
			n2 = Integer.parseInt(input[2]);
			if(t == 0){
				update(n1, n2 - ind[n1+M-1]);
			}else{
				bw.write(String.valueOf(find(n1, n2)) + "\n");
			}
		}
		br.close();
		bw.close();
		
	}
	void update(int pos, int data){
		pos += M - 1;
		while(pos != 0){
			ind[pos] += data;
			pos>>=1; // /2 연산.
		}
	}
	long find(int le, int ri){
		long ret = 0;
		le += M - 1; 
		ri += M - 1;
		while(le <= ri){
			
			//홀수 - 배열의 오른쪽 값으로.
			if((le&1) == 1){
				ret += ind[le];
				le++;
			}
			// 짝수 - 배열의 왼쪽 값으로
			if((ri&1) == 0){
				ret += ind[ri];
				ri--;
			}
			
			le>>=1;
			ri>>=1;
		}
		return ret;
	}
	void mainmain(){
		for(int i = 1; i <= N; i++){
			update(i, i);
		}
		
		for(int i = 1; i <= Q; i++){
			int a=0, b=0, c=0;
			if(a == 0){
				update(b, c-ind[b+M-1]);
			}else{
				find(b, c);
			}
		}
	}
	
	
	public void print(int [] args){
		System.out.println(Arrays.toString(args));
	}
	
	public void print(int [][] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}

