/**
Class name:    Movies.java
Author:        David Mendez
               Lin Meawitz
               Shalin Bhalala
               
Date:          12/11/2023

Assignment:    Final Project

Description:   The Movies class defines a movie with title, plot, and an imdbID        
**/

public class Movies {
   
   //Initialize attributes
   private String Title;
   private String Plot;
   private String imdbID;
   
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


}