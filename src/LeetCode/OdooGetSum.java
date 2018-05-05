package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class OdooGetSum {
    public static void main(String[] args) {
        List<String> in =  new ArrayList<>();
        in.add("2");
        in.add("4");
        in.add("hi");
        in.add("2s");
        in.add("4");
        //System.out.println(getSumOfIntegers(in));

        System.out.println(getSumOfIntegersRecursive(in,0,0));
    }

    //q3
    public static int getSumOfIntegers(List<String> inputs){
        int output = 0;
        for(String input: inputs){
            try{
                output+=Integer.parseInt(input);
            }catch (Exception e)
            {
                    continue;
            }
        }
        return output;
    }

    //q4
    public static int getSumOfIntegersRecursive(List<String> inputs, int index, int output){
        if(index>inputs.size())
            return output;

        try {
                output += Integer.parseInt(inputs.get(index));
        } catch (Exception e) { }

        return getSumOfIntegersRecursive(inputs,++index,output);
    }


}
