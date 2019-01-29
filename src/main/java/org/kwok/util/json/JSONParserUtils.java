package org.kwok.util.json;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import pl.jalokim.propertiestojson.util.PropertiesToJsonConverter;

/**
 * JSON TO Properties
 * Properties TO JSON
 * JSON TO Map
 * Map TO JSON
 * Depend on alibaba/fastjson, mikolajmitura/java-properties-to-json.
 * @author Kwok
 */
public class JSONParserUtils {

/**
  * JSON TO Map
  * @author Kwok
  **/
public static Map<String,Object> jsonToMap(String jsonStr, String keyPrefix){
		
		if(keyPrefix == null){
			keyPrefix = "";
		}
		
		Map<String,Object> keyValueMap = new TreeMap<String,Object>();
		
		/*
		 * 当值为字符串数组（如："pages_en":["one","two","three"]），递归解析字符串时，会抛异常（如：JSON.parse("one") ）。
		 * 这里进行异常捕获，按键值对进行储存。
		 * 详情查看 src/main/java/org/kwok/util/json/Test_FastJson_Parse.java 。
		 */
		Object obj;
		try{
			obj = JSON.parse(jsonStr);
			
			/*
			//通过 Feature.UseObjectArray 属性，可以设置只转换第一层 Key，其他按数组对象储存。
			obj = JSON.parse(jsonStr, Feature.UseObjectArray);
			*/
		}catch (Exception e) {
			obj = jsonStr;
		}
		
		if(obj instanceof JSONObject){
			JSONObject jsonObject = JSON.parseObject(jsonStr);
			Set<Entry<String, Object>>mapSet = jsonObject.entrySet();
			Iterator<Entry<String, Object>>iterator = mapSet.iterator();
			while (iterator.hasNext()) {
				Entry<String, Object>entry = iterator.next();
				if(entry.getValue() instanceof JSONObject){
					String tempKeyPrefix = keyPrefix + entry.getKey() + ".";
					keyValueMap.putAll(jsonToMap(entry.getValue().toString(), tempKeyPrefix));
				}else if(entry.getValue() instanceof JSONArray){
					String tempKeyPrefix = keyPrefix + entry.getKey()+ ".";
					keyValueMap.putAll(jsonToMap(entry.getValue().toString(), tempKeyPrefix));
				}else{
					/*
					 * 处理属性值为 null 的情况，这里转为空字符串。
					 */
					if (entry.getValue() == null) {
						keyValueMap.put(keyPrefix + entry.getKey(), "");
					} else {
						keyValueMap.put(keyPrefix + entry.getKey(), entry.getValue());
					}
				}
			}
		}else if(obj instanceof JSONArray){
			JSONArray jsonArray = JSON.parseArray(jsonStr);
			for (int i = 0; i < jsonArray.size(); i++) {
				String tempKeyPrefix = keyPrefix == "" ? keyPrefix + "[" + i + "]" + "." : keyPrefix.substring(0, keyPrefix.length() - 1) + "[" + i + "]" + ".";
				/*
				 * 处理数组中元素为 null 的情况，这里转为空字符串。如：{"pages":[1,2,null]}。
				 */
				if (jsonArray.get(i) == null) {
					keyValueMap.putAll(jsonToMap("", tempKeyPrefix));
				} else {
					keyValueMap.putAll(jsonToMap(jsonArray.get(i).toString(), tempKeyPrefix));
				}
				
			}
		}else{
			/*
			 * 当值为数组，递归时进入该分支。如：{"pages":[1,2,3]}。
			 */
			keyValueMap.put(keyPrefix == "" ? keyPrefix : keyPrefix.substring(0, keyPrefix.length() - 1), jsonStr);
		}
		return keyValueMap;
	}
	
	
	/**
	 * JSON TO Properties
	 * 注：由于  Properties 继承自 Hashtable，固 key、value 值均不可为 null。
	 * 详情查看 src/main/java/org/kwok/util/json/Test_Properties.java。
	 * @author Kwok
	 **/
	public static Properties jsonToProperties(String jsonStr){
		Properties properties = new Properties();
		properties.putAll(jsonToMap(jsonStr, null));
		return properties;
	}
	
	
	/**
	  * Map TO JSON
	  * @author Kwok
	  **/
	public static String mapToJson(Map<String,Object> map){
		return new PropertiesToJsonConverter().convertFromValuesAsObjectMap(map);
	}
	
	
	/**
	  * Properties TO JSON
	  * @author Kwok
	  **/
	public static String propertiesToJson(Properties properties){
		return new PropertiesToJsonConverter().convertToJson(properties);
	}
	
}
