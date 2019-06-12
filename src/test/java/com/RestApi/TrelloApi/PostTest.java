package com.RestApi.TrelloApi;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.Charsets;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.auth.Credentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostTest extends TestData {
	
	public  String boardid,listid1,listid2,cardid1,cardid2,labelid1,labelid2;
	
	@Test(priority=1)
	
	public void postBoard() throws ClientProtocolException, IOException, URISyntaxException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();

		URIBuilder builder = new URIBuilder();
		builder.setScheme("https")
	    		.setHost("api.trello.com/1")
	    		.setPath("/boards/")
	            .setParameter("key", key)
		    .setParameter("token", token)
		    .setParameter("name", boardName);
		URI uri = builder.build();
		
		
	           
	    HttpPost httppost = new HttpPost(uri);
	    CloseableHttpResponse response = httpclient.execute(httppost);
	    
	   

	    
	    
	    HttpEntity entity = response.getEntity();
	    Header encodingHeader = entity.getContentEncoding();

	    // you need to know the encoding to parse correctly
	    Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 : 
	    Charsets.toCharset(encodingHeader.getValue());

	    // use org.apache.http.util.EntityUtils to read json as string
	    String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);

	    JSONObject o = new JSONObject(json);
	    boardid=(String) o.get("id");
	    
	    
	    int code=response.getStatusLine().getStatusCode();
		System.out.println("Response code is" + code);
		Assert.assertEquals(code, 200);
	    
		
		
		
	}
	
	
@Test(priority=2)
	
	public void postList1() throws ClientProtocolException, IOException, URISyntaxException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();

		URIBuilder builder = new URIBuilder();
		builder.setScheme("https")
	    		.setHost("api.trello.com/1")
	    		.setPath("/lists")
	            .setParameter("key", key)
		    .setParameter("token", token)
		    .setParameter("name", listName1)
		    .setParameter("idBoard", boardid);
		URI uri = builder.build();
		
		
	           
	    HttpPost httppost = new HttpPost(uri);
	    CloseableHttpResponse response = httpclient.execute(httppost);
	    HttpEntity entity = response.getEntity();
	    Header encodingHeader = entity.getContentEncoding();

	    
	    Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 : 
	    Charsets.toCharset(encodingHeader.getValue());

	    
	    String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);

	    JSONObject o = new JSONObject(json);
	    listid1=(String) o.get("id");
	    
	    
	    int code=response.getStatusLine().getStatusCode();
		System.out.println("Response code is" + code);
//		Assert.assertEquals(code, 200);
		
		
	}

@Test(priority=3)
public void postList2() throws ClientProtocolException, IOException, URISyntaxException {
	
	CloseableHttpClient httpclient = HttpClients.createDefault();

	URIBuilder builder = new URIBuilder();
	builder.setScheme("https")
    		.setHost("api.trello.com/1")
    		.setPath("/lists")
            .setParameter("key", key)
	    .setParameter("token", token)
	    .setParameter("name", listName2)
	    .setParameter("idBoard", boardid);
	URI uri = builder.build();
	
	
           
    HttpPost httppost = new HttpPost(uri);
    CloseableHttpResponse response = httpclient.execute(httppost);
    HttpEntity entity = response.getEntity();
    Header encodingHeader = entity.getContentEncoding();

    
    Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 : 
    Charsets.toCharset(encodingHeader.getValue());

    
    String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);

    JSONObject o = new JSONObject(json);
    listid2=(String) o.get("id");
    
    
    int code=response.getStatusLine().getStatusCode();
	System.out.println("Response code is" + code);
	Assert.assertEquals(code, 200);
	
	
}



@Test(priority=4)

public void postCard1() throws ClientProtocolException, IOException, URISyntaxException {
	
	CloseableHttpClient httpclient = HttpClients.createDefault();
	URIBuilder builder = new URIBuilder();
	builder.setScheme("https")
    		.setHost("api.trello.com/1")
    		.setPath("/cards/")
            .setParameter("key", key)
	    .setParameter("token", token)
	    .setParameter("name", cardName1)
	    .setParameter("idList", listid1);
	URI uri = builder.build();
           
    HttpPost httppost = new HttpPost(uri);
    CloseableHttpResponse response = httpclient.execute(httppost);
    HttpEntity entity = response.getEntity();
    Header encodingHeader = entity.getContentEncoding();
    
    Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 : 
   Charsets.toCharset(encodingHeader.getValue());
    String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
    
    JSONObject jsonObject = new JSONObject(json);
    cardid1=(String) jsonObject.get("id");
    
    int code=response.getStatusLine().getStatusCode();
	System.out.println("Response code is" + code);
//	Assert.assertEquals(code, 200);
    
	
}
	
	
@Test(priority=5)

public void postCard2() throws ClientProtocolException, IOException, URISyntaxException {
	
	CloseableHttpClient httpclient = HttpClients.createDefault();
	URIBuilder builder = new URIBuilder();
	builder.setScheme("https")
    		.setHost("api.trello.com/1")
    		.setPath("/cards/")
            .setParameter("key", key)
	    .setParameter("token", token)
	    .setParameter("name", cardName2)
	    .setParameter("idList", listid2);
	URI uri = builder.build();
           
    HttpPost httppost = new HttpPost(uri);
    CloseableHttpResponse response = httpclient.execute(httppost);
    HttpEntity entity = response.getEntity();
    httppost.setHeader("content-type", "application/json");
    Header encodingHeader = entity.getContentEncoding();
    
    Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 : 
   Charsets.toCharset(encodingHeader.getValue());
    String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
    
    JSONObject jsonObject = new JSONObject(json);
    cardid2=(String) jsonObject.get("id");
    System.out.println(cardid2);
    
    int code=response.getStatusLine().getStatusCode();
	System.out.println("Response code is" + code);
	Assert.assertEquals(code, 200);
    
	
}
	
@Test(priority=8)

public void postLabel1() throws ClientProtocolException, IOException, URISyntaxException {
	
	CloseableHttpClient httpclient = HttpClients.createDefault();
	URIBuilder builder = new URIBuilder();
	builder.setScheme("https")
    		.setHost("api.trello.com/1")
    		.setPath("/cards/"+cardid1+"/labels")
            .setParameter("key", key)
	    .setParameter("token", token)
	    .setParameter("name", labelName1)
	    .setParameter("color", labelColor1)
        .setParameter("idCard", cardid1);
	URI uri = builder.build();
           
    HttpPost httppost = new HttpPost(uri);
    System.out.println("************" +uri);
    CloseableHttpResponse response = httpclient.execute(httppost);
    HttpEntity entity = response.getEntity();
    Header encodingHeader = entity.getContentEncoding();
    
    Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 : 
    	   
     Charsets.toCharset(encodingHeader.getValue());
    
    String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
    
    
    System.out.println("************"+json);
   
    
    int code=response.getStatusLine().getStatusCode();
	System.out.println("Response code is" + code);
    Assert.assertEquals(code, 200);
	
}

@Test(priority=9)

public void postLabel2() throws ClientProtocolException, IOException, URISyntaxException {
	
	CloseableHttpClient httpclient = HttpClients.createDefault();
	URIBuilder builder = new URIBuilder();
	builder.setScheme("https")
    		.setHost("api.trello.com/1")
    		.setPath("cards/"+cardid2+"/labels")
//    		(url+"cards/"+cardid1+"/labels");
            .setParameter("key", key)
	    .setParameter("token", token)
	    .setParameter("name", labelName2)
	    .setParameter("color", labelColor2)
        .setParameter("idCard", cardid2);
	URI uri = builder.build();
           
    HttpPost httppost = new HttpPost(uri);
    
    CloseableHttpResponse response = httpclient.execute(httppost);
    HttpEntity entity = response.getEntity();
    Header encodingHeader = entity.getContentEncoding();
    
    Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 : 
   Charsets.toCharset(encodingHeader.getValue());
    
    String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
   
   
    
    int code=response.getStatusLine().getStatusCode();
	System.out.println("Response code is" + code);
    Assert.assertEquals(code, 200);
	
}
	
	

@Test(priority=10)

public void postAttach() throws ClientProtocolException, IOException, URISyntaxException {
	
	CloseableHttpClient httpclient = HttpClients.createDefault();
	URIBuilder builder = new URIBuilder();
	builder.setScheme("https")
    		.setHost("api.trello.com/1")
    		.setPath("cards/"+cardid1+"/attachments")
            .setParameter("key", key)
	    .setParameter("token", token)
	    .setParameter("url",imageUrl1);
	    
	URI uri = builder.build();
           
    HttpPost httppost = new HttpPost(uri);
    CloseableHttpResponse response = httpclient.execute(httppost);
    
    int code=response.getStatusLine().getStatusCode();
 	System.out.println("Response code is" + code);
 	Assert.assertEquals(code, 200);
     
 	
 }
@Test(priority=11)

public void postAttach2() throws ClientProtocolException, IOException, URISyntaxException {
	
	CloseableHttpClient httpclient = HttpClients.createDefault();
	URIBuilder builder = new URIBuilder();
	builder.setScheme("https")
    		.setHost("api.trello.com/1")
    		.setPath("cards/"+cardid2+"/attachments")
            .setParameter("key", key)
	    .setParameter("token", token)
	    .setParameter("url",imageUrl2);
	    
	URI uri = builder.build();
           
    HttpPost httppost = new HttpPost(uri);
    CloseableHttpResponse response = httpclient.execute(httppost);
    
    int code=response.getStatusLine().getStatusCode();
 	System.out.println("Response code is" + code);
 	Assert.assertEquals(code, 200);
     
 	
 }



}

	


