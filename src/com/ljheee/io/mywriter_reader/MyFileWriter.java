package com.ljheee.io.mywriter_reader;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 自定义 文件输出流 封装了 数据加密算法[凯撒Caesar]
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

		// 调用父类的，写之前，加入其他操作，进行加密
		super.write(chars);
	}

}
