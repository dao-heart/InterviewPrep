import java.util.HashMap;
import java.util.Map;

public class CountNumberOfLetters {
    public static void main(String[] args) {
        String input = "aabbbbcccAAA";
        System.out.println("Count the chars in string : "+countChar(input));
    }

    public static String countChar(String s){
        String outputString = "";

        HashMap<String, Integer> stringCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch =  s.charAt(i);
            if(stringCountMap.get(ch+"")!=null){
                stringCountMap.put(ch+"",stringCountMap.get(ch+"")+1);
            }
            else {
                stringCountMap.put(ch+"",1);
            }
        }

        for (Map.Entry<String,Integer> value: stringCountMap.entrySet() ) {
            outputString+=value.getValue()+value.getKey();
        }

        return outputString;
    }
}
