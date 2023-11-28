import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }
    Button button = new Button();
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Movie Search");
        
        StackPane layout = new StackPane();

        Scene scene = new Scene(layout, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}