public class RemoveArbitarySpace {
    public static void main(String[] args) {

        String input = "Input string with space in the end ";
        System.out.println("trim sting : "+spaceRemover(input));
    }

    public static String spaceRemover(String s){
        return s.trim();
    }
}
