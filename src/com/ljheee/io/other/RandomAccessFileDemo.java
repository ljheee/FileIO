package com.ljheee.io.other;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * RandomAccessFile实现了--DataInput、DataOutput接口，既可输入，也可输出
 * @author ljheee
 *
 */
public class RandomAccessFileDemo {
	
	public static void main(String[] args) {
		
//		write();
		read();
	}

	public static void read() {
		
		try (
				RandomAccessFile accessFile= new RandomAccessFile("access.dat", "rw");
				){
			accessFile.seek(4+8);//skip
			
			System.out.println(accessFile.readUTF());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void write() {
		RandomAccessFile accessFile = null;
		try {
			accessFile = new RandomAccessFile("access.dat", "rw");
			
			accessFile.writeInt(9);
			accessFile.writeDouble(3.14);
			accessFile.writeUTF("Msg");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			
			try {
				if(accessFile!=null) accessFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
