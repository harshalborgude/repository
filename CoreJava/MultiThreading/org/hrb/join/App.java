package org.hrb.join;

public class App {
	
	// if another thread is dependant on one thread then to synchronize this 2 threads 1 by 1 , join should use.
	// here th1 will start and counter will keep incrementing , th1's join method will wait for th1 to get finish.
	// once finish then main thread will resume.
	
	// th2 will wait for th1 , main thread will wait for th2.
	
	// with thread pool , we can limit number of thread under execution,
	// thread executor is helpfull to execute threads and after completion we should shut it down otherwise it will keep on running.
	
	
	public int counter=0;
	
	public static void main(String[] args) {
		
		App app=new App();
		Thread th1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					app.counter++;
				}
				
			}
			
		});
		Thread th2=new Thread(new Runnable() {

			@Override
			public void run() {
				// here th2 will wait for the completion of th1.th2 will join th1.
				try {
					th1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<1000;i++) {
					app.counter++;
				}
				
			}
			
		});
		
		/*
		 * try { // bcz of this join , th1 and main thread will join. th1.join(); }
		 * catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		th1.start();
		th2.start(); // th2 will wait for th1.
		
		try {
			// here main thread will wait till th2. thread 2 will join with main thread.
			th2.join();
			//th2.join(2000); // th2 will wait for 2k milisec and then will release the lock.
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}		
		System.out.println("the value of counter is :"+app.counter);
	}

}
