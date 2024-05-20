
package businessinventorysystam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BusinessInventorySystam extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UserAuthentication.fxml"));
        
        Scene scene = new Scene(root);
 
        stage.setScene(scene);
        stage.setHeight(544.8);
        stage.setWidth(938);
        stage.setTitle("Registration & Login");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
