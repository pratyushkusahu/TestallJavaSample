package json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;



public class jsonKeys {
	
	//References Website ::- https://www.baeldung.com/java-jsonnode-get-keys
	
	public static void main(String[] args) throws IOException {
		String json="{\r\n" + 
				"   \"Name\":\"Craig\",\r\n" + 
				"   \"Age\":10,\r\n" + 
				"   \"BookInterests\":[\r\n" + 
				"      {\r\n" + 
				"         \"Book\":\"The Kite Runner\",\r\n" + 
				"         \"Author\":\"Khaled Hosseini\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"Book\":\"Harry Potter\",\r\n" + 
				"         \"Author\":\"J. K. Rowling\"\r\n" + 
				"      }\r\n" + 
				"   ],\r\n" + 
				"   \"FoodInterests\":{\r\n" + 
				"      \"Breakfast\":[\r\n" + 
				"         {\r\n" + 
				"            \"Bread\":\"Whole wheat\",\r\n" + 
				"            \"Beverage\":\"Fruit juice\"\r\n" + 
				"         },\r\n" + 
				"         {\r\n" + 
				"            \"Sandwich\":\"Vegetable Sandwich\",\r\n" + 
				"            \"Beverage\":\"Coffee\"\r\n" + 
				"         }\r\n" + 
				"      ]\r\n" + 
				"   }\r\n" + 
				"}";
		
		
		String newsjson="{\r\n" + 
				"  \"items\": [\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"HCL TECH: CO SAYS ELDERS SELECTS CO TO SUPPORT NEXT PHASE OF DIGITAL TRANSFORMATION\",\r\n" + 
				"      \"description\": \"HCL TECH: CO SAYS ELDERS SELECTS CO TO SUPPORT NEXT PHASE OF DIGITAL TRANSFORMATION\",\r\n" + 
				"      \"guid\": \"64f842551d42825a2186d06f\",\r\n" + 
				"      \"categories\": [\r\n" + 
				"        \"Default\"\r\n" + 
				"      ],\r\n" + 
				"      \"date\": \"Wed September 6 2023 14:41:49\",\r\n" + 
				"      \"enclosure\": false,\r\n" + 
				"      \"custom_elements\": [\r\n" + 
				"        {\r\n" + 
				"          \"companies\": [\r\n" + 
				"            {\r\n" + 
				"              \"nameOfCompany\": \"HCL Technologies Limited\",\r\n" + 
				"              \"nse\": \"HCLTECH\",\r\n" + 
				"              \"bse\": 0\r\n" + 
				"            }\r\n" + 
				"          ],\r\n" + 
				"          \"notification\": false,\r\n" + 
				"          \"customName\": \"HCL TECH\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		
		String news ="{\r\n" + 
				"      \"title\": \"HCL TECH: CO SAYS ELDERS SELECTS CO TO SUPPORT NEXT PHASE OF DIGITAL TRANSFORMATION\",\r\n" + 
				"      \"description\": \"HCL TECH: CO SAYS ELDERS SELECTS CO TO SUPPORT NEXT PHASE OF DIGITAL TRANSFORMATION\",\r\n" + 
				"      \"guid\": \"64f842551d42825a2186d06f\",\r\n" + 
				"      \"categories\": [\r\n" + 
				"        \"Default\"\r\n" + 
				"      ],\r\n" + 
				"      \"date\": \"Wed September 6 2023 14:41:49\",\r\n" + 
				"      \"enclosure\": false,\r\n" + 
				"      \"custom_elements\": [\r\n" + 
				"        {\r\n" + 
				"          \"companies\": [\r\n" + 
				"            {\r\n" + 
				"              \"nameOfCompany\": \"HCL Technologies Limited\",\r\n" + 
				"              \"nse\": \"HCLTECH\",\r\n" + 
				"              \"bse\": 0\r\n" + 
				"            }\r\n" + 
				"          ],\r\n" + 
				"          \"notification\": false,\r\n" + 
				"          \"customName\": \"HCL TECH\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    }";
		
		
		ObjectMapper objmp= new ObjectMapper();
		System.out.println(getKeysInJsonUsingJsonNodeFieldNames(json,objmp));
		System.out.println(getKeysInJsonUsingJsonNodeFieldNames(newsjson,objmp));
		System.out.println(getKeysInJsonUsingJsonNodeFieldNames(news,objmp));
		
	}
	
	/*
	 * We can use the fieldNames() method on a JsonNode instance to fetch the nested field names. 
	 * It returns names of direct nested fields only.
	 * */
	public static List<String> getKeysInJsonUsingJsonNodeFieldNames(String json, ObjectMapper mapper) throws IOException {

	    List<String> keys = new ArrayList<>();
	    JsonNode jsonNode = mapper.readTree(json);
	    Iterator<String> iterator = jsonNode.fieldNames();
	    iterator.forEachRemaining(e -> keys.add(e));
	    return keys;
	}
	
	/*
	In order to get all the inner nested nodes, we need to call the fieldNames() method 
	on nodes at each level:*/
	public List<String> getAllKeysInJsonUsingJsonNodeFieldNames(String json, ObjectMapper mapper) throws JsonMappingException, JsonProcessingException {

	    List<String> keys = new ArrayList<>();
	    JsonNode jsonNode = mapper.readTree(json);
	    getAllKeysUsingJsonNodeFieldNames(jsonNode, keys);
	    return keys;
	}


	private void getAllKeysUsingJsonNodeFields(JsonNode jsonNode, List<String> keys) {
		/*
		First, we’ll check whether a JSON value is an object or array. 
		If yes, we’ll traverse the value object as well to fetch inner nodes.
		 * */
	    if (jsonNode.isObject()) {
	        Iterator<Entry<String, JsonNode>> fields = jsonNode.fields();
	        fields.forEachRemaining(field -> {
	            keys.add(field.getKey());
	            getAllKeysUsingJsonNodeFieldNames((JsonNode) field.getValue(), keys);
	        });
	    } else if (jsonNode.isArray()) {
	        ArrayNode arrayField = (ArrayNode) jsonNode;
	        arrayField.forEach(node -> {
	            getAllKeysUsingJsonNodeFieldNames(node, keys);
	        });
	    }
	}
}
