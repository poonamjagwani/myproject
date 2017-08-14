package examples;

import java.util.HashMap;

public class FigureToWords {

	public static HashMap<Integer,String> map = new HashMap<Integer,String>();
	
	public static void main(String[] args)
	{
		init();
		System.out.println(convert(1256,10));
	}
	
static void init(){
		
		map.put(0, "Zero");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Nineteen");
		
		map.put(10, "Ten");
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Fourty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eightty");
		map.put(90, "Ninety");
		
		map.put(100, "Hundred and");
		map.put(1000, "Thousand");
		map.put(100000, "Lacks");
	}
	
	static String convert(int number, int divisor){
		
//		Single digit - return
		if(number < 10) { return map.get(number); }
		
//		Double digits
		if(number < 100) { return map.get(number - (number%10)) + " " + map.get(number%10); }
		
		while(number/ divisor > 9){
			divisor *= 10;
		}
		
		String currentString = "";
		if(!map.containsKey(divisor)){ currentString = map.get(Integer.valueOf(number/divisor + "0")); }
		else { currentString = map.get(number/divisor) + " " + map.get(divisor); }
		
		return currentString + " " + convert(number%divisor, 1);

	}
}
