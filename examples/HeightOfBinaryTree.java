package examples;
import java.util.Scanner;


class HeightOfBinaryTree {	
    class Node 
    {
    	int data;
    	Node left;
    	Node right;

    	Node(int data)
    	{
    		this.data= data;
    		left = null;
    		right = null;
    	}
    }

static int height(Node root) {
  	int heightLeft=0,heightRight=0;
    if(root.left ==null && root.right == null)
        return 0;
    if(root.left != null)
        heightLeft = height(root.left);
    if(root.right != null)
        heightRight = height(root.right);
    if(heightLeft>heightRight)
    {
        return heightLeft+1;
    }
    else
    {
        return heightRight+1;
    }
}
public static Node insert(Node root, int data) {
    /*if(root == null){
        return new Node(data);
    }
    else */{
        Node cur;
        if(data <= root.data){
            cur = insert(root.left, data);
            root.left = cur;
        }
        else{
            cur = insert(root.right, data);
            root.right = cur;
        }
        return root;
    }
}


public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while(t-- > 0){
        int data = scan.nextInt();
        root = insert(root, data);
    }
    scan.close();
    int height = height(root);
    System.out.println(height);
}	
}