package org.hrb.lambda;

interface Lamda{
	abstract public void demo();
}

public class Test {

	public static void main(String[] args) {
		
		Lamda lamda=new Lamda() {

			@Override
			public void demo() {
				System.out.println("testing lamda!");
				
			}			
		};
		lamda.demo();

	}

}
