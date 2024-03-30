package Project3_Weather211;
//Name: Kien Dang
//Id: 202438396
//Date: 5/18/2022
// This file will create a html file called myMap and print out the map
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Map211 {
	static String html;
	static String weather;
	static String mapFileName="myMap.html";
	static ArrayList<String> weatherInfo = new ArrayList<>(); 
    static String APIKey="AIzaSyBDmx8EWYOCdLG54_C1U_XL6kxzesCqdRY";
    
    Map211 (ArrayList<String> weatherInfo, String mapType, int zoom) throws IOException {
    		
    	String city=weatherInfo.get(0);
    	String description = weatherInfo.get(1);
    	String temp = weatherInfo.get(2);
    	String low = weatherInfo.get(3);
    	String high = weatherInfo.get(4);
    	String humidity = weatherInfo.get(5);

    	
    	weather= " "+city.toUpperCase()+ " | "  + description.toUpperCase()+ " | " 
    				+ temp.toUpperCase()+ " | " + low.toUpperCase()+ " | " + high.toUpperCase()+ " | "
    				+ humidity.toUpperCase()+ " | ";

    	
    	writeHTML(weather,city, mapType, zoom);
        String url = mapFileName;   // you can find this html file in the project folder
        File htmlFile = new File(url);
        Desktop.getDesktop().browse(htmlFile.toURI());
    }
    

    
    public static void writeHTML(String weatherNow, String city, String mapType, int zoom) {
    	html="<!DOCTYPE html>"
    	+ "<html>"
    	+ "<body>"
    	+ "<h2>"
    	+ weatherNow
    	+ "</h2>"
    	+ "<iframe"
    	+ "  width=1200"
    	+ "  height=900"
    	+ "  style=border:0"
    	+ "  loading=lazy"
    	+ "  allowfullscreen"
    	+ "  referrerpolicy=\"no-referrer-when-downgrade\""
    	+ "src=\"https://www.google.com/maps/embed/v1/place?key=AIzaSyDyIu9tCtwk9ZRY6JnpZq6tiOzTCVriULY&q="+ city +"&zoom="+ zoom 
    	+"&maptype=" + mapType+"\""
    	+ "</iframe>"
    	+ "</body>"
    	+ "</html>";
 
    	
    	File f= new File (mapFileName);
    	try {
    		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
    		bw.write(html);
    		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}