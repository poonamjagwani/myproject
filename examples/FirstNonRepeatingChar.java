package examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstNonRepeatingChar {

	Set<Character> charSet = new HashSet<Character>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FirstNonRepeatingChar cls = new FirstNonRepeatingChar();
		//System.out.println(cls.fun("abcdeabcdr"));
		String str = "abcdeabcdr";
		int c=0;
		for(int i=0;i<str.length();++i){
			c ^= (int)str.charAt(i);
		}
		System.out.println((char)c);

	}
	
	public char fun(String str)
	{
		List<Character> nonRepeating = new ArrayList<Character>();
        List<Character> repeatCharacters = new ArrayList<Character>();
        int index = 0;

        for (int i=0;i<str.length();i++)
        {
        	Character ch = str.charAt(i);
            if (!nonRepeating.contains(ch))
            {
                nonRepeating.add(ch);
            }
            else
            {
                repeatCharacters.add(ch);
                nonRepeating.remove(ch);
            }
        }

        for(char c : nonRepeating)
        {
            if (index == 0 || str.indexOf(c) < index)
            {
                index = str.indexOf(c);
            }
        }

        return str.toCharArray()[index];
	}

}
