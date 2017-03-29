package P41_SDS_PRO_6_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	/**
	 * 0 + (2Ta1)*Da2 + (2Ta1+2Ta2)*Da3 + ...
	 * 
	 * (2T*Dai + (2T+2Tai)*Dai+1)-(2T*Dai+1 + (2T+2Tai+1)*Dai)
	 * = Tai*Dai+1 - Tai+1*Dai
	 */
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P41_SDS_PRO_6_6.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N, T, K;
		N = Integer.parseInt(br.readLine());
		
		Pri [] ps = new Pri[N];
		String [] input;
		for(int i = 0; i < N; i++){
			input = br.readLine().split(" ");
			T = Integer.parseInt(input[0]);
			K = Integer.parseInt(input[1]);
			ps[i] = new Pri(T, K);
		}
		Arrays.sort(ps, new Comparator<Pri>() {

			@Override
			public int compare(Pri p1, Pri p2) {
				int temp1 = p1.t * 2 * p2.d;
				int temp2 = p2.t * 2 * p1.d;
				return temp1 - temp2;
			}
		});
//		print(ps);
		long ret = 0;
		long currentTime = ps[0].t * 2;
		for(int i = 1; i < N; i++){
			ret += currentTime * (long)ps[i].d;
			currentTime += (long)(ps[i].t * 2);
		}
		bw.write(ret + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	class Pri{
		int t;
		int d;
		public Pri(int t, int d){
			this.t = t;
			this.d = d;
		}
		@Override
		public String toString() {
			return "[t=" + t + ", d=" + d + "]";
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

