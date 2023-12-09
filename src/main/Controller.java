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
import java.net.URL;
import java.net.MalformedURLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Controller implements Initializable{

    @FXML
    private TextField searchInput;
    private MenuButton sortId;
    private Button submit;
    private TabPane tabPane;
    
    @FXML
    private AnchorPane anchorPane;
    
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
    
    @FXML
    private Button viewToggle;
    
    private String input;
    private String sort;
    private enum Mode {DARKMODE, LIGHTMODE};
    private Mode mode;
    public static final String VIEWMODE = "view_mode_key";
    
    
    
   /**Search Button action event calls Search.searchByTitle method and passes search results to the table columns
   @param event: ActionEvent of button click
   **/
   
   @FXML
   protected void handleButton(ActionEvent event) throws IOException
   {
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
   
   /** Change view styling based on view mode selected and
   update user preferences for view mode
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
   
   /**initialize app with user preferences for 
   Dark mode and Watchlist
   **/
   @Override
   public void initialize(URL location, ResourceBundle resources)
   {  
      Preferences p = Preferences.userNodeForPackage(Controller.class);
      this.mode = Mode.valueOf( p.get(VIEWMODE, Mode.LIGHTMODE.toString()));
      
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
