/**
 * 
 */
package com.maroy.random.probs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MaRoy
 *
 */
public class ReformatDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++){
			
			String inputDate = br.readLine();
			
			inputDate = inputDate.replaceFirst("[a-zA-Z]{2}","");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM yyyy");
	        Date rightNow = simpleDateFormat.parse(inputDate);
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = dateFormat.format(rightNow);
	        System.out.println(formattedDate);
		}

	}

}
