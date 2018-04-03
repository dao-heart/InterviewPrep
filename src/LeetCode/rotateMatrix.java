package LeetCode;

public class rotateMatrix{
    public static void main(String [] args){
        int [][] input = new int[][] {{5, 1, 9,11},
                                    {2, 4, 8,10},
                                    {13, 3, 6, 7},
                                    {15,14,12,16}};

        System.out.println("===Input===");
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }
        int [][] output = rotate(input);

        System.out.println("===Output===");
        for(int i=0;i<output .length;i++){
            for(int j=0;j<output [0].length;j++) {
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int[][] input){
        int [][] output =  new int[input[0].length][input.length];

        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                 output[j][i]=input[i][j];
            }
        }
        return output;
    }
}
