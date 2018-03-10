import java.util.*;
public class MergeSortAlgo {

    public static void main(String[] args) {
        System.out.println("--Marge Sort--");


        int [] a =  new int[]{1,3,5,4,3,3, 9,4,7};
        int [] output = mergeSort(a);

        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]+ "   ");
        }


    }

    public static int [] mergeSort(int [] a){

        if(a.length==0){
            return null;
        }
        if(a.length==1){
            return a;
        }

        int [] array1 = new int[a.length/2];
        System.arraycopy(a,0,array1,0,array1.length);


        int [] array2;
        if(a.length%2==0)
            array2 = new int[a.length/2];
        else
            array2 = new int[a.length/2+1];
        System.arraycopy(a,array1.length,array2,0,array2.length);

        array1 =  mergeSort(array1);
        array2 =  mergeSort(array2);


        int []  returnArray =  new int[array1.length+array2.length];

        int returnArrayCounter = 0;
        int array1Count = 0;
        int array2Count = 0;


        while(array1Count < array1.length && array2Count < array2.length){
            if(array1[array1Count] < array2[array2Count] ){
                returnArray[returnArrayCounter++] = array1[array1Count++];
            }
            else {
                returnArray[returnArrayCounter++] = array2[array2Count++];
            }
        }


        while (array1Count < array1.length){
            returnArray[returnArrayCounter++]= array1[array1Count++];
        }


        while (array2Count < array2.length){
            returnArray[returnArrayCounter++]= array2[array2Count++];
        }

        return returnArray;

    }
}
