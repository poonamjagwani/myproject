package examples;

public class FindMissingNo {
	// Do the XOR if 1 to n say its A
	// Do the XOR of given array say its B
	// Do the XOR of A and B will give the missing no
	public static int missingNo(int arrA[], int range) {
		int A = 0;
		int B = 0;
		for (int i = 1; i <= range; i++) {
			A = A ^ i;
		}
		for (int i = 0; i < arrA.length; i++) {
			B = B ^ arrA[i];
		}
		return A ^ B;
	}

	public static void main(String[] args) {
		/*int A[] = { 1, 2, 7, 5, 3, 6 };
		int range = 7;
		System.out.println("Missing No is :" + missingNo(A, range));*/
		int[] array = new int[]{3, 4, 5, 6, 7, 9, 10};
	    int missingInt = getMissingInt(array, 0, array.length-1);
	    System.out.println(missingInt); //it prints 9

	}

	
	public static int getMissingInt(int[] array, int low, int high) {
	    if (high == low + 1) return array[high] - 1;
	    int mid = low + (high - low) / 2;
	    if (array[mid] == array[low] + (array[high] - array[low]) / 2 - (high - low) % 2)
	        return getMissingInt(array, mid, high);
	    else 
	        return getMissingInt(array, low, mid);
	}

	
}
