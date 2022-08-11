package SynchronizedBlockClassandObjectLevel;

public class ClassLevelLock {
    
	public static void main(String[] args) {
 	    Common c1=new Common();
 		Common c2=new Common();
 		
 		ThreadA t1=new ThreadA(c1, "raju");
 		ThreadB t2=new ThreadB(c2, "salman");
 		
 		t1.start();
 		t2.start();
	}
	
}

class Common {
	   
	public void fun1(String name) {
		   
		synchronized (Common.class) {             //synchronized block(class level)
			   System.out.print(" Welcome \n ");
			   
			   try {
				   Thread.sleep(1000);
			   }
			   
			   catch(Exception ee) {
				   
			   }
			   
			   System.out.println(name);
		   }
	   }
	}

	
	class ThreadA extends Thread {
		Common c;
		String name;
	
		public ThreadA(Common c,String name) {
			this.c=c;
			this.name=name;
		}
		
		@Override
		public void run() {
			c.fun1(name);
		}
		
	}

	class ThreadB extends Thread {
		Common c;
		String name;
		
		public ThreadB(Common c,String name) {
			this.c=c;
			this.name=name;
		}
	
		@Override
		public void run() {
			c.fun1(name);
		}
	}
