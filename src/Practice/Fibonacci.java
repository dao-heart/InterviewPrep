package Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {

    static ArrayList<Integer> memory;

    public static void main(String[] args) {
        System.out.println("Fibonacci==");
        int number =15;
        System.out.println("Input = "+number );
        printFibonacci(number );
        System.out.println();
        System.out.println();

        System.out.println("==Dumb Fibonacci with recursion==");
        for (int i = 0; i < number; i++) {
            System.out.print(dumbFibonacci(i)+" ");
        }


        System.out.println();
        System.out.println();


        printFibonacciWithRecursion(number);

        System.out.println();
        System.out.println();

        printFibonacciTillValue(number );
        System.out.println();
        System.out.println();

    }

    private static int dumbFibonacci(int number) {
        if(number<=1){
            return number;
        }
        return dumbFibonacci(number-1)+dumbFibonacci(number-2);

    }

    private static void printFibonacciWithRecursion(int number) {
        System.out.println("==printFibonacci with Recursion==");
        int [] memory = new int [number+1];
        int finalNumber = getFibonacciWithRecursion(number,memory);

        Arrays.stream(memory)
                .filter(p->p<=number)
                .forEach(p-> System.out.print(" "+p));

    }

    private static int getFibonacciWithRecursion(int number, int [] memory) {
        if(number==1||number==0) {
            memory[number]= number;
            return memory[number];
        }

        if(0==memory[number])
            memory[number] = getFibonacciWithRecursion(number - 1,memory) + getFibonacciWithRecursion(number - 2,memory);

        return memory[number];
    }

    public static void printFibonacci(int number){
        System.out.println("==printFibonacci==");
        int num1 = 0;
        int num2 = 1;
        System.out.print(num1+ " "+num2);

        int count =3;
        while (count++<number){

            int temp = num1+num2;
            System.out.print(" "+temp);
            num1=num2;
            num2=temp;
        }
    }




    public static void printFibonacciTillValue(int number){
        System.out.println("==printFibonacciTillValue==");
        int num1 = 0;
        int num2 = 1;
        System.out.print(num1+ " "+num2);

        int temp =0;
        do{
                temp = num1+num2;
                if(temp>number)break;
                System.out.print(" "+temp);
                num1=num2;
                num2=temp;
        } while(temp<number);
    }
}
