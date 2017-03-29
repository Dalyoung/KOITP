package P43_LONGEST_INCREASING_SUBSEQUENCE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source2 {
	public static void main(String[] args) throws Exception {
		source2 s = new source2();
		s.test();
	}
	int N;
	int arr[] = {2, 10, 20, 30, 40, 50, 60, 70, 80};
	int dp[];
	
	void test(){
		int n = 30;
		System.out.println(lowerBound(0, arr.length, n));
		System.out.println(upperBound(0, arr.length, n));
	}
	
	int lowerBound(int s, int e, int target){
		int m;
		
		while(e-s > 0){
			m = (s+e)/2;
			if(arr[m] < target){
				s = m+1;
			}else{
				e = m;
			}
		}
		return e + 1;
	}
	
	int upperBound(int s, int e, int target){
		int m;
		
		while(e-s > 0){
			m = (s+e)/2;
			if(arr[m] <= target){
				s = m+1;
			}else{
				e = m;
			}
		}
		return s;
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

