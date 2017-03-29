package P25_SDS_PRO_4_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
		
		
	}
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P25_SDS_PRO_4_1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		int W, H;
		String [] input = br.readLine().split(" ");
		W = Integer.parseInt(input[0]);
		H = Integer.parseInt(input[1]);
		
		char [][] map = new char[H][W];
		int [][] ans = new int[H][W];
		int sx = 0, sy = 0, ex = 0, ey = 0;
		for(int i = 0; i < H; i++){
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < W; j++){
				if(map[i][j] == 'S'){
					sx = i;
					sy = j;
				}
				if(map[i][j] == 'E'){
					ex = i;
					ey = j;
				}
				ans[i][j] = -1;
			}
		}
		int [] dx = {-1, 0, 1, 0};
		int [] dy = {0, -1, 0, 1};
		int nx, ny;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy));
		ans[sx][sy] = 0;
		while(!q.isEmpty()){
			Node n = q.poll();
			for(int i = 0; i < 4; i++){
				nx = n.x + dx[i];
				ny = n.y + dy[i];
				if(nx < 0 || nx >= H || ny < 0 || ny >= W){
					continue;
				}
				
				if(map[nx][ny] != 'X' && ans[nx][ny] == -1){
					ans[nx][ny] = ans[n.x][n.y] + 1;
					q.add(new Node(nx, ny));
				}
			}
		}
		
//		for(int i = 0; i < H; i++){
//			print(ans[i]);
//		}
		bw.write(ans[ex][ey] + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public class Node{
		int x;
		int y;
		public Node(int x, int y){
			this.x = x;
			this.y = y;
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

