package examples;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertionSort {
    
    

    public static void insertIntoSorted(int[] ar) {
        int n = ar.length;
        int temp = ar[n-1];
        for(int i=n-2;i>=0;i--)
        {
            for(int j=i+1;j>=0;j--)
            {
                if(ar[i]>temp)
                {
                    ar[j]=ar[i];
                    printArray(ar);
                    ar[i]=temp;
                    break;
                }
            }
        }
        printArray(ar);
    }
    
    
/* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}