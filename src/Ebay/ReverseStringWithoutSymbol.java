package Ebay;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringWithoutSymbol {
    public static String revStringWithoutSymbol(String input){
        int start = 0;
        int end = input.length()-1;


        char [] inputArray = input.toCharArray();

        while(start < end){

            while(isSymbol(input.charAt(start)))
            {
                start++;
            }

            while(isSymbol(input.charAt(end)))
            {
                end--;
            }

            if(start<end) { //TO prevent rev5 ... lot of symbols in middle
                char temp = inputArray[start];
                inputArray[start] = inputArray[end];
                inputArray[end] = temp;
            }
            start++;
            end--;
        }

        String output = "";
        for(char c :inputArray) output+=c;
        return output;
    }

    public static boolean isSymbol(char inputChar){
        if(inputChar >= 'a' && inputChar <= 'z' || inputChar >= 'A' && inputChar <= 'Z' || inputChar >= '0' && inputChar <= '9')
            return false;
        return true;
    }

    @Test
    public void revStringWithoutSymbol(){

        assertEquals("Rev1","Gaurang",revStringWithoutSymbol("gnaruaG"));
        assertEquals("Rev2","",revStringWithoutSymbol(""));
        assertEquals("Rev3","fed@cba",revStringWithoutSymbol("abc@def"));
        assertEquals("Rev4","%fed@cba$",revStringWithoutSymbol("%abc@def$"));
        assertEquals("Rev5","%fed@*cba$",revStringWithoutSymbol("%abc@*def$"));
    }

}
