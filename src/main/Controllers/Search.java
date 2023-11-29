import java.io.*;
import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;


/*
   Task: Create Search class
   Assigned To: **Not yet assigned**
   Description: Search class will contain searchById and searchByTitle methods
*/
public class Search {
   String APIKEY = "d9781dca";
   
   public String searchByTitle(String title) throws IOException{
      URL url = new URL("https://www.omdbapi.com/?t=" + title + "&apikey=" + APIKEY);
      Scanner s = new Scanner(url.openStream());
      String rawData = s.nextLine();
      System.out.println(rawData);
    }
    
    public String searchById(String id) throws IOException{
      URL url = new URL("https://www.omdbapi.com/?i=" + id + "&apikey=" + APIKEY);
      Scanner s = new Scanner(url.openStream());
      String rawData = s.nextLine();
      System.out.println(rawData);
    }
}
