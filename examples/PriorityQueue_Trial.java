package examples;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class PriorityQueue_Trial {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		//  A MIN HEAP
		PriorityQueue<Integer> right = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});

		//  A MAX HEAP
		PriorityQueue<Integer> left = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -o1.compareTo(o2);
			}
		});

		for(int i=0;i<n;i++){
			insert(left,right,in.nextInt());
			balance(left, right);
			printMedian(left, right);
		}
		
	}
	
	public static void insert(PriorityQueue<Integer> left, PriorityQueue<Integer> right,int number) {
		
		right.add(number);
	}
	
	public static void balance(PriorityQueue<Integer> left, PriorityQueue<Integer> right){

		if(left.size() < right.size())
			left.add(right.poll());
		else if(left.size() == right.size() && left.peek() > right.peek()){
			int l = left.poll();
			int r = right.poll();
			
			left.add(r);
			right.add(l);
		}
		
	}
	
	static DecimalFormat formatter = new DecimalFormat("0.0");

	public static void printMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
		
		if(left.size()==right.size())
			System.out.println(formatter.format(  (left.peek()+right.peek())/2.0  ));
		else if(left.size()==right.size()+1)
			System.out.println(formatter.format( left.peek() ));
		
	}
	
	
	
	
}
