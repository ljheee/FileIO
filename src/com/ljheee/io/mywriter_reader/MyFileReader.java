package com.ljheee.io.mywriter_reader;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class MyFileReader extends FilterReader {

	public MyFileReader(Reader in) {
		super(in);
	}

	/*
	 * 读取一个字符，并返回
	 * 
	 * @see java.io.FilterReader#read()
	 */
	@Override
	public int read() throws IOException {

		int ch = (char) super.read();

		// TODO 有问题的 z,最后字母z+1后，变成非字母，可能无法处理
		if (ch >= 'a' && ch <= 'z') {
			ch--;
		}

		return ch;
	}

	/*
	 * 使用缓存区，cbuf读取数据，返回缓存区有效字符长度
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
