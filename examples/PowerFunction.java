package examples;

public class PowerFunction {

	public double powHelper(int a, int b)
	{
	    return b == 1 ? a : a * powHelper(a, b - 1);
	}

	public double pow(int a, int b)
	{
	  // Corner cases and edge cases
	  if (b == 0 && a < 0) return -1;
	  if (a == 0 && b < 0) return -1 >> 1; // MAX_INT
	  if (b == 0) return 1;
	  if (a == 0) return 0;
	  
	  // Use separate helper function to avoid
	  // duplicating corner/edge case tests
	  if (b > 0)
	    return powHelper(a, b);
	  else
	    return 1.0 / powHelper(a, -b);
	}
	
	public static void main(String[] args)
	{
		PowerFunction pf = new PowerFunction();
		System.out.println(" 2^3 = "+pf.pow(2, 3));
		System.out.println(" 0^3 = "+pf.pow(0, 3));
		System.out.println(" 2^0 = "+pf.pow(2,0));
		System.out.println(" 2^1 = "+pf.pow(2,1));
		System.out.println(" 2^-3 = "+pf.pow(2,-3));
		System.out.println(" 0^-1 = "+pf.pow(0,-1));
	}
}
