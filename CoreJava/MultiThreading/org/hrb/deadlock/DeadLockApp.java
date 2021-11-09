package org.hrb.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockApp {

	// reproducing same deadlock schenario with lock method of reentrant lock.
	// mechanism to prevent deadlock schenarios
	
	public static void main(String[] args) {
		Lock lock1=new ReentrantLock();
		Lock lock2=new ReentrantLock();
		Thread th1=new Thread(new Runnable() {

			@Override
			public void run() {
				boolean flagLock1=false;
				boolean flagLock2=false;
				boolean doneFlag1=false;
				boolean doneFlag2=false;
				
				while(true) {
					try {
						if(!flagLock1) {
							flagLock1=lock1.tryLock(10,TimeUnit.MILLISECONDS);
						}
						if(!flagLock2) {
							flagLock2=lock2.tryLock(10, TimeUnit.MILLISECONDS);
						}
						
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}finally {
						if(flagLock1 && !doneFlag1) {
							System.out.println("inside th1 lock1");
							lock1.unlock();
							doneFlag1=true;
						}
						if(flagLock2 && !doneFlag2) {
							System.out.println("inside th1 lock2");
							lock2.unlock();
							doneFlag2=true;
						}
						if(flagLock1 && flagLock2) {
							break;
						}
					}
					
				}
				
						
			}			
		});
		Thread th2=new Thread(new Runnable() {

			@Override
			public void run() {
				boolean flagLock1=false;
				boolean flagLock2=false;
				boolean doneFlag1=false;
				boolean doneFlag2=false;
				while(true) {
					try {
						if(!flagLock1) {
							flagLock1=lock1.tryLock(10,TimeUnit.MILLISECONDS);
						}
						if(!flagLock2) {
							flagLock2=lock2.tryLock(10, TimeUnit.MILLISECONDS);
						}
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}finally {
						if(flagLock1 && !doneFlag1) {
							System.out.println("inside th2 lock1");
							lock1.unlock();
							doneFlag1=true;
						}
						if(flagLock2 && !doneFlag2) {
							System.out.println("inside th2 lock2");
							lock2.unlock();
							doneFlag2=true;
						}
						if(flagLock1 && flagLock2) {
							break;
						}
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
