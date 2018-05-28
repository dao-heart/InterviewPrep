public class ThreadSafeCode {

    public static void main(String[] args) throws Exception {

        Counter c = new Counter();
        c.increment();
        c.increment();

        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run()  {
                for (int i = 0; i <1000 ; i++) {
                    c.increment();
                    try{Thread.sleep(100);}catch (Exception e){}
                }
            }
        },"TheardSafeCodeThread1");


        Thread t2 =  new Thread(() -> {
            for (int i = 0; i <1000 ; i++) {
                c.increment();
                try{Thread.sleep(100);}catch (Exception e){}
            }
        },"TheardSafeCodeThread2");

        t1.start();
        t2.start();

        //all main thread, t1. and t2 are running.

        t1.join(); ///Tells main thread to wait till t1 is complete
        //main thread will stop till t1 is finished. (Running threads t1,t2).

        t2.join(); ///Tells main thread to wait till t2 is complete
        //main thread will stop till t2 is finished. (Running threads t1,t2).

        //main thread resume after t1 t2 are finished. (Running thread is main)
        System.out.println("Value of c is : "+c.count);
    }
}

class Counter{
    int count = 0;

    synchronized void increment(){
        count++;
    }
}


