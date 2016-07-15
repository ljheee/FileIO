package com.ljheee.io.encrypt;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.ljheee.io.mywriter_reader.MyFileReader;
import com.ljheee.io.mywriter_reader.MyFileWriter;

/**
 * �������� Caesar
 * 
 * @author ljheee
 *
 */
public class Caesar {

	public static String encryptString(String content) {
		String str = content;

		if (str == null || str.equals("")) {
			return null;
		}

		char[] chars = str.toCharArray();
		byte[] bytes = str.getBytes();

		// System.out.println(Arrays.toString(chars));
		// System.out.println(Arrays.toString(bytes));

		// �ַ�char ���ʾ�����ֵ�����Կ��Խ�����ֵ����ͱȽ�����,if(ch>='a'&&ch<='z')

		//ֱ��+1�������λ+1��ͻ᲻����ĸ
//		for (int i = 0; i < chars.length; i++) {
//			chars[i] += 1; // ��λ����
//		}
		
		for (int i = 0; i < chars.length; i++) {
			if(chars[i]<'a'+13&&chars[i]>='a'){
				chars[i] +=1;   //��ĸǰһ�� +1
			}else{
				chars[i] -=5;	//��һ��-5����װ���ܺ�����ĸ
			}
		}

		// System.out.println(chars.length);
		// System.out.println(bytes.length);

		System.out.println("���ܺ�" + new String(chars));
		return new String(chars);
	}

	public static String deEncryptString(String content) {
		String str = content;

		if (str == null || str.equals("")) {
			return null;
		}
		char[] chars = str.toCharArray();

		
		for (int i = 0; i < chars.length; i++) {
			if(chars[i]<'a'+13&&chars[i]>='a'){
				chars[i] -=1;
			}else{
				chars[i] +=5;
			}
		}
		return new String(chars);
	}
	
	
	
	public static void write(String msg) {

		try (MyFileWriter out = new MyFileWriter(new FileWriter(new File("caesar.txt")));) {

			out.write(msg);
			out.flush();
			System.out.println("write over");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void read() {

		try (MyFileReader in = new MyFileReader(new FileReader("caesar.txt"));

		) {
			char[] buf = new char[1024];
			int size = 0;
			StringBuilder sb = new StringBuilder();

			while (-1 != (size = in.read(buf))) {
				sb.append(buf, 0, size);
			}

			// ���� ������ݴ�ӡ���
			System.out.println(sb.toString());

		} catch (Exception e) {
		}

	}

	
	
	public static void main(String[] args) {
		// encryptString("Ilove");
		// write("msgqqqqqqqqqqqqLJH");

		read();

	}
}
