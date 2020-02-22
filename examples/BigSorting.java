package examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigSorting{		
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
//        int[] unsorted = new int[n];
        for(int i = 0; i < n; i++){
        	unsorted[i] = in.next();
        }
//        insertIntoSorted(unsorted);
        Arrays.sort(unsorted, new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				if(s1.length()>s2.length()) return 1;
				if(s1.length()<s2.length()) return -1;
				for(int i=0;i<s1.length();i++)
				{
					if((int)s1.charAt(i) > (int)s2.charAt(i)) return 1;
					if((int)s1.charAt(i) < (int)s2.charAt(i)) return -1;
				}
				return 0;
			}
        	
        	
        });

        
        StringBuilder output = new StringBuilder("");
        for(String num : unsorted)
            output.append(num+"\n");
        System.out.println(output);
	}
	
public static void insertIntoSorted(int[] ar) {
        int n = ar.length;
        //for(int i=)
        String str = "mat";
        n = str.length();
    }
}
