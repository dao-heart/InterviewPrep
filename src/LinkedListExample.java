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

       /* LinkedListNode tempRef6 = new LinkedListNode(6);
        tempRef5.setNextLinkedListNode(tempRef6);

        LinkedListNode tempRef7 = new LinkedListNode(7);
        tempRef6.setNextLinkedListNode(tempRef7);

        LinkedListNode tempRef8 = new LinkedListNode(8);
        tempRef7.setNextLinkedListNode(tempRef8);*/

        System.out.println("Original LinkedList is:");
        printLinkedList(start);

        /*start =  revCoupleLinkedList(start);

        System.out.println("Rev LinkedList is :");
        printLinkedList(start);
        */
        start = reverseLinkedList(start);

        System.out.println("Rev LinkedList is :");
        printLinkedList(start);

    }

    public static LinkedListNode reverseLinkedList(LinkedListNode head){

        LinkedListNode newHead = null;
        while (head!=null){
            LinkedListNode temp = head.getNextLinkedListNode();
            head.setNextLinkedListNode(newHead);
            newHead = head;
            head = temp;
        }
        return newHead;
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
        while (loopRef!=null){
            System.out.print(loopRef.getData()+"   ");
            loopRef = loopRef.getNextLinkedListNode();
        }
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
