package com.ljheee.io.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
	
	public static void main(String[] args) {

		Map<String,Integer> map = new HashMap<>();
		int wordNum = 0;
		
		
		try {
			FileReader in = new FileReader(new File("caesar.txt"));
			
			//通过流，构造一个---字符解析器
			StreamTokenizer st = new StreamTokenizer(in);
			
			int type;
			while(StreamTokenizer.TT_EOF!=(type=st.nextToken())){
				
				switch (type) {
				
				case StreamTokenizer.TT_WORD:
					String str = st.sval;
					
					if(map.containsKey(str)){
						int num  = map.get(str);
						map.remove(str);
						map.put(str, ++num);
					}else{
						map.put(st.sval,new Integer(1) );
					}
					
					break;
					
				case StreamTokenizer.TT_NUMBER:
					System.out.println("number:"+st.nval);
					break;

				default:
					break;
				}
			}
			
			System.out.println("over");
			System.out.println(map);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
