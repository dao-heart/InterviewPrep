public class ReverseInteger {
    public static void main(String[] args) {
        int number  = 12067;
        System.out.println( "Number is :"+ number );
        System.out.println( "Reverse Int with sting conversion : "+reversedIntegerWithString(number));
        System.out.println( "Reverse Int without sting conversion : "+reversedIntegerWithoutString(number));
    }

    public static int reversedIntegerWithString(int number){
        return Integer.parseInt(new StringBuffer(number+"").reverse().toString());
    }

    public static int reversedIntegerWithoutString(int number){

        int reverseValue  = 0;
        while(number!=0){
            reverseValue+=number%10;
            reverseValue*=10;
            number/=10;
        }

        return reverseValue/10;
    }



}
