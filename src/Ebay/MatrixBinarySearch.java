package Ebay;

public class MatrixBinarySearch {

    public static void main(String[] args) {
        int [][] input =  new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int key = 10;
        System.out.println("Number is "+key+" present : "+findNumberInMatrix(input,key));

        System.out.println();
        key = 13;
        System.out.println("Number is "+key+" present : "+findNumberInMatrix(input,key));

        System.out.println();
        key = 4;
        System.out.println("Number is "+key+" present : "+findNumberInMatrix(input,key));

        System.out.println();
        key = -9;
        System.out.println("Number is "+key+" present : "+findNumberInMatrix(input,key));

        System.out.println();
        key = 100;
        System.out.println("Number is "+key+" present : "+findNumberInMatrix(input,key));

    }

    public static boolean findNumberInMatrix(int [][] input, int key){

        int row = getRow(input,key,0,input.length-1);
        System.out.println("Selected row = "+row);
        return isNumberInRow(input, row, key,0,input[0].length-1);
    }

    public static int getRow(int [][] input, int key, int lowRow, int highRow){
        int midRow = ((highRow+lowRow)/2);

        if(input[midRow][0]==key || lowRow>highRow)
            return midRow;
        if(input[midRow][0]>key)
            return getRow(input,key,lowRow,midRow-1);

        if(input[midRow][0]<key && input[midRow][input[0].length-1] > key)
            return midRow;
        else
            return getRow(input,key,midRow+1,highRow);
    }

    public static boolean isNumberInRow(int [][] input, int searchRow, int key,  int lowCol, int highCol){
        int midCol = (lowCol+highCol)/2;

        if(input[searchRow][midCol]==key) {
            System.out.println("Position of " + key + " :  Input[" + searchRow + "][" + midCol + "]");
            return true;
        }

        if(lowCol>highCol)
            return false;

        if(input[searchRow][midCol]>key)
            return isNumberInRow(input,searchRow,key,lowCol,midCol-1);

        if(input[searchRow][midCol]<key)
            return isNumberInRow(input,searchRow,key,midCol+1,highCol);

        return false;
    }
}
