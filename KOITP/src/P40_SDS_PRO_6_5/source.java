package P40_SDS_PRO_6_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P40_SDS_PRO_6_5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N, K;
		String input[];
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		Gem [] gems = new Gem[N];
		int bags[] = new int[K];
		for(int i = 0; i < N; i++){
			input = br.readLine().split(" ");
			gems[i] = new Gem(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		for(int i = 0; i < K; i++){
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		
		Arrays.sort(gems, new Comparator<Gem>() {

			@Override
			public int compare(Gem o1, Gem o2) {
				if(o1.m == o2.m){
					return o2.v - o1.v;
				}
				return o1.m - o2.m;
			}
		});
		Arrays.sort(bags);
//		print(gems);
//		print(bags);
		
		long ret = 0;
		int b = 0, g = 0;
		
		PriorityQueue<Gem> pq = new PriorityQueue<>(N, new Comparator<Gem>() {

			public int compare(Gem o1, Gem o2) {
				if(o1.v == o2.v){
					return o2.m - o1.m;
				}
				return o2.v - o1.v;
			}
		});
		

		while(g < N && b < K){
			if(gems[g].m <= bags[b]){
				pq.add(gems[g]);
				g++;
			}else{
				Gem temp = pq.poll();
				ret += (long)temp.v;
				b++;
			}
		}
		while(b <= K-1 && !pq.isEmpty()){
			Gem temp = pq.poll();
			if(temp.m <= bags[b]){
				ret += (long)temp.v;
				b++;
			}
		}
		
		bw.write(ret + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	class Gem{
		int m;
		int v;
		public Gem(int m, int v){
			this.m = m;
			this.v = v;
		}
		public String toString(){
			return "[" + m + "," + v + "]";
		}
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

