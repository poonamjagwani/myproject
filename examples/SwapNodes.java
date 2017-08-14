package examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*class Node
{
	Node left;
	Node right;
	int data;
	
	Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}*/

public class SwapNodes {

	private static Node root = new Node(1);
	
	private static void constructBinaryTree()
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Queue<Node> queue= new LinkedList<Node>();
		queue.add(root);
		for(int i=1;i<=n;i++)
		{
			Node cur = queue.remove();
			int l = scan.nextInt();
			int r = scan.nextInt();
			if(l!=-1)
			{
				Node left = new Node(l);
				cur.left = left;
				queue.add(left);
			}
			if(r != -1)
			{
				Node right = new Node(r);
				cur.right = right;
				queue.add(right);
			}
		}
	}
	
	
	private static void print(Node root)
	{
		if(root == null)
			return;
		if(root.left != null)
			print(root.left);
		System.out.print(root.data + " ");
		if(root.right != null)
			print(root.right);
	}
	
	
	public static void main(String[] args)
	{
		//constructBinaryTree();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Queue<Node> queue= new LinkedList<Node>();
		queue.add(root);
		for(int i=1;i<=n;i++)
		{
			Node cur = queue.remove();
			int l = scan.nextInt();
			int r = scan.nextInt();
			if(l!=-1)
			{
				Node left = new Node(l);
				cur.left = left;
				queue.add(left);
			}
			if(r != -1)
			{
				Node right = new Node(r);
				cur.right = right;
				queue.add(right);
			}
		}
		int T = scan.nextInt();
		for(int j=0;j<T;j++)
		{
			int k = scan.nextInt();
			swap(root,k);
			print(root);
			System.out.println();
		}
		
	}


	private static void swap(Node root, int k) {
		swap(root,1,k);
		
	}


	private static void swap(Node root2, int level, int k) {
		
			if(root2 == null || (root2.left ==null && root2.right==null ))
				return;
			if(level%k == 0)
			{
				Node temp = root2.left;
				root2.left = root2.right;
				root2.right = temp;
			}
			swap(root2.left,level+1,k);
			swap(root2.right,level+1,k);
		
	}
	
}
