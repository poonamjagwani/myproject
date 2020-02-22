package examples;

import java.util.*;
import java.util.Map.Entry;

public class LazyBartender
{        
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
      LazyBartender sol = new LazyBartender();
        sol.startStop();
    }
    
    
    public int startStop(){
    	Set<String> commondrinks = new HashSet<String>();
		Map<String,Set<Integer>> customer = new HashMap<String,Set<Integer>>();
		customer.put("A", new HashSet<Integer>(Arrays.asList(3,7,5,2,9)));
		customer.put("B", new HashSet<Integer>(Arrays.asList(5,3)));
		customer.put("C", new HashSet<Integer>(Arrays.asList(2,3)));
		customer.put("D", new HashSet<Integer>(Arrays.asList(4)));
		customer.put("E", new HashSet<Integer>(Arrays.asList(3,4,3,5,7,4)));

		
		int maxCounterOfDrink = 0;
		Set<Integer> commonDrinks = new HashSet<Integer>();
			
			Entry<String, Set<Integer>> curCustomer;
			Entry<String, Set<Integer>> nextCustomer = null;
			/*Iterator<Entry<String, Set<Integer>>> it = customer.entrySet().iterator();
			curCustomer = it.next();
			*/
			Iterator<Entry<String, Set<Integer>>> it = customer.entrySet().iterator();
			curCustomer = it.next();
			while (it.hasNext()) {
			    
			    if(it.hasNext())
			    {
			    	nextCustomer = it.next();
			    }
			    commonDrinks = findCommonDrinks(curCustomer.getValue(),nextCustomer.getValue(),commonDrinks);
			    
			}
			
		System.out.println(commonDrinks.toString());

		return commonDrinks.size();
	}


	private Set<Integer> findCommonDrinks(Set<Integer> set1,Set<Integer> set2, Set<Integer> commonDrinks) {
		if(set1 == null || set2 == null)
			return commonDrinks;
		if(set1.size()==1)
			commonDrinks.addAll(set1);
		if(set2.size()==1)
			commonDrinks.addAll(set2);
		
		for(int drink : set1)
		{
			if(set2.contains(drink))
			{
				commonDrinks.add(drink);
			}
		}
		return commonDrinks;
	}
    
    
}