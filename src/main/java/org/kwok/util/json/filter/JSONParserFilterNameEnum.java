package org.kwok.util.json.filter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 过滤器名枚举类。
 * @author Kwok
 */
public enum JSONParserFilterNameEnum {

	nullReplaceString(0), 
	keyReplaceMap(1), 
	valueReplaceMap(2), 
	keyValueReplaceMap(3), 
	keyIgnoreList(4), 
	valIgnoreList(5), 
	keyValueIgnoreMap(6);
	
	/**
	 * 默认过滤优先级数值。
	 */
	private int order;
	
	JSONParserFilterNameEnum(int order){
		this.order = order;
	}
	
	public int order() {
		return order;
	}
	
	/**
	 * 根据过滤优先级数值，设置默认过滤的优先级。
	 * new JSONParserFilterBuilder(...).create()，或者 new JSONParserFilter(...) 执行有参构造方法时调用该方法。
	 */
	public static Set<JSONParserFilterNameEnum> setfilterOrderSet(String nullReplaceString, Map<String, String> keyReplaceMap,
			Map<Object, Object> valueReplaceMap, Map<String, Object> keyValueReplaceMap, List<String> keyIgnoreList,
			List<Object> valIgnoreList, Map<String, Object> keyValueIgnoreMap){
		
		Set<JSONParserFilterNameEnum> filterOrderSet = new LinkedHashSet<JSONParserFilterNameEnum>();
		
		TreeMap<Integer, JSONParserFilterNameEnum> filterOrderMap = new TreeMap<Integer, JSONParserFilterNameEnum>();
		
		if(nullReplaceString != null){
			filterOrderMap.put(JSONParserFilterNameEnum.nullReplaceString.order(), JSONParserFilterNameEnum.nullReplaceString);
		}
		
		if(keyReplaceMap!=null && !keyReplaceMap.isEmpty()){
			filterOrderMap.put(JSONParserFilterNameEnum.keyReplaceMap.order(), JSONParserFilterNameEnum.keyReplaceMap);
		}
		
		if(valueReplaceMap!=null && !valueReplaceMap.isEmpty()){
			filterOrderMap.put(JSONParserFilterNameEnum.valueReplaceMap.order(), JSONParserFilterNameEnum.valueReplaceMap);
		}
		
		if(keyValueReplaceMap!=null && !keyValueReplaceMap.isEmpty()){
			filterOrderMap.put(JSONParserFilterNameEnum.keyValueReplaceMap.order(), JSONParserFilterNameEnum.keyValueReplaceMap);
		}
		
		if(keyIgnoreList!=null && !keyIgnoreList.isEmpty()){
			filterOrderMap.put(JSONParserFilterNameEnum.keyIgnoreList.order(), JSONParserFilterNameEnum.keyIgnoreList);
		}
		
		if(valIgnoreList!=null && !valIgnoreList.isEmpty()){
			filterOrderMap.put(JSONParserFilterNameEnum.valIgnoreList.order(), JSONParserFilterNameEnum.valIgnoreList);
		}
		if(keyValueIgnoreMap!=null && !keyValueIgnoreMap.isEmpty()){
			filterOrderMap.put(JSONParserFilterNameEnum.keyValueIgnoreMap.order(), JSONParserFilterNameEnum.keyValueIgnoreMap);
		}
		
		filterOrderSet.addAll(filterOrderMap.values());
		
		return filterOrderSet;
		
	}
	
}
