package Practice;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int [] input = new int []{0,1,2,3,4,5,6,7,8,9};

        NodeFromSortedArray root = getBSTfromSortedArray(input, 0,input.length-1);


        System.out.println(root);

    }

    private static NodeFromSortedArray getBSTfromSortedArray(int[] input, int min, int max) {
        if(max<min)
            return null;

        int midIndex = ((max+min)/2);

        NodeFromSortedArray root = new NodeFromSortedArray(input[midIndex]);

        root.setLeft(getBSTfromSortedArray(input, min,midIndex-1));
        root.setRight(getBSTfromSortedArray(input,midIndex+1 ,max));

        return root;
    }
}

class NodeFromSortedArray {
    private int data;
    private NodeFromSortedArray left;
    private NodeFromSortedArray right;

    public NodeFromSortedArray(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeFromSortedArray getLeft() {
        return left;
    }

    public void setLeft(NodeFromSortedArray left) {
        this.left = left;
    }

    public NodeFromSortedArray getRight() {
        return right;
    }

    public void setRight(NodeFromSortedArray right) {
        this.right = right;
    }
}

