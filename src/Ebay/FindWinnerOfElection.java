package Ebay;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class FindWinnerOfElection {


    public static void main(String[] args)
    {
        String[] votes = { "john", "jphnny", "jackie",
                "jphnny", "john", "jackie",
                "jamie", "jamie", "john",
                "jphnny", "jamie", "jphnny",
                "john" };

        System.out.println(computeWinner(votes));
        System.out.println(computeWinnerWithStream(votes));
    }

    public static String computeWinner(String [] votes){
        Map<String, Integer> voteMap = new HashMap<>();

        for(String vote:votes){
            if(voteMap.get(vote)!=null){
                voteMap.put(vote, voteMap.get(vote)+1);
            }else{
                voteMap.put(vote,1);
            }
        }
        int maxVotes = 0;
        String winner = "";

        for(Map.Entry<String,Integer> entry: voteMap.entrySet()){
            System.out.println(entry.getKey()+"  ->  "+entry.getValue());
            if(entry.getValue() > maxVotes){
                maxVotes=entry.getValue();
                winner= entry.getKey();
            }else if(entry.getValue()==maxVotes && entry.getKey().compareTo(winner)>0){
                winner= entry.getKey();
            }
        }
        return winner;
    }

    public static String computeWinnerWithStream(String [] votes){

        Map<String, Integer> voteMap = new HashMap<>();

        for(String vote:votes){
            if(voteMap.get(vote)!=null){
                voteMap.put(vote, voteMap.get(vote)+1);
            }else{
                voteMap.put(vote,1);
            }
        }
        List<Map.Entry<String, Integer>> listOfVotes =  new ArrayList<>(voteMap.entrySet());

        listOfVotes.sort((o1,o2)->{
            if(o1.getValue() == o2.getValue()) {
                if(o1.getKey().compareTo(o2.getKey())<1)
                    return 1;
                else
                    return -1;
            }
            if(o1.getValue() < o2.getValue())
                return 1;
            else
                return -1;
       });

        return listOfVotes.get(0).getKey();
    }

}
