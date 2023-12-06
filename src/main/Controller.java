import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import java.net.URL;
import java.net.MalformedURLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Controller{

    @FXML
    private TextField searchInput;
    private MenuButton sortId;
    private Button submit;
    private TabPane tabPane;
    
    @FXML
    private Tab resultsTab;
    private MenuItem azSort;
    private MenuItem zaSort;
    private MenuItem idSort;
    
    @FXML
    private TableView resultsTable;
    
    @FXML
    private TableColumn titleColumn;
    
    @FXML
    private TableColumn plotColumn;
    
    String input;
    String sort;
    
   /**Search Button action event calls Search.searchByTitle method and passes search results to the table columns
   @param event: ActionEvent of button click
   **/
   
   @FXML
   void handleButton(ActionEvent event) throws IOException{
      //Get text field input
      input = searchInput.getText();
      
      //Call searchByTitle method and input data to searchResultObject
      Movies searchResult = Search.searchByTitle(input);
      ObservableList<Movies> movieResults = FXCollections.observableArrayList(searchResult);
      titleColumn.setCellValueFactory(
         new PropertyValueFactory<Movies, String>("Title"));
      plotColumn.setCellValueFactory(
         new PropertyValueFactory<Movies, String>("Plot"));
      resultsTable.setItems(movieResults);
      
   }
   
   //Sort MenuItem action events
   @FXML
   void sortAZ(ActionEvent event) {
      return;
   }
   @FXML
   void sortID(ActionEvent event) {
      return;
   }
   @FXML
   void sortZA(ActionEvent event) {
      return;
   }
   
   //Add to watchlist button handler
   @FXML
   void addToWatchlist(ActionEvent event){
      
   
   }

}
