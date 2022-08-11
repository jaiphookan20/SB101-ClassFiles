package GeeksforGeeksJoining;


//Java program to explain the
//concept of joining a thread.
import java.io.*;

//Creating thread by creating the
//objects of that class
class GFG extends Thread {
	 
	 @Override
	 public void run() {
	     for (int i = 0; i < 2; i++)
	     {
	         try
	         {
	             Thread.sleep(800);
	             System.out.println("Currently running from run method");
	             System.out.println("Current Thread: " + Thread.currentThread().getName());
	         }
	
	         catch(Exception ex)
	         {
	             System.out.println("Exception has" + " been caught" + ex);
	         }
	         
	         System.out.println(i);
	     }
	 }

}

/* 
In the above example we can see clearly second thread t2 starts after 
first thread t1 has died 
and t3 will start its execution after second thread t2 has died.
 * */
