
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
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class BusinessVideoDemoController implements Initializable {
    @FXML
    private Button playPauseBtn;
    @FXML
    private Slider videoSlider;
    @FXML
    private Button fullscreenBtnID;
    @FXML
    private Button soundBtnID;
    @FXML
    private Pane videoPane;
    @FXML
    private Button previousBtnID;
    @FXML
    private Button nextBtnID;
    @FXML
    private TextArea videosListTtxt;
    @FXML
    private Button backBtnID;
    @FXML
    private Label nameNumberOfVideoLbl;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MediaView videoPlayer = new MediaView();
        videoPlayer.setFitHeight(282);
        videoPlayer.setFitWidth(608);
        this.videoPane.getChildren().addAll(videoPlayer);
    }    

    @FXML
    private void fullscreenID(ActionEvent event) {
    }

    @FXML
    private void soundBtn(ActionEvent event) {
    }

    @FXML
    private void previousBtn(ActionEvent event) {
    }

    @FXML
    private void nextBtn(ActionEvent event) {
    }

    @FXML
    private void backBtn(ActionEvent event) throws IOException {
        Parent businessDRP = FXMLLoader.load(getClass().getResource("BusinessDRPs.fxml"));
        Scene businessDRPScene = new Scene(businessDRP);
        Stage businessDRPStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        businessDRPStage.setTitle("Business/DRP Plans");
        businessDRPStage.setScene(businessDRPScene);
        businessDRPStage.setHeight(370);
        businessDRPStage.setWidth(412);
        businessDRPStage.setResizable(false);
    }
    
}
