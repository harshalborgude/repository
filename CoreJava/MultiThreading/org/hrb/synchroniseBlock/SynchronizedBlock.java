package org.hrb.synchroniseBlock;

class Brackets{
	// with this synchronized keyword , we can synchronise threads of single instance.
	// but if threads are from 2 diff instances , then inconsitency will be there.
	// while synchronised , a intrinsic lock will be applied.
	// for locking , we should use private object to hide this lock from outside world.
	private Object lock="Lock";
	 public void generate() {

		 //  with this synchronized block , if generate method get called from any instances , even then
		 // it will work in synchronized way only.
		 
		synchronized(lock){
			for(int i=1;i<=10;i++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(i<=5) {
					System.out.print("[");
				}
				else {
					System.out.print("]");
				}
			}
			System.out.println();
		}

		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

public class SynchronizedBlock {

	// here in these 2 threads , we r not getting consitent op , as both running parallel and op depend on hardware
	// so we have to prevent generate() method to execute on multiple threads parallely.

	// so we have to mark that method as synchronized , so it will not be exexute on both thread simultaneously.
	// if objects are differnt then synchronized method will not work in synchronized manner.
	// in this case we have to make synchronized(this) block for that perticular method.
	// so in this case we have to preffer synchronized block over synchronized method.
	
	public static void main(String[] args) {
		Brackets bracket1=new Brackets();
		Brackets bracket2=new Brackets();
		//bracket.generate();

		new Thread(new Runnable() {

			@Override
			public void run() {
				long startTime= System.currentTimeMillis();
				for(int i=1;i<=10;i++) {
					bracket1.generate();
				}
				long endTime= System.currentTimeMillis();
				System.out.println("time for thread 1:"+(endTime-startTime));
			}


		}).start();;

		new Thread(new Runnable() {

			@Override
			public void run() {
				long startTime= System.currentTimeMillis();
				for(int i=1;i<=10;i++) {
					bracket2.generate();
				}				
				long endTime= System.currentTimeMillis();
				System.out.println("time for thread 2:"+(endTime-startTime));
			}

		}).start();;

	}

}
