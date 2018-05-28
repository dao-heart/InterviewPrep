package Java8;


import java.util.*;

public class HashMapSorter {

    public static void main(String[] args) {

        Map<String,Integer> inputMap = new HashMap<>();
        inputMap.put("Gaurang",10);
        inputMap.put("Shreya",100);
        inputMap.put("Vishruti",7);
        inputMap.put("Nitin",55);
        inputMap.put("Amol",33);
        inputMap.put("Jeff",2);
        inputMap.put("Timm",999);

        System.out.println("Before Sorting Hashmap : ");
        for (String name: inputMap.keySet()){

            String key =name.toString();
            String value = inputMap.get(name).toString();
            System.out.println(key + "=" + value);
        }

        System.out.println(

        );
        List<Map.Entry<String,Integer>> sortedList = convertHashMapToSortedList(inputMap);


        System.out.println("Sorted List");
        sortedList.stream().forEach(System.out::println);

    }

    public static List<Map.Entry<String,Integer>> convertHashMapToSortedList(Map<String,Integer> unsortedMap){

        List<Map.Entry<String,Integer>> hashMapList =  new ArrayList<>(unsortedMap.entrySet());

       /* Comparator<Map.Entry<String,Integer>> com = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if( o1.getValue() ==o2.getValue()) return 0;
                if(o1.getValue()<o2.getValue()) return -1;
                else return 1;
            }
        };*/

        Comparator<Map.Entry<String,Integer>> com = (o1, o2) -> {
            if( o1.getValue() ==o2.getValue()) return 0;
            if(o1.getValue()<o2.getValue()) return -1;
            else return 1;
        };

        hashMapList.sort(com);

        return hashMapList;
    }
}
