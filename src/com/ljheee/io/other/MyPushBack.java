package com.ljheee.io.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PushbackReader;
import java.util.ArrayList;

public class MyPushBack {
	
	public static void main(String[] args) {
		
		//中文--词语库
		ArrayList<String> zh = new ArrayList<>();
		zh.add("中国");
		zh.add("今天");
		zh.add("是");
		zh.add("星期天");
		zh.add("我");
		zh.add("明天");
		zh.add("天气");
		zh.add("不错");
		zh.add("晴");
		
		//存储--最终分词结果
		ArrayList<String> words  =new ArrayList<>();
		
		try (
				PushbackReader in = new PushbackReader(
						new BufferedReader(
								new FileReader(new File("tt.txt"))));
				
				){
			int c;
			
			//一个词语（截词的一个临时空间）
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
