package Java8;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class getOddRange {
    public static void main(String[] args) {
        int l=2;
        int r=17;
        System.out.println("Range : ");
        //Arrays.stream(oddNumbers(l,r)).forEach(p->System.out.println(p +"  "));
        System.out.println(oddNumbersWithStream(l,r));
    }

    public static int[] oddNumbers(int l, int r){
        ArrayList<Integer> output = new ArrayList<>();
        if(l>r) return new int[]{};
        if(l%2==0) l++;
        if(l==r) return new int[]{l};
        for (int i = l; i <= r; i+=2) {
            output.add(i);
        }

        int [] outArray = new int[output.size()];
        int pointer =0;
        for (int i:output
             ) {
            outArray[pointer++]=i;
        }
        return outArray;
    }

    public static int[] oddNumbersWithStream(int l, int r){

        int [] output = IntStream.rangeClosed(l,r).filter(p->p%2!=0).toArray();

        Arrays.stream(output).forEach(p-> System.out.print( p+"  "));

        return output;
    }

}
