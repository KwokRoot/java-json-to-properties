package org.kwok.util.json;

import org.json.JSONArray;
import org.json.JSONObject;

/** 
 * 判断普通字符串对象是否为 JSONObject 实例。
 * 判断普通字符串对象是否为 JSONArray 实例。
 * 判断 JSONArray 对象是否为 JSONObject 实例。
 * 判断 JSONObject 对象是否为 JSONArray 实例。
 * 依据此判断，判断字符串是哪种类型，进行相应处理。
 * @author Kwok
 */
public class Test_OrgJson_Object {
	
	public static void main(String[] args) {
		
		Object obj = "true";
		System.out.println(obj instanceof JSONObject);
		System.out.println(obj instanceof JSONArray);
		
		Object jsonObject = new JSONObject();
		System.out.println(jsonObject instanceof JSONObject);
		System.out.println(jsonObject instanceof JSONArray);
		
		Object jsonArray = new JSONArray();
		System.out.println(jsonArray instanceof JSONObject);
		System.out.println(jsonArray instanceof JSONArray);
		
		/*
		结果：
		false
		false
		true
		false
		false
		true
		*/
		
	}
	
}
