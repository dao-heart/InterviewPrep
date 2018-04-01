import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.message.source.PayloadSourceMessage;

public class Fibonacci {

    static int [] memory;
    public static void main(String[] args) {
        int number = 10000  ;

        memory = new int[number+1];
        System.out.println("Fib with memory for "+number+" : "+withMemoryFibonacci(number));

        System.out.println("Memory : ");
        /*for (int i = 0; i < memory.length; i++) {
            System.out.println(memory[i]);
        }*/

        //System.out.println("Fib of "+number+" : "+simpleFibonacci(number));
    }

    public static int simpleFibonacci(int input){ // very bad code with O(2^n)
        if(input==1 || input==2)
            return 1;
        else
            return simpleFibonacci(input-1) + simpleFibonacci(input-2);
    }


    public static int withMemoryFibonacci(int input){ // very bad code with O(n)
        if(memory[input]!=0){
            return memory[input];
        }

        if(input==1 || input==2) {
            memory[input] = 1;
        }
        else {
            memory[input] = withMemoryFibonacci(input - 1) + withMemoryFibonacci(input - 2);

        }

        return memory[input];
    }



}
