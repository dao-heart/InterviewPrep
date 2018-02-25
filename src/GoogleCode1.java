public class GoogleCode1 {

    public static void main(String[] args) {
       // System.out.println( "Hello World!");


       /* System.out.println("test Modied Anagram = "+ isModifiedAnagram("abcd","abcd"));
        System.out.println("test Modied Anagram = "+ isModifiedAnagram("abcd","cdabcdab"));
*/

        System.out.println("Solution: "+solution("ZZZZZ","cdabcdabcda"));

    }

    public static int solution(String A, String B){
        if(B.length()<A.length()){
            return -1;
        }
        if(isModifiedAnagram(A,B)==-1){
            return -1;
        }
        if(A.length()>=B.length()){
            if(A.contains(B)){
                return 1;
            }
        }

        int count=1;
        StringBuffer aBuffer=new StringBuffer(A);
        while(aBuffer.length()<B.length()){
                aBuffer.append(A);
                count++;
        }
        if(aBuffer.toString().contains(B)){
                return count;
        }else{
                aBuffer.append(A);
                count++;
                if(aBuffer.toString().contains(B)){
                    return count;
                }
                else{
                    return -1;
                }
        }
    }

    public static int isModifiedAnagram(String str1, String str2)
    {
        int [] character_set = new int[256];
        for(int i = 0; i < str1.length(); i++)
        {
            character_set[str1.charAt(i)]++;
            character_set[str2.charAt(i)]--;
        }
        for(int i = 0; i < str1.length(); i++) {
            if (character_set[str1.charAt(i)] < 0)
                return -1;
            if (character_set[str2.charAt(i)] < 0)
                return -1;
        }
        return 1;
    }
}
