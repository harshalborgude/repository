package org.hrb.synchronisation;

public class App {

	public static int counter=0;
	
	// here creating a thread object with Runnable class.
	// if synchronization is not there then counter var will be having diff value at the end of threads.bcz
	// bcz multiple threads are working simultaniously.
	// synchronized element restrict multiple threads to work on it simultaniously.
	public static void main(String[] args) {
	
		Thread thread1=new Thread(new Runnable() {

			@Override
			public void run() {
			
				for(int i=0;i<1000;i++) {
					App.counter++;
				}
				System.out.println("The loop in thread 1	 is over ");
			}
			
		});
		Thread thread2=new Thread(new Runnable() {

			@Override
			public void run() {
			
				for(int i=0;i<1000;i++) {
					App.counter++;
				}
				System.out.println("The loop in thread 2 is over ");
			}
			
		});
		
		
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("counter value :"+App.counter);

	}

}
