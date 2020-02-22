package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HighestAssociationGroup {
	
	private static int itemLength = 0;

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String inputLine = null;
		String[][] itemList = new String[10][2];
		
		for(int i=0;i<10;i++)
		{
			inputLine = scan.nextLine();
			if("".equals(inputLine))
			{
				itemLength=i;
				break;
			}
			String[] strArr = inputLine.split(",");
			String[] newStrArr;
			for(int j=0;j<strArr.length;j++)
			{
				if(strArr[j].contains("["))
				{
					
					String myString = removeSpecialCharacter(strArr[j],"[");
					itemList[i][0] = new String(myString);
				}
				else if(strArr[j].contains("]"))
				{
					String myString = removeSpecialCharacter(strArr[j],"]");
					itemList[i][1]=new String(myString);
				}
			}
		}
		
		HighestAssociationGroup sol = new HighestAssociationGroup();
		sol.findHAG(itemList);
	}
	
	private static String removeSpecialCharacter(String string, String splChar) {
		String newString = null;
		if(splChar.equals("["))
		{
			/*for(int i=0;i<string.length();i++)
			{
				if(string.charAt(i) != '[')
				{
					newString = string.substring(i);
					break;
				}
					
			}*/
			String[] strArr = string.split("\\[");
			for(int i=0;i<strArr.length;i++)
			{
				if(!strArr[i].equals(""))
				{
					newString = strArr[i];
				break;
				}
			}
		}
		if(splChar.equals("]"))
		{
			/*for(int i=0;i<string.length();i++)
			{
				if(string.charAt(i) == ']')
				{
					newString = string.substring(0,i);
					break;
				}
					
			}*/
			String[] strArr = string.split("\\]");
			for(int i=0;i<strArr.length;i++)
			{
				if(!strArr[i].equals(""))
				{
					newString = strArr[i];
				break;
				}
			}
		}
		return newString;
	}

	public String[] findHAG(String[][] itemList)
	{
		int n = itemLength;
		String [] highestAG = new String[itemLength*2];
		List<String> finalList= new ArrayList<String>();
		int commonfound = 0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				for(int k=0;k<2;k++)
				{
					if(itemList[i][0].equals(itemList[j][k]) || itemList[i][1].equals(itemList[j][k]))
					{
						if(!finalList.contains(itemList[i][0]))
							finalList.add(itemList[i][0]);
						if(!finalList.contains(itemList[i][1]))
							finalList.add(itemList[i][1]);
						if(!finalList.contains(itemList[j][0]))
							finalList.add(itemList[j][0]);
						if(!finalList.contains(itemList[j][1]))
							finalList.add(itemList[j][1]);
						commonfound = 1;
						break;
					}
				}
			}
			
		}
		if(commonfound == 0)
		{
			highestAG[0]=itemList[0][0];
			highestAG[1]=itemList[0][1];
			System.out.print(highestAG[0]+" "+highestAG[1]);
		}
		int i=0;
		Collections.sort(finalList);
		for(String str:finalList)
		{
			highestAG[i++]=str;
			System.out.print(str+" ");
		}
		return highestAG;
	}
}
