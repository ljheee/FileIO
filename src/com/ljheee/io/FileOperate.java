package com.ljheee.io;

import java.io.*;
/**
 * �ļ�����
 * @author ljheee
 *
 */
public class FileOperate {

	/**
	 * ���Ƶ��� �ļ�(ʹ���ֽ���)
	 * 
	 * @param srcFile
	 *            Դ�ļ�
	 * @param destFile
	 *            Ŀ���ļ�
	 */
	public static void copySingleFile(File srcFile, File destFile) {

		FileInputStream in = null;
		FileOutputStream out = null;
		byte buf[] = new byte[1024 * 4];
		int size = 0;

		try {

			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);

			while (-1 != (size = in.read(buf))) {//��Դ�ļ�����==����buf
				out.write(buf, 0, size);  //��buf���ݣ�д��Ŀ���ļ�
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
	 * ���Ƶ��� �ļ�(ʹ�ô������ �ֽ���[JVM��])
	 * 
	 * @param srcFile
	 *            Դ�ļ�
	 * @param destFile
	 *            Ŀ���ļ�
	 */
	public static void copySingleFile2(File srcFile, File destFile) {

		FileInputStream in = null;
		FileOutputStream out = null;

		BufferedInputStream bin = null; // �Ի��� �ֽ�����װ��װ����ģʽ
		BufferedOutputStream bout = null;
		byte buf[] = new byte[1024 * 4];
		int size = 0;

		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);

			// �������µĻ��ǻ����ֽ�������װ����ǿ����
			bin = new BufferedInputStream(in);
			bout = new BufferedOutputStream(out);

			while (-1 != (size = bin.read(buf))) {
				bout.write(buf, 0, size);
				bout.flush();//����һ��Ҫ���ӣ�����ᱨ��bout�Դ�����
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
	 * JDK1.7�����Ͽ���
	 * ��Դ�����Ĵ�==�ŵ�try()  �����ڣ�����Ҫ�Լ��ر�
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
	 * �����ļ���С
	 * @param file	
	 * @return	�����ļ��ֽڴ�С;return -1��ʾԴ�ļ�Ϊ�ջ򲻴���
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
		//���Ը����ļ�
//		copySingleFile(new File("D:/mm.txt"), new File("C:/mm.txt"));
//		copySingleFile17(new File("D:/mm.txt"), new File("C:/mm.txt"));
//		copySingleFile2(new File("D:/mm.txt"), new File("C:/mm.txt"));
		int s = fileSize(new File("D:/servlet-api.jar"));
		System.out.println(s);
	}

}
