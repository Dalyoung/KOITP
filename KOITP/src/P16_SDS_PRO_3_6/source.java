package P16_SDS_PRO_3_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	int N;
	public void solve() throws Exception {
		//System.setIn(new FileInputStream("input/P16_SDS_PRO_3_6.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine().trim());
		// left, right priority queue를 만든다.
		PriorityQueue<Integer> left = new PriorityQueue<>();
		PriorityQueue<Integer> right = new PriorityQueue<>();
		int mid = Integer.parseInt(br.readLine().trim());
		bw.write(String.valueOf(mid) + "\n");
		int num;
		for(int i = 1; i < N; i += 2){
			num = Integer.parseInt(br.readLine().trim());
			if(num < mid){
				left.add(-num);
			}else{
				right.add(num);
			}
			num = Integer.parseInt(br.readLine().trim());
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
			bw.write(String.valueOf(mid) + "\n");
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

