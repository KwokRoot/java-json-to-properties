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
		
		Object obj = JSON.parse(jsonStr);
		
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
					keyValueMap.put(keyPrefix + entry.getKey(), entry.getValue());
				}
			}
		}else if(obj instanceof JSONArray){
			JSONArray jsonArray = JSON.parseArray(jsonStr);
			for (int i = 0; i < jsonArray.size(); i++) {
				String tempKeyPrefix = keyPrefix == ""?keyPrefix + "[" + i + "]" + ".":keyPrefix.substring(0,keyPrefix.length()-1) + "[" + i + "]" + ".";
				keyValueMap.putAll(jsonToMap(jsonArray.get(i).toString(), tempKeyPrefix));
			}
		}else{
			/*
			 * 当值为数组，进入该分支，如：{"pages":[1,2,3]}。
			 */
			keyValueMap.put(keyPrefix.substring(0, keyPrefix.length()-1), jsonStr);
		}
		return keyValueMap;
	}
	
	
	/**
	 * JSON TO Properties
	 * @author Kwok
	 **/
	public static Properties jsonToProperties(String jsonStr){
		Properties properties = new Properties();
		properties.putAll(jsonToMap(jsonStr, null));
		return properties;
	}
	
	
	/**
	  * Properties TO JSON
	  * @author Kwok
	  **/
	public static String propertiesToJson(Properties properties){
		return new PropertiesToJsonConverter().convertToJson(properties);
	}
	
}
