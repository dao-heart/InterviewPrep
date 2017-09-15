import java.util.HashMap;
import java.util.Map;

public class FindNumberWithOddFrequencyOfOccurance {
    public static void main(String[] args) {
        int [] array = new int[7];
        array[0]=1;
        array[1]=2;
        array[2]=3;
        array[3]=1;
        array[4]=3;
        array[5]=1;
        array[6]=10;

        int [] resultArray = getArrayOfNumbersWithOddFrequency(array);
        System.out.println(" Array of objects with odd frequency: "+resultArray);

        System.out.println( "input : ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }


        System.out.println("Result: ");
        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(resultArray[i]);
        }
    }

    public static int [] getArrayOfNumbersWithOddFrequency(int [] inputArray){
        int [] outputArray =  new int[inputArray.length];

        HashMap<Integer,Integer> countKeeper =  new HashMap();

        for (int value:inputArray) {
            if(countKeeper.get(value)!=null){
                countKeeper.put(value,Integer.parseInt(countKeeper.get(value).toString())+1);
            }
            else{
                countKeeper.put(value,1);
            }
        }

        System.out.println(countKeeper.keySet().toString());
        int i = 0;
        for (Map.Entry<Integer,Integer> e:countKeeper.entrySet()) {
            if(e.getValue()%2!=0){
                outputArray[i++]=e.getKey();
            }
        }
        return outputArray;
    }
}
