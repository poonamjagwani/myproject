package examples;

import java.util.HashMap;
import java.util.TreeMap;

public class SecondMostRepeatingWord {
	
	public static void main(String[] args){
		System.out.println(secondMostRepeatingWord("abc ddd abc test abc ddd test aa aa aa aa a a a a a"));
		System.out.println(secondMostRepeatingWord("abc ddd ddd ddd abc ddd test"));
		System.out.println(secondMostRepeatingWord("ddd test ddd test ddd test"));
		System.out.println(secondMostRepeatingWord("ddd ddd ddd ddd ddd ddd"));
		System.out.println(secondMostRepeatingWord(""));
	}

	private static String secondMostRepeatingWord(String string) {

		HashMap<String,Integer> map= new HashMap<String,Integer>();
		for(String str:string.split(" ")){
			if(!map.containsKey(str)){
				map.put(str, 1);
			} else {
				map.put(str,map.get(str)+1);
			}
		}	
		
		TreeMap<Integer, String> finalMap = new TreeMap<Integer, String>();
		for(String word : map.keySet()){
			finalMap.put(map.get(word), word);
		}
		
		
		System.out.println("Map ===="+map);
		System.out.println("TreeMap ===="+finalMap);
		return finalMap.size()<2? finalMap.get(finalMap.keySet().toArray()[finalMap.size()-1]):
				finalMap.get(finalMap.keySet().toArray()[finalMap.size()-2]);
		
	}

}