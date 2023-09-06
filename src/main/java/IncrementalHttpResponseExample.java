
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class IncrementalHttpResponseExample {
	public static void main(String[] args) {
		try {
			URL url = new URL( "https://news.redboxglobal.in/api/news/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImxzbmV3c0ByYXRoaS5jb20iLCJpYXQiOjE2NTExMjc4MzV9.ajCFaQXn5ZBejufwff0QU0tm-XuUx4YnedP8wJEBi2M"); // Replace
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				InputStream inputStream = connection.getInputStream();
				JsonFactory jsonFactory = new JsonFactory();
				JsonParser jsonParser = jsonFactory.createParser(inputStream);
//				try {
//					System.out.println(jsonParser.);
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//				
				
                if (jsonParser.nextToken() == JsonToken.START_OBJECT) {
                	int i=0;
                    while (i!=100) {i++;
//                        if (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME
//                                && "items".equals(jsonParser.getText())) {
//                        	
//                        	
//                        	
//                            if (jsonParser.nextToken() == JsonToken.START_ARRAY) {
//                            	
//                                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
//                                	//System.out.println("Sleep");
                    				jsonParser.nextToken();
                                	System.out.println(jsonParser.getText());
//                                }
//                            }
//                        }
                    }
                }


				jsonParser.close();
				connection.disconnect();
			} else {
				System.out.println("HTTP request failed with response code: " + responseCode);
			}
		} catch (Exception  e) {
			e.printStackTrace();
		}
	}
}
