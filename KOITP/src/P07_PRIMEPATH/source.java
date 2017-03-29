package P07_PRIMEPATH;

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

	int T;
	int arr[] = new int[10000];
	int visit[] = new int[10000];
	public void solve() throws Exception {
		//System.setIn(new FileInputStream("input/P07_PRIMEPATH.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// ¼Ò¼ö
		for(int i = 2; i < 10000; i++){
			if(arr[i] == 0){
				for(int j = i * i; j < 10000; j+=i){
					arr[j] = 1;
				}
			}
		}

		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++){
			int ret = 0;

			for(int i = 1000; i < 10000; i++){
				visit[i] = 0;
			}

			Queue<Node> q = new LinkedList<>();
			String [] input = br.readLine().split(" ");
			int source = Integer.parseInt(input[0]);
			int target = Integer.parseInt(input[1]);

			//			System.out.println(source + "->" + target);
			//			if(source != target){
			q.add(new Node(source, 0));
			visit[source] = 1;
			while(!q.isEmpty()){
				Node n = q.poll();
				if(n.number == target){
					ret = n.count;
					break;
				}
				String str = Integer.toString(n.number);
				for(int i = 0; i < 4; i++){
					int d = Integer.parseInt(str.substring(i, i+1));
					//						System.out.println(d);
					String pre = str.substring(0, i);
					String post = str.substring(i+1);
					//						System.out.println(pre + "/" + post);
					for(int j = 1; j <= 9; j++){
						String next = Integer.toString((d + j) % 10);
						int temp = Integer.parseInt(pre + next + post);
						//							System.out.println(temp);
						if(temp >= 1000 && arr[temp] == 0 && visit[temp] == 0 ){
							visit[temp] = 1;
							q.add(new Node(temp, n.count + 1));
						}
					}
				}
			}
			//			}
			bw.write(String.valueOf(ret) + "\n");
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

	public class Node{
		int number;
		int count;
		public Node(int n, int c){
			this.number = n;
			this.count = c;
		}
	}
}
