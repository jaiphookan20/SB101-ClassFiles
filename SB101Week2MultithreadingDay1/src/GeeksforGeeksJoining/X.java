package GeeksforGeeksJoining;

class X {
	 
	public static void main (String[] args) {

     // creating two threads
     GFG t1 = new GFG();
     GFG t2 = new GFG();
     GFG t3 = new GFG();
     
     t1.setName("Thread 1");
     t2.setName("Thread 2");
     t3.setName("Thread 3");
     
     // thread t1 starts
     t1.start();
     
     // starts second thread after when first thread t1 has died.
     
     try
     {
    	 System.out.println("Current Thread: " + Thread.currentThread().getName());
         t1.join();
          
         /*
          If t is a Thread object whose thread is currently executing, then t.join() will make sure that 
          t is terminated before the next instruction is executed by the program.
          If there are multiple threads calling the join() methods that means overloading on 
          join allows the programmer to specify a waiting period
          */
     }

     catch(Exception ex)
     {
         System.out.println("Exception has " +
                             "been caught" + ex);
     }

     // t2 starts
     t2.start();

     // starts t3 after when thread t2 has died.
     try
     {
         System.out.println("Current Thread: " + Thread.currentThread().getName());
         t2.join();
     }

     catch(Exception ex)
     {
         System.out.println("Exception has been" +  " caught" + ex);
     }

     t3.start();
 }
}

/*
output:

Current Thread: main
Current Thread: Thread-0
0
Current Thread: Thread-0
1
Current Thread: main
Current Thread: Thread-1
0
Current Thread: Thread-1
1
Current Thread: Thread-2
0
Current Thread: Thread-2
1

In the above example we can see clearly second thread t2 
starts after first thread t1 has died and 
t3 will start its execution  after second thread t2 has died.

*/
