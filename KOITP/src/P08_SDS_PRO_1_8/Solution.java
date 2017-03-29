package P08_SDS_PRO_1_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.solve();
	}

	int M, N;
	int grid[][];
	int group[][];
	Set <Node> set = new HashSet<>();
	
	List<Integer>[] adjList;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P08_SDS_PRO_1_8_1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++){
			
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			set = new HashSet<>();
			grid = new int[M][N];
			group = new int[M][N];
			for(int i = 0; i < M; i++){
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++){
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//		print(grid);
			int color = 1;
			for(int i = 0; i < M; i++){
				for(int j = 0; j < N; j++){
					if(group[i][j] == 0){
						dfs(i, j, grid[i][j], color);
						color++;
					}
					
				}
			}
//		print(group);
			
//		System.out.println(set.size() + "/" + color);
			
			// 인접리스트 생성..
			adjList = new ArrayList[color];
			for(int i = 0; i < color; i++){
				adjList[i] = new ArrayList<>();
			}
			
			for(Node n : set){
				adjList[n.x].add(n.y);
				adjList[n.y].add(n.x);
			}
//		for(List<Integer> l : adjList){
//			System.out.println(Arrays.toString(l.toArray()));
//		}
			
			// BFS
			int min = Integer.MAX_VALUE;
			for(int i = 1; i < adjList.length; i++){
				int visit[] = new int[color];
				Queue<Node> q = new LinkedList<>();
				q.add(new Node(i, 0));
				visit[i] = 1;
				int max = -1;
				while(!q.isEmpty()){
					Node n = q.poll();
					for(Integer num : adjList[n.x]){
						if(visit[num] == 0){
							q.add(new Node(num, n.y + 1));
							visit[num] = 1;
							max = Math.max(max, n.y + 1);
						}
					}
				}
//			System.out.println("MAX : " + max);
				min = Math.min(min, max);
			}
			bw.write("#" + tc + " " + min + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	int [] dx = {-1, 0, 1, 0};
	int [] dy = {0, -1, 0, 1};
	// x, y 좌표, 기준번호(0 또는 1), 현재 그룹번호.
	public void dfs(int x, int y, int pre, int color){
		int nx, ny;
		group[x][y] = color;
		for(int i = 0; i < 4; i++){
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx >= 0 && nx < M && ny >= 0 && ny < N){
				if(group[nx][ny] != 0 && group[nx][ny] != group[x][y]){
					set.add(new Node(Math.min(group[x][y], group[nx][ny]), Math.max(group[x][y], group[nx][ny])));
				}
				if(grid[nx][ny] == pre && group[nx][ny] == 0){
					dfs(nx, ny, pre, color);
				}
			}
		}
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

	public class Node{
		int x;
		int y;
		public Node(int n, int c){
			this.x = n;
			this.y = c;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			Node n = (Node)obj;
			if(x == n.x && y == n.y){
				return true;
			}
				
			return false;
		}
		private Solution getOuterType() {
			return Solution.this;
		}
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
		
	}
}

/**
어떤 흑색 그룹이 어떤 백색 그룹과 연결되어있는지
그래프로 만들어서 모든 정점을 기준으로 BFS를 수행
각 정점에서 최대 값이 최소인 것이 정답

그룹핑은 DFS
동시에 인접리스트를 만들 수 잇다. SET 활용하여 pair를 넣는다. 
DFS 는 이중포문 돌려서..
*/