package org.hrb.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Data{
	String name;
	
	public Data(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}

public class CompareLambda {

	// here instead of overriding whole comparator method, we can implement that in a single line using lambda expression.
	
	public static void main(String[] args) {

		List<Data> list=new ArrayList<>();
		list.add(new Data("maruti"));
		list.add(new Data("joker"));
		list.add(new Data("harshal"));
		list.add(new Data("iron man"));
				
		
	    Collections.sort(list, (Data o1, Data o2)->o1.getName().compareTo(o2.getName()));
	    
			/*
			 * Collections.sort(list,new Comparator<Data>() {
			 * 
			 * @Override
			 * public int compare(Data o1, Data o2) {
			 * 
			 * return o1.getName().compareTo(o2.getName()); 
			 * } 
			 * });
			 */		
		
		for(Data data:list) {
			System.out.println(data.getName());
		}
		
		
	}

}
















