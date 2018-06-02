package Hard;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {

    public static void main(String[] args) {
        String input = "ABCD";

        List<String> permutations = getPermutationOfString(input);
        for(String permutation: permutations){
            System.out.print("  "+permutation);
        }

    }

    public static List<String> getPermutationOfString(String inputString){

        List<String> permutationList=  new ArrayList<>();
        permutationList.add(new String());

        char[] inputChar = inputString.toCharArray();

        for(char input: inputChar) {

            List<String> tempList =  new ArrayList<>();

            for(String permutation:permutationList){
                for(int i=0;i<permutation.length();i++){
                    tempList.add(new String(permutation.substring(0,i)+input+permutation.substring(i,permutation.length())));
                }

                tempList.add(new String(permutation+input));
            }

            permutationList = tempList;

        }

        return permutationList;
    }
}
