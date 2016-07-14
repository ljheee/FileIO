package com.ljheee.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ljheee.io.entity.Address;
import com.ljheee.io.entity.Person;

/**
 * 使用ObjectInputStream
 * 一次读写一个对象(实体对象需要自定义)
 * @author ljheee
 *
 */
public class ObjectStreamDemo {
	
	
	public static void main(String[] args) {
		
		//序列化
		//Object ---->字节流
		
		//反序列化
		//字节流------Object对象
		

//		write();
		read();
	}

	
	public static void read() {

		try (
			ObjectInputStream objectIn = new ObjectInputStream(
								new BufferedInputStream(new FileInputStream("obj.dat")));	
				
				){

			Person[] ps = (Person[])objectIn.readObject();

			for (Person person : ps) {
				System.out.println(person);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	public static void write() {

		Person p1 = new Person("ljheee", "15773114762");
		Person p2 = new Person("Alices", "15379822214");
		p1.setAddress(new Address("cs","shaoshan498"));
		p2.setAddress(new Address("cs","shaoshan498"));
		
		
		Person[] ps = new Person[2];
		ps[0] = p1;
		ps[1] = p2;
		
		try (
			ObjectOutputStream objectOut = new ObjectOutputStream(
								new BufferedOutputStream(new FileOutputStream("obj.dat")));
				
				){
			
//			objectOut.writeObject(p1);
//			objectOut.writeObject(p2); //写了两个对象，读取时，按顺序读
			
			//或者直接--一次性写入一个数组对象
			objectOut.writeObject(ps);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
