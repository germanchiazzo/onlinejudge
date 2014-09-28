import java.util.Scanner;
import java.util.Arrays;

/*
 * Poj 1050 - To The Max
 * Maximum Sub Rectangle in Matrix
 * Kadane's 2d Algorithm
 * Time O(n^3)
 * Auxiliary Space: O(n)
 */
public class Main{

	private static int[][] mat = new int[101][101];

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				mat[i][j] = in.nextInt();
			}
		}
		int result = kadane2D(n);
		System.out.println(result);
	}
	
	public static int kadane2D(int n){
		int max = 0;
		int current_max = 0;
		int[] maxFromRowI = new int[n];
		//Foreach start row
		for(int i = 0;i<n;i++){
			Arrays.fill(maxFromRowI, 0);
			//foreach end row
			for(int j = i;j<n;j++){
					//Compute sum from row i to row j having sum from row i to row j-1 in maxFromRowI
					for(int col = 0;col<n;col++){
						maxFromRowI[col] += mat[j][col];
					}
					//current maximum subrectangle from row i to row j
					current_max = kadane1D(maxFromRowI);
					if(max<current_max){
						max = current_max;
					}
			}
		}
		return max;
	}
	
	public static int kadane1D(int[] arr){
		int max_so_far = 0;
		int current_max = 0;
		for(int i = 0;i<arr.length;i++){
			current_max +=arr[i];
			if(current_max<0){
				current_max = 0;
			}else{
				if(current_max> max_so_far){
					 max_so_far = current_max;
				}
			}
		}
		return max_so_far;
	}
}