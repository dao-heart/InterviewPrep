package Practice;

public class PowerFunction {

    public static void main(String[] args) {

        int number = 4;
        int power = 3;

        System.out.println("Number : "+number+ "  power : "+power);

        System.out.println("Simple with power function: "+simplePower(number,power));

        System.out.println("Simple with power function: "+powerWithMultiplication(number,power));

        System.out.println("Simple with power function: "+powerWithMultiplicationRecursion(number,power));

    }

    private static int powerWithMultiplicationRecursion(int number, int power) {
        if(power==1) return number;
        return number * powerWithMultiplicationRecursion(number,--power);
    }

    private static int powerWithMultiplication(int number, int power) {
        int output=1;
        while(power > 0){
            power--;
            output*=number;
        }
        return output;
    }

    private static double simplePower(int number, int power) {
        return Math.pow(number,power);

    }



}
