package examples;

import java.util.Scanner;

class StringNode{
	StringNode left;
	StringNode right;
	String data;
	
	StringNode(String data)
	{
		this.data=data;
		left= null;
		right = null;
	}
}

public class Contacts {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		StringNode root = null;
		for (int i=0;i<=n;i++)
		{
			String input = scan.nextLine();
//			input = scan.nextLine();
			String[] splitInput = input.split(" ");
			if (input.contains("add"))
			{
				root = insertToTree(splitInput[1],root);
			}
			else if(input.contains("find"))
			{
				int count = findCount(splitInput[1],root);
				System.out.println(count);
			}
			
		}
	}

	private static int findCount(String string, StringNode root) {
		int count=0;
		if(root == null)
		{
			return 0;
		}
		if(root.data.contains(string))
		{
			count++;
		}
		count += findCount(string,root.left);
		count += findCount(string,root.right);
		return count;
	}

	private static StringNode insertToTree(String data,StringNode root) {
		if(root == null && data != null && !data.isEmpty() && !data.trim().isEmpty())
		{
			return new StringNode(data);
		}
		else
		{
			StringNode cur;
			if(data.compareTo(root.data)<=0)
			{
				cur = insertToTree(data,root.left);
				root.left= cur;
			}
			else{
				cur = insertToTree(data,root.right);
				root.right = cur;
			}
			return root;
		}
	}
}
