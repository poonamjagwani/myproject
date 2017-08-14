package examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Darrubaaj {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<String> commondrinks = new HashSet<String>();
		Map<String,Set<Integer>> customer = new HashMap<String,Set<Integer>>();
		customer.put("A", new HashSet<Integer>(Arrays.asList(3,7,5,2,9)));
		customer.put("B", new HashSet<Integer>(Arrays.asList(5,3)));
		customer.put("C", new HashSet<Integer>(Arrays.asList(2,3)));
		customer.put("D", new HashSet<Integer>(Arrays.asList(4)));
		customer.put("E", new HashSet<Integer>(Arrays.asList(3,4,3,5,7,4)));
		
		int[][] inputList = {
		{3,7,5,2,9},{5},{2,3},{4},{3,4,3,5,7,4}};
		
		/*int[][] inputList = {
				{4,5},{4},{2,3,5},{6},{1,2,3}};*/
		
//		Set<Integer>
		
		Set<Integer> resultSet = new HashSet<Integer>();
		
		for (int i = 0; i < inputList.length; i++) {
			int[] list = inputList[i];
			Arrays.sort(list);
			inputList[i] =list; 
		}
		
		for (int i = 0; i < inputList.length - 1; i++) {
			if (i == inputList.length - 1) {
				break;
			}
			int[] list1 = inputList[i];
			boolean loop = true;
			for (int j = i + 1; j < inputList.length && loop; j++) {
				int[] list2 = inputList[j];
				for (int k = 0; k < list1.length && k < list2.length; k++ ) {
					if (list1[k] > list2[k]) {
						inputList[i] = list2;
						inputList[j] = list1;
						loop = false;
						break;
					} else if (list1[k] < list2[k]) {
						loop = false;
						break;
					}
				}
				if (loop == true) {
					if (list1.length > list2.length) {
						inputList[i] = list2;
						inputList[j] = list1;
					}
				}
			}
			
		}
		for (int i = 0; i < inputList.length; i++) {

			resultSet.add(inputList[i][0]);
		}
		
		for (Iterator<Integer> iterator = resultSet.iterator(); iterator.hasNext();) {
			System.out.print(" " + iterator.next());
		}
	}

}
