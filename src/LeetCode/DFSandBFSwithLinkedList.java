package LeetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int value;
    LinkedList<Node> edges =  new LinkedList<Node>();
    boolean visited; //clean this flag after each run
    public Node(int value){
        this.value=value;
    }

    public void setVisited(){
        this.visited =  true;
    }
}

public class DFSandBFSwithLinkedList {
    public static void main(String[] args) {
        System.out.println("Graph construction.");
        Node node1 =  new Node(1);
        Node node2 =  new Node(2);
        Node node3 =  new Node(3);
        Node node4 =  new Node(4);
        Node node5 =  new Node(5);
        node1.edges.add(node2);
        node1.edges.add(node4);
        node2.edges.add(node3);
        node4.edges.add(node1);
        node4.edges.add(node5);
        System.out.println("Graph construction complete.");

        System.out.println("Compute DFS:");
        Node start = node1;
        Node destination = node5;
        System.out.println("DFS for path for "+start.value+"  to " +destination.value+"  =  "+  DFS(start,destination));

        System.out.println();

        System.out.println("BFS for path for "+start.value+"  to " +destination.value+"  =  "+  BFS(start,destination));


    }

    public static boolean DFS(Node start, Node end){
        boolean output = false;
        System.out.println("start: "+start.value+ " | end: "+end.value );
        if(start.visited){
            return false;
        }

        if(start==end){
            return true;
        }

        start.setVisited();

       /* Iterator<Node> itr = start.edges.iterator();
        while(itr.hasNext()){
            Node temp = itr.next();
            System.out.println("Node under process: "+temp.value);
            if (DFS(temp,end))
                return true;

        }*/

        for(Node temp : start.edges){
                System.out.println("Node under process: "+temp.value);
                if(DFS(temp,end))
                    return true;
        }

        return false;
    }

    public static boolean BFS(Node start, Node end){
        System.out.println("start: "+start.value+ " | end: "+end.value );
        Queue<Node> fifoNode = new LinkedList<Node>();

        fifoNode.add(start);

        while(!fifoNode.isEmpty()){
            Node temp  =  fifoNode.remove();
            System.out.println("Node under process: "+temp.value);
            if(temp==end)
                return true;

            if(!temp.visited) {
                System.out.println("Node first time in process: "+temp.value);
                temp.visited=true;
                for (Node node : temp.edges) {
                    System.out.println("Adding node to the queue: " + node.value);
                    fifoNode.add(node);

                }
            }
        }
        return false;
    }


}
