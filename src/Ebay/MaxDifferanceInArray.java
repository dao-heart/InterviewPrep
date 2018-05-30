package Ebay;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxDifferanceInArray {
    public static void main(String[] args) {
        int [] input= new int []{2,3,10,2,4,8,1};
        System.out.println("Max diff from left to right = "+getMaxDiff(input));
    }
    public static int getMaxDiff(int [] input){

        Queue<Integer> minFinder = new PriorityQueue<>();
        int maxDiff = 0;
        for(int value:input){
            minFinder.add(value);
            if(minFinder.peek()< value)
                maxDiff = Math.max(maxDiff,value-minFinder.peek());
        }

        minFinder.stream().forEach(System.out::println);
        minFinder.poll();
        System.out.println();
        minFinder.stream().forEach(System.out::println);
        System.out.println();

        return maxDiff;
    }


}
