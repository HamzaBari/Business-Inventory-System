
package businessinventorysystam;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BusinessDRPsController implements Initializable {
    @FXML
    private Button documentBtnID;
    @FXML
    private Button videoBtnID;
    @FXML
    private Button backBtnID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void documentBtn(ActionEvent event) throws IOException {
        Parent DRPDocument = FXMLLoader.load(getClass().getResource("DRPDocument.fxml"));
        Scene DRPDocumentScene = new Scene(DRPDocument);
        Stage DRPDocumentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        DRPDocumentStage.setTitle("Business Plan/Disaster Recovery");
        DRPDocumentStage.hide();
        DRPDocumentStage.setScene(DRPDocumentScene);
        DRPDocumentStage.setHeight(2950);
        DRPDocumentStage.setWidth(1200);
        DRPDocumentStage.setResizable(true);
        DRPDocumentStage.show();
    }

    @FXML
    private void videoBtn(ActionEvent event) throws IOException {
        Parent VideoDemo = FXMLLoader.load(getClass().getResource("BusinessVideoDemo.fxml"));
        Scene VideoDemoScene = new Scene(VideoDemo);
        Stage VideoDemoStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        VideoDemoStage.setTitle("Business DRP Video Demo");
        VideoDemoStage.hide();
        VideoDemoStage.setScene(VideoDemoScene);
        VideoDemoStage.setHeight(720);
        VideoDemoStage.setWidth(830);
        VideoDemoStage.setResizable(true);
        VideoDemoStage.show();
    }

    @FXML
    private void backBtn(ActionEvent event) throws IOException {
        Parent MainMenu = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene MainMenuScene = new Scene(MainMenu);
        Stage MainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        MainMenuStage.setTitle("Main Menu");
        MainMenuStage.hide();
        MainMenuStage.setScene(MainMenuScene);
        MainMenuStage.setHeight(540);
        MainMenuStage.setWidth(727);
        MainMenuStage.setResizable(false);
        MainMenuStage.show();
    }
    
    
    
}
