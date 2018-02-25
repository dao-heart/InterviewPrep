public class SAPOneDirectionLL {
    SAPLLnode start;
    SAPLLnode end;

    public SAPOneDirectionLL(){
        start = null;
        end = null;
    }

    public void addToLL(int data){
        SAPLLnode node = new SAPLLnode(data);

        if(start==null){
            start=node;
        }
        if(end!=null){
            end.setNextNode(node);
        }
        end = node;
    }
}

class SAPLLnode{
    int data;
    SAPLLnode next;

    public SAPLLnode(int data){
        this.data=data;
        this.next = null;
    }

    public int getData(){
        return data;
    }

    public void setNextNode(SAPLLnode next){
        this.next=next;
    }

    public SAPLLnode getNextNode() {
        return next;
    }
}

