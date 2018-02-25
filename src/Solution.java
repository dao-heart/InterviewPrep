import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Questions: https://leetcode.com/articles/degree-of-an-array/

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        int [] a = new int []{1,1,2,1,2,2};
        System.out.println( "Hello world! " +findShortestSubArray(a));
    }

    public static int findShortestSubArray(int[] arr) {
        Map<Integer, Integer> fromLeftSide = new HashMap();
        Map<Integer, Integer> fromRightSide = new HashMap();
        Map<Integer, Integer> countTracker = new HashMap();
        int minimum = arr.length;

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (fromLeftSide.get(x) == null) {
                fromLeftSide.put(x, i);
            }
            fromRightSide.put(x, i);
            if(countTracker.get(x)!=null){
                countTracker.put(x,countTracker.get(x)+1);
            }
            else{
                countTracker.put(x,1);
            }
            //countTracker.put(x, countTracker.getOrDefault(x, 0) + 1); //put difference as count
        }

        int degree = Collections.max(countTracker.values());
        for (int x: countTracker.keySet()) {
            if (countTracker.get(x) == degree) {
                minimum = Math.min(minimum, fromRightSide.get(x) - fromLeftSide.get(x) + 1);
            }
        }
        return minimum;
    }
}