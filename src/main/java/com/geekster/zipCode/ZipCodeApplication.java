package com.geekster.zipCode;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ZipCodeApplication {

	public static void main(String[] args)throws Exception {
		URL getUrl= new URL("https://api.zippopotam.us/us/33162");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");
		int respondCode=connection.getResponseCode();
		if(respondCode==200){
			BufferedReader in= new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseData= new StringBuilder();
			String readLine=null;
			while((readLine=in.readLine())!=null){
				responseData.append(readLine);}
			in.close();
			JSONObject randomZipCodes= new JSONObject(responseData.toString());
			System.out.println(randomZipCodes.toString(4));
		} else{ System.out.println("This is not valid URL "+respondCode);}
	}
}