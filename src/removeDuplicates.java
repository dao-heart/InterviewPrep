public class removeDuplicates {

    public static void main(String[] args) {
        int [] input = new int[]{1,1,3,3,3,4,5};

        System.out.println(removeDuplicates(input));
    }

    public static int removeDuplicates(int[] nums) {
        int  i = 0;

        for(int j=0;j<nums.length;j++){
            System.out.print(nums[j]+ " ");

        }
        System.out.println();
        for(int j = 0;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
