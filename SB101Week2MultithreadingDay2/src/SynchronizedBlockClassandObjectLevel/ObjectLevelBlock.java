package SynchronizedBlockClassandObjectLevel;

//public class ObjectLevelBlock {
//	
//}

public class ObjectLevelBlock {
	public void fun1(String name){
		
		/* Object Level Lock */
		synchronized(this){
			System.out.print("Welcome :");
		
		try { 
			Thread.sleep(1000);
		} 
		
		catch (InterruptedException e) { 
			e.printStackTrace();
		}
		
		System.out.println(name); }
	} 
}