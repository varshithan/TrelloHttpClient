package com.RestApi.TrelloApi;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.Charsets;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;



public class PutTest extends PostTest  {
	
	

	
	@Test(priority=3)
	public void updateList1() throws ClientProtocolException, IOException, URISyntaxException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();

		URIBuilder builder = new URIBuilder();
		builder.setScheme("https")
//		https://api.trello.com/1/lists/
	    		.setHost("api.trello.com/1")
	    		.setPath("lists/"+"id")
	  
	    		.setParameter("name", "HAI")
	            .setParameter("key", key)
		    .setParameter("token", token)
		    ;
		    
		URI uri = builder.build();
		
		
	    HttpPut httpput = new HttpPut(uri);
	    System.out.println(uri);
	    CloseableHttpResponse response = httpclient.execute(httpput);
	    
	    HttpEntity entity = response.getEntity();
	    Header encodingHeader = entity.getContentEncoding();
	    String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
	  
	    int code=response.getStatusLine().getStatusCode();
		System.out.println("Response code is" + code);
	    Assert.assertEquals(code, 200);
	    
	    
	    
	    
		
		
	}
	
	@Test(priority=6)
	public void updateCard2() throws URISyntaxException, ClientProtocolException, IOException  {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		URIBuilder builder = new URIBuilder();
		builder.setScheme("https")
	    		.setHost("api.trello.com/1")
	    		.setPath("/cards/"+"cardid")
	            .setParameter("key", key)
		    .setParameter("token", token)
		    .setParameter("name", "HELOOOOO")
		    .setParameter("idCard", cardid2);
		    
		    
		URI uri = builder.build();
	           
	    HttpPut httpput = new HttpPut(uri);
	    
	    httpput.setHeader("content-type", "application/json");
	    CloseableHttpResponse response = httpclient.execute(httpput);
	    HttpEntity entity = response.getEntity();
	    Header encodingHeader = entity.getContentEncoding();
	    
	   
	    String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
	    
	    int code=response.getStatusLine().getStatusCode();
		System.out.println("Response code is" + code);
		Assert.assertEquals(code, 200);
	}  
		

}
