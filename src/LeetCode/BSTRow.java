package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class NodeTree{
    int value;
    NodeTree left;
    NodeTree right;

    public NodeTree(int value){
        this.value=value;
    }
}

public class BSTRow{

    public static void main(String [] args){
        NodeTree root =  new NodeTree(5);
        NodeTree l1l=  new NodeTree(3);
        NodeTree l1r =  new NodeTree(7);
        NodeTree l2ll =  new NodeTree(1);
        NodeTree l2lr =  new NodeTree(4);
        //NodeTree l1rl =  new NodeTree(6);
        NodeTree l2rr =  new NodeTree(10);

        root.left = l1l;
        root.right = l1r;
        //l1l.left = l2ll;
        l1l.right=l2lr;
       // l1r.left = l1rl;
        l1r.right=l2rr;

        getRowFormatedTree(root);
    }

    public static void getRowFormatedTree(NodeTree root){ //
        Queue<NodeTree> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()){

            int nodeCounter =  nodeQueue.size();

            while(nodeCounter-- > 0) {
                NodeTree temp = nodeQueue.remove();
                System.out.print(temp.value + " ");

                if (temp.left != null)
                    nodeQueue.add(temp.left);
                if (temp.right != null)
                    nodeQueue.add(temp.right);
            }
            System.out.println();

        }
    }

    public static void getRowFormatedForCompleteTree(NodeTree root){ //
        Queue<NodeTree> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int levelNodeCounter = 1;
        while(!nodeQueue.isEmpty()){
            NodeTree temp = nodeQueue.remove();
            System.out.print(temp.value+" ");
            if(isPowerOfTwo(++levelNodeCounter)){
                System.out.println();
            }


            if(temp.left!=null)
                nodeQueue.add(temp.left);
            if(temp.right!=null)
                nodeQueue.add(temp.right);


        }
    }

    public static boolean isPowerOfTwo(int number){
        if(Math.floor(Math.log(number)/Math.log(2)) == Math.ceil(Math.log(number)/Math.log(2)))
            return true;
        return false;
    }
}
