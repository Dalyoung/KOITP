package P37_USACO_2006DEC_ROLLERCOASTER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 조건 : 길이가 L 이면서 예산 B 이하.
 * dp[L, B] 가능 
 * 
 * V[i] : 끝위치가 i인 막대의 배열 
 * dp[i, j] : 0~i 까지 부품을 조립하고 동시에 cost합 = j
 * d[i, j] = d[i-k.w, j-k.c] + k.f. k는 i 로 끝나는 모든 막대.
 * 
 * 
 */

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	int L, N, B;
	int fun[][];
	int cost[][];
	int dp[][];
//	ArrayList<Item> [] list;
	Item [] items;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P37_USACO_2006DEC_ROLLERCOASTER.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input[];
		input = br.readLine().split(" ");
		L = Integer.parseInt(input[0]); // 길이
		N = Integer.parseInt(input[1]); // 총 부품수
		B = Integer.parseInt(input[2]); // 예산
		
		dp = new int[L+1][B+1];
		items = new Item[N];
		int x, w, f, c;
		for(int i = 0; i < N; i++){
			input = br.readLine().split(" ");
			x = Integer.parseInt(input[0]);
			w = Integer.parseInt(input[1]);
			f = Integer.parseInt(input[2]);
			c = Integer.parseInt(input[3]);
			items[i] = new Item(x, w, f, c);
		}
		Arrays.sort(items, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				if(o1.e == o2.e){
					return o1.x - o2.x;
				}
				return o1.e - o2.e;
			}
		});
//		print(items);
		
		for(int i = 0; i < N; i++){
			Item item = items[i];
			for(c = item.c; c <= B; c++){
				if(item.x == 0){
					dp[item.e][c] = Math.max(dp[item.e][c], item.f + dp[item.x][c - item.c]);
				}else{
					
					if( dp[item.x][c - item.c] != 0){
						dp[item.e][c] = Math.max(dp[item.e][c], item.f + dp[item.x][c - item.c]);
					}
				}
			}
		}
//		print(dp);
		bw.write((dp[L][B]==0?-1:dp[L][B]) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	
	class Item{
		int x; // start
		int e; // end
		int w; // width
		int f; // fun
		int c; // cost
		
		public Item(int x, int w, int f, int c) {
			super();
			this.x = x;
			this.w = w;
			this.f = f;
			this.c = c;
			e = x + w;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", w=" + w + ", e=" + e + ", f=" + f + ", c=" + c + "]";
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

