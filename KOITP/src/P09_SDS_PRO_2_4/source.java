package P09_SDS_PRO_2_4;

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
		//System.setIn(new FileInputStream("input/P09_SDS_PRO_2_4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
	//	print(arr);
		int count = 1;
		int max = 0;
		int last = arr[0];
		int ans = arr[0];
		for(int i = 1; i < N; i++){
			if(arr[i] == last){
				count++;
			}else{
				if(count > max){
					max = count;
					ans = last;
				}
				last = arr[i];
				count = 1;
			}
		}
		if(count > max){
			max = count;
			ans = last;
		}
		bw.write(ans + "\n");
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

