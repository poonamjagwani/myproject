package examples;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    
    private static boolean checkIfBalanced(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(' || ch == '{' || ch == '[')
            {
                stack.push(ch);
            }
            else if(ch == ')' )
            {
                if(stack.isEmpty())            return false;
                else if (stack.pop() != '(')    return false;
            }
            else if(ch == '}' )
            {
                if(stack.isEmpty())            return false;
                else if (stack.pop() != '{')    return false;
            }
            else if(ch == ']' )
            {
                if(stack.isEmpty())            return false;
                else if (stack.pop() != '[')    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            boolean result = checkIfBalanced(s);
            System.out.println((result) ? "YES":"NO");
        }
    }
}
