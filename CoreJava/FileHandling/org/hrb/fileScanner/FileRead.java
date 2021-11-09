package org.hrb.fileScanner;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileRead {

	// Diff between BufferedReader and Scanner class
	// BufferedReader should be preffered in multithreaded application and scanner should be avoided in multiThreaded.
	// BufferedReader has 8kb buffer. Scanner have 1Kb buffer.
	// BUfferedReader is faster as simply reads sequence of chars
	// Scanner is slower as it does parsing of input data.
	// so for dealing with files BufferedReader is preffered 
	// and for user inouts , Scanner class is preffered.
	// if u dont close open file or scanner then there will be resource leak.
	
	// try with resource 
	// whenever opened stream or resourse is not closed then there will be a problem of resourse leak,
	// so it should be inside parenthesys of try block or resource should be closed after use.
	// try(<statement here >){}
	
	public static void main(String[] args) {
		
		try {
			Scanner sc =new Scanner(new File("myDirectory\\file.txt"));
			String line;
			while(sc.hasNext()) {
				line=sc.nextLine();
				System.out.println(line);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error in reading file");
			e.printStackTrace();
		}

	}

}
