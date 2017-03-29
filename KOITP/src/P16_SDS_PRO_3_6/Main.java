package P16_SDS_PRO_3_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		Main s = new Main();
		s.solve();
	}
	
	int T, N;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P16_SDS_PRO_3_6.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++){
			
			N = Integer.parseInt(br.readLine().trim());
			// left, right priority queue를 만든다.
			PriorityQueue<Integer> left = new PriorityQueue<>();
			PriorityQueue<Integer> right = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int mid = Integer.parseInt(st.nextToken());
			StringBuffer sb = new StringBuffer();
			sb.append(String.valueOf(mid));
			int num;
			for(int i = 1; i < N; i += 2){
				num = Integer.parseInt(st.nextToken());
				if(num < mid){
					left.add(-num);
				}else{
					right.add(num);
				}
				num = Integer.parseInt(st.nextToken());
				if(num < mid){
					left.add(-num);
				}else{
					right.add(num);
				}
				
				if(left.size() < right.size()){
					left.add(-mid);
					mid = right.poll();
				}else if(left.size() > right.size()){
					right.add(mid);
					mid = -left.poll();
				}
				sb.append(" " + String.valueOf(mid));
				
			}
			bw.write(String.valueOf(N/2+1) + "\n");
			bw.write(sb.toString() + "\n");
		}
//		print(left.toArray());
//		print(right.toArray());
		bw.flush();
		br.close();
		bw.close();
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

