import java.util.Set;
import java.util.TreeSet;

public class TreeSetTester {
    public static void main(String[] args) {
        Set<String> treeSetObj = new TreeSet<>();
        treeSetObj.add("HTML ");
        treeSetObj.add("CSS ");
        treeSetObj.add("Java ");
        treeSetObj.add("Python ");
        treeSetObj.add("NodeJS ");

        System.out.println("Tree set : ");
        treeSetObj.stream().forEach(System.out::print);

        System.out.println();
        System.out.println("Last Item:"+ ((TreeSet<String>) treeSetObj).last());

        System.out.println("First Item:"+ ((TreeSet<String>) treeSetObj).first());

        System.out.println("   "+((TreeSet<String>) treeSetObj).tailSet("Java", true));


    }
}
