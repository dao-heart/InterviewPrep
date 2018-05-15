import jdk.nashorn.internal.ir.annotations.Ignore;

public class contiguousSubarray {
    public static void main(String[] args) {

        int [] input =  new int[]{1,2,-1,3,-10,4,-4};
        System.out.println(getContiguousSum(input));
    }

    @Ignore
    public static int getContiguousSum(int [] input){
        int globalMaxSum = 0;
        int localMaxSum = 0;


        for(int number : input){

            localMaxSum = Math.max(localMaxSum, localMaxSum+number);
            /*if(localMaxSum > localMaxSum+number)
                localMaxSum = number;*/
            globalMaxSum = Math.max(globalMaxSum, localMaxSum);
        }
        return globalMaxSum;

    }
}

