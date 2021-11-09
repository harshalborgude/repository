package org.hrb.lambda;

interface Lambda {
	void demo();
}

public class App {
	
	// we can make use of lambda expression where only single method interface.
	// -> this expression is known as arrow token.
	public static void main(String[] args) {

		//Lambda lambda = (() -> System.out.println("statement single"));

		  Lambda lambda=()->{ 
		  System.out.println("statement 1");
		  System.out.println("statement 2"); 
		  };
		 		 
		lambda.demo();
	}

}

/*
 * public class App {
 * 
 * public static void main(String[] args) {
 * 
 * Lambda lambda=new Lambda() {
 * 
 * @Override public void demo() { System.out.println("statement 1");
 * 
 * } }; lambda.demo();
 * 
 * }
 * 
 * }
 */