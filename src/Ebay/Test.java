package Ebay;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String input = "     -234.543 DBC gfg     ";


        System.out.println("Result");
        Arrays.stream(input.trim().split(" ")).forEach(System.out::println);

        System.out.println();
        System.out.println("Get the first number: of "+input);

        System.out.println(input.trim().substring(0,input.trim().indexOf(" ")));
    }

}
