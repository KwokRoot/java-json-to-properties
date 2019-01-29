package org.kwok.util.json.filter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 过滤器构建类的构造方法。
 * @author Kwok
 */
public class JSONParserFilterBuilder {
	
	//空值(null)替换字符串。
	private String nullReplaceString;
	
	//键替换，如把所有的键为 oldKey --> newKey。
	private Map<String, String> keyReplaceMap;
	
	//值替换，如把所有的值为 oldVal --> newVal。
	private Map<Object, Object> valueReplaceMap;
	
	//键值替换，如把所有键为 key 的值替换为 newVal。
	private Map<String, Object> keyValueReplaceMap;
	
	//键忽略，如把键为 key1、key2的键在解析时忽略该键值对。
	private List<String> keyIgnoreList;
	
	//值忽略，如把值为 val1、val2的值在解析时忽略该键值对。
	private List<Object> valIgnoreList;
	
	//键值忽略，如把键为 key，值为 Val 的键值对在解析时忽略该键值对。
	public Map<String, Object> keyValueIgnoreMap;
	
	//过滤器优先级
	public Set<JSONParserFilterNameEnum> filterOrderSet = new LinkedHashSet<JSONParserFilterNameEnum>();
	
	public JSONParserFilterBuilder() {}
	
	/**
	  * 注：
	  * 通过 new JSONParserFilterBuilder(...)，或者 new JSONParserFilter(...).create()，
	  * 执行有参构造方法时创建 JSONParserFilter 实例时，
	  * 过滤器优先级不是按照参数的顺序，而是按照 JSONParserFilterNameEnum 枚举类型的 order 的值，设置默认过滤的优先级。
	  * ！！！不影响 new JSONParserFilterBuilder.setXXX(...)...create() 链式构建方法创建 JSONParserFilter 实例的过滤优先级。
	  * ！！！链式构建方法的过滤优先级 仅 与链式调用的顺序有关，且为不同过滤类型。
	  * @author Kwok
	  **/
	public JSONParserFilterBuilder(String nullReplaceString, Map<String, String> keyReplaceMap,
			Map<Object, Object> valueReplaceMap, Map<String, Object> keyValueReplaceMap, List<String> keyIgnoreList,
			List<Object> valIgnoreList, Map<String, Object> keyValueIgnoreMap) {
		
		this.nullReplaceString = nullReplaceString;
		this.keyReplaceMap = keyReplaceMap;
		this.valueReplaceMap = valueReplaceMap;
		this.keyValueReplaceMap = keyValueReplaceMap;
		this.keyIgnoreList = keyIgnoreList;
		this.valIgnoreList = valIgnoreList;
		this.keyValueIgnoreMap = keyValueIgnoreMap;
		
		//设置默认过滤的优先级。
		this.filterOrderSet = JSONParserFilterNameEnum.setfilterOrderSet(nullReplaceString, keyReplaceMap, valueReplaceMap, keyValueReplaceMap, keyIgnoreList, valIgnoreList, keyValueIgnoreMap);
		
	}
	
	
	/**
	  * 注：
	  * 通过 new JSONParserFilterBuilder(...)，或者 new JSONParserFilter(...).create()，
	  * 执行有参构造方法时创建 JSONParserFilter 实例时，
	  * 过滤器优先级不是按照参数的顺序，而是按照 JSONParserFilterNameEnum 枚举类型的 order 的值，设置默认过滤的优先级。
	  * ！！！不影响 new JSONParserFilterBuilder.setXXX(...)...create() 链式构建方法创建 JSONParserFilter 实例的过滤优先级。
	  * ！！！链式构建方法的过滤优先级 仅 与链式调用的顺序有关，且为不同过滤类型。
	  * @author Kwok
	  **/
	public JSONParserFilter create() {
		return new JSONParserFilter(nullReplaceString, keyReplaceMap, valueReplaceMap, keyValueReplaceMap, keyIgnoreList, valIgnoreList, keyValueIgnoreMap, filterOrderSet);
	}
	
	public JSONParserFilterBuilder setNullReplaceString(String nullReplaceString) {
		this.nullReplaceString = nullReplaceString;
		if (nullReplaceString != null){
			filterOrderSet.add(JSONParserFilterNameEnum.nullReplaceString);
		}
		return this;
	}
	
	public JSONParserFilterBuilder setKeyReplaceMap(Map<String, String> keyReplaceMap) {
		this.keyReplaceMap = keyReplaceMap;
		if (keyReplaceMap != null && !keyReplaceMap.isEmpty()) {
			filterOrderSet.add(JSONParserFilterNameEnum.keyReplaceMap);
		}
		return this;
	}

	public JSONParserFilterBuilder setValueReplaceMap(Map<Object, Object> valueReplaceMap) {
		this.valueReplaceMap = valueReplaceMap;
		if (valueReplaceMap != null && !valueReplaceMap.isEmpty()) {
			filterOrderSet.add(JSONParserFilterNameEnum.valueReplaceMap);
		}
		return this;
	}

	public JSONParserFilterBuilder setKeyValueReplaceMap(Map<String, Object> keyValueReplaceMap) {
		this.keyValueReplaceMap = keyValueReplaceMap;
		if (keyValueReplaceMap != null && !keyValueReplaceMap.isEmpty()) {
			filterOrderSet.add(JSONParserFilterNameEnum.keyValueReplaceMap);
		}
		return this;
	}

	public JSONParserFilterBuilder setKeyIgnoreList(List<String> keyIgnoreList) {
		this.keyIgnoreList = keyIgnoreList;
		if (keyIgnoreList != null && !keyIgnoreList.isEmpty()) {
			filterOrderSet.add(JSONParserFilterNameEnum.keyIgnoreList);
		}
		return this;
	}

	public JSONParserFilterBuilder setValIgnoreList(List<Object> valIgnoreList) {
		this.valIgnoreList = valIgnoreList;
		if (valIgnoreList != null && !valIgnoreList.isEmpty()) {
			filterOrderSet.add(JSONParserFilterNameEnum.valIgnoreList);
		}
		return this;
	}

	public JSONParserFilterBuilder setKeyValueIgnoreMap(Map<String, Object> keyValueIgnoreMap) {
		this.keyValueIgnoreMap = keyValueIgnoreMap;
		if (keyValueIgnoreMap != null && !keyValueIgnoreMap.isEmpty()) {
			filterOrderSet.add(JSONParserFilterNameEnum.keyValueIgnoreMap);
		}
		return this;
	}
	
}
