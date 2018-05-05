import java.util.*;

public class AmazonWordMaxFrequency{
    public static void main(String [] args){
        String input =  "eat the ball of my eatting friend who ball me now that was super eat";
        List<String> wordsToDrop =  new ArrayList<>();
        wordsToDrop.add("is");
        wordsToDrop.add("the");
        wordsToDrop.add("an");
        wordsToDrop.add("a");
        wordsToDrop.add("of");
        wordsToDrop.add("on");

        List<String> output = retriveTheMostUsedWord(input,wordsToDrop);
    }

    public static List<String> retriveTheMostUsedWord(String literatureText, List<String> wordsToDrop){

        Map<String, Integer> wordMap= new HashMap<>();

        Set<String> commonWords =  new HashSet<>();
        for(String word: wordsToDrop){
            commonWords.add(word);
        }

        int start = 0;
        while(literatureText.length()>0){
            int indexOfWordBrake = literatureText.indexOf(" ");

            if(indexOfWordBrake<0)
                break;

            String temp = literatureText.substring(start,indexOfWordBrake-1);
            literatureText = literatureText.substring(indexOfWordBrake+1);

        }


        return null;
    }

}