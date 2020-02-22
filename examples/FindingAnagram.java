package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindingAnagram {

	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String s1 = scan.nextLine();
		String[] str = s1.split(",");
		String haystack = str[0];
		String needle = str[1];
		String st = haystack.substring(0);
		String stm = haystack.substring(0,4);
		FindingAnagram fa = new FindingAnagram();
		List<Integer> l1 = fa.findIndicesOfAnagram(haystack,needle);
		if( !l1.isEmpty())
		{
			for( int i:l1)
			{
				System.out.print(i+ " " );
			}
		}
	}

	public List<Integer> findIndicesOfAnagram(String haystack, String needle) {
		List<Integer> listOfIndices = new ArrayList<Integer>();
		int h = haystack.length();
		int n = needle.length();
		int j=0;
		int index = 0;
		for(int i=0;i<h;i++)
		{
			char ch = haystack.charAt(i);
			
			if(needle.charAt(j)==ch)
			{
				boolean flag = checkifNeedlePresent(needle,haystack.substring(i,h));
				if(flag == true)
				{
					
					listOfIndices.add(i);
					j=0;i+=n-1;
				}
			}
		}
		
		return listOfIndices;
	}

	private boolean checkifNeedlePresent(String needle, String substring) {
		return substring.contains(needle);
	}
	
	
}
