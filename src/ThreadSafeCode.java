public class ThreadSafeCode {

    public static void main(String[] args) throws Exception {

        Counter c = new Counter();
        c.increment();
        c.increment();


        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <1000 ; i++) {
                    c.increment();
                }
            }
        });


        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <1000 ; i++) {
                    c.increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Value of c is : "+c.count);
    }
}

class Counter{
    int count = 0;

    synchronized void increment(){
        count++;
    }
}


