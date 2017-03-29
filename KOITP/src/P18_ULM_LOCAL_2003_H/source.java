package P18_ULM_LOCAL_2003_H;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	  
	/* https://www.acmicpc.net/blog/view/12
	 * 높이가 낮아질때는 그 전 높이는 사용하지 않는다. Stack 사용.
	 * 
	 */
	public void solve() throws Exception {
//		System.setIn(new FileInputStream("input/P18_ULM_LOCAL_2003_H.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;
		long [] arr;
		while(true){
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			if(N == 0){
				break;
			}
			arr = new long[N];
			for(int i = 0; i < N; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Stack<Integer> s = new Stack<>();
			long ret = 0L;
			
			for(int i = 0; i < N; i++){
				while(!s.isEmpty() && arr[s.peek()] > arr[i]){
					long width = i;
					long height = arr[s.pop()];
					if(!s.isEmpty()){
						width = i - s.peek() - 1;
					}
					ret = Math.max(ret, width * height);
				}
				s.push(i);
			}
			while(!s.isEmpty()){
				long width = N;
				long height = arr[s.pop()];
				if(!s.isEmpty()){
					width = width - s.peek() - 1;
				}
				ret = Math.max(ret, width * height);
			}
			
//			print(arr);
			bw.write(String.valueOf(ret) + "\n");
		}
		
		bw.flush(); 
		br.close();
		bw.close();
	}
	
	public void print(long [] args){
		System.out.println(Arrays.toString(args));
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

