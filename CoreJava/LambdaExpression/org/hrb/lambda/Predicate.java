package org.hrb.lambda;

import java.util.function.IntPredicate;

public class Predicate {

	// predicate using lamda expression.
	// this whole method declaration can be done in single line using lamda expression.with same result.
	public static void main(String[] args) {

		/*
		 * IntPredicate lessThan18=new IntPredicate() {
		 * 
		 * @Override public boolean test(int value) { 
		 * if(value<18) return true; 
		 * else
		 * return false; }
		 * 
		 * };
		 * 
		 */		
		
		IntPredicate lessThan18=i->i<18;
		IntPredicate moreThan10=i->i>10;
		
		//System.out.println(lessThan18.test(20));
		System.out.println(lessThan18.and(moreThan10).test(9));
		
	}

}
