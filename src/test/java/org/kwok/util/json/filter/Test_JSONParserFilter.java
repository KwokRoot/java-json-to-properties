package org.kwok.util.json.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 测试 JSONParserFilter 构建方法。
 * @author Kwok
 */
public class Test_JSONParserFilter {
	
	@Test
	public void setfilterOrderSetTest() {
		
		/*
		 * JSONParserFilter 无论如何创建，保证 filterOrderSet 不为空。
		 */
		System.out.println(new JSONParserFilter().filterOrderSet.size());
		System.out.println(new JSONParserFilterBuilder().create().filterOrderSet.size());
		System.out.println(new JSONParserFilterBuilder(null, null, null, null, null, null, null).create().filterOrderSet.size());
		System.out.println(new JSONParserFilter(null, null, null, null, null, null, null, null).filterOrderSet.size());
		
		/*
		结果
		0
		0
		0
		0
		*/
		
		System.out.println("-------------------------------------------------");
		
		/*
		 * 利用过滤器构建类  JSONParserFilterBuilder 创建 JSONParserFilter 实例。
		 */
		String nullReplaceString = "HelloNull";
		
		List<String> keyIgnoreList = new ArrayList<>();
		keyIgnoreList.add("1");
		keyIgnoreList.add("2");
		
		List<Object> valIgnoreList = new ArrayList<>();
		valIgnoreList.add("1");
		valIgnoreList.add("2");
		
		Map<String, Object> keyValueIgnoreMap = new HashMap<String, Object>();
		keyValueIgnoreMap.put("id", 3);
		
		Map<String, String> keyReplaceMap = new HashMap<String, String>();
		keyReplaceMap.put("Name", "name");
		
		Map<Object, Object> valueReplaceMap = new HashMap<Object, Object>();
		valueReplaceMap.put("2", "Ok");
		
		Map<String, Object> keyValueReplaceMap = new HashMap<String, Object>();
		keyValueReplaceMap.put("name", "567");
		
		/*
		 * 不同类型过滤，每次取上次过滤结果。
		 */
		JSONParserFilter parserFilter = new JSONParserFilterBuilder()
				.setNullReplaceString(nullReplaceString)
				.setKeyIgnoreList(keyIgnoreList)
				.setValIgnoreList(valIgnoreList)
				.setKeyValueIgnoreMap(keyValueIgnoreMap)
				.setKeyReplaceMap(keyReplaceMap)
				.setValueReplaceMap(valueReplaceMap)
				.setKeyValueReplaceMap(keyValueReplaceMap)
				.create();
		
		System.out.println(JSON.toJSONString(parserFilter, true));
		
		/*
		结果：
		{
			"filterOrderSet":["valIgnoreList","keyValueReplaceMap","nullReplaceString","keyValueIgnoreMap","keyReplaceMap","valueReplaceMap","keyIgnoreList"],
			"keyIgnoreList":[
				"1",
				"2"
			],
			"keyReplaceMap":{
				"Name":"name"
			},
			"keyValueIgnoreMap":{
				"id":3
			},
			"keyValueReplaceMap":{
				"name":"567"
			},
			"nullReplaceString":"HelloNull",
			"valIgnoreList":[
				"1",
				"2"
			],
			"valueReplaceMap":{
				"2":"Ok"
			}
		}
		
		*/
		
		System.out.println("-------------------------------------------------");
	}
	
}
