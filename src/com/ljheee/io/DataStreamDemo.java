package com.ljheee.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用DataInputStream、DataOutputStream 
 * 装饰器模式，也是对基本流FileInputStream的包装，一次读一个基本类型
 * 
 * @author ljheee
 *
 */
public class DataStreamDemo {

	public static void readData() {

		DataInputStream dataIn = null;

		try {
			dataIn = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));

			int a = dataIn.readInt(); // 此处读取顺序，应该和写这些基本类型时一致，否则数据紊乱
			int a2 = dataIn.readInt();
			int a3 = dataIn.readInt();
			int a4 = dataIn.readInt();
			int a5 = dataIn.readInt();

			System.out.println(a);
			System.out.println(a2);
			System.out.println(a3);
			System.out.println(a4);
			System.out.println(a5);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeData() {

		FileInputStream in = null;
		FileOutputStream out = null;

		DataInputStream dataIn = null;
		DataOutputStream dataOut = null;

		try {
			out = new FileOutputStream("data.txt");
			dataOut = new DataOutputStream(new BufferedOutputStream(out));

			dataOut.writeInt(5); // 按基本类型，一次写一次，读取时按顺序读
			dataOut.writeInt(59); // 因此可以把他们封装成对象，使用ObjectInputStream
			dataOut.writeInt(56);
			dataOut.writeInt(53);
			dataOut.writeInt(new Integer(77));

			dataOut.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dataOut != null)
					dataOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// writeData();
		readData();
	}

}
