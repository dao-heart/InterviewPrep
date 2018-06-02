package Practice;

import java.util.ArrayList;

public class MinStackImplementation{
    public static void main(String[] args) {
        MinStack minstack = new MinStack();

        minstack.getMinValue();

        minstack.push(3);
        minstack.push(4);
        minstack.push(12);
        minstack.push(9);

        System.out.println("Current Stack");
        minstack.printstack();
        System.out.println("Min Value: "+minstack.getMinValue());
        minstack.pop();
        System.out.println("Min Value: "+minstack.getMinValue());

        System.out.println();


        minstack.push(2);
        minstack.push(10);
        System.out.println("Current Stack");
        minstack.printstack();

        System.out.println("Min Value: "+minstack.getMinValue());
        minstack.pop();
        System.out.println("Min Value: "+minstack.getMinValue());


        minstack.pop();
        System.out.println("Min Value: "+minstack.getMinValue());
        minstack.pop();
        System.out.println("Min Value: "+minstack.getMinValue());
        minstack.pop();
        System.out.println("Min Value: "+minstack.getMinValue());


        minstack.pop();
        System.out.println("Min Value: "+minstack.getMinValue());



    }
}

class MinStack {
    private ArrayList<NodeMinStack> stack;
    private int index;

    public MinStack(){
        stack =  new ArrayList<>();
        index = -1;
    }

    void push(int data){
        int minValue = Math.min(data,getMinValue());
        stack.add(new NodeMinStack(data,minValue));
        index++;
    }

    int pop(){
        if(index==-1)
            return 0;
        return stack.remove(index--).getData();
    }

    int peek(){
        if(index==-1)
            return 0;
        return stack.get(index).getData();
    }

    int getMinValue(){
        if(index==-1)
            return 1000000000;
        return stack.get(index).getMinValue();
    }

    void printstack(){
        stack.stream()
                .map(NodeMinStack::getData)
                .forEach(System.out::println);
    }

}

class NodeMinStack{
    private int data;
    private int minValueSofar;

   /* NodeMinStack(){
        data = 0;
        minValueSofar = 0;
    }*/

    NodeMinStack(int data, int minValueSofar){
        this.data=data;
        this.minValueSofar=minValueSofar;
    }

    int getData(){
        return this.data;
    }

    int getMinValue(){
        return this.minValueSofar;
    }

    void setdata(int data){
        this.data = data;
    }

    void setMinValue(int minValueSofar){
        this.minValueSofar = minValueSofar;
    }
}

