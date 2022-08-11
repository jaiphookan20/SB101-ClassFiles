
public class _3ThreadStatesLifecycle {
    public static void main(String[] args) {
        //new state
        Thread firstThread = new Thread(
                //run method implementation
                        ()-> {
                            System.out.println("thread is running");
                            Thread.currentThread().setName("firstThread");
                            System.out.println(Thread.currentThread().getName());
                            
                            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                            System.out.println(Thread.currentThread().getPriority());
                            
                            System.out.println("sleeping...");
                            
                            /*  
                             A thread which is already under execution can be suspended 
                             (prevented from getting executed further) or we can control their execution based on three criteria:
								1. Time
								2. Conditionally
								3. Unconditionally.
							
							Suspending a thread based on time:
								There is a static method by name sleep(long ms) inside the Thread class which 
								takes time in milliseconds as an argument Example: Thread.sleep(1000);
								
								This method will suspend the current thread which is under execution with those many 
								millisecond passed as argument(1000ms=1sec).
								
								This sleep method is proven to generate checked exception hence it 
								must be called inside try and catch block.
								
								Note : we cannot use throws with run() method, it will violate the method override rule.
							
                             * */
                            
                            
                            try {
                                //4. blocked state
                                Thread.sleep(1000);
                            } 
                            
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("waking up...."); //This is printed 1 sec after 'sleeping' is printed (because of the thread.sleep)
                        }

        );



        //runnable
        //3. running
        firstThread.start();
    }
}


/* 
 * 
 * Thread Lifecycle:
    * In Java, a thread always exists in any one of the following states.
    * 1. New : vehicle is manufactured
    * 2. Runnable : Ready to Run : on the traffic light , yellow light
    * 3. Running: start() -> run() -> bike running
    * 4. Blocked: Paused. stop for fuel, food, red signal
    * 5. Dead/end state: You reach your destination. 
    * 
 

 * */
 