import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
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
    private MenuItem azSort;
    private MenuItem zaSort;
    private MenuItem idSort;
    String input;
    String sort;
    
   //Search Button action event
   @FXML
   void handleButton(ActionEvent event) throws IOException{
      input = searchInput.getText();
      //String title = Search.searchByTitle(input);
      //System.out.print(title);
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


}
