package org.kwok.util.json.filter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 过滤器构造方法。
 * @author Kwok
 */
public class JSONParserFilter {
	
	//空值(null)替换字符串。
	public String nullReplaceString;
	
	//键替换，如把所有的键为 oldKey --> newKey。
	public Map<String, String> keyReplaceMap;
	
	//值替换，如把所有的值为 oldVal --> newVal。
	public Map<Object, Object> valueReplaceMap;
	
	//键值替换，如把所有键为 key 的值替换为 newVal。
	public Map<String, Object> keyValueReplaceMap;
	
	//键忽略，如把键为 key1、key2的键在解析时忽略该键值对。
	public List<String> keyIgnoreList;
	
	//值忽略，如把值为 val1、val2的值在解析时忽略该键值对。
	public List<Object> valIgnoreList;
	
	//键值忽略，如把所有键为 key，值为 Val 的键值对在解析时忽略该键值对。
	public Map<String, Object> keyValueIgnoreMap;
	
	//过滤器优先级
	public Set<JSONParserFilterNameEnum> filterOrderSet = new LinkedHashSet<JSONParserFilterNameEnum>();
	
	public JSONParserFilter() {}

	/**
	  * 注：
	  * 通过 new JSONParserFilterBuilder(...)，或者 new JSONParserFilter(...).create()，
	  * 执行有参构造方法时创建 JSONParserFilter 实例时，
	  * 过滤器优先级不是按照参数的顺序，而是按照 JSONParserFilterNameEnum 枚举类型的 order 的值，设置默认过滤的优先级。
	  * ！！！不影响 new JSONParserFilterBuilder.setXXX(...)...create() 链式构建方法创建 JSONParserFilter 实例的过滤优先级。
	  * ！！！链式构建方法的过滤优先级 仅 与链式调用的顺序有关，且为不同过滤类型。
	  * @author Kwok
	  **/
	public JSONParserFilter(String nullReplaceString, Map<String, String> keyReplaceMap,
			Map<Object, Object> valueReplaceMap, Map<String, Object> keyValueReplaceMap, List<String> keyIgnoreList,
			List<Object> valIgnoreList, Map<String, Object> keyValueIgnoreMap, Set<JSONParserFilterNameEnum> filterOrderSet) {
		this.nullReplaceString = nullReplaceString;
		this.keyReplaceMap = keyReplaceMap;
		this.valueReplaceMap = valueReplaceMap;
		this.keyValueReplaceMap = keyValueReplaceMap;
		this.keyIgnoreList = keyIgnoreList;
		this.valIgnoreList = valIgnoreList;
		this.keyValueIgnoreMap = keyValueIgnoreMap;
		if (filterOrderSet != null) {
			this.filterOrderSet = filterOrderSet;
		}else{
			//设置默认过滤的优先级。
			this.filterOrderSet = JSONParserFilterNameEnum.setfilterOrderSet(nullReplaceString, keyReplaceMap, valueReplaceMap, keyValueReplaceMap, keyIgnoreList, valIgnoreList, keyValueIgnoreMap);
		}
	}
	
}
