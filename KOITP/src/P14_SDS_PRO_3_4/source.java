package P14_SDS_PRO_3_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}

	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P14_SDS_PRO_3_4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		int ans[] = new int[N+1];
		Stack<Integer> ts = new Stack<>();
		Stack<Integer> is = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N; i > 0; i--){
			if(ts.isEmpty()){
				ts.push(arr[i]);
				is.push(i);
			}else{
				while(!ts.isEmpty()){
					int num = ts.peek();
					if(num < arr[i]){
						ts.pop();
						ans[is.pop()] = i;
					}else{
						break;
					}
				}
				ts.push(arr[i]);
				is.push(i);
			}
		}
//		print(arr);
//		print(ans);
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= N; i++){
			sb.append(String.valueOf(ans[i]));
			sb.append(" ");
		}
		bw.write(sb.toString() + "\n");
		bw.flush();
		br.close();
		bw.close();
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

