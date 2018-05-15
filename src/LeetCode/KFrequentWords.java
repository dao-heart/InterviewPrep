/*
package LeetCode;

import java.util.*;

public class KFrequentWords {
    public static void main(String[] args) {
        String input = "I am gaurang mhatre, people call me gaurang as well, hence you can also call me as gaurang";

        System.out.println(input);

        String[] out = getkFrequentWords(input.split(" "),3);

        System.out.println("Output : ");
        Arrays.stream(out).forEach(System.out::println);

    }

    public static String [] getkFrequentWords(String [] inputArray, int frequency ){

        HashMap<String, Integer> wordCountMap = new HashMap<>();
        List<String> output =  new ArrayList<>();

        for(String input:inputArray){
            wordCountMap.put(input,wordCountMap.containsKey(input)?wordCountMap.get(input)+1:0);
        }

        Collections.sort(wordCountMap,(word1, word2) -> word1.getValue() == word2.getValue()? word1.getKey().equals(word2.getKey()):word1.getValue()-word2.getValue());

        Iterator itr = wordCountMap.entrySet().iterator();

        while (itr.hasNext()){
            Map.Entry currentEntry = (Map.Entry)itr.next();

            if((int)currentEntry.getValue()==frequency)
                output.add((String)currentEntry.getKey());
        }



        return output.toArray(new String[0]);
    }
}
*/
