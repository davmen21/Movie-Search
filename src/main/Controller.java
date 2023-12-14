/**
Class name:    Contoller.java
Author:        David Mendez
               Shalin Bhalala
               
Date:          12/11/2023

Assignment:    Final Project

Description:   The Controller defines the methods of the FXML file       
**/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.io.*;
import java.util.Scanner;
import java.util.prefs.Preferences;
import java.util.ResourceBundle;
import java.util.Comparator;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.regex.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Controller implements Initializable{

    @FXML
    private TextField searchInput; //Search text field
    
    @FXML
    private MenuButton sortId; //Sort menu button
    
    @FXML
    private Button submit; //Submit search button
    
    @FXML
    private TabPane tabPane; //Tab pane for search and watchlist results
    
    @FXML
    private AnchorPane anchorPane;//Anchor pane 
    
    @FXML
    private Tab resultsTab; //Search results tab
    
    @FXML
    private Button azSort; //Button to sort A-Z
    
    @FXML
    private Button zaSort; //Button to sort Z-A
    
    @FXML
    private MenuItem idSort;
    
    @FXML
    //private TableView resultsTable; //Search results table

    private TableView<Movies> resultsTable;

    
    @FXML
    private TableColumn titleColumn; //Search results titles column
    
    @FXML
    private TableColumn plotColumn; //Search results plot column
    
    @FXML
    private TableColumn yearColumn; //Seach results year column
    
    @FXML
    private Button viewToggle; //dark/light mode toggle
    
    @FXML
    private Button addToWatchlistButton; //Add to watchlist button
    
    @FXML
    private TableView<Movies> watchlistTable; //Watchlist table
    
    @FXML
    private TableColumn watchlistTitleColumn; //Watchlist title column
    
    @FXML
    private TableColumn watchlistPlotColumn; //Watchlist plot column
    
    @FXML
    private TableColumn watchlistYearColumn; //watchlist year column
    
    @FXML
    private Button removeFromWatchlist; //Remove from watchlist button
    
    
    private String input;
    private String sort;
    private String tempID; 
    private enum Mode {DARKMODE, LIGHTMODE}; //Dark/Light mode enum
    private Mode mode; 
    public static final String VIEWMODE = "view_mode_key"; //Viewmode preference key
    
    
    private ObservableList<Movies> watchlist = FXCollections.observableArrayList(); //Collection of movies to hold for watchlist
    
    
    
   /**Search Button action event calls Search.searchByTitle/searchById method and passes search results to the table columns
   @param event: ActionEvent of button click
   **/ 
   @FXML
   protected void handleButton(ActionEvent event) throws IOException
   {
      //Get text field input
      input = searchInput.getText();
      
      //Regex pattern matcher to find IMDB ID
      Pattern pattern = Pattern.compile("[t][t][0-9]");
      Matcher matcher = pattern.matcher(input);
      
      Movies searchResult = new Movies();
      boolean found = matcher.find();
      
      //Call the proper search method given the input
      if(found)
      {
          searchResult = Search.searchById(input);
      } else
      {
          searchResult = Search.searchByTitle(input);
      }
      
      //Call searchByTitle method and input data to searchResultObject
      ObservableList<Movies> movieResults = FXCollections.observableArrayList(searchResult);
      titleColumn.setCellValueFactory(
         new PropertyValueFactory<Movies, String>("Title"));
      plotColumn.setCellValueFactory(
         new PropertyValueFactory<Movies, String>("Plot"));
      yearColumn.setCellValueFactory(
         new PropertyValueFactory<Movies, String>("Year"));
      resultsTable.setItems(movieResults);
      
      addToWatchlistButton.setDisable(false);
      tempID = searchResult.getID();
      
   }
   
   /** Change view styling based on view mode selected and
   update user preferences for view mode
   @param event: ActionEvent of dark mode / light mode button
   **/
   @FXML   
   protected void changeViewMode(ActionEvent event)
   {
      if(this.mode == Mode.DARKMODE)
      {
         this.mode = Mode.LIGHTMODE;
         viewToggle.setText("Dark Mode");
         viewToggle.setStyle("");
         anchorPane.setStyle("");
         
      } 
      else
      {
         this.mode = Mode.DARKMODE;
         viewToggle.setText("Light Mode");
         viewToggle.setStyle("-fx-background-color: #707070;");
         anchorPane.setStyle("-fx-background-color: #595959;");
      }
      
      Preferences p = Preferences.userNodeForPackage(Controller.class);
      p.put(VIEWMODE, this.mode.toString());
   }
   
   
   /**
   *This method is usesd to sort the list of movies in a selected tab in alphabetical order, A-Z
   *@param event This is the ActionEvent of the Sort A-Z button
   */
   @FXML
   void sortAZ(ActionEvent event) {
   
      Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
      
      if(selectedTab != null) {
      
         if(selectedTab.getText().equals("Search Results")) {
         
            ObservableList<Movies> movieResults = resultsTable.getItems();
            movieResults.sort(Comparator.comparing(Movies :: getTitle, String.CASE_INSENSITIVE_ORDER));
            resultsTable.setItems(movieResults);
         
         } else if (selectedTab.getText().equals("Watchlist")) {
         
            ObservableList<Movies> movieResults = watchlistTable.getItems();
            movieResults.sort(Comparator.comparing(Movies :: getTitle, String.CASE_INSENSITIVE_ORDER));
            watchlistTable.setItems(movieResults);
         
         }
         
      }
  
   }
   
   
   /**
   *This method is usesd to sort the list of movies in a selected tab in reversed alphabetical order, Z-A
   *@param event This is the ActionEvent of the Sort Z-A button
   */
   @FXML
   void sortZA(ActionEvent event) {
      
      Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
      
      if(selectedTab != null) {
      
         if(selectedTab.getText().equals("Search Results")) {
         
            ObservableList<Movies> movieResults = resultsTable.getItems();
            movieResults.sort(Comparator.comparing(Movies :: getTitle, String.CASE_INSENSITIVE_ORDER).reversed());
            resultsTable.setItems(movieResults);
         
         } else if (selectedTab.getText().equals("Watchlist")) {
         
            ObservableList<Movies> movieResults = watchlistTable.getItems();
            movieResults.sort(Comparator.comparing(Movies :: getTitle, String.CASE_INSENSITIVE_ORDER).reversed());
            watchlistTable.setItems(movieResults);
         
         }
         
      }
   }
   
   /**
   *This method is usesd to add to the Watchlist Table and refrsh the table items with the new added movie selection
   *@param event This is the ActionEvent of the addToWatchlistButton
   */
   @FXML
   void addToWatchlist(ActionEvent event) {
         
      Movies selectedMovie = resultsTable.getSelectionModel().getSelectedItem();
      
      //Check to make sure a movie is selected by the user
      if(selectedMovie != null) {
         
         //Check to see if movie selected by user is already in the watchlist
         if(!watchlist.contains(selectedMovie)) {
         
            watchlist.add(selectedMovie);
            
            watchlistTable.setItems(watchlist);
            
            //Set table column content and refresh table
            watchlistTitleColumn.setCellValueFactory(
               new PropertyValueFactory<Movies, String>("Title"));
            watchlistPlotColumn.setCellValueFactory(
               new PropertyValueFactory<Movies, String>("Plot"));
            watchlistYearColumn.setCellValueFactory(
               new PropertyValueFactory<Movies, String>("Year"));
               
            watchlistTable.setItems(watchlist);
         
         }
      
      }
   
   }
   
   /**
   *This method is usesd to remove from the Watchlist Table and refresh the table items with the movie selection removed
   *@param event This is the ActionEvent of the removeFromWatchlistButton
   */
   @FXML 
   void removeFromWatchlist(ActionEvent event) {
      
      Movies selectedMovie = watchlistTable.getSelectionModel().getSelectedItem();
      
      if(selectedMovie != null) {
      
         watchlist.remove(selectedMovie);
         
         watchlistTable.setItems(watchlist);
      
      }
   
   }
   
   /**initialize app with user preferences for 
   Dark mode and Watchlist
   **/
   @Override
   public void initialize(URL location, ResourceBundle resources)
   {  
      //Create preferences object to access user preferences
      Preferences p = Preferences.userNodeForPackage(Controller.class);
      this.mode = Mode.valueOf( p.get(VIEWMODE, Mode.LIGHTMODE.toString()));
      
      //Determine what the user's view mode is and set styles
      if(this.mode == Mode.DARKMODE)
      {
         viewToggle.setText("Light Mode");
         viewToggle.setStyle("-fx-background-color: #707070;");
         anchorPane.setStyle("-fx-background-color: #595959;");
      } else 
      {
         viewToggle.setText("Dark Mode");

      }
   }

}
