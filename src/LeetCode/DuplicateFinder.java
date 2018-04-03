package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class DuplicateFinder{
    public static void main(String [] args){
        int [] input = new int[]{1,3,4,10,41,31};
        System.out.println("The array has duplicates : "+findDuplicates(input));

        double [] inputDouble = new double[]{1.333,3.0,4,1.333,10,41,31};
        System.out.println("The array has (Double) duplicates : "+findDuplicatesForDoubles(inputDouble));

        float [] inputFloat = new float[]{1.333f,3.0f,4f,1.333f,10f,41f,31f};
        System.out.println("The array has (Float) duplicates : "+findDuplicatesForFloat(inputFloat));

    }


    public static boolean findDuplicates(int [] input){
        Set<Integer> numberTrackerSet =  new HashSet<>();

        for(int i=0;i<input.length;i++){
            if(numberTrackerSet.contains(input[i]))
                return true;
	    else
            numberTrackerSet.add(input[i]);
        }
        return false;
    }

    public static boolean findDuplicatesForDoubles(double [] input){
        Set<Double> numberTrackerSet =  new HashSet<>();

        for(int i=0;i<input.length;i++){
            if(numberTrackerSet.contains(input[i]))
                return true;
            else
                numberTrackerSet.add(input[i]);
        }
        return false;
    }

    public static boolean findDuplicatesForFloat(float [] input){
        Set<Float> numberTrackerSet =  new HashSet<>();

        for(int i=0;i<input.length;i++){
            if(numberTrackerSet.contains(input[i]))
                return true;
            else
                numberTrackerSet.add(input[i]);
        }
        return false;
    }
}

