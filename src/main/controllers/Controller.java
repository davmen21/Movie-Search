package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class Controller {

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
   void handleButton(ActionEvent event) {
      input = searchInput.getText();
      System.out.print(input);
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