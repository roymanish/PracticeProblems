package com.main.java.code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	public static void main(String[] args) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try{
		fw = new FileWriter("C:\\VMShares\\output.txt");
		bw = new BufferedWriter(fw);
		bw.write("Hello World..!!!!");
		}
		catch(IOException e1){
			
		}
	}

}
