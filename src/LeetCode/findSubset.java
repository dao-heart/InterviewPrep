package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findSubset{
    public static void main(String [] args){
        int [] array1 = new int[]{1,2,2,3,4,5,6,100,200,300};
        int [] array2 =  new int[]{2,4,2,6,200,7};
        int [] output = findSubsetOfArrays(array1,array2);

        System.out.println("  =====  ");
        for(int i=0;i<output.length;i++){
            System.out.print(output[i]+" ");
        }
    }

    public static int [] findSubsetOfArrays(int [] array1, int [] array2){
        List<Integer> outputList = new ArrayList<>();
        Map<Integer,Integer> firstArrayMap =  new HashMap<>();
        for(int i=0;i<array1.length;i++){
            if(firstArrayMap.containsKey(array1[i]))
                firstArrayMap.put(array1[i],firstArrayMap.get(array1[i])+1);
            else
                firstArrayMap.put(array1[i],1);
        }

        for(int i=0;i<array2.length;i++){
            if(firstArrayMap.containsKey(array2[i]) && firstArrayMap.get(array2[i])>0){
                outputList.add(array2[i]);
                firstArrayMap.put(array2[i],firstArrayMap.get(array2[i])-1);
            }
        }

        int [] output =  new int[outputList.size()];
        int i=0;
        for(int number: outputList){
            output[i++]=number;
        }
        return output;
    }
}
