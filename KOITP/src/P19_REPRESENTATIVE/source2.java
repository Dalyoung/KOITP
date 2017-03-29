package P19_REPRESENTATIVE;

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
		s.solve();
	}
	
	/**
	 * ��������Ʈ���� ��� �ʱ�ȭ�� �ݺ������� ����.
	 * �� ��������Ʈ���� ����� ���� dummy �����͸� ������ �Ѵ�.
	 * 1 2 3 4 5 �� ���, 1 2 3 4 5 0 0 0 ����..(5�� 2���� ���� ũ�Ƿ�, 2��3�� ���� ������Ѵ�.
	 * �ʱ�ȭ�� for������?
	 * 2�� �������� �����͸� ������Ʈ ���ش�..
	 * 
	 */
//	int M = 131072;
	int minArr[];
	int maxArr[];
	long sumArr[];
	int N, Q, M;
	public void solve() throws Exception{
		System.setIn(new FileInputStream("input/P19_REPRESENTATIVE.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		M = 1;
		int count = 0;
		while(M < N){
			M <<= 1;
			count++;
		}
		
		minArr = new int[2*M];
		maxArr = new int[2*M];
		sumArr = new long[2*M];
		Arrays.fill(minArr, 1000000001);
		Arrays.fill(maxArr, -1);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		System.out.println(st.nextToken());
		int num;
		for(int i = 1; i <= N; i++){
			num = Integer.parseInt(st.nextToken());
			updateMin(i, num);
			updateMax(i, num);
			updateSum(i, num);
		}
		print(minArr);
		print(maxArr);
		print(sumArr);
		
		Q = Integer.parseInt(br.readLine());
		String [] input;
		int n1, n2;
		for(int i = 0; i < Q; i++){
			input = br.readLine().split(" ");
			n1 = Integer.parseInt(input[0]);
			n2 = Integer.parseInt(input[1]);
			bw.write(new StringBuffer()
					.append(String.valueOf(findMin(n1, n2))).append(" ")
					.append(String.valueOf(findMax(n1, n2))).append(" ")
					.append(String.valueOf(findSum(n1, n2))).append("\n")
					.toString());
		}
		br.close();
		bw.close();
		
	}
	void updateMin(int pos, int data){
		pos += M - 1;
		while(pos != 0){
			minArr[pos] = Math.min(data, minArr[pos]);
			pos>>=1; // /2 ����.
		}
	}
	
	void updateMax(int pos, int data){
		pos += M - 1;
		while(pos != 0){
			maxArr[pos] = Math.max(data, maxArr[pos]);
			pos>>=1; // /2 ����.
		}
	}
	
	void updateSum(int pos, int data){
		pos += M - 1;
		while(pos != 0){
			sumArr[pos] += data;
			pos>>=1; // /2 ����.
		}
	}
	
	
	long findMin(int le, int ri){
		long ret = 1000000001L;
		le += M - 1; 
		ri += M - 1;
		while(le <= ri){
			
			//Ȧ�� - �迭�� ������ ������.
			if((le&1) == 1){
				ret = Math.min(ret, minArr[le]);
				le++;
			}
			// ¦�� - �迭�� ���� ������
			if((ri&1) == 0){
				ret = Math.min(ret, minArr[ri]);
				ri--;
			}
			le>>=1;
			ri>>=1;
		}
		return ret;
	}
	
	long findMax(int le, int ri){
		long ret = 0;
		le += M - 1; 
		ri += M - 1;
		while(le <= ri){
			
			//Ȧ�� - �迭�� ������ ������.
			if((le&1) == 1){
				ret = Math.max(ret, maxArr[le]);
				le++;
			}
			// ¦�� - �迭�� ���� ������
			if((ri&1) == 0){
				ret = Math.max(ret, maxArr[ri]);
				ri--;
			}
			le>>=1;
			ri>>=1;
		}
		return ret;
	}
	
	long findSum(int le, int ri){
		long ret = 0;
		le += M - 1; 
		ri += M - 1;
		while(le <= ri){
			
			//Ȧ�� - �迭�� ������ ������.
			if((le&1) == 1){
				ret += sumArr[le];
				le++;
			}
			// ¦�� - �迭�� ���� ������
			if((ri&1) == 0){
				ret += sumArr[ri];
				ri--;
			}
			le>>=1;
			ri>>=1;
		}
		return ret;
	}
	
	public void print(int [] args){
		System.out.println(Arrays.toString(args));
	}
	
	public void print(long [] args){
		System.out.println(Arrays.toString(args));
	}
	
	public void print(int [][] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}

