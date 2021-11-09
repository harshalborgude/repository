package org.hrb.lambda;

public class ThreadLambda {

	// below whole thread declaration can be avoided with lambda expression.
	public static void main(String[] args) {
			
		Thread th1=new Thread(()->{
			System.out.println("statement 1");
			System.out.println("statement 2");
		});
		
		/*
		 * Thread th1=new Thread(new Runnable() {
		 * @Override 
		 * public void run() { 
		 * System.out.println("statement!");
		 * 
		 * } 
		 * });
		 */
		
		// another way of declaring thread with lambda expression.
		new Thread(()->{
			System.out.println("statement 1");
			System.out.println("statement 2");
		}).start();
		
		th1.start();
		
	}

}
