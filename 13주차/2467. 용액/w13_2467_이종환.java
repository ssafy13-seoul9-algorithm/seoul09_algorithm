import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class w13_2467_이종환 {
	static int[] arr;
	static int size,idx1,idx2,totalMinDiff;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[size];
		for (int i = 0; i <size; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		idx1 = idx2 = totalMinDiff = Integer.MAX_VALUE;
		
		for (int i = 0; i < size; i++) binarySearch(i);
		
		System.out.println((arr[idx1] < arr[idx2])?arr[idx1] + " "+ arr[idx2] :arr[idx2] + " "+ arr[idx1] );
	}
	
	private static void binarySearch(int i) {
		int tempIdx = -1;
		int minDiff = Integer.MAX_VALUE;
		
		int start = 0;
		int end = size;
		int mid = (start+end)/2;
		
		while(start < end) {
			int tempSum = arr[i] + arr[mid];
			
			if (mid != i && Math.abs(tempSum) < minDiff) {
				tempIdx = mid;
				minDiff = Math.abs(tempSum);
			}
			
			if (tempSum < 0) {
				start = mid+1;
			} else {
				end = mid;
			}
			
			mid = (start+end)/2;
		}
		
		if (minDiff < totalMinDiff) {
			totalMinDiff = minDiff;
			idx1 =i;
			idx2 = tempIdx;
		}
		
	}
}
