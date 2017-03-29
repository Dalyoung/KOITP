package P31_MILITARY_ROAD_NETWORK;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

// MST. 가능한 MST는 여러개 가능..
// 합은 같은데 쌍은 다름. a + b = x1 + x2
// 1 - 다른 간선이지만 cost가 같은 경우. 대체 가능해야 함.
// 2 - 서로 다 다르지만 합은 같은 경우? -> 이 가능성은 0. 왜?
//
/**
 * Kruskal's Algorithm.
 * cost가 같은 것들을 한번에 처리.
 * union find로 팀 값을 구한다.
 * 한 단계가 끝났을 때, 선택된 값의 cost와 union find에 의한 팀 값이 같은 것이 남아있으면 유일하지 않다.
 * 정렬 후, 어떤 값을 만나면 그 값이 끝날 때 까지 포인터를 이동.
 * 
 * 팀의 번호가 같은건 빼고, 팀 번호가 다른 것들의 수를 센다. 그 후 크루스칼에서 선택된 갯수가 팀 번호 다른것들의 수와 같지 않으면 unique 하지 않다.
 * 
 * 도로를 미리 제거. 도로 제거 SUM을 구한다.
 * 그리고 해당 엣지들은 음수값으로..
 * 
 */


public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	int N, M, K;
	long sum = 0;
	int p[];
	Edge [] edges;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P31_MILITARY_ROAD_NETWORK.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String [] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		p = new int[N+1];
		edges = new Edge[M + K];
		for(int i = 1; i <= N; i++){
			p[i] = i;
		}
		
		int f, t, d;
		for(int i = 0; i < M; i++){
			input = br.readLine().split(" ");
			f = Integer.parseInt(input[0]);
			t = Integer.parseInt(input[1]);
			d = Integer.parseInt(input[2]);
			sum += d;
			edges[i] = new Edge(f, t, -d);
		}
		
		for(int i = 0; i < K; i++){
			input = br.readLine().split(" ");
			f = Integer.parseInt(input[0]);
			t = Integer.parseInt(input[1]);
			d = Integer.parseInt(input[2]);
//			sum += d;
			edges[i+M] = new Edge(f, t, d);
		}
		Arrays.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.dist - o2.dist;
			}
		});
//		print(edges);
		
		int n1, n2;
		boolean isUnique = true;
		int j = 0;
		int count = 0;
		int count2 = 0;
		int last = 1000000001;
		for(int i = 0; i < edges.length; i++){
			Edge e = edges[i];
			
			n1 = find(e.from);
			n2 = find(e.to);
			if(n1 != n2){
				p[n1] = n2;
				sum += e.dist;
			}
//			System.out.println(count + ", " + count2);
		}
		
//		print(p);
		bw.write(sum + " " + (isUnique?"unique":"not unique") + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	int find(int v){
		if(v == p[v]){
			return v;
		}
		return p[v] = find(p[v]);
	}
	
	
	public class Edge{
		int from;
		int to;
		int dist;
		
		public Edge(int f, int t, int d){
			this.from = f;
			this.to = t;
			this.dist = d;
		}

		@Override
		public String toString() {
			return "[from=" + from + ", to=" + to + ", dist=" + dist + "]";
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

