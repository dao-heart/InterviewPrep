import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class LinkedListExample
{


    public static void main(String[] args) {
        System.out.println("Linked List test");

        LinkedListNode start = null;

        LinkedListNode tempRef1 = new LinkedListNode(1);

        start = tempRef1;

        LinkedListNode tempRef2 = new LinkedListNode(2);
        tempRef1.setNextLinkedListNode(tempRef2);

        LinkedListNode tempRef3 = new LinkedListNode(3);
        tempRef2.setNextLinkedListNode(tempRef3);

        LinkedListNode tempRef4 = new LinkedListNode(4);
        tempRef3.setNextLinkedListNode(tempRef4);

        LinkedListNode tempRef5 = new LinkedListNode(5);
        tempRef4.setNextLinkedListNode(tempRef5);

        LinkedListNode tempRef6 = new LinkedListNode(6);
        tempRef5.setNextLinkedListNode(tempRef6);

        System.out.println("Original LinkedList is:");
        printLinkedList(start);

        /*start =  revCoupleLinkedList(start);

        System.out.println("Rev LinkedList is :");
        printLinkedList(start);
        */
        start = revLinkedList(start);

        System.out.println("Rev LinkedList is :");
        //printLinkedList(start);

    }

    public static LinkedListNode revLinkedList(LinkedListNode root){
        System.out.println("Initial linklist before reverse: ");
        int count = 0;

        printLinkedList(root);
        LinkedListNode head= root;
        LinkedListNode second =  head.getNextLinkedListNode();
        LinkedListNode third=  head.getNextLinkedListNode().getNextLinkedListNode();

        do {
            second.setNextLinkedListNode(head);
            head.setNextLinkedListNode(third);

            head = second;

            third = third.getNextLinkedListNode();
            second = third;

            System.out.println();
            System.out.println("Iteration:"+ count);
            printLinkedList(root);

            count++;
        }while(count <= 4);

        return null;
    }

    public static LinkedListNode revCoupleLinkedList(LinkedListNode start){
        System.out.println( "1->2->3->4->5 should be converted to 2->1->4->3->5");

        LinkedListNode tempRef = start;

        LinkedListNode newStart = tempRef.getNextLinkedListNode();

        System.out.println( "New start: "+newStart.getData());
        boolean flag=false;

        LinkedListNode memoryOfLastNode = null;
        while(tempRef!=null){

            System.out.println("Temp ref pointing to [Start] : "+tempRef.getData());

            LinkedListNode firstNode = tempRef;
            LinkedListNode secondNode = tempRef.getNextLinkedListNode();


            //System.out.println(" first points "+ firstNode.getData() +" to [Before]: "+firstNode.getNextLinkedListNode().getData());
            //System.out.println(" second points "+ secondNode.getData() + "  to [Before]: "+ secondNode.getNextLinkedListNode().getData());

            if(flag) {

                memoryOfLastNode.setNextLinkedListNode(secondNode);

                System.out.println(" memoryOfLastNode points "+ memoryOfLastNode.getData() +" to [Before]: "+memoryOfLastNode.getNextLinkedListNode().getData());

            }

            flag=true;
            memoryOfLastNode = firstNode;

            firstNode.setNextLinkedListNode(secondNode.getNextLinkedListNode());
            secondNode.setNextLinkedListNode((tempRef));


            //System.out.println(" first points "+ firstNode.getData() + " to [after]: "+firstNode.getNextLinkedListNode().getData());
            //System.out.println(" second points "+ secondNode.getData() + " to [after]: "+ secondNode.getNextLinkedListNode().getData());

            tempRef = firstNode.getNextLinkedListNode();

            System.out.print("Printing step list: ");
            printLinkedList(newStart);
            System.out.println();

        }
        return newStart;
    }

    public static void printLinkedList(LinkedListNode start){
        LinkedListNode loopRef = start;
        do {
            System.out.print(loopRef.getData()+"   ");
            loopRef = loopRef.getNextLinkedListNode();
        } while(loopRef!=null);
        System.out.println();
    }

}

class LinkedListNode{
    private int data;
    private LinkedListNode next;

    public LinkedListNode(int data){
        this.data = data;
        this.next = null;
    }

    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }

    public LinkedListNode getNextLinkedListNode(){
        return this.next;
    }

    public void setNextLinkedListNode(LinkedListNode node){
        this.next = node;
    }

    public boolean nextNodeRefIsNotNull(){
        if(this.next==null)
            return false;
        else
            return true;
    }
}
