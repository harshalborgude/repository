package org.hrb.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {

	// using this lock, we can stop multiple threads to running simultaneously.
	// here we r using lock a common variable between 2 threads,so there is a problem.
	// so we should apply lock whenever we r working with that variable in both threads.
	// to prevent deadlocks , reentrant lock is usefull.
	// if inside lock , we encountered exception , then this lock will become infinite lock.
	// so whatever between lock and unlock , put that inside try catch.
	
	static int counter=0;
	static Lock lock=new ReentrantLock();
	public static void main(String[] args) {
		
		Thread th1=new Thread(new Runnable() {

			@Override
			public void run() {
				lock.lock();				// after this lock call. reentrant lock will be applied, so 
				try {
					for(int i=1;i<=1000;i++) {   // only this single thread will get executed.no simultaneous operation.
						App.counter++;			
					}
				} finally {
					
					lock.unlock(); 			// with finally we ensure call to unlock.
				}
				
				
			}			
		});
		
		Thread th2=new Thread(new Runnable() {

			@Override
			public void run() {
				lock.lock();
				for(int i=1;i<=1000;i++) {
					App.counter++;				
				}
				lock.unlock();
			}			
		});
		th1.start();
		th2.start();
		
		try {
			th1.join();					// main method will wait untill th1 finishes
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		try {
			th2.join();					// main method will wait untill th2 finishes
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		
		System.out.println("final value of counter ="+App.counter);

	}

}
