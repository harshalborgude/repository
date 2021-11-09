package org.hrb.waitNotify;

public class App {

	// notify method should enclosed in synchronised block.
	// so by enclosing wait in synchronized block , there will not be any exception and crash.
	// one thread is waiting for another thread to complete, once complete will call notify method and 
	// lock on another waiting method get revoked!
	// with notifyAll(), all locks by wait method get released!
	// but notify all should be surrounded with synchronized block.
	// notify method will notify the longest waiting thread or higher priority thread.

	private int balence=0;

	public void withdraw(int amnt) {
		synchronized(this){
			if(balence<=0){
				try {
					System.out.println("waiting for balence!");
					wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}
		balence=balence-amnt;
		System.out.println("withdrawal successful!");
	}
	public void deposite(int amnt) {
		System.out.println("depositing balence!");
		balence+=amnt;
		System.out.println("deposite successfull!");
		synchronized(this){
			notify();
		}
	}

	public static void main(String[] args) {
		App app=new App();
		Thread th1=new Thread (new Runnable() {

			@Override
			public void run() {
				app.withdraw(3000);

			}

		});
		th1.setName("Thread1");
		th1.start();

		Thread th2=new Thread (new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				app.deposite(5000);

			}

		});
		th2.setName("Thread2");
		th2.start();



	}

}





















