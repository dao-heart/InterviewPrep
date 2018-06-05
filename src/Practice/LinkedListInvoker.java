package Practice;

public class LinkedListInvoker{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.printLinkedList();
        ll.addNode(10);
        ll.addNode(140);
        ll.addNode(40);
        ll.addNode(30);
        ll.addNode(20);
        ll.printLinkedList();
        ll.addNode(15);
        ll.addNode(35);
        ll.addNode(25);
        ll.addNode(300);
        ll.addNode(150);
        ll.addNode(200);
        /*ll.addNode(450);*/
        ll.printLinkedList();

        System.out.println();
        int key = 4;
        System.out.println("Reverse fragement: Key "+key+" :");
        ll.revLinkedList(key);

        ll.printLinkedList();
/*

        System.out.println();
        System.out.println("Find mid element");
        System.out.println(ll.findMidNodeInOnePass());

        System.out.println();
        System.out.println("Reverse the list");
        ll.revLinkedList();
        ll.printLinkedList();


        System.out.println();
        System.out.println("FInd Index of 20 : "+ll.findIndexOfNode(20));
        System.out.println("FInd Index of 15 : "+ll.findIndexOfNode(15));
        System.out.println("FInd Index of 1000 : "+ll.findIndexOfNode(1000));

        System.out.println();
        System.out.println("Removing 35");
        ll.removeNode(35);
        ll.printLinkedList();

        System.out.println();
        System.out.println("Removing 40");
        ll.removeNode(40);
        ll.printLinkedList();

        System.out.println();
        System.out.println("Removing 10");
        ll.removeNode(10);
        ll.printLinkedList();

        System.out.println();
        System.out.println("Removing 25");
        ll.removeNode(25);
        ll.printLinkedList();


*/





    }
}



class LinkedList {

    private LinkedListNode head;

    public LinkedList() {
        head =null;
    }

    public void addNode(int data){
        LinkedListNode newNode = new LinkedListNode(data);

        if(this.head==null){
            head = newNode;
            return;
        }

        LinkedListNode tempPointer=head;
        while(tempPointer.getNext()!=null){
            tempPointer=tempPointer.getNext();
        }
        tempPointer.setNext(newNode);
    }

    public int findIndexOfNode(int data){
        if(head == null)
            return -1;

        int counter=0;
        LinkedListNode tempNode =  head;
        while (tempNode!=null){
            if(tempNode.getData()==data)
                return counter;
            counter++;
            tempNode = tempNode.getNext();
        }
        return -1;
    }

    public void removeNode(int data){
        if(head==null)
            return;
        if(head.getData()==data){
            head=head.getNext();
            return;
        }

        LinkedListNode prevNode= head;
        LinkedListNode tempNode =  head.getNext();
        while (tempNode!=null){
            if(tempNode.getData()==data){
                prevNode.setNext(tempNode.getNext());
            }
            prevNode = tempNode;
            tempNode = tempNode.getNext();
        }
    }

    public int findMidNodeInOnePass(){
        if(head==null)
            return -1;

        LinkedListNode mid = head;
        LinkedListNode jumper = head;
        LinkedListNode prev=null;
        while(jumper!=null){

            jumper=jumper.getNext();
            if(jumper!=null)
                jumper=jumper.getNext();
            prev = mid;
            mid=mid.getNext();
        }
        return prev.getData();
    }

    public void printLinkedList(){
        System.out.println();
        System.out.println("Printing linked list: ");
        if(head==null) {
            System.out.println("List is empty.");
            return;
        }
        LinkedListNode tempPointer=head;

        while ( null!=tempPointer ){
            System.out.print(tempPointer.getData()+" ==> ");
            tempPointer=tempPointer.getNext();
        }
        System.out.println();
    }

    public void revLinkedList(){

        if(head==null)
            return;

        LinkedListNode newHead = null;
        LinkedListNode temp = head;

        while (head!=null){
            temp=head.getNext();
            head.setNext(newHead);
            newHead=head;
            head=temp;
        }
        head = newHead;
    }

    public void revLinkedList(int k){
        this.recLinkedListInFragements(head,k);
    }

    private void recLinkedListInFragements(LinkedListNode head, int k){
        //find the end

        LinkedListNode endPointer = head;
        LinkedListNode prevPointer = null;
        int  counter = 0;
        while (counter++<k*2-1){

            if(endPointer==null){
                //endPointer=prevPointer;
                break;
            }
            //prevPointer=endPointer;
            endPointer=endPointer.getNext();
        }

        LinkedListNode newHead=endPointer;
        counter=0;
        while (counter++<k){
            if(head==null)
                break;

            LinkedListNode temp = head.getNext();
            head.setNext(newHead);
            newHead = head;
            head = temp;
        }

        if(head!=null)
            recLinkedListInFragements(head,k);

        this.head = newHead;
    }

    private class LinkedListNode{
        private int data;
        private LinkedListNode next;

        LinkedListNode(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public LinkedListNode getNext() {
            return next;
        }

        public void setNext(LinkedListNode next) {
            this.next = next;
        }
    }
}


