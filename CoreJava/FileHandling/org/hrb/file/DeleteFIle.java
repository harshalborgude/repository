package org.hrb.file;

import java.io.File;

public class DeleteFIle {

	public static void main(String[] args) {
		
		File file=new File("myDirectory\\\\file.txt");
		
		if(file.delete()) {
			System.out.println("file Deleted!");
		}else {
			System.out.println("Error while deleting file!");
		}
		
	}

}
