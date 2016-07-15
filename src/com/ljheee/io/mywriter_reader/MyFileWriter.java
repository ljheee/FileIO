package com.ljheee.io.mywriter_reader;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * �Զ��� �ļ������ ��װ�� ���ݼ����㷨[����Caesar]
 * 
 * @author ljheee
 *
 */
public class MyFileWriter extends FilterWriter {

	public MyFileWriter(Writer out) {
		super(out);
	}

	@Override
	public void write(char[] chars) throws IOException {
		
		for (int i = 0; i < chars.length; i++) {

			if (chars[i] >= 'a' && chars[i] <= 'z') {
				chars[i] += 1;
			}
		}

		super.write(chars);
	}

	@Override
	public void write(String str) throws IOException {

		char[] chars = str.toCharArray();

		for (int i = 0; i < chars.length; i++) {

			if (chars[i] >= 'a' && chars[i] <= 'z') {
				chars[i] += 1;
			}
		}

		// ���ø���ģ�д֮ǰ�������������������м���
		super.write(chars);
	}

}
