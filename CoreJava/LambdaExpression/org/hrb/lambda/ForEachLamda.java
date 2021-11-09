package org.hrb.lambda;

import java.util.ArrayList;
import java.util.List;

public class ForEachLamda {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(17);
		list.add(37);
		list.add(63);
		
		/*
		 * for(int i:list)
		 *  { 
		 *  System.out.println(i); 
		 *  }
		 */
		
		list.forEach(i->System.out.println(i));
		
		System.out.println("*****************");
		list.forEach(i->{
			if(i>20) System.out.println(i);
			
		});

	}

}
