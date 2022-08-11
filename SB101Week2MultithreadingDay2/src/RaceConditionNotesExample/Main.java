package RaceConditionNotesExample;

class Common{
	
	public static synchronized void fun1(String name) {
			System.out.print("Welcome"); 
			
			try{
				Thread.sleep(1000); 
			}
			catch(Exception ee){
			
			}
			System.out.println(name);
	}
}
// the above method fun1() is supposed to give the output as welcome and after one second print the supplied name. N
// Now what will happen if two threads acts on this function simultaneously.

class ThreadA extends Thread {
	Common c; 
	String name;

	public ThreadA(Common c,String name) { 
		this.c = c;
		this.name = name; 
	}

		@Override
		public void run() {
				c.fun1(name); 
		}
}

class ThreadB extends Thread {
Common c; 
String name;

	public ThreadB(Common c, String name) { 
		this.c = c;
		this.name = name; 
	}

@Override
public void run() {
		c.fun1(name); 
}

}

class Main{
	public static void main(String[] args) { 
	
		Common c = new Common();
	
	//sharing same Common object to two thread 
	ThreadA t1 = new ThreadA(c,"Ram");
	ThreadB t2 = new ThreadB(c,"Shyam");
	
	t1.start();
	t2.start(); 
	
	}
}

/* 
Now the output will be 
Welcome Welcome Ram Shyam which is not expected. 

We can get the desired output if we avoid two thread acting on fun1() simultaneously.
To achieve this requirement we need to make fun1() as synchronized.
 * */

