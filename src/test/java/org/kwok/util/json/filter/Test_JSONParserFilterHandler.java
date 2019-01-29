package org.kwok.util.json.filter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.kwok.util.json.JSONParserUtils2;

/**
 * @author Kwok
 */
public class Test_JSONParserFilterHandler {

	@Test
	public void doFilterTest() throws IOException{
		
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
		 * 须为不同过滤类型（多个同过滤类型，链式后面过滤参数会覆盖前面同类型的过滤参数），每次取上次过滤结果。
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
		
		Map<String, Object> map = JSONParserUtils2.jsonToMap(FileUtils.readFileToString(new File("src/main/resources/test.json"), Charset.defaultCharset()),null);
		map = JSONParserFilterHandler.doFilter(map, parserFilter);
		Set<Entry<String, Object>> mapSet = map.entrySet();
		for (Entry<String, Object> entry : mapSet) {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}
		
	}
	
	/**
	 * @author Kwok
	 **/
	@Test
	public void doEntryFilterTest(){
		
		String nullReplaceString = "HelloNull";
		
		List<String> keyIgnoreList = new ArrayList<>();
		keyIgnoreList.add("1");
		keyIgnoreList.add("Name");
		
		List<String> keyIgnoreList2 = new ArrayList<>();
		keyIgnoreList2.add("4");
		
		List<Object> valIgnoreList = new ArrayList<>();
		valIgnoreList.add(5);
		valIgnoreList.add("7");
		
		Map<String, Object> keyValueIgnoreMap = new HashMap<String, Object>();
		keyValueIgnoreMap.put("id", 3);
		
		Map<String, String> keyReplaceMap = new HashMap<String, String>();
		keyReplaceMap.put("Name", "name");
		
		Map<Object, Object> valueReplaceMap = new HashMap<Object, Object>();
		valueReplaceMap.put("6", "Ok");
		
		Map<String, Object> keyValueReplaceMap = new HashMap<String, Object>();
		keyValueReplaceMap.put("name", "567");
		
		/*
		 * 须为不同过滤类型（多个同过滤类型，链式后面过滤参数会覆盖前面同类型的过滤参数），每次取上次过滤结果。
		 */
		JSONParserFilter parserFilter = new JSONParserFilterBuilder()
				.setNullReplaceString(nullReplaceString)
				.setKeyIgnoreList(keyIgnoreList)
				.setKeyIgnoreList(keyIgnoreList2) //过滤参数会覆盖 keyIgnoreList。
				.setValIgnoreList(valIgnoreList)
				.setKeyValueIgnoreMap(keyValueIgnoreMap)
				.setKeyReplaceMap(keyReplaceMap)
				.setValueReplaceMap(valueReplaceMap)
				.setKeyValueReplaceMap(keyValueReplaceMap)
				.create();
		
		System.out.println(parserFilter.filterOrderSet);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Name", "6");
		map.put("4", "6");
		
		Set<Entry<String, Object>> mapSet = map.entrySet();
		for (Entry<String, Object> entry : mapSet) {
			System.out.println(JSONParserFilterHandler.doEntryFilter(entry, parserFilter));
		}
		
	}
	
}
