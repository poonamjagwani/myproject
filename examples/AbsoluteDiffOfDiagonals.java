package examples;
import java.util.Scanner;

public class AbsoluteDiffOfDiagonals {

    public static int findAbsoluteDiff(int n)
    {
        Scanner in = new Scanner(System.in);
        int leftDiagonal=0,rightDiagonal=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int k = in.nextInt();
                if(i==j)
                {
                    leftDiagonal += k;
                }
                if((i+j) == (n-1))
                {
                    rightDiagonal += k;
                }
            }
        }
        return Math.abs(leftDiagonal-rightDiagonal);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        int diff;
        diff = findAbsoluteDiff(n);
        System.out.println(diff);
    }
}