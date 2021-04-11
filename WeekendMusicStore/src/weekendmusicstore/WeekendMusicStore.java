package weekendmusicstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WeekendMusicStore extends Application {

    public static final String CURRENCY = "$";
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("w2w.fxml"));
        primaryStage.setTitle("Welcome");
        primaryStage.setScene(new Scene(root));
        //welcome preset
        //primaryStage.setX(250);
        //primaryStage.setY(5);
        
        //home preset
        //primaryStage.setX(300);
        //primaryStage.setY(100);
        
        //Admin preset
        primaryStage.setX(0);
        primaryStage.setY(0);
        
        //login preset
        //primaryStage.setX(450);
        //primaryStage.setY(150);
        
        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}
