package org.hrb.runnable;

import java.util.Random;

class MyCounter implements Runnable{
	private int threadNo;

	public MyCounter(int threadNo) {
		
		this.threadNo = threadNo;
	}

	@Override
	public void run() {
		// this random object will provide random digits.
		// here will get random int between 1 - 500
	
		Random random=new Random();
		for(int i=0;i<=9;i++) {
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("The value of i is :"+i+" and thread no is :"+threadNo);
		}
		
	}
		
}

public class RunnableInterfaceApp {
	// for the runnable , creation of objects should be like below,
	// sequence of running thread will varry depend upon hardware.
	// so using runnable interface we can create object of thread.and can override run method.
	// and we can start it same using start() method.
	// or we can make use of anonymous object and start the thread directly.
	
	// so we can use threads by extending thread class as well as runnable interface.
	
	public static void main(String[] args) throws InterruptedException {

		Thread thread1=new Thread(new MyCounter(1));
		Thread thread2=new Thread(new MyCounter(2));
		
		thread1.start();
		thread2.start();
	}

}










