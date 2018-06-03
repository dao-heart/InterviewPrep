package Practice;

import java.util.Arrays;

public class MargeSort {

    public static void main(String[] args) {
        int [] input =  new int []{3,2,100,32,45,32,20,10,11,10,3,4};
        System.out.println("Input====");
        Arrays.stream(input).forEach(p-> System.out.print(" "+p));

        int [] output  = mergeSort(input);

        System.out.println();
        System.out.println("Output====");
        Arrays.stream(output).forEach(p-> System.out.print(" "+p));
    }


    public static int [] mergeSort(int [] inputArray){

        if(inputArray.length==1)
            return inputArray;

        int [] array1 =  new int[inputArray.length/2];
        int [] array2;
        if(inputArray.length%2 == 0)
            array2 = new int[inputArray.length/2];
        else
            array2 = new int[inputArray.length/2+1];

        System.arraycopy(inputArray,0,array1,0,array1.length);
        System.arraycopy(inputArray,inputArray.length/2,array2,0,array2.length);

        int [] sortedArray1 = mergeSort(array1);
        int [] sortedArray2 = mergeSort(array2);
        int [] result = new int[sortedArray1.length+sortedArray2.length];
        int resultIndex = 0;
        //merge logic

        int sortedArray1Index=0;
        int sortedArray2Index=0;

        while(sortedArray1Index < sortedArray1.length && sortedArray2Index < sortedArray2.length){

            if(sortedArray1[sortedArray1Index] <= sortedArray2[sortedArray2Index]){
                result[resultIndex++] = sortedArray1[sortedArray1Index++];
            }else{
                result[resultIndex++] = sortedArray2[sortedArray2Index++];
            }
        }

        while (sortedArray1Index < sortedArray1.length ){
            result[resultIndex++] = sortedArray1[sortedArray1Index++];
        }


        while (sortedArray2Index < sortedArray2.length ){
            result[resultIndex++] = sortedArray2[sortedArray2Index++];
        }
        return result;
    }
}
