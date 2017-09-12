/*Atlassian*/
public class DecimalToBinary {

    public static void main(String[] args) {
        System.out.println("Binary : "+convert(10, 2) );

        System.out.println("Octa :"+convert(10, 7) );

        System.out.println("Traya :"+convert(2, 3) );

    }

    public static String convert(int number, int converter){
        String output = "";

        int processNumber = number;

        while (processNumber>1) {
            output += processNumber % converter;
            processNumber = processNumber / converter;
        }
        output+=processNumber;


        return new StringBuffer(output).reverse().toString();
    }
}
