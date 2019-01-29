package org.kwok.util.json.filter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * 过滤器处理类，执行过滤。
 * @author Kwok
 */
public class JSONParserFilterHandler {

	public static Map<String, Object> doFilter(Map<String, Object> srcMap, JSONParserFilter jsonParserFilter) {

		Map<String, Object> resultMap = new TreeMap<String, Object>();
		
		Set<Entry<String, Object>> srcMapEntrys = srcMap.entrySet();
		for (Entry<String, Object> entry : srcMapEntrys) {
			if(doEntryFilter(entry, jsonParserFilter)!=null){
				resultMap.putAll(doEntryFilter(entry, jsonParserFilter));
			}
		}
		
		return resultMap;
	}

	public static Map<String, Object> doEntryFilter(Entry<String, Object> entry, JSONParserFilter jsonParserFilter) {
		Map<String, Object> returnMapEntry = new HashMap<String, Object>();
		String keyPrefix = "";
		String key = "";
		
		if (entry.getKey() != null) {
			keyPrefix = entry.getKey().substring(0, entry.getKey().lastIndexOf(".") + 1);
			key = entry.getKey().substring(entry.getKey().lastIndexOf(".") + 1);
			returnMapEntry.put(key, entry.getValue());
		}else{
			returnMapEntry.put(null, entry.getValue());
		}
		
		Iterator<JSONParserFilterNameEnum> iterator = jsonParserFilter.filterOrderSet.iterator();
		if(iterator.hasNext()){
			JSONParserFilterNameEnum filterName = iterator.next();
			switch (filterName) {
			case nullReplaceString:
				if (returnMapEntry == null || returnMapEntry.isEmpty()) {
					return null;
				}
				if (returnMapEntry.values().iterator().next() == null) {
					String keyTemp = returnMapEntry.keySet().iterator().next();
					returnMapEntry.clear();
					returnMapEntry.put(keyTemp, jsonParserFilter.nullReplaceString);
				}
				break;
			case keyReplaceMap:
				if (jsonParserFilter.keyReplaceMap.containsKey(returnMapEntry.keySet().iterator().next())) {
					String keyTemp = jsonParserFilter.keyReplaceMap.get(returnMapEntry.keySet().iterator().next());
					Object valTemp = returnMapEntry.values().iterator().next();
					returnMapEntry.clear();
					returnMapEntry.put(keyTemp, valTemp);
				}
				break;
			case valueReplaceMap:
				if (jsonParserFilter.valueReplaceMap.containsKey(returnMapEntry.values().iterator().next())) {
					returnMapEntry.put(returnMapEntry.keySet().iterator().next(), jsonParserFilter.valueReplaceMap.get(returnMapEntry.values().iterator().next()));
				}
				break;
			case keyValueReplaceMap:
				if (jsonParserFilter.keyValueReplaceMap.containsKey(returnMapEntry.keySet().iterator().next())) {
					returnMapEntry.put(returnMapEntry.keySet().iterator().next(), jsonParserFilter.keyValueReplaceMap.get(returnMapEntry.keySet().iterator().next()));
				}
				break;
			case keyIgnoreList:
				if(jsonParserFilter.keyIgnoreList.contains(returnMapEntry.keySet().iterator().next())){
					returnMapEntry.clear();
					return null;
				}
				break;
			case valIgnoreList:
				if(jsonParserFilter.valIgnoreList.contains(returnMapEntry.values().iterator().next())){
					returnMapEntry.clear();
					return null;
				}
				break;
			case keyValueIgnoreMap:
				if(jsonParserFilter.keyValueIgnoreMap.containsKey(returnMapEntry.keySet().iterator().next()) && jsonParserFilter.keyValueIgnoreMap.get(returnMapEntry.keySet().iterator().next()).equals(returnMapEntry.values().iterator().next())){
					returnMapEntry.clear();
					return null;
				}
				break;
			default:
				break;

			}
		}
		
		if (returnMapEntry != null && !returnMapEntry.isEmpty()) {
			String lastKey = returnMapEntry.keySet().iterator().next();
			Object lastValue = returnMapEntry.values().iterator().next();
			returnMapEntry.clear();
			returnMapEntry.put(keyPrefix + lastKey, lastValue);
		}
		return returnMapEntry;
	}

}
