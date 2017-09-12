import com.sun.deploy.security.DeployURLClassPathCallback;
import com.sun.xml.internal.ws.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortedArrayBasedOnNumberOfOnesInBinary {

    public static void main(String[] args) {

        int []  array =  new int[2];
        /*array[0]=5;
        array[1]=5;
        array[2]=3;
        array[3]=7;
        array[4]=10;
        array[5]=14;
*/
        array[0]=1;
        array[1]=1;
       /* array[2]=3;
        array[3]=7;
        array[4]=10;
        array[5]=14;*/

        System.out.println( "Rearrange :  "+rearrange(array) );
    }

    static int[] rearrange(int[] elements) {
        int [] output = new int[elements.length-1];
        ArrayList<Elements> e =  new ArrayList<Elements>();

        for (int i = 1; i < elements.length ; i++) {
            String binaryString = convertToBinary(elements[i]);
            int countOfOnes =  binaryString.replace("0", "").length();
          //  System.out.println("Number : "+elements[i] +" binaryString :  "+binaryString+"    length of binary : "+countOfOnes);

            Elements ElementsObject =  new Elements(countOfOnes,elements[i]);

            e.add(ElementsObject);
        }

        Collections.sort(e,Elements.ElementsComparator);

        int i=0;
        for (Elements element:e) {
            output[i]=element.decimalvalue;
            System.out.println( element.decimalvalue);
            i++;
        }
        return output;
    }

    public static String convertToBinary(int number){
        String output = "";
        int processNumber = number;

        while (processNumber>1) {
            output += processNumber % 2;
            processNumber = processNumber / 2;
        }
        output+=processNumber;
        return new StringBuffer(output).reverse().toString();
    }

    static class Elements implements Comparable<Elements>{
        int numberOfOne;
        int decimalvalue;

        public Elements(int numberOfOne,int decimalvalue ){
            this.numberOfOne =  numberOfOne;
            this.decimalvalue = decimalvalue;
        }

        public int compareTo(Elements compareElements) {
            return 0;
        }

        public static Comparator<Elements> ElementsComparator
                = new Comparator<Elements>() {

            public int compare(Elements e1, Elements e2) {

                if(e1.numberOfOne > e2.numberOfOne )
                {
                    return 1;
                }
                else if(e1.numberOfOne < e2.numberOfOne )
                {
                    return -1;
                }
                else if(e1.numberOfOne == e2.numberOfOne ) {
                    if(e1.decimalvalue>e2.decimalvalue){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }

                return 0;
            }

        };

    }
}


