package com.ljheee.io.other;

import java.io.FileWriter;

public class CreateBigData {
	public static void main(String[] args) {
		
		
		try (
				FileWriter writer = new FileWriter("n1.txt",true);
				
				){
			
			
			for (int i = 0; i < 1000; i++) {
				int n = (int) (Math.random()*Integer.MAX_VALUE);	
				writer.write(String.valueOf(n)+"\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
