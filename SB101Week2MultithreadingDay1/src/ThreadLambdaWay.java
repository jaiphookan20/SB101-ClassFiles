
public class ThreadLambdaWay {

	public static void main(String[] args) {

        //2nd way
        //implement runnable interface

        Thread myThreadSecondWay = new Thread(new MyRunnable());
        myThreadSecondWay.start();

        Thread myThreadLambdaWay=new Thread(()
					-> System.out.println("my thread lambda way"));

        myThreadLambdaWay.start();
    }

}

//2nd way
//lambda
//implement Runnable
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("hello from MyThreadSecondWay");
    }
}
