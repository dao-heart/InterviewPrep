import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

    public static void main(String[] args) {

        System.out.println("Two Sum problem");

        int [] inputArray = new int[]{1,3,4,5};
        int target = 9;

        System.out.println("Two sum index : "+getTwoSum(inputArray,target));
    }

    public static String getTwoSum(int [] input, int target){

        HashMap<Integer,Integer> numbersSet= new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int compliment = target-input[i];
            if(numbersSet.containsKey(compliment)){
                return "["+i+" , "+ numbersSet.get(compliment)+ "]";
            }
            numbersSet.put(input[i],i);
        }
        return "No Match";
    }
}
