package json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;



public class jsonKeys {
	
	//References Website ::- https://www.baeldung.com/java-jsonnode-get-keys
	
	
	//Free open APis for testing URL:-- https://apipheny.io/free-api/
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
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"TATA CONSUMER: CO IS IN TALKS TO BUY AT LEAST 51% OF POPULAR INDIAN SNACK FOOD MAKER HALDIRAM'S- RTRS\",\r\n" + 
				"      \"description\": \"TATA CONSUMER: CO IS IN TALKS TO BUY AT LEAST 51% OF POPULAR INDIAN SNACK FOOD MAKER HALDIRAM'S- RTRS\",\r\n" + 
				"      \"guid\": \"64f83f2d1d42825a2186d06e\",\r\n" + 
				"      \"categories\": [\r\n" + 
				"        \"Default\"\r\n" + 
				"      ],\r\n" + 
				"      \"date\": \"Wed September 6 2023 14:28:21\",\r\n" + 
				"      \"enclosure\": false,\r\n" + 
				"      \"custom_elements\": [\r\n" + 
				"        {\r\n" + 
				"          \"companies\": [\r\n" + 
				"            {\r\n" + 
				"              \"nameOfCompany\": \"TATA CONSUMER PRODUCTS LIMITED\",\r\n" + 
				"              \"nse\": \"TATACONSUM\",\r\n" + 
				"              \"bse\": 0\r\n" + 
				"            }\r\n" + 
				"          ],\r\n" + 
				"          \"notification\": false,\r\n" + 
				"          \"customName\": \"TATA CONSUMER\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"DHARMAJ CROP GUARD: CO LAUNCHED THE THREE NEW PRODUCTS IN THE MARKET IN INSECTICIDE AND FUNGICIDE CATEGORY\",\r\n" + 
				"      \"description\": \"DHARMAJ CROP GUARD: CO LAUNCHED THE THREE NEW PRODUCTS IN THE MARKET IN INSECTICIDE AND FUNGICIDE CATEGORY\",\r\n" + 
				"      \"guid\": \"64f83eee1d42825a2186d06d\",\r\n" + 
				"      \"categories\": [\r\n" + 
				"        \"Default\"\r\n" + 
				"      ],\r\n" + 
				"      \"date\": \"Wed September 6 2023 14:27:18\",\r\n" + 
				"      \"enclosure\": false,\r\n" + 
				"      \"custom_elements\": [\r\n" + 
				"        {\r\n" + 
				"          \"companies\": [\r\n" + 
				"            {\r\n" + 
				"              \"nameOfCompany\": \"Dharmaj Crop Guard Ltd\",\r\n" + 
				"              \"nse\": \"DHARMAJ\",\r\n" + 
				"              \"bse\": 0\r\n" + 
				"            }\r\n" + 
				"          ],\r\n" + 
				"          \"notification\": false,\r\n" + 
				"          \"customName\": \"DHARMAJ CROP GUARD\"\r\n" + 
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
		
		String testJson ="[\r\n" + 
				"{\r\n" + 
				"\"state-province\": null,\r\n" + 
				"\"name\": \"Marywood University\",\r\n" + 
				"\"web_pages\": [\r\n" + 
				"\"http://www.marywood.edu\"\r\n" + 
				"],\r\n" + 
				"\"country\": \"United States\",\r\n" + 
				"\"domains\": [\r\n" + 
				"\"marywood.edu\"\r\n" + 
				"],\r\n" + 
				"\"alpha_two_code\": \"US\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"state-province\": null,\r\n" + 
				"\"name\": \"Lindenwood University\",\r\n" + 
				"\"web_pages\": [\r\n" + 
				"\"http://www.lindenwood.edu/\"\r\n" + 
				"],\r\n" + 
				"\"country\": \"United States\",\r\n" + 
				"\"domains\": [\r\n" + 
				"\"lindenwood.edu\"\r\n" + 
				"],\r\n" + 
				"\"alpha_two_code\": \"US\"\r\n" + 
				"}\r\n" + 
				"]";
		ObjectMapper objmp= new ObjectMapper();
		System.out.println(getKeysInJsonUsingJsonNodeFieldNames(json,objmp));
		System.out.println(getKeysInJsonUsingJsonNodeFieldNames(newsjson,objmp));
		System.out.println(getKeysInJsonUsingJsonNodeFieldNames(news,objmp));
		System.out.println(getKeysInJsonUsingJsonNodeFieldNames(testJson,objmp).toString());
		
		FileWriter file = new FileWriter("C:\\Users\\praty\\Desktop\\Back Up for the day\\jsonfile.json");
		file.write(newsjson.toString());
		file.close();
	}
	
	/*
	 * We can use the fieldNames() method on a JsonNode instance to fetch the nested field names. 
	 * It returns names of direct nested fields only.
	 * @Param Json as a String 
	 * @Param 
	 * */
	public static JSONArray getKeysInJsonUsingJsonNodeFieldNames(String json, ObjectMapper mapper) throws IOException {

//	    List<String> keys = new ArrayList<>();
		JSONArray keys = new JSONArray();
	    JsonNode jsonNode = mapper.readTree(json);
	    Iterator<String> iterator = jsonNode.fieldNames();
	    iterator.forEachRemaining(e -> keys.put(e));
	    return keys;
	}
	
	/*
	In order to get all the inner nested nodes, we need to call the fieldNames() method 
	on nodes at each level:*/
//	public List<String> getAllKeysInJsonUsingJsonNodeFieldNames(String json, ObjectMapper mapper) throws JsonMappingException, JsonProcessingException {
//
//	    List<String> keys = new ArrayList<>();
//	    JsonNode jsonNode = mapper.readTree(json);
//	    getAllKeysUsingJsonNodeFieldNames(jsonNode, keys);
//	    return keys;
//	}


//	private void getAllKeysUsingJsonNodeFields(JsonNode jsonNode, List<String> keys) {
//		/*
//		First, we’ll check whether a JSON value is an object or array. 
//		If yes, we’ll traverse the value object as well to fetch inner nodes.
//		 * */
//	    if (jsonNode.isObject()) {
//	        Iterator<Entry<String, JsonNode>> fields = jsonNode.fields();
//	        fields.forEachRemaining(field -> {
//	            keys.add(field.getKey());
//	            getAllKeysUsingJsonNodeFieldNames((JsonNode) field.getValue(), keys);
//	        });
//	    } else if (jsonNode.isArray()) {
//	        ArrayNode arrayField = (ArrayNode) jsonNode;
//	        arrayField.forEach(node -> {
//	            getAllKeysUsingJsonNodeFieldNames(node, keys);
//	        });
//	    }
//	}
}
