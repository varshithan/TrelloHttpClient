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
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteTest extends PutTest{

	@Test(priority=7)

	public void deleteCard2() throws ClientProtocolException, IOException, URISyntaxException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		URIBuilder builder = new URIBuilder();
		builder.setScheme("https")
	    		.setHost("api.trello.com/1")
	    		.setPath("/cards/cardid2")
	            .setParameter("key", key)
		    .setParameter("token", token);
		    
		URI uri = builder.build();
		System.out.println(uri);
	           
	    HttpDelete httpdelete = new HttpDelete(uri);
	    httpdelete.setHeader("content-type", "application/json");
	    CloseableHttpResponse response = httpclient.execute(httpdelete);
	 
	    
	    int code=response.getStatusLine().getStatusCode();
		System.out.println("Response code is" + code);
		Assert.assertEquals(code, 200);
	    
		
	}
		
		
	
	
	
	
	
	
	
}
