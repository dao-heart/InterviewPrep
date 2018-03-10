public class NumberIsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println("Is power : "+ isPowerOfTwo(100000000));
    }

    public static boolean isPowerOfTwo(int number){

        if(number < 1 || number%2 != 0){
            System.out.println("Inside number < 1 || number%2 != 0 : Number:   "+number+"  number < 1:  "+ number +"  number%2 != 0:  "+number%2 );
            return false;
        }


        int computation = 0;
        int factor = 0;
        while (number>=computation)
        {
            System.out.println("Inside number "+ number +"<=computation: "+computation+ " power Math.pow(2,factor++)"+ Math.pow(2,factor));
            computation = (int)Math.pow(2,factor);
            factor++;

            if(computation==number){
                return true;
            }
        }

        return false;
    }
}
