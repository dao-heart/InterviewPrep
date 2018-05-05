package LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class CheckValidKeyboardWord {
    public static void main(String [] args){
    }




    public String[] getValidWords(String [] input){
        Set<String> output =  new HashSet<>();

        if(input.length==0)
            return new String[]{};
        if(input.length==1)
            return input;

        Map<Character,Integer> keyboardRow= new HashMap<>();
        keyboardRow.put('q',1);
        keyboardRow.put('w',1);
        keyboardRow.put('e',1);
        keyboardRow.put('r',1);
        keyboardRow.put('t',1);
        keyboardRow.put('y',1);
        keyboardRow.put('u',1);
        keyboardRow.put('i',1);
        keyboardRow.put('o',1);
        keyboardRow.put('p',1);

        keyboardRow.put('a',2);
        keyboardRow.put('s',2);
        keyboardRow.put('d',2);
        keyboardRow.put('f',2);
        keyboardRow.put('g',2);
        keyboardRow.put('h',2);
        keyboardRow.put('j',2);
        keyboardRow.put('k',2);
        keyboardRow.put('l',2);


        keyboardRow.put('z',3);
        keyboardRow.put('x',3);
        keyboardRow.put('c',3);
        keyboardRow.put('v',3);
        keyboardRow.put('b',3);
        keyboardRow.put('n',3);
        keyboardRow.put('m',3);

        //Char redundentChar;
        int keyBoardRow;

        for(String word: input){
            word = word.toLowerCase();
            keyBoardRow = keyboardRow.get(word.charAt(0));
            int i=1;
            for(;i<word.length();i++){
                if(keyBoardRow!= keyboardRow.get(word.charAt(i)))
                    break;
            }
            if(i==word.length()){
                output.add(word);
            }
        }

        int j=0;
        String [] out = new String[output.size()];
        for(String value: output){
            out [j++]=value;
        }
        return out ;
    }

    @Test
    public void testGetValidWords(){
        assertEquals("string matched", getValidWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}), new String[]{"Alaska", "Dad"});
    }


}
