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
 * ʹ��ObjectInputStream
 * һ�ζ�дһ������(ʵ�������Ҫ�Զ���)
 * @author ljheee
 *
 */
public class ObjectStreamDemo {
	
	
	public static void main(String[] args) {
		
		//���л�
		//Object ---->�ֽ���
		
		//�����л�
		//�ֽ���------Object����
		

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
//			objectOut.writeObject(p2); //д���������󣬶�ȡʱ����˳���
			
			//����ֱ��--һ����д��һ���������
			objectOut.writeObject(ps);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
