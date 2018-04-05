package LeetCode;

public class Morse{
    public static void main(String [] args){
        System.out.println(getMorseCode("iloveyouvishrutiwhatdoyouwantforyourbirthday"));
    }

    public static String getMorseCode(String input){
        String output="";
        input =  input.toLowerCase();
        String [] morseCode = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(int i=0;i<input.length();i++){
            output+= morseCode[(input.charAt(i)-'a')]+" ";
        }
        return output;
    }
}

