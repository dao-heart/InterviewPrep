import com.sun.org.apache.xpath.internal.operations.Number;

public class NumberChecker {
    public static void main(String[] args) {
       /* System.out.println(isNumberChecker("-123"));
        System.out.println(isNumberChecker("123"));
        System.out.println(isNumberChecker("-1A23"));
        System.out.println(isNumberChecker("12e3"));
        System.out.println(isNumberChecker("0"));

        System.out.println(isNumberChecker("-123.123"));*/

        System.out.println(test("-1234.55"));


    }


    public static boolean isNumberChecker(String input){
        //return input.chars().allMatch(Character::isDigit);

        return input.matches("-?\\d+(\\.\\d+)?");
        //return input.matches("\\d+(\\.\\d+)?");
    }

    public static boolean test(String input){


        return input.matches("-?\\d+(\\.\\d+)?");

    }


}
