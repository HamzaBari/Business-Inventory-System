
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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DRPDocumentController implements Initializable {
    @FXML
    private Font x1;
    @FXML
    private TextArea majorGoalsTxt;
    @FXML
    private Font x4;
    @FXML
    private Font x2;
    @FXML
    private TextArea personnelTxt;
    @FXML
    private TextArea appProfileTxt;
    @FXML
    private Font x3;
    @FXML
    private TextArea businessExternalCostsTxt;
    @FXML
    private TextArea backUpInfoTxt;
    @FXML
    private Button saveEditBtnID;
    @FXML
    private TextArea recoveryPlanOnsiteLocationTxt;
    @FXML
    private TextArea alternativeRecoveryPlanTxt;
    @FXML
    private TextArea proceduresForRestoringTxt;
    @FXML
    private TextArea assessDamageTxt;
    @FXML
    private TextArea emerengencyContactNumbersListTxt;
    @FXML
    private TextArea testProcedureTxt;
    @FXML
    private TextArea disasterSiteRebuildingTxt;
    @FXML
    private Button uploadBtnID;
    @FXML
    private ImageView floorPlanImageView;
    @FXML
    private Button backBtnID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void saveEditBtn(ActionEvent event) {
    }

    @FXML
    private void uploadBtn(ActionEvent event) {
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
