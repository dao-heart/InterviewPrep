import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;

public class MargeSort
{
    public static ArrayList<Integer> margeSort(int [] a, int [] b){
        ArrayList<Integer> margedList = new ArrayList<>();

        int i=0,j=0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                margedList.add(a[i]);
                i++;
            }
            else{
                margedList.add(b[j]);
                j++;
            }
        }

        if(i<a.length){
            margedList.add(a[i]);
        }
        if(j<b.length){
            margedList.add(b[j]);
        }

        return margedList;
    }


    public static void main(String[] args) {
        System.out.println("MargeSort the arrays :");

        int [] a = new int []{1,4,7,9,99};
        int [] b = new int []{2,3,8,11};

        System.out.println("Array 1: "+a[0] + a[1] + a[2]);
        System.out.println("Array 2: ");
        Arrays.stream(b).forEach(p->System.out.print(p +"  "));
        System.out.println();

        System.out.println("Marge Sorted Array: "+margeSort(a,b).toString());
    }
}
