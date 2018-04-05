package LeetCode;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JandS{
    public static void main(String args[]){

        String s ="baABAaA";
        String j="aA";
       // System.out.println(new JandS().countTheJewels(s,j));

        new JandS().countTheJewels(s,j);
    }

    public int countTheJewels(String s, String j){
        int countJewels = 0;
        if(j.length()==0 || s.length()==0)
            return 0;

        for(int i=0;i<s.length();i++){
            int k=0;
            while(s.charAt(i) == j.charAt(k)){
                if(k==j.length()-1){
                    countJewels++;
                    break;
                }
                k++;
                i++;
                if(i==s.length())
                    break;

                if(k==j.length())
                    break;

            }
        }
        return countJewels;
    }

    @Test
    public void CountTheJewelsTest(){
        assertEquals("Answer must be 2",2,new JandS().countTheJewels("aAAaAbb","aA"));
        assertEquals("Answer must be 3",3,new JandS().countTheJewels("aAAaAbbaA","aA"));
    }


}



