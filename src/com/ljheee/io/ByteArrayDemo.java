package com.ljheee.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * 使用ByteArrayOutputStream、ByteArrayInputStream字节数组
 * @author ljheee
 *
 */
public class ByteArrayDemo {

	public static void read(File src,File dest) {

		try(
			BufferedInputStream in = 
					new BufferedInputStream(new FileInputStream(src));	
			BufferedOutputStream bout = 
					new BufferedOutputStream(new FileOutputStream(dest));
				
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream(1024*8)
			
				) {
			
			byte[] buf = new byte[1024*8];
			int size;
			
			while(-1!=(size=in.read(buf))){  //把数据读到 buf
				//把Buf中的数据，写到内存
				byteOut.write(buf, 0, size);
			}
			
			//(从字节数组[内存中])获得所有数据
			byte[] data = byteOut.toByteArray();
			
			//对数据进行 编码----==编码后数据大小比原来多1/3
			byte[] b64 = Base64.getEncoder().encode(data);
//			System.out.println(b64);
			
			
			//用输出流，写到文件
			bout.write(b64);
			bout.flush();
			
			
		} catch (Exception e) {
		}
	}
	
	public static void fromBase64(File src,File dest) {
		
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		ByteArrayOutputStream byteOut = null;
		
		
		try {
			in = new BufferedInputStream(new FileInputStream(src));
			out = new BufferedOutputStream(new FileOutputStream(dest));
			byteOut = new ByteArrayOutputStream();
			
			
			byte[] buff = new byte[1024*8];
			int size = 0;
			while(-1!=(size=in.read(buff))){
				//输出--写到内存数组
				byteOut.write(buff,0,size);
			}

			byte[] data = byteOut.toByteArray();//从内存数组中--获得数据
			
			//解码
			byte[] png = Base64.getDecoder().decode(data);
			
			//将解码后的数据，还原[生成]之前的格式，如图片
			out.write(png);
			out.flush();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
				try {
					if(in!=null) in.close();
					if(out!=null) out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void main(String[] args) {
		//把 各种MIME数据，如图片，变成字符
//		read(new File("D:\\todo\\2.png"),new File("2.txt"));
		
		
		//把“被编码的字符”，还原成  图片
		fromBase64(new File("2.txt"),new File("2.png"));
		
	}

	
}
