public class camelCase {

    public static void main(String[] args) {

        String input = "Hi, I am gaurang.";
        System.out.println(camelCaseConvertor(input));
    }

    public static String camelCaseConvertor(String input){

        //input = input.replaceAll("[.+:;!,]",""); //both works
        input = input.replaceAll("[^A-Za-z0-9 ]","");//both works

        String[] inputArray = input.split(" ");
        String output = "";
        for (int i=0;i<inputArray.length;i++){
            //System.out.println(inputArray[i].substring(0,1).toUpperCase());

            if(i==0)
                inputArray[i] = inputArray[i].substring(0,1).toLowerCase() + inputArray[i].substring(1,inputArray[i].length());
            else
                inputArray[i] = inputArray[i].substring(0,1).toUpperCase() + inputArray[i].substring(1,inputArray[i].length());

            output+=inputArray[i];
        }

        return output;
    }
}
