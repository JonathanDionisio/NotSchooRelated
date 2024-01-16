import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class App extends Application  {
public static void main(String[] args) {

      launch(args);
    }
	public void start(Stage stage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MusicAppView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
            stage.setResizable(false);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}