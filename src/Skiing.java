public class Skiing {


    public static void main(String[] args) {
        int [][] mountain =  new int [][]{  {0,0,0,0,0,0,0,0},
                                            {0,0,0,1,0,0,0,0},
                                            {0,1,0,0,0,1,1,1},
                                            {0,1,1,0,0,0,0,0},
                                            {0,0,0,0,1,1,0,1},
                                            {0,0,1,0,1,0,0,0},
                                            {0,0,0,0,1,0,0,0}
                                            }; // 1-> Trees 0->Ice
        System.out.println("Is path exits: "+isPathExists(mountain,0,0));


        int [][] mountain2 =  new int [][]{ {0,0,0,1,0,0,0,0},
                                            {0,0,0,1,0,0,0,0},
                                            {1,1,1,1,0,1,1,1},
                                            {0,1,1,0,0,0,0,0},
                                            {0,0,0,0,1,1,0,1},
                                            {0,0,1,0,1,0,0,0},
                                            {0,0,0,0,1,0,0,0}
                                    }; // 1-> Trees 0->Ice
        System.out.println("Is path exits mountain 2: "+isPathExists(mountain2,0,0));
    }

    public static boolean isPathExists(int [][] mountain, int rowIdx, int columnIdx){

        if(rowIdx==mountain.length-1 && columnIdx==mountain[rowIdx].length-1){
            return true;
        }
        if(rowIdx > mountain.length-1 || columnIdx > mountain[rowIdx].length-1 || mountain[rowIdx][columnIdx]==1)
            return false;

        return isPathExists(mountain,rowIdx,columnIdx+1) || isPathExists(mountain,rowIdx+1,columnIdx);
        //return false;
    }
}
