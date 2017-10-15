import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class LiveRamp1 {
    public static void main(String[] args) {
        int [] skyline2 = new int[]{ 1, 3, 2,1,2,1,5,3,3,4,2};
        int [] skyline3 = new int[]{ 5,8};
        int [] skyline4 = new int[]{ 1,1,1,1};
        int [] skyline5 = new int[]{ 1,-7,1,1};
        System.out.println(ComputeNumberOfStrokes(skyline2));
        System.out.println(ComputeNumberOfStrokes(skyline3));
        System.out.println(ComputeNumberOfStrokes(skyline4));
        System.out.println(ComputeNumberOfStrokes(skyline5));

    }

    public static int ComputeNumberOfStrokes(int [] skyline)
    {
        int CurrentLevel = 0;
        int strokesCount = 0;


        for (int height=0; height< skyline.length; height++)
        {
            if (skyline[height] < CurrentLevel)
            {
                if(skyline[height]<0) // If the skyline has negative height [There is a Deep trench in the skyline]
                    CurrentLevel = 0;
                else
                   CurrentLevel = skyline[height]; // Bringing the current level down
            }
            else if (skyline[height] > CurrentLevel)
            {
                strokesCount += skyline[height] - CurrentLevel; //Diff between current and new height
                CurrentLevel = skyline[height];
            }
            if (strokesCount > 1000000000)
                return -1;
        }
        return strokesCount;
    }

}
