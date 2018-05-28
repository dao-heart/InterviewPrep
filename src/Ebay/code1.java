package Ebay;

import java.util.HashMap;
import java.util.Map;

public class code1 {
    public static String findWinner(String votes[])
    {

        Map<String,Integer> map =
                new HashMap<>();
        for (String str : votes)
        {
            if (map.keySet().contains(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }

        int maxValueInMap = 0;
        String winner = "";

        for (Map.Entry<String,Integer> entry : map.entrySet())
        {
            String key  = entry.getKey();
            Integer val = entry.getValue();
            if (val > maxValueInMap)
            {
                maxValueInMap = val;
                winner = key;
            }

            else if (val == maxValueInMap &&
                    winner.compareTo(key) > 0)
                winner = key;
        }
       return winner;
    }

    // Driver code
    public static void main(String[] args)
    {
        String[] votes = { "john", "johnny", "jackie",
                "johnny", "john", "jackie",
                "jamie", "jamie", "john",
                "johnny", "jamie", "johnny",
                "john" };

        System.out.println(findWinner(votes));
    }

}

