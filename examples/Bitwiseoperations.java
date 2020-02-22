package examples;

import java.util.Scanner;

public class Bitwiseoperations {
	
	
	public static void main(String[] args)
	{
//		bitwiseAdd(10,3);
//		bitwiseMultiply(10,3);
		Scanner scan = new Scanner(System.in);
		int firstNum = scan.nextInt();
		int secondNum = scan.nextInt();
		bitwiseAdd(firstNum,secondNum);
		System.out.println("Result from add_rec : " +add_rec(firstNum,secondNum));
		
	}
	
	public static int add_rec(int a, int b) {
		if (b == 0) return a;
		 int sum = a ^ b; // add without carrying
		 int carry = (a & b) << 1; // carry, but don’t add
		 return add_rec(sum, carry); // recurse
		 }

	
	public static void bitwiseAdd(int n1, int n2) {
        int a = n1, b = n2;
        int sum, carry, temp;
        carry = a & b;
        sum = a ^ b;

        while (carry != 0) {
            carry <<= 1;
            temp = sum ^ carry;
            carry &= sum;
            sum = temp;
        }
        System.out.println(sum);
    }
	
	public static void bitwiseMultiply(int n1, int n2) {
        int a = n1, b = n2, result=0;
        while (b != 0) // Iterate the loop till b==0
        {
            if ((b & 01) != 0) // Logical ANDing of the value of b with 01
            {
                result = result + a; // Update the result with the new value of a.
            }
            a <<= 1;              // Left shifting the value contained in 'a' by 1.
            b >>= 1;             // Right shifting the value contained in 'b' by 1.
        }
        System.out.println(result);
    }
}
