package org.hrb.deadlock;

public class DeadLock {

	// deadlock will make stuck application on one stage , it will not terminate as well not proceed further.
	// here one thread applied lock1 and another applied lock2, lock1 needs lock2 to unlock and lock2 need
	// lock1 to unlock but they become interdependant so came in deadlock state.
	// here synchronized block was on different locks,
	// intersection of resources is cause to deadlock.
	
	public static void main(String[] args) {
		String lock1="lock1";
		String lock2="lock2";
		Thread th1=new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lock1){
					System.out.println("inside th1 lock1");
					synchronized(lock2){
						System.out.println("inside th1 lock2");
						
					}
				}			
			}			
		});
		Thread th2=new Thread(new Runnable() {

			@Override
			public void run() {
				
				synchronized(lock2){
					System.out.println("inside th2 lock2");
					synchronized(lock1){
						System.out.println("inside th2 lock1");
						
					}
				}
				
			}			
		});
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("in main thread!");

	}

}
