package Ebay;

import java.util.Arrays;
import java.util.Comparator;

public class SortString {
    public static void main(String[] args) {
        String [] input = new String []{"gaurang","sam","harry","pool","bob","zack","ash"};

        System.out.println("ASC==");
        Arrays.stream(getSortedString(input)).forEach(System.out::println);

        System.out.println();
        System.out.print("DESC==");
        Arrays.stream(getRevorderSortedString(input)).forEach(System.out::println);


    }
    public static String[] getSortedString(String [] input){

        Arrays.sort(input);

        return input;
    }

    public static String[] getRevorderSortedString(String[] input){

        Comparator<String> comparator = (String s1, String s2)->{
                    if(s1.equals(s2))
                        return 0;
                    else if((new StringBuilder(s1).reverse().toString().compareTo(new StringBuilder(s2).reverse().toString())) < 0)
                            return -1;
                    return 1;
        };

        Arrays.sort(input,comparator);
        return input;
    }



}
