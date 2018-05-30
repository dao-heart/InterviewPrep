package Java8;

import java.util.Arrays;

public class FindInArray {
    public static void main(String[] args) {
        int [] input = new int[]{1,1,3,3,3,4,5};
        int k = 3;

        System.out.println(findElement(input,k));

    }

    public static String findElement(int[] nums, int k) {

        if( Arrays.stream(nums).parallel().filter(p->p==k).findFirst().isPresent()){
            return "YES";
        }
        return "NO";
    }
}

