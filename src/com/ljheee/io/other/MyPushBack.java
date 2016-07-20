package com.ljheee.io.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PushbackReader;
import java.util.ArrayList;

public class MyPushBack {
	
	public static void main(String[] args) {
		
		//����--�����
		ArrayList<String> zh = new ArrayList<>();
		zh.add("�й�");
		zh.add("����");
		zh.add("��");
		zh.add("������");
		zh.add("��");
		zh.add("����");
		zh.add("����");
		zh.add("����");
		zh.add("��");
		
		//�洢--���շִʽ��
		ArrayList<String> words  =new ArrayList<>();
		
		try (
				PushbackReader in = new PushbackReader(
						new BufferedReader(
								new FileReader(new File("tt.txt"))));
				
				){
			int c;
			
			//һ������شʵ�һ����ʱ�ռ䣩
			StringBuilder word = new StringBuilder();
			
			while(-1!=(c = in.read())){
				word.append((char)c);
				
				if(zh.contains(word.toString())){
					
					words.add(word.toString());
					
					
					word.setLength(0);
					
				}
				
			}
			System.out.println(words);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
