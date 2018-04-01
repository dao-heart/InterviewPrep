package LeetCode;

import java.util.Arrays;

public class strRev {
    public static void main(String[] args) {

        String input = "Hello World";
        System.out.println(input);
        System.out.println(reverseString(input));
    }

    public static String reverseString(String s) {

        char [] chArray = s.toCharArray();
        for(int i =0; i <= s.length()/2; i++)
        {
            char temp;
            temp = chArray[i];
            chArray[i] = chArray[s.length()-1-i];
            chArray[s.length()-1-i] =  temp;
        }
        return new String(chArray);
    }
}
