package P13_SDS_PRO_3_2;

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

	int N, Q;
	int arr[];
	int rank[];
	public void solve() throws Exception {
//		System.setIn(new FileInputStream("input/P13_SDS_PRO_3_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		Q = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		rank = new int[N+1];
		for(int i = 1; i <= N; i++){
			arr[i] = i;
		}
//		print(arr);
		StringTokenizer st;
		int t, num1, num2;
		String ret;
		for(int i = 0; i < Q; i++){
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			
			if(t == 0){
				union(num1, num2);
			}else{
				int p1 = find(num1);
				int p2 = find(num2);
				
				if(p1 == p2){
					ret = "1";
				}else{
					ret = "0";
				}
				bw.write(ret + "\n");
			}
		}
		//print(arr);
		bw.flush();
		br.close();
		bw.close();
	}
	public void union(int num1, int num2){
		num1 = find(num1);
		num2 = find(num2);
		if(num1 == num2){
			return;
		}
		if(rank[num1] > rank[num2]){
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		arr[num1] = num2;
		if(rank[num1] == rank[num2]){
			rank[num2]++;
		}
	}
	public int find(int num){
		if(arr[num] == num){
			return num;
		}
		
		return arr[num] = find(arr[num]);
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

