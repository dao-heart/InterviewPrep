package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*   2,4,7,8,10,12 = 6
     1,3,3,7,9 = 5



     11 = item (6)
     7


     --------------


     2,4,7,8,10= 5
     1,3,3,7,9 = 5



     10 = item(5)+item(6) /2
        = 4 + 7 /2
        = 11/2 = 5.5



*/



public class MedianOfTwoSortedLists {
    public static void main(String[] args) { //1,2,3,4,5, 6,  7,8,9,10,12
        Integer [] arrayone = new Integer[]{2,4,6,8,10,12};
        List<Integer> listOne = Arrays.asList(arrayone);

        Integer [] arrayTwo = new Integer[]{1,3,3};
        List<Integer> listTwo = Arrays.asList(arrayTwo);


        System.out.println(getMedianOfSortedLists(listOne,listTwo));
    }


    public static double getMedianOfSortedLists(List<Integer> list1,List<Integer> list2){

        int totalNumberCount = list1.size()+list2.size();

        System.out.println(totalNumberCount);

        int list1Counter = 0;
        int list2Counter = 0;

        int medianTracker = 0;
        boolean countIsOdd = totalNumberCount%2==0?false:true;

        int median = 0;
        while(medianTracker++ <= (totalNumberCount)/2  && countIsOdd){

            if( list1Counter< list1.size() && list1.get(list1Counter)<= list2.get(list2Counter)  ){
                median = list1.get(list1Counter);
                if(list1Counter<list1.size()-1)
                    list1Counter++;
            }
            else if(list2Counter < list2.size()){
                median = list2.get(list2Counter);
                if(list2Counter<list2.size()-1)
                    list2Counter++;
            }
        }

        return median;


    }
}
