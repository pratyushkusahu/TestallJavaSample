package json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public  class Api_fetching {
	public static CloseableHttpResponse responseSendGet(String baseUrl) throws ClientProtocolException, IOException {
		HttpGet httpGet = new HttpGet(baseUrl);
		CloseableHttpResponse response = HttpClients.createDefault().execute(httpGet);
		return response;
	}
	
	
	public static  Boolean getDatafrmAPI(String baseUrl) throws IOException  {
		CloseableHttpResponse dataresponse=null;
		FileWriter writer=null;
		try {
			dataresponse=responseSendGet(baseUrl);
			HttpEntity entity = dataresponse.getEntity(); 
			String newsResponse =entity != null ? EntityUtils.toString(entity) : null;
			System.out.println(newsResponse);
			if(dataresponse.getStatusLine().getStatusCode()==200) {
				ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//				News mappedValue =mapper.readValue(newsResponse,News.class);
//				String path=new StringBuilder(JaamoonHome.getJaamoonHome()).append(JaamoonHome.getEtlModuleDirectory())
//						.append( JaamoonHome.getInboxDirectory())
//						.append(dumpFile).toString();
//				Path loc = Paths.get(path);
//				Files.deleteIfExists(loc);
//				writer = new FileWriter(path);
				List<String> outputData =null;
				String collect =null;
				
//				FileWriter file = new FileWriter("E:/output.json");
//				file.write(jsonObject.toJSONString());
//				file.close();
				
				return true;
			}else {
				return true;
			}
		}catch(org.apache.http.ParseException e){
			throw e;
		}catch(IOException e){
			throw e;
		}
		finally {
			if(dataresponse!=null)
				dataresponse.close();
			if(writer!=null)
				writer.close();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("getDatafrmAPI");
		try {
			getDatafrmAPI("http://localhost:8080/api/v1/employees");

		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
