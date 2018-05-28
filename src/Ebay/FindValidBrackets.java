package Ebay;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class FindValidBrackets {

    public static boolean bracketChecker(String input){

        Map<Character,Character> bracketLookup = new HashMap<>();
        bracketLookup.put('}','{');
        bracketLookup.put(']','[');
        bracketLookup.put(')','(');

        Stack<Character> symbolStack = new Stack<>();
        for(int i=0;i<input.length();i++){
            switch(input.charAt(i)){
                case '{':
                case '[':
                case '(':
                    symbolStack.push(input.charAt(i));
                    break;
                case '}':
                case ']':
                case ')':{
                     if(symbolStack.isEmpty() || bracketLookup.get(input.charAt(i))!= symbolStack.peek())
                         return false;
                     char temp = symbolStack.pop();
                     break;
                }
            }
        }
        if(symbolStack.isEmpty())
            return true;

        return false;
    }

    @Test
    public void testBracketChecker(){
        assertEquals("Test1",true,bracketChecker("{{[[]]}}"));
        assertEquals("Test2",false,bracketChecker("{{[]]}}"));
        assertEquals("Test3",false,bracketChecker("{{[[]}}"));
        assertEquals("Test4",true,bracketChecker("{{[[]()]()}}"));
        assertEquals("Test5",false,bracketChecker("}{"));
        assertEquals("Test6",true,bracketChecker("(a+b)"));
        assertEquals("Test7",true,bracketChecker("([a+(+)+b])[c+d]"));
    }

}
