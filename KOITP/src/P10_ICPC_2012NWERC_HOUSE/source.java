package P10_ICPC_2012NWERC_HOUSE;

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

	public void solve() throws Exception {
//		System.setIn(new FileInputStream("input/P10_ICPC_2012NWERC_HOUSE.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int X = Integer.parseInt(br.readLine()) * 10000000;
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
//		print(arr);
		int l = 0;
		int r = N - 1;
		while(l < r){
			int num1 = arr[l];
			int num2 = arr[r];
			if(num1 + num2 == X){
				break;
			}else if(num1 + num2 > X){
				r--;
			}else if(num1 + num2 < X){
				l++;
			}
		}
		if(l < r){
			String str = "yes " + String.valueOf(arr[l]) + " " + String.valueOf(arr[r]);
			bw.write(str + "\n");
		}else{
			bw.write("danger\n");
		}
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

