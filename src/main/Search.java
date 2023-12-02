import java.io.*;
import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Search {
   static String APIKEY = "d9781dca";

   /**searchByTitle method
   @param String title
   @return String movieData
   */
   public static String searchByTitle(String title) throws IOException
   {
      URL url = new URL("https://www.omdbapi.com/?t=" + title + "&apikey=" + APIKEY);
      Scanner s = new Scanner(url.openStream());
      String movieData = s.nextLine();
      
      Gson gson = new Gson();
      Movies newMovie = gson.fromJson(movieData, Movies.class);
      
      return newMovie.Title;
    }
    
    public static String searchById(String id) throws IOException
    {
      URL url = new URL("https://www.omdbapi.com/?i=" + id + "&apikey=" + APIKEY);
      Scanner s = new Scanner(url.openStream());
      String rawData = s.nextLine();
      System.out.println(rawData);
      return rawData;
    }
}