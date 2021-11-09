package org.hrb.file;

import java.io.File;
import java.io.IOException;

public class Directory {

	public static void main(String[] args) throws IOException {
		
		File directory = new File("myDirectory");
		directory.mkdir();										// this will create single directory
		System.out.println("directory created!");
		
		File directories=new File("myDirectory\\hrb\\programs");
		directories.mkdirs();										// this will create multiple directories at time.
		System.out.println("all directories created!");
		
		File file=new File("myDirectory\\hrb\\programs\\myFile.txt");		
		file.createNewFile();											// this will create file in that path.
		
	}

}
