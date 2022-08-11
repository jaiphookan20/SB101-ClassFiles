package NotesThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/* 
We can create Thread Pool as follows: 
	ExecutorService service=Executors.newFixedThreadPool(3);


Here we have created the pool of 3 threads.

After creating the pool we need to submit the tasks to this pool.

	service.submit(task); 
// here task is the object of Runnable.

 * */

public class Main {
	
	public static void main(String[] args){
		PrintJob[] jobs = {
		new PrintJob("Ram"),
		new PrintJob("Ravi"), 
		new PrintJob("Anil"), 
		new PrintJob("Shiva"), 
		new PrintJob("Pawan"), 
		new PrintJob("Suresh")
		};
		
		ExecutorService service = Executors.newFixedThreadPool(3); 
		
		for(PrintJob job:jobs){
			service.submit(job); 
		}
		
		service.shutdown();
		//to shutdown the executorService. }
	}

}


class PrintJob implements Runnable {
	String name; 
	
	PrintJob(String name){
		this.name=name; 
	}
	
	public void run(){
		System.out.println(name +" job started by Thread :"+Thread.currentThread().getName());
	
	try{
		Thread.sleep(5000);
	}
	catch(InterruptedException e){ 
		e.printStackTrace();
	}
	
	System.out.println(name +"..job completed by Thread :"+Thread.currentThread().getName()); }
}