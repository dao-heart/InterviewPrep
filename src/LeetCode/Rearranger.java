package LeetCode;

public class Rearranger{
    public  static void main(String [] args){
        int [] input = new int[]{1,9,7,3,4,9,10,2,4,7,9,0 };
        System.out.println("--Input--");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+" ");
        }

        rearrange(input,8);

        System.out.println();
        System.out.println("--output--");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+" ");
        }
    }

    public static void rearrange(int [] input, int pivot){
        input[input.length-1]=pivot;

        System.out.println();
        System.out.println("--mid--");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+" ");
        }

        int i=0;
        int j=input.length-2;
        while(i<j){
            while(input[i]<pivot)
                i++;

            while(input[j]>pivot)
                j--;

            if(i<j)
                swap(input,i,j);

            System.out.println();
            System.out.println("====");
            System.out.println("--mid-i: "+i+" j: "+j);
            for (int k = 0; k < input.length; k++) {
                System.out.print(input[k]+" ");
            }
            System.out.println();

        }

        System.out.println();
        System.out.println("--mid-2--");
        for (int k = 0; k < input.length; k++) {
            System.out.print(input[k]+" ");
        }


        swap(input,i,input.length-1);

    }


    public static void swap(int []input, int i,int j)
    {
        input[j]=input[j]+input[i];
        input[i]=input[j]-input[i];
        input[j]=input[j]-input[i];
    }

}
