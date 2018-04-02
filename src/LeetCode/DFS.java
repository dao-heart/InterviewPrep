package LeetCode;

public class DFS {

    static int [] node = new int[]{0,1,2,3,4};
    static int [][] adjacency  =  new int [][]{ {1,2,0,1,0},
                                                {0,1,1,0,0},
                                                {0,0,1,0,0},
                                                {0,0,0,1,9},
                                                {0,0,0,0,1}};

    static boolean  [] visited = new boolean [node.length];

    public static void main(String[] args) {
        int nodeIndex  =  1;
        int destination =  2;
        System.out.println("Check the path from node "+ node[nodeIndex] +" = "+adjacencyDFS(nodeIndex, destination));
    }

    static public boolean adjacencyDFS(int start, int destination){
        boolean path =  false;
        visited[start] = true;

        if(adjacency[start][destination]!=0){
            visited[destination] = true;
            return true;
        }

        for(int i=0;i<adjacency[start].length;i++){
            if(visited[i]==false && adjacency[start][i]!= 0){
                path = adjacencyDFS(i,destination);
            }
        }
        return path;
    }

}

