package examples;

import java.util.Arrays;
import java.util.Scanner;

public class FindingMissingNoMine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		FindingMissingNoMine s = new FindingMissingNoMine();
//		int[] arr = {3,4,6,7,8};
//		int[] arr = {0,1,2,3,4,6,7,8,9,10,11,12,13,14,15};
//		int missingNumber = missingNumber(arr);
//		System.out.println("Missing number is : "+missingNumber);
		int[] arr = {2,3,4,6,7,8,9,10,11,12,13,14,15};
		int missingNumber = s.foo(arr,0,12,13);
		
		if (missingNumber == -1)
			System.out.println("No missing number");
		
	}

	public static int missingNumber(int[] nums) {
		   Arrays.sort(nums);
		   int l=0, r=nums.length;
		   while(l<r){
		       int m = (l+r)/2;
		       if(nums[m]>m){
		           r=m;
		       }else{
		           l=m+1;
		       }
		   }
		 
		   return r;
		}
	
	public int foo(int[] a,int low,int high, int len) {
			int missinNumber=0;
			int mid = (low+high)/2;
			if(a[low]+(len-1)==a[high])
				return -1;
			if(low+1==high)
			{
				if(a[low]+1 != a[high])
				{
					missinNumber = a[low]+1;
					System.out.println("Missing element is : "+missinNumber);
					return missinNumber;
				}
			}
			if(len==1)
			{
				if(a[low]+1 < a[mid])
				{
					missinNumber = a[low]+1;
					System.out.println("Missing number is : "+missinNumber);
					return missinNumber;
				}
				if(a[mid]+1 < a[high])
				{
					missinNumber = a[mid]+1;
					System.out.println("Missing number is : "+missinNumber);
					return missinNumber;
				}
			}
			if(a[mid]+len/2<a[high])
			{
				low = mid;
				foo(a,low,high,len/2);
			}
			else
			{
				high = mid;
				foo(a,low,high,len/2);
			}
			
		  	return missinNumber;
	}

}
