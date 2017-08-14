package examples;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RunningMedianMyWay {
	
	private static ArrayList<Double> ar = new ArrayList<Double>();

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0;i<n;i++)
		{
			Double number = scan.nextDouble();
			insert(number);
			printMedian();
		}
	}
	
	public static void insert(Double number)
	{
		ar.add(number);
		Collections.sort(ar);
	}
	
	public static void printMedian()
	{
		DecimalFormat formatter = new DecimalFormat("0.0");
		Double median;
		int index;
		if(ar.size()%2==0)
		{
			index = ar.size()/2;
			median = (ar.get(index)+ar.get(index-1))/2;
		}
		else
		{
			index = (ar.size()-1)/2;
			median = ar.get(index);
		}
		System.out.println(formatter.format(median));
	}
}
