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
 * ʹ��ByteArrayOutputStream��ByteArrayInputStream�ֽ�����
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
			
			while(-1!=(size=in.read(buf))){  //�����ݶ��� buf
				//��Buf�е����ݣ�д���ڴ�
				byteOut.write(buf, 0, size);
			}
			
			//(���ֽ�����[�ڴ���])�����������
			byte[] data = byteOut.toByteArray();
			
			//�����ݽ��� ����----==��������ݴ�С��ԭ����1/3
			byte[] b64 = Base64.getEncoder().encode(data);
//			System.out.println(b64);
			
			
			//���������д���ļ�
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
				//���--д���ڴ�����
				byteOut.write(buff,0,size);
			}

			byte[] data = byteOut.toByteArray();//���ڴ�������--�������
			
			//����
			byte[] png = Base64.getDecoder().decode(data);
			
			//�����������ݣ���ԭ[����]֮ǰ�ĸ�ʽ����ͼƬ
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
		//�� ����MIME���ݣ���ͼƬ������ַ�
//		read(new File("D:\\todo\\2.png"),new File("2.txt"));
		
		
		//�ѡ���������ַ�������ԭ��  ͼƬ
		fromBase64(new File("2.txt"),new File("2.png"));
		
	}

	
}
