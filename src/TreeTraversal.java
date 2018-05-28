


//Mirror Tree
//Median
//ksmallest - klargest
//IN-Pre-Post order


import java.sql.SQLOutput;

public class TreeTraversal
{
    static class Node
    {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }

        void setLeft(Node node){
            this.left=node;
        }
        void setRight(Node node){
            this.right=node;
        }

    }

    static int scount = 0;
    static int smaxcount = 7;

    // Root of Binary Tree
    Node root;

    TreeTraversal()
    {
        root = null;
    }

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    void printPostorder(Node node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    void printkthSmallestElement(Node node, int k){
        if(node == null)
            return;
        printkthSmallestElement(node.left, k);
        ++scount;
        if(scount == k){
            System.out.println( "Kth smallest element is : "+ node.key);
            return;
        }
        printkthSmallestElement(node.right, k);
    }

    void printkthLargestElement(Node node, int k){
        if(node == null)
            return;
        printkthLargestElement(node.right, k);
        --smaxcount;
        if(smaxcount == k+1){
            System.out.println( "Kth largest element is : "+ node.key);
            return;
        }
        printkthLargestElement(node.left, k);

    }

    public static void getInvertedBinaryTree(Node root){
        if(root.left!=null || root.right!=null){
            Node temp = root.left;
            root.setLeft(root.right);
            root.setRight(temp);

            getInvertedBinaryTree(root.left);
            getInvertedBinaryTree(root.right);
        }
    }

    public static void getMedianOnTree(Node root){

        getNumberOfNodes(root);
        System.out.println();
        System.out.println("Count of number of node:"+count);
        medianNumber(root);
        System.out.println();
        System.out.println("Median:"+median);
    }

    static int count = 0;
    static int counter = 0;
    static int median  =0;

    public static void getNumberOfNodes(Node root){
        if(root==null)
            return;
        getNumberOfNodes(root.left);
        count++;
        getNumberOfNodes(root.right);
    }

    public static void medianNumber(Node root){

        if(root==null)
            return;

        medianNumber(root.left);
        counter++;
        if(count%2!=0){
            if(counter==(count/2))
                median = root.key;
                return;
        }else {
            if(counter==(count/2) || counter==(count/2+1))
                median +=root.key;

            if(counter==(count/2+1)) {
                median= median/2;
                return;
            }

        }
        medianNumber(root.right);

    }

    //Find LCA - Least common Ancestor
    void printLCA(int n1, int n2){
        Node result = getLCA(root,n1,n2);
        if(v1&&v2)
            System.out.println("Least Common partent of N1:"+ n1+" & N2: "+n2+" is "+result.key);
        else
            System.out.println("One node not present ");
    }


    static boolean v1,v2;
    private static Node getLCA(Node root, int n1,int n2){

        if(root==null)
            return null;
        if(root.key==n1 ) {
            v1=true;
            return root;
        }

        if( root.key==n2) {
            v2=true;
            return root;
        }

        Node leftTreeNode = getLCA(root.left,n1,n2);
        Node rightTreeNode = getLCA(root.right,n1,n2);

        if(leftTreeNode!=null && rightTreeNode!=null) {
            System.out.println("LCA: " + root.key);
            return root;
        }

        return leftTreeNode==null?rightTreeNode:leftTreeNode;
    }


    // Wrappers over above recursive functions
    void printPostorder()  {     printPostorder(root);  }
    void printInorder()    {     printInorder(root);   }
    void printPreorder()   {     printPreorder(root);  }
    void printkthSmallestElement(int k)   {     printkthSmallestElement(root, k);  }
    void printkthLargestElement(int k)   {     printkthLargestElement(root, k);  }
    // Driver method




    public static void main(String[] args)
    {
        /*
         *
         *               5
         *            /     \
         *           2       10
         *         /  \    /   \
         *        1   3   7     12
         *               / \    /  \
         *              6   8  11   14
         * */

        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(5);

        tree.root.left = new Node(2);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        tree.root.right = new Node(10);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(12);

        tree.root.right.left.left = new Node(6);
        tree.root.right.left.right= new Node(8);

        tree.root.right.right.left = new Node(11);
        tree.root.right.right.right = new Node(14);


/*
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();

        System.out.println("\nKth smallest element of binary tree is ");
        tree.printkthSmallestElement(3);

        System.out.println("\nKth largest element of binary tree is ");
        tree.printkthLargestElement(4);*/

//        System.out.println("Before");
//        tree.printInorder();
//        //getInvertedBinaryTree(tree.root);
//
//        getMedianOnTree(tree.root);
//        System.out.println();
//        System.out.println("After");
//        tree.printInorder();

          tree.printLCA(6,11);
          tree.printLCA(11,6);

        tree.printLCA(11,14);
        tree.printLCA(14,11);
        tree.printLCA(1,8);
        tree.printLCA(6,3);



    }
}


