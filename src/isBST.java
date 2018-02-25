public class isBST {

/*    public static boolean checkIsBST(Node root, Integer min*//*0*//*, Integer max*//*99999*//*){

        if (root == null)
            return true;
        if(min != null && root.data < min)
            return false;
        if(max != null && root.data >= max)
            return false;

        return checkIsBST(root.left, min ,root.data) && checkIsBST(root.right,root.data, max);
    }*/

}


/*
class Node{
    int data;
    Node left;
    Node right;
}
*/


