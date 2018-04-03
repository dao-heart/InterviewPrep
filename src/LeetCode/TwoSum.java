package LeetCode;

public class TwoSum{
    public static void main(String [] args){
        int [] input =  new int[]{1,2,3,5,7,8,10,11,15,20,21,70};
        int target = 700;
        int [] output = getTwoItemsWithSum(input,target);

        System.out.println(output[0]+" "+output[1]);

    }

    public  static int[] getTwoItemsWithSum(int [] input, int target){
        int i=0;
        int j = input.length-1;

        while(i<j){
            while(j>input.length && input[i]+input[j]>target){ //length check to save from array index out of bound
                j--;
            }

            while(i < input.length && input[i]+input[j]<target){
                i++;
            }

            if( i < input.length &&  j>input.length && input[i]+input[j]==target)
                break;
        }

        if(i>j)
            return new int[]{0,0};
        else
            return new int[]{input[i],input[j]};
    }
}

