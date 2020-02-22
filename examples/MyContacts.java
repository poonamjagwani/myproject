package examples;

import java.util.HashMap;
import java.util.Scanner;


public class MyContacts {
	
	private static MyTrieNode root = new MyTrieNode();
	
	private static void add(String contact)
	{
		MyTrieNode cur = root;
		for(int i=0;i<contact.length();i++)
		{
			Character ch = contact.charAt(i);
			cur.addChildIfAbsent(ch);
			cur = cur.children.get(ch);
			cur.size++;
		}
	}
	
	private static int find(String prefix)
	{
		MyTrieNode cur = root;
		for(int i=0;i<prefix.length();i++)
		{
			Character ch = prefix.charAt(i);
			if(!cur.children.containsKey(ch))
				return 0;
			else
				cur = cur.children.get(ch);
		}
		return cur.size;
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0;i<n;i++)
		{
			String operation = scan.next();
			String contact = scan.next();
			if(operation.equals("add"))
			{
				add(contact);
			}
			else
			{
				System.out.println(find(contact));
			}
				
		}
	}

	private static class MyTrieNode{
		public HashMap<Character,MyTrieNode> children = new HashMap<Character,MyTrieNode>();
		public int size;
		
		public void addChildIfAbsent(Character ch)
		{
			if(children.get(ch)==null)
				children.put(ch, new MyTrieNode());
		}
	}
}
