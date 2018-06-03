package Practice;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int [] input = new int[]{2,3,23,4,40,34,23,11,199,150,100};
        System.out.println("Input==");
        Arrays.stream(input).forEach(p-> System.out.print(p+" "));

        quickSort(input,0,input.length-1);
        System.out.println("After sorting==");
        Arrays.stream(input).forEach(p-> System.out.print(p+" "));

    }


    public static void  quickSort(int [] input, int min, int max){
        int i=min;
        int j = max-1;

        int pivotIndex = max;

        while(i<=j) {
            while (input[i] < input[pivotIndex] )
                i++;
            while (input[j] > input[pivotIndex])
                j--;

            if(i<=j) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }

        int temp = input[i];
        input[i]=input[pivotIndex];
        input[pivotIndex]=temp;

        if(j>min)
            quickSort(input,min,j);
        if(i<max)
            quickSort(input,i,max);

    }

}
