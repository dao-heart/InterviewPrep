public class Solution3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int [] num = {6,1,3,2,3,4,1};
        String patterns[] = BitPattern(num);
        System.out.println( patterns[0] + "\n" + patterns[1]);
    }

    public static String[] BitPattern(int [] num){
        String patterns[] = new String[2];
        patterns[0] = findPattern(num,0);
        patterns[1] = findPattern(num,1);
        return patterns;
    }

    public static String findPattern( int [] num , int direction){
        if(num.length == 0 || num == null)
            return "";
        String pattern = "";
        for(int i=1; i<num.length;i++){
            if( direction == 0 ? isPresent(num,0,i,num[i]) : isPresent(num,i+1,num.length,num[i]) ){
                pattern+="1";
            }
            else{
                pattern+="0";
            }
        }
        return pattern;
    }

    public static boolean isPresent(int num[], int startIndex, int stopIndex, int number){
        boolean present = false;
        if(num == null || stopIndex > num.length)
            return false;
        for( int i=startIndex; i<stopIndex ; i++){
            if(num[i] == number)
            {
                present = true;
                break;
            }
        }
        return present;
    }
}