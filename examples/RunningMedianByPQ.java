package examples;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedianByPQ {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		//Max Heap
		PriorityQueue<Integer> left = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -o1.compareTo(o2);
			}
		});
		//MinHeap
		PriorityQueue<Integer> right = new PriorityQueue<Integer>(n,new Comparator<Integer>(){
			public int compare(Integer o1,Integer o2)
			{
				return o1.compareTo(o2);
			}
		});
		
		for(int i=0;i<n;i++)
		{
			int number = scan.nextInt();
			insert(right,number);
			balance(left,right);
			printMedian(left,right);
		}
	}

	private static DecimalFormat formatter = new DecimalFormat("0.0");
	
	private static void printMedian(PriorityQueue<Integer> left,
			PriorityQueue<Integer> right) {
		if(left.size()==right.size())
			System.out.println(formatter.format((left.peek()+right.peek())/2.0));
		else if (left.size()==right.size()+1)
			System.out.println(formatter.format(left.peek()));
		
	}

	private static void balance(PriorityQueue<Integer> left,
			PriorityQueue<Integer> right) {
		if(left.size() < right.size())
			left.add(right.poll());
		else if(left.size()==right.size() || left.peek()>right.peek())
		{
			int l = left.poll();
			int r = right.poll();
			left.add(r);
			right.add(l);
		}
	}

	private static void insert(PriorityQueue<Integer> right, int number) {
		right.add(number);
		
	}
}
