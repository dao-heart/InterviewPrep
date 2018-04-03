package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class findElementOccuredOnce{

    public static void main(String [] args){
        int [] input1 =  new int[]{1,1,2,2,3,4,3,4,5,6,5};
        int [] input2 =  new int[]{1,1,1,2,2,3,4,3,5,4,4,3,3};
        System.out.println("getElementOccuredOnce : "+getElementOccuredOnce(input1));
        System.out.println("getElementsOccuredOnceFromAllOthers : "+getElementsOccuredOnceFromAllOthers(input2));

    }

    public static int getElementOccuredOnce(int [] input){ //other element occured only twice
        Set<Integer> numberSet = new HashSet<>();

        for(int i=0;i<input.length;i++){
            if(numberSet.contains(input[i]))
            numberSet.remove(input[i]);
        	else
            numberSet.add(input[i]);
        }

        for(int number:numberSet){
            return number;
        }
        return 0;
    }

    public static int getElementsOccuredOnceFromAllOthers(int [] input){ //other elements occured multiple times
        Map<Integer, Integer> numberMap = new HashMap<>();

        for(int i=0;i<input.length;i++){
            if(numberMap.containsKey(input[i])){
                numberMap.put(input[i], numberMap.get(input[i])+1);
            }else{
                numberMap.put(input[i],1);
            }
        }

        for(int key: numberMap.keySet()){
            if(numberMap.get(key)==1){
                return key;
            }
        }

        return 0;
    }


}
