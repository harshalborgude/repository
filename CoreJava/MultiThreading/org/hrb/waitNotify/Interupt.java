package org.hrb.waitNotify;

public class Interupt {

	
	static public int balence=0;

	public void withdraw(int amnt) {
		synchronized(this){
			if(balence<=0){
				try {
					System.out.println("waiting for balence!");
					wait();
				} catch (InterruptedException e) {
					System.out.println("Thread got interupted!");
					return; 
				}
			}
		}
		balence=balence-amnt;
		System.out.println("withdrawal successful! balence =");
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
		if(balence<=0) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			th1.interrupt();
		}
		
		
	}

}











