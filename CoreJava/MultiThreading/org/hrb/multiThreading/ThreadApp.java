package org.hrb.multiThreading;

class MyCounter extends Thread{
	private int threadNo;

	public MyCounter(int threadNo) {
		
		this.threadNo = threadNo;
	}
	
	
	@Override
	public void run() {
		countMe();
	}


	public void countMe() {
		for(int i=1;i<=9;i++) {
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			System.out.println("value of i is :"+i+"and thread no is :"+threadNo);
		}	
	}	
}

public class ThreadApp {
	// threads are running parallely in same process using same memory.
	// to implement the thread , class should extends Thread class and should override run() method,
	// run method should call to the methods of class.
	// run method is get called by JVM , we should not call it ,
	// we should call to start() method so thread will start.and will taken care by JVM.
	public static void main(String[] args) throws InterruptedException {

		
		MyCounter counter1=new MyCounter(1);
		MyCounter counter2=new MyCounter(2);
		
		long startTime=System.currentTimeMillis();
		counter1.start();
		System.out.println("*****************************");	
		counter2.start();
		
		Thread.sleep(4507);
		long endTime=System.currentTimeMillis();
		
		System.out.println("difference between time is :"+(endTime-startTime));
	}

}










