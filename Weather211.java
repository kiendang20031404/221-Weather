package Project3_Weather211;
//Name: Kien Dang
//Id: 202438396
//Date: 5/18/2022
// This file reads from weather api, takes the necessary information and check if the city name is valid or not 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Weather211 {

	static String cityName;
	static String weatherNow;
	static double cityTemp;
	static String tempNow;
	static double cityTempMin;
	static String tempLow;
	static double cityTempHigh;
	static String tempHigh;
	static long cityHumidity;
	static String humidity;
	static boolean validCityName = false ;
	static ArrayList <String> weatherInfo = new ArrayList<>();
	public static boolean weatherInformation(String cityName1) throws Exception {
		
		cityName = cityName1;

			try {
				
				
				///Create a URL instance
				String firstPartURL = "https://api.openweathermap.org/data/2.5/weather?q=";
				String secondPartURL ="&appid=0e035cc3b46ec52403af689481d44c96"; 
				String theURL = firstPartURL + cityName + secondPartURL;
				//System.out.println(theURL);
				URL url = new URL(theURL); 
				///Reads information from URL    
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				//JSON parser object to parse read file
				JSONParser jsonParser = new JSONParser();
				//Read JSON file. All the data for the city is stored in “myObject"
				JSONObject myObject = (JSONObject)jsonParser.parse(br); 
				
				// 1. add city name to the data structure 
				
				 weatherInfo.add(cityName);
				 //System.out.println("This is :" + cityName);
				 
				// 2. Weather 
				 JSONArray weatherArray = (JSONArray)myObject.get("weather");
				 JSONObject w = (JSONObject) weatherArray.get(0);
				// get weather info from w
				 weatherNow =(String) w.get("description");
				// add weather info to the data structure (see 1. add city name...  above)
				 weatherInfo.add(weatherNow ); 
				 //System.out.println(weatherNow);
				 
				// 3. Temp  
				// get temp from myObject
				cityTemp = (double)((JSONObject) myObject.get("main")).get("temp"); 
				cityTemp = ((cityTemp - 273.15)*9)/5 + 32;///convert to Fahrenheit;
				tempNow="temp: "+ String.format("%.1f", cityTemp)+"\u00B0";
				// add temp to the data structure 
				weatherInfo.add(tempNow); 
				
				// 4. Temp_min  
				// get temp_min from myObject 
				cityTempMin =(double)((JSONObject) myObject.get("main")).get("temp_min"); 
				cityTempMin = ((cityTempMin - 273.15)*9)/5 + 32;///convert to Fahrenheit;   
				tempLow="low: "+String.format("%.1f", cityTempMin)+"\u00B0";
				// add temp_min to the data structure 
				weatherInfo.add(tempLow);
				
				// 5. Temp_high   
				// get temp_high from myObject 
				double cityTempHigh =(double)((JSONObject) myObject.get("main")).get("temp_max"); 
				cityTempHigh = ((cityTempHigh - 273.15)*9)/5 + 32;///convert to Fahrenheit;   
				tempHigh="high: "+String.format("%.1f", cityTempHigh)+"\u00B0";
				// add temp_High to the data structure 
				weatherInfo.add(tempHigh);
				
				// 6. Humidity 
				// get humidity from myObject  
				cityHumidity =(long)((JSONObject) myObject.get("main")).get("humidity"); 
				humidity = "humidity: "+ Long.toString(cityHumidity)+"%";
				// add humidity to the data structure 
				weatherInfo.add(humidity);
				
				
				validCityName = true;

		 
			}
			catch (Exception ex) {
				validCityName = false;

			}
		
		return validCityName;
	}
	
	public static void CityWeather() {
		for (int i = 0; i < weatherInfo.size();i++) {
			System.out.println(weatherInfo.get(i));

		}
	
				
		
	}

	public static ArrayList<String> getCityWeatherNow() {		
		return weatherInfo;
	}

	
}