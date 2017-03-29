package P12_USACO_2017FEB_MINCROSS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	
	int N;
	int q[][];
	int qInv[][];
	int qCopy[][];
	public void solve() throws Exception {
		//System.setIn(new FileInputStream("input/P12_USACO_2017FEB_MINCROSS.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		q = new int[2][N+1];
		qInv = new int[2][N+1];
		qCopy = new int[2][N+1];
		for(int i = 0; i < 2; i++){
			for(int j = 1; j <= N; j++){
				q[i][j] = Integer.parseInt(br.readLine());
				qInv[i][q[i][j]] = j;
			}
		}
		
		for(int i = 0; i < 2; i++){
			for(int j = 1; j <= N; j++){
				qCopy[i][j] = qInv[1-i][q[i][j]];
			}
		}
		
		for(int i = 0; i < 2; i++){
			for(int j = 1; j <= N; j++){
				q[i][j] = qCopy[i][j];
			}
		}
		
		long ret = Long.MAX_VALUE;
		
		for(int i = 0; i < 2; i++) {
	        long cur = inversions(q[i], 1, N);

	        for (int j = N; j >= 1; j--) {
	            cur += 2 * qCopy[i][j] - N - 1;
	            ret = Math.min(ret, cur);
	        }
	    }
//		print(q);
//		print(qInv);
//		print(qCopy);
		bw.write(String.valueOf(ret) + "\n");
		//bw.write(String.valueOf(count) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	List<Integer> merged = new ArrayList<>();
	public long inversions(int p[], int l, int r){
		if (l != r) {
	        int m = (l+r) / 2;  // [l,m], [m+1,r]

	        long res = inversions(p, l, m) + inversions(p, m + 1, r);

	        merged = new ArrayList<>();

	        int i = l; int j = m + 1;

	        while (i <= m && j <= r) {
	            if (p[i] < p[j]) {
	                res += j - (m + 1);
	                merged.add(p[i]);
	                i++;
	            }
	            else {
	                merged.add(p[j]);
	                j++;
	            }
	        }
	        while (i <= m) {
	            res += j - (m + 1);
	            merged.add(p[i]);
	            i++;
	        }
	        while (j <= r) {
	            merged.add(p[j]);
	            j++;
	        }

	        i = 0;
	        for (j = l; j <= r; j++) {
	            p[j] = merged.get(i);
	            i++;
	        }

	        return res;
	    }
	    else {
	        return 0;
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

}

// merge 할때, 왼쪽 원소를 넣을 때 오른쪽 배열의 위치..
/**
 * 1, 2, 5 - 4, 4, 6 이면
 * 5을 넣을 때 count가 2가 된다.
 * 
 * 
 * http://www.usaco.org/index.php?page=feb17results
 */

