package Project3_Weather211;
//Name: Kien Dang
//Id: 202438396
//Date: 5/18/2022
// This is the main where the user types in a valid/invalid name and if the city is valid, the map will appear
import java.util.ArrayList;
import java.util.Scanner;
public class myWeatherApp {
	 private static ArrayList<String> weatherInfo = new ArrayList<>();
	 static String mapType;
	 static int mapNum;
	 static int zoom;
	 static String city;
	 public static void main(String[] args) throws Exception {
	   System.out.println("Welcome to Weather 211 - Spring 2022");
	   System.out.println();
	   
	   inputCityName();
	   getWeatherInfo();

	  }
	 
	 // Input and check the validity of city name
	 public static String inputCityName() throws Exception{     
		 Scanner keyboard = new Scanner(System.in);
		 city = "";
		 
	     boolean validCityName=false; 
	     while (!validCityName) {
	 
		       System.out.println("Input a city name:");
		        city = keyboard.nextLine();
		   
		    
		       boolean valid = Weather211.weatherInformation(city);
		 
		       if (valid) { 
		    	 keyboard.nextLine();
		         // ask for map type (roadmap, satellite)
		    	 System.out.println("Select map type:        1)roadmap    2)satellite");
		    	 mapNum = keyboard.nextInt();
		    	 
		    	 // Switch cases for roadmap or satellite
		    	 switch (mapNum) {
		    	 	case 1: 
		    	 		mapType ="roadmap";
		    	 		break;
		    	 	case 2:
		    	 		mapType ="satellite";
		    	 		break;
		    	 }
	
		         // ask for zoom level (0 ~21)
		    	 System.out.println("Select zoom level: 0~21" + " (default = 14)");
		    	 zoom = keyboard.nextInt();
		    	 
		         System.out.println("Current Weather [" + city +"]\n");
		         
		        break;
		      } else {
		       System.out.println("Invalid city name. Type again.\n"); 
		     } 
	      
	     }
	     return city;
	 }
	 
	 // Print out the information
	 public static void getWeatherInfo() throws Exception {
		 //Get the information
		 weatherInfo=Weather211.getCityWeatherNow();
		 for (int i=0; i<weatherInfo.size(); i++) {
		      System.out.println(weatherInfo.get(i));
		  }
		 System.out.println("");
		 //Print the map
		 new Map211(weatherInfo, mapType, zoom);
		 
		
	 }
	 
}


