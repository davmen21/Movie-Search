/**
Class name:    Main.java
Authors:       David Mendez
               Shalin Bhalala
Date:          12/11/2023

Assignment:    Final Project

Description:   The main java class launches the javafx application 
               and initializes the stage and fxml.       
**/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class Main extends Application
{
   
    public static void main(String[] args)
    {
        launch(args);
    }
    
    /**start and initializes the primary stage
    @param primaryStage: Stage object
    **/
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
      //Load FXML View
      Parent root = FXMLLoader.load(getClass().getResource("/views/view.fxml"));
      
      //Create and display Scene and Stage
      Scene scene = new Scene(root);
      //set stage title
      primaryStage.setTitle("Movie Search");   
      
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    

}