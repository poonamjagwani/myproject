package examples;
import java.util.*;

public class CopyOfLazyBartender {

	public static void main(String[] args) {

		HashMap<String, Set<String>> custMap = new HashMap<String, Set<String>>();

		custMap.put("cust1", new HashSet<String>(Arrays.asList("n3", "n7", "n5", "n2", "n9")));
		custMap.put("cust2", new HashSet<String>(Arrays.asList("n5")));
		custMap.put("cust3", new HashSet<String>(Arrays.asList("n2", "n3")));
		custMap.put("cust4", new HashSet<String>(Arrays.asList("n4")));
		custMap.put("cust5", new HashSet<String>(Arrays.asList("n3", "n4", "n5", "n7")));

		System.out.println("total number of drinks required: " + countDrinks(custMap));
	}

	private static int countDrinks(HashMap custMap) {

		int count = 0;
		HashMap<String, ArrayList<String>> cutomerDrinksMap;
		Iterator custItr = custMap.entrySet().iterator();

		while (custItr.hasNext()) {
			Map.Entry pairs = (Map.Entry) custItr.next();

			String customer = (String) pairs.getKey();
			Set<String> drinksSet = (Set<String>) pairs.getValue();

			String maxDrinks = new String();
			int maxDrinksCount = 0;

			cutomerDrinksMap = new HashMap<String, ArrayList<String>>(); // temporaryMap

			for (String set : drinksSet) {

				
				cutomerDrinksMap.put(set, new ArrayList<String>(Arrays.asList(customer)));
				
				if (cutomerDrinksMap.get(set).size() > maxDrinksCount) {
					maxDrinksCount = cutomerDrinksMap.get(set).size();
					maxDrinks = set;
				}
				
				
				Iterator internalCustItr = custMap.entrySet().iterator();
				while (internalCustItr.hasNext()) {

					Map.Entry internalPairs = (Map.Entry) internalCustItr.next();
					String internalCustomer = (String) internalPairs.getKey();

					if (!internalCustomer.equals(customer)) {

						Set<String> internalDrinksSet = (Set<String>) internalPairs.getValue();

						if (internalDrinksSet.contains(set)) {
							cutomerDrinksMap.get(set).add(internalCustomer);

							if (cutomerDrinksMap.get(set).size() > maxDrinksCount) {
								maxDrinksCount = cutomerDrinksMap.get(set).size();
								maxDrinks = set;
							}

						}

					}

				}

			}

			ArrayList customerList = cutomerDrinksMap.get(maxDrinks);
			
			if (customerList != null && customerList.size() > 0) {
				count++;
				for (int index = 0; index < customerList.size(); index++) {
					custMap.remove(customerList.get(index));
				}
			}
			custItr = custMap.entrySet().iterator();
		
		}

		return count;
	}

}