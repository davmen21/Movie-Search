/**
Class name:    Movies.java
Author:        David Mendez
               Shalin Bhalala
               
Date:          12/11/2023

Assignment:    Final Project

Description:   The Movies class defines a movie with title, plot, year nad imdbID     
**/

public class Movies {
   
   //Initialize attributes
   private String Title;
   private String Plot;
   private String imdbID;
   private String Year;
   
   /**Method getTitle: gets movie title
   @return Title; String value of movie title
   **/
   public String getTitle()
   {
      return this.Title;
   }
   
   /**Method getPlot: gets movie plot
   @return Plot: String value of movie plot
   **/
   public String getPlot()
   {
      return this.Plot;
   }
   
   /**Method getID: gets the movie Imdb ID
   @return imdbID: String value of imdb ID
   **/
   public String getID()
   {
      return this.imdbID;
   }
      
   /**Method getYear: gets the movie year release
   @return Year: String value of movie year release
   **/
   public String getYear()
   {
      return this.Year;
   }


}