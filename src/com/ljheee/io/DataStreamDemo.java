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
 * ʹ��DataInputStream��DataOutputStream 
 * װ����ģʽ��Ҳ�ǶԻ�����FileInputStream�İ�װ��һ�ζ�һ����������
 * 
 * @author ljheee
 *
 */
public class DataStreamDemo {

	public static void readData() {

		DataInputStream dataIn = null;

		try {
			dataIn = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));

			int a = dataIn.readInt(); // �˴���ȡ˳��Ӧ�ú�д��Щ��������ʱһ�£�������������
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

			dataOut.writeInt(5); // ���������ͣ�һ��дһ�Σ���ȡʱ��˳���
			dataOut.writeInt(59); // ��˿��԰����Ƿ�װ�ɶ���ʹ��ObjectInputStream
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
