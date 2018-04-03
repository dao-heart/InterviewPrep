import java.util.ArrayList;
import java.util.List;

public class Amazon {

    public static void main(String[] args) {

        List<String> logLines = new ArrayList<>();
        logLines.add("t2 13 121 98");
        logLines.add("r1 box ape bit");
        logLines.add("b4 xi me nu");
        logLines.add("br8 eat nim gry");
        logLines.add("w1 has uni gry");
        logLines.add("f3 52 54 31");


        System.out.println("==input==");
        for(String in:logLines){
            System.out.println(in);
        }

        List<String> output = reorderLines(logLines.size(),logLines);



        System.out.println("==Output==");
        for(String out:output){
            System.out.println(out);
        }

    }

    public static List<String> reorderLines(int logFileSize, List<String> logLines){
        System.out.println(logFileSize);

        ArrayList<String> outputList =  new ArrayList<>();
        ArrayList<String> numberList =  new ArrayList<>();

        for(String log: logLines){
            if(isNumberedLine(log))
               numberList.add(log);
            else
                outputList.add(log);
        }

        System.out.println();
        System.out.println("==numberList==");
        for(String out:numberList){
            System.out.println(out);
        }

        System.out.println();
        System.out.println("==outputList==");
        for(String out:outputList){
            System.out.println(out);
        }
        System.out.println();
        for(int i=0;i<outputList.size()-1;i++){
            for (int j = i+1; j < outputList.size(); j++) {
                   if(getStringWithoutIndex(outputList.get(i)).compareTo(getStringWithoutIndex(outputList.get(j)))>0){
                       String temp = "";
                       temp =  outputList.get(i);
                       outputList.set(i,outputList.get(j));
                       outputList.set(j,temp);
                   }
            }
        }





        for(String line: numberList){
            outputList.add(line);
        }

        System.out.println("==outputList before return==");
        for(String out:outputList){
            System.out.println(out);
        }

        return outputList;
    }

    public static boolean isNumberedLine(String input){
        if(Character.isDigit(getStringWithoutIndex(input).charAt(0))) {
            return true;
        }
        return false;
    }


    public static String getStringWithoutIndex(String input){
        return input.substring(input.indexOf(" ")+1);
    }

}
