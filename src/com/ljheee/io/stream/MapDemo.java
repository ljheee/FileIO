package com.ljheee.io.stream;

import java.util.HashMap;
import java.util.Map;
/**
 * Map --key�������ظ���value�����ظ�
 * @author ljheee
 *
 */
public class MapDemo {
	public static void main(String[] args) {
		
		Map<String , Integer> map = new HashMap<>();
		
		
		map.put("Bob", 4);
		map.put("Alicwes", 14);
		map.put("jack", 44);
		map.put("Lee", 59);
		System.out.println(map.get("bobs"));  //������key������Null
		System.out.println(map);
	}

}
