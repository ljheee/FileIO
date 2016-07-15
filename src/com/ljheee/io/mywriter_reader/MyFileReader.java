package com.ljheee.io.mywriter_reader;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class MyFileReader extends FilterReader {

	public MyFileReader(Reader in) {
		super(in);
	}

	/*
	 * ��ȡһ���ַ���������
	 * 
	 * @see java.io.FilterReader#read()
	 */
	@Override
	public int read() throws IOException {

		int ch = (char) super.read();

		// TODO ������� z,�����ĸz+1�󣬱�ɷ���ĸ�������޷�����
		if (ch >= 'a' && ch <= 'z') {
			ch--;
		}

		return ch;
	}

	/*
	 * ʹ�û�������cbuf��ȡ���ݣ����ػ�������Ч�ַ�����
	 * 
	 * @see java.io.Reader#read(char[])
	 */
	@Override
	public int read(char[] cbuf) throws IOException {
		int size = super.read(cbuf);
		
		for (int i = 0;i< size;i++){
			char ch = cbuf[i];
			if (ch >= 'a' && ch <= 'z') {
				ch--;
				cbuf[i] = ch;
			}
		}
		
		return size;
	}

}
