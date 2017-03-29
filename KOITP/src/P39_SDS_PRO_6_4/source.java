package P39_SDS_PRO_6_4;

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
	
	
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P39_SDS_PRO_6_4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
//		int arr[] = new int[N];
		int hi[] = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int count = 0;
		int num;
		for(int i = 0; i < N; i++){
			num = Integer.parseInt(st.nextToken());
			if(hi[num] == 0){
				count++;
			}else{
				hi[num]--;
			}
			hi[num-1]++;
		}
		
		
		System.out.println(count);
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

