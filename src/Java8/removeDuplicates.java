package Java8;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

public class removeDuplicates {
    public static void main(String[] args) {
        int [] input = new int[]{1,1,3,3,3,4,5};

        Arrays.stream(removeDuplicates(input)).forEach(p->System.out.println(p));
    }

    public static int[] removeDuplicates(int[] nums) {

        return Arrays.stream(nums)
                .distinct().toArray();

    }
}
