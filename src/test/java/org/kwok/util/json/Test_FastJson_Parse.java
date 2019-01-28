package org.kwok.util.json;

import com.alibaba.fastjson.JSON;

/**
 * 判断哪些基本类型的字符串能被 JSON.parse() 方法处理。
 * @author Kwok
 */
public class Test_FastJson_Parse {
	
	public static void main(String[] args) {
		
		System.out.println(JSON.parse("1"));
		System.out.println(JSON.parse("1.10"));
		System.out.println(JSON.parse("true"));
		System.out.println(JSON.parse(null));
		try{
			System.out.println(JSON.parse("one"));
		}catch (Exception e) {
			System.err.println("FastJson 不能转化该字符串。");
		}
		
		
		/*
		结果：
		1
		1.10
		true
		null
		FastJson 不能转化该字符串。
		*/
		
	}
	
}
