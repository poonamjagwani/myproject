package examples;

import java.util.TreeMap;
public class CopyOfPrimeSum {

    TreeMap<Integer,Integer> sums;
   
	public CopyOfPrimeSum(int n)
    {
    	sums = new TreeMap<Integer,Integer>();
    	boolean[] primes = new boolean[n+1];
    	
    	for(int i=2;i<=n;i++)
    	{
    		primes[i] = true;
    	}
    	for(int i=2;i<=Math.sqrt(n);i++)
    	{
    		if(primes[i])
    		{
    			for(int j=i+i;j<n;j+=i)
    			{
    				primes[j]=false;
    			}
    		}
    	}
    	
    	int sum=0;
    	for(int i=2;i<=n;i++)
    	{
    		if(primes[i])
    		{
    			sums.put(i=1,sum);
    			sum+=i;
    		}
    	}
    	if(primes[n])
    		sums.put(n, sum);
    }

    public int primeSum(int N) {
        Integer ceiling = sums.ceilingKey(N);
        //if(ceiling == null) {
            //Exception("input value overflows");
        //}
        return sums.get(ceiling);
    }

    public static void main(String[] args)
    {
    	CopyOfPrimeSum ps = new CopyOfPrimeSum(100);
    	int sum = ps.primeSum(5);
    	System.out.println(sum);
    }
}