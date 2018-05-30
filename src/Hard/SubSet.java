package Hard;
import java.util.HashSet;
import java.util.Set;

public class SubSet{
    public static void main(String[] args) {
        Set<Character> input= new HashSet<>();
        input.add('A');
        input.add('B');
        input.add('C');
        input.add('D');
        input.add('E');

        input.stream().forEach(System.out::print);

        Set<Set<Character>> result = getTheSubset(input);

        System.out.println("--");

        for(Set<Character> set: result) {
            for (Character c : set) {
                System.out.print("  " + c);
            }
            System.out.println();
        }
    }


    public static Set<Set<Character>> getTheSubset(Set<Character> input){

        Set<Set<Character>> results = new HashSet<>();
        results.add(new HashSet<>());

        for(char inputChar: input){
            Set<Set<Character>> tempResult = new HashSet<>();

            for(Set<Character> result: results){
                tempResult.add(new HashSet<>(result));
            }

            for(Set<Character> temp:tempResult){
                temp.add(inputChar);
            }

            results.addAll(tempResult);

            System.out.println();
        }

        return results;
    }
}
