package org.kwok.util.json;

import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * @author Kwok
 */
public class JSONParserUtilsTest {

	
	@Test
	public void jsonToMapTest() throws IOException{
		
		Map<String,Object> map = JSONParserUtils.jsonToMap(IOUtils.resourceToString("/test.json",Charset.defaultCharset()), null);
		
		Set<Entry<String, Object>> mapSet =  map.entrySet();
		for (Entry<String, Object> entry : mapSet) {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}
		
		System.out.println(JSONParserUtils.mapToJson(map));
		
	}
	
	
	@Test
	public void jsonToPropertiesTest() throws IOException{
		
		Properties props = JSONParserUtils.jsonToProperties(IOUtils.resourceToString("/test.json",Charset.defaultCharset()));
		
		Set<Entry<Object, Object>> propSet =  props.entrySet();
		for (Entry<Object, Object> entry : propSet) {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}
		
		System.out.println(JSONParserUtils.propertiesToJson(props));
		
	}
	
}
