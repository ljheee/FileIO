package com.ljheee.io;

import java.io.*;
/**
 * 文件操作
 * @author ljheee
 *
 */
public class FileOperate {

	/**
	 * 复制单个 文件(使用字节流)
	 * 
	 * @param srcFile
	 *            源文件
	 * @param destFile
	 *            目标文件
	 */
	public static void copySingleFile(File srcFile, File destFile) {

		FileInputStream in = null;
		FileOutputStream out = null;
		byte buf[] = new byte[1024 * 4];
		int size = 0;

		try {

			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);

			while (-1 != (size = in.read(buf))) {//把源文件数据==读到buf
				out.write(buf, 0, size);  //把buf数据，写到目标文件
			}
			System.out.println("copy over.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 复制单个 文件(使用带缓冲的 字节流[JVM层])
	 * 
	 * @param srcFile
	 *            源文件
	 * @param destFile
	 *            目标文件
	 */
	public static void copySingleFile2(File srcFile, File destFile) {

		FileInputStream in = null;
		FileOutputStream out = null;

		BufferedInputStream bin = null; // 对基础 字节流包装，装饰器模式
		BufferedOutputStream bout = null;
		byte buf[] = new byte[1024 * 4];
		int size = 0;

		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);

			// 真正做事的还是基础字节流，包装后，增强功能
			bin = new BufferedInputStream(in);
			bout = new BufferedOutputStream(out);

			while (-1 != (size = bin.read(buf))) {
				bout.write(buf, 0, size);
				bout.flush();//此行一定要增加，否则会报错。bout自带缓冲
			}
			System.out.println("copy over.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
				if (bin != null)
					bin.close();
				if (bout != null)
					bout.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * JDK1.7及以上可用
	 * 资源、流的打开==放到try()  括号内；不需要自己关闭
	 * @param src
	 * @param dest
	 */
	public static void copySingleFile17(File src,File dest){
		
		try (
			BufferedInputStream in = 
					new BufferedInputStream(new FileInputStream(src));
			
			BufferedOutputStream out = 
					new BufferedOutputStream(new FileOutputStream(dest))
				
				){
			
			byte[] buf = new byte[1024*8];
			int size = 0;
			while(-1!=(size=in.read(buf))){
				out.write(buf,0,size); 
			}
			System.out.println("copy over");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 返回文件大小
	 * @param file	
	 * @return	返回文件字节大小;return -1表示源文件为空或不存在
	 */
	public static int fileSize(File file){
		
		FileInputStream fin = null;
		int size = 0;
		if(!file.exists()||file==null)  return -1;
		
		try {
			fin = new FileInputStream(file);
			size = fin.available();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(fin!=null) fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return size;
	}

	public static void main(String[] args) {
		//测试复制文件
//		copySingleFile(new File("D:/mm.txt"), new File("C:/mm.txt"));
//		copySingleFile17(new File("D:/mm.txt"), new File("C:/mm.txt"));
//		copySingleFile2(new File("D:/mm.txt"), new File("C:/mm.txt"));
		int s = fileSize(new File("D:/servlet-api.jar"));
		System.out.println(s);
	}

}
