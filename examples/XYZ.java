package examples;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class XYZ{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        try{
        	System.out.println("Enter the string");
        	String s1=in.nextLine();
//        	String[] str1 = s1.split("\\[");
//        	String s2 = in.nextLine();
//        	System.out.println("Anagram of one of the strings is present in the second string: "+checkAnagrams(s1, s2));
        	List<String> per = permutation(s1);
        	for(String str:per)
        	{
        		System.out.println(str);
        	}
        }
        finally{
        	in.close();
        }
    }

    boolean checkIfElementExistInSet(List<Set<Integer>> setList,Set<Integer> inputSet) {
    	int n = inputSet.size();
    	for(Set currSet : setList)
    	{
    		int j=0;
    		/*for(int number : currSet)
    		{
    			if(inputSet.contains(number))
    			{
    				j++;
    			}
    		}*/
    		if(j!=n)
    			return false;
    	}
		return false;
    	
    }

/*
    * @param s the input string
    * @return  the list of permutation
    */
   public static ArrayList<String> permutation(String s) {
       // The result
       ArrayList<String> res = new ArrayList<String>();
       // If input string's length is 1, return {s}
       if (s.length() == 1) {
           res.add(s);
       } else if (s.length() > 1) {
           int lastIndex = s.length() - 1;
           // Find out the last character
           String last = s.substring(lastIndex);
           // Rest of the string
           String rest = s.substring(0, lastIndex);
           // Perform permutation on the rest string and
           // merge with the last character
           res = merge(permutation(rest), last);
       }
       return res;
   }

   /**
    * @param list a result of permutation, e.g. {"ab", "ba"}
    * @param c    the last character
    * @return     a merged new list, e.g. {"cab", "acb" ... }
    */
   public static ArrayList<String> merge(ArrayList<String> list, String c) {
       ArrayList<String> res = new ArrayList<String>();
       // Loop through all the string in the list
       for (String s : list) {
           // For each string, insert the last character to all possible postions
           // and add them to the new list
           for (int i = 0; i <= s.length(); ++i) {
               String ps = new StringBuffer(s).insert(i, c).toString();
               res.add(ps);
           }
       }
       return res;
   }
}