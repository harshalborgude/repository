package org.hrb.volatileInMultiThreading;

public class App {

	// in this static case , there is chances that value of var will not get updated.
	// so we should mark it as volatile, its a rare issue.
	// so whenever thread is based on variable then mark that variable as volatile.
	
	volatile public static int flag=0;
	public static void main(String[] args) {
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				
				while(true) {
				if(flag==0)	System.out.println("running..");
				else break;
				}	
			}
		}).start();;
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				App.flag=1;
				System.out.println("flag value updated!");
			}
		}).start();;	

	}

}
