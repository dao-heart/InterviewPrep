import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Questions http://qa.geeksforgeeks.org/219/qa.geeksforgeeks.org/219/uneaten-leaves-problem

public class Solution2 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        int [] a = new int []{1,1,2,1,2,2};
        /*System.out.println( "Hello world! " +findShortestSubArray(a));*/
    }


    private int  count(int n , int[]a) {
        HashSet<Integer> eaten = new HashSet<>();
        Arrays.sort(a);
        for (int jump : a) {
            if (jump == 1) {
                return 0;
            }

            if (eaten.contains(jump)) {
                continue;
            }
            int jumpIndex = jump;
            System.out.println(jumpIndex);
            while (jumpIndex <= n) {
                System.out.println("While : " + jumpIndex);
                eaten.add(jumpIndex);
                jumpIndex = jumpIndex + jump;
            }
        }
        return n - eaten.size();
    }

}