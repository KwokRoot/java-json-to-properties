package org.kwok.util.json;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 判断哪些基本类型的字符串能被 JSONObject、JSONArray 方法处理。
 * @author Kwok
 */
public class Test_OrgJson_Parse {
	
	public static void main(String[] args) {
		
		try{
			System.out.println(new JSONObject("1"));
		}catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("OrgJson 不能转化该字符串。");
		}
		
		try{
			System.out.println(new JSONArray("1"));
		}catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("OrgJson 不能转化该字符串。");
			System.err.println("------------------------------------");
		}
		
		
		try{
			System.out.println(new JSONObject("1.10"));
		}catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("OrgJson 不能转化该字符串。");
		}
		
		try{
			System.out.println(new JSONArray("1.10"));
		}catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("OrgJson 不能转化该字符串。");
			System.err.println("------------------------------------");
		}
		
		
		try{
			System.out.println(new JSONObject("true"));
		}catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("OrgJson 不能转化该字符串。");
		}
		
		try{
			System.out.println(new JSONArray("true"));
		}catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("OrgJson 不能转化该字符串。");
			System.err.println("------------------------------------");
		}
		
		
		try{
			Object obj = null;
			System.out.println(new JSONObject(obj));
		}catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("OrgJson 不能转化该字符串。");
		}
		
		try{
			Object obj = null;
			System.out.println(new JSONArray(obj));
		}catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("OrgJson 不能转化该字符串。");
			System.err.println("------------------------------------");
		}
		
		
		try{
			System.out.println(new JSONObject("one"));
		}catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("OrgJson 不能转化该字符串。");
		}
		
		try{
			System.out.println(new JSONArray("one"));
		}catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("OrgJson 不能转化该字符串。");
			System.err.println("------------------------------------");
		}
		
		/*
		结果：
		A JSONObject text must begin with '{' at 1 [character 2 line 1]
		OrgJson 不能转化该字符串。
		A JSONArray text must start with '[' at 1 [character 2 line 1]
		OrgJson 不能转化该字符串。
		------------------------------------
		A JSONObject text must begin with '{' at 1 [character 2 line 1]
		OrgJson 不能转化该字符串。
		A JSONArray text must start with '[' at 1 [character 2 line 1]
		OrgJson 不能转化该字符串。
		------------------------------------
		A JSONObject text must begin with '{' at 1 [character 2 line 1]
		OrgJson 不能转化该字符串。
		A JSONArray text must start with '[' at 1 [character 2 line 1]
		OrgJson 不能转化该字符串。
		------------------------------------
		null
		OrgJson 不能转化该字符串。
		null
		OrgJson 不能转化该字符串。
		------------------------------------
		A JSONObject text must begin with '{' at 1 [character 2 line 1]
		OrgJson 不能转化该字符串。
		A JSONArray text must start with '[' at 1 [character 2 line 1]
		OrgJson 不能转化该字符串。
		------------------------------------
		*/
		
	}
	
}
