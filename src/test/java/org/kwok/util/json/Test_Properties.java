package org.kwok.util.json;

import java.util.Properties;

/**
 * 由于  Properties 继承自 Hashtable，固 key、value 值均不可为 null。
 * @author Kwok
 */
public class Test_Properties {
	
	public static void main(String[] args) {
		
		Properties properties = new Properties();
		
		try{
			properties.setProperty(null, "kwok");
		}catch (Exception e) {
			System.err.println("键不能为 null。");
		}
		
		try{
			properties.setProperty("kwok", null);
		}catch (Exception e) {
			System.err.println("值不能为 null。");
		}
		
		/*
		结果：
		键不能为 null。
		值不能为 null。
		*/
		
	}
	
}
