package org.hrb.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteRead {
	
	// BufferedWriter to write into file.
	// BufferedReader to read from file.
	
	public static void main(String[] args) {
		
		File directory=new File("myDirectory");
		directory.mkdir();
		File file=new File("myDirectory\\file.txt");
		try {
			file.createNewFile();
			System.out.println("File created!");
		} catch (IOException e) {
			System.out.println("Error occured while creating a file!");
			
		}
		// FileWriter(file,true) mns content is appended to file.
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(file,true))){
			bw.write("harshal\n");
			bw.write("i dont know\n");
			bw.write("this is my program\n");
			bw.write("i will finish core java now\n");
			bw.write("i left with 2 topics\n");
			bw.write("then i will start\n");
			bw.write("servlets and jsp's\n");
			System.out.println("file writing completed!");
			bw.close();
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		try{
			BufferedReader br=new BufferedReader(new FileReader("myDirectory\\\\file.txt"));
			String line;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			br.close(); 
		}catch(FileNotFoundException e){	
			System.out.println("reading file failed!");
			e.printStackTrace();
			
		}catch(IOException e) {
			System.out.println("reading file failed!");
			e.printStackTrace();
		}
		

	}

}
