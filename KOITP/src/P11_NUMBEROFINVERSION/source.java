package P11_NUMBEROFINVERSION;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws Exception {
		source s = new source();
		s.solve();
	}
	int arr[];
	int N;
	public void solve() throws Exception {
		System.setIn(new FileInputStream("input/P11_NUMBEROFINVERSION.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken(" "));
		}
		
//		print(arr);
		long ret = 0;
		int [] temp = new int[N];
		ret = mergesort(arr, temp, 0, N-1);
//		print(arr);
		bw.write(String.valueOf(ret) + "\n");
		//bw.write(String.valueOf(count) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	long mergesort(int arr[], int temp[], int left, int right){
	
		long c = 0;
		//			System.out.println(left + ", " + right);
		if(right > left){
			
			int mid = (left + right) / 2;
			
			c = mergesort(arr, temp, left, mid);
			c += mergesort(arr, temp, mid+1, right);
			
			c += merge(arr, temp, left, mid + 1, right);
		}
		return c;
	}
	long merge(int [] arr, int [] temp, int left, int mid, int right){
		long c = 0;
		int i = left;
		int j = mid;
		int k = left;
		
		while((i <= mid - 1) && (j <= right)){
			if(arr[i] <= arr[j]){
				temp[k++] = arr[i++];
			}else{
				temp[k++] = arr[j++];
				c = c + (mid - i);
			}
		}
		while(i <= mid - 1){
			temp[k++] = arr[i++];
		}
		
		while(j <= right){
			temp[k++] = arr[j++];
		}
		
		for(i = left; i <= right; i++){
			arr[i] = temp[i];
		}
		
		return c;
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
 */

