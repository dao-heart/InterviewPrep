package Java8;

import java.util.ArrayList;
import java.util.Arrays;

public class countNumber {

    public static void main(String [] args) {

        System.out.println("Sum " + processCount(new int[]{2, 3, 4, 5}));
        System.out.println("Sum with stream " + processCountNewJava(new int[]{2, 3, 4, 5}));

    }

    public static int processCount(int [] array){
        if(array==null)
            return 0;
        int sum=0;
        for (int number: array
             ) {
            sum+=number;
        }
        return sum;
    }

    public static int processCountNewJava(int [] array){
        if(array==null)
            return 0;
        return Arrays.stream(array)
                    .filter( p -> p > 3)
                    .sum();
    }
}
