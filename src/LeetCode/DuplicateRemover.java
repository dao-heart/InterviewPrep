package LeetCode;

import com.sun.org.apache.xpath.internal.SourceTree;

public class DuplicateRemover{

        public static void main(String args[]){
            int [] input = new int[]{1,1,1,2,2,3,3,4,5,5,6};

            System.out.println("In");
            for(int i= 0;i<input.length;i++)
                System.out.print(input[i]+" ");

            removeDuplicates(input); //Pass by referance

            System.out.println();
            System.out.println("Out");
            for(int i= 0;i<input.length;i++)
                System.out.print(input[i]+" ");

        }

        public static void removeDuplicates(int [] input){

            int i=0;
            int j=1;

            while(j<input.length){
                if(input[j]!=input[j-1]){
                    input[++i]=input[j];
                 }
                 j++;
            }

            while(++i<j){
                input[i]=0;
            }

        }
}
