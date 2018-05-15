package LeetCode;

public class TestInheritance {

    public static void main(String[] args) throws Exception {


        Integer i =  new Integer(1);
        Number n =  new Integer(2);
        Object o =  new Integer(3);


        ///Since Object -> number ->Integer (All the veriables will have access to it.)
        ///wait() is a object class method
        i.wait();
        n.wait();
        o.wait();

        Object p =  new Object();
        p.wait();

        ///

        i.wait();




    }
}
