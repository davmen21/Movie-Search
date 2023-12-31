/**
Class name:    Search.java
Author:        David Mendez
               Shalin Bhalala
               
Date:          12/11/2023

Assignment:    Final Project

Description:   Methods to call on the OMDBAPI and parse JSON data to create a movie object       
**/
import java.io.*;
import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Search {
   static String APIKEY = System.getenv("APIKEY");

   /**searchByTitle method
   @param String title
   @return String movieData
   */
   public static Movies searchByTitle(String title) throws IOException
   {
      URL url = new URL("https://www.omdbapi.com/?t=" + title + "&apikey=" + APIKEY); //API Call
      Scanner s = new Scanner(url.openStream());
      String movieData = s.nextLine();
      
      Gson gson = new Gson();
      Movies movie = gson.fromJson(movieData, Movies.class); //Create movie object from Json
      
      return movie;
    }
    
    public static Movies searchById(String id) throws IOException
    {
      URL url = new URL("https://www.omdbapi.com/?i=" + id + "&apikey=" + APIKEY);
      Scanner s = new Scanner(url.openStream());
      String movieData = s.nextLine();
            
      Gson gson = new Gson();
      Movies movie = gson.fromJson(movieData, Movies.class);
      
      return movie;
    }
}