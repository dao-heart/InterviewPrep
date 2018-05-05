

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



    // Wrappers over above recursive functions
    void printPostorder()  {     printPostorder(root);  }
    void printInorder()    {     printInorder(root);   }
    void printPreorder()   {     printPreorder(root);  }
    void printkthSmallestElement(int k)   {     printkthSmallestElement(root, k);  }
    void printkthLargestElement(int k)   {     printkthLargestElement(root, k);  }
    // Driver method
    public static void main(String[] args)
    {
        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(5);

        tree.root.left = new Node(2);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        tree.root.right = new Node(7);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(9);

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

        System.out.println("Before");
        tree.printPreorder();
        getInvertedBinaryTree(tree.root);
        System.out.println();
        System.out.println("After");
        tree.printPreorder();

    }
}


/*
*
*               5
*              / \
*             2   7
*           /  \  / \
*          1   3 6   9
*
*
* */