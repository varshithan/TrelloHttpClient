package com.RestApi.TrelloApi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.opencsv.CSVReader;

public class TestData {
	                                                                                
		static Map<String, String> map= new LinkedHashMap();
		static  String key;
		static  String token;
		static  String boardName;
		static  String cardName1,cardName2;
		static  String listName1,listName2;
		static  String labelName1,labelName2;
		static  String labelColor1,labelColor2;
		static  String imageUrl1,imageUrl2;
		
		public Properties prop;
		
		public TestData()
		{ 
			try { 
				
				prop = new Properties();
		      File file =new File("/home/varshitha/Desktop/Ecllipse/TrelloApi/src/test/resource/Trello.csv");
				FileReader filereader = new FileReader(file);
				CSVReader csvReader = new CSVReader(filereader);

				String[] line;  

				while ((line = csvReader.readNext()) != null) 
				{ 
					map.put(line[0], line[1]);
				} 
				key=map.get("key");
				token=map.get("token");
				boardName=map.get("board name");
				listName1=map.get("list1 name");
				listName2=map.get("list2 name");
				cardName1=map.get("card1 name");
				cardName2=map.get("card2 name");
				labelName1=map.get("label1 name");
				labelName2=map.get("label2 name");
				labelColor1=map.get("label2 color");
				labelColor2=map.get("label2 color");
				imageUrl1=map.get("URL1");
				imageUrl2=map.get("URL2");



			}

			catch (Exception e) { 
				e.printStackTrace(); 
			} 
		} 

	}



//package com.qa.base;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;

//public class TestBase {
//	
//	public int RESPONSE_STATUS_CODE_200 = 200;
//	public int RESPONSE_STATUS_CODE_500 = 500;
//	public int RESPONSE_STATUS_CODE_400 = 400;
//	public int RESPONSE_STATUS_CODE_401 = 401;
//	public int RESPONSE_STATUS_CODE_201 = 201;
//
//	public Properties prop;
//	
//	
//	public TestBase(){
//		try {
//			prop = new Properties();
//			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	
//	
//	
//
//}
