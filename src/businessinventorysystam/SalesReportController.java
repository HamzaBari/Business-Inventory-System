
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
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class SalesReportController implements Initializable {
    @FXML
    private Button printBtnID;
    @FXML
    private Button saveBtnID;
    @FXML
    private Button closeBtnID;
    @FXML
    private WebView viewReport;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void printBtn(ActionEvent event) {
    }

    @FXML
    private void saveBtn(ActionEvent event) {
    }

    @FXML
    private void closeBtn(ActionEvent event) throws IOException {
        Parent Finance = FXMLLoader.load(getClass().getResource("Finance.fxml"));
        Scene FinanceScene = new Scene(Finance);
        Stage FinanceStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FinanceStage.setTitle("Finance");
        FinanceStage.setScene(FinanceScene);
        FinanceStage.setHeight(970);
        FinanceStage.setWidth(1476);
        FinanceStage.setResizable(false);
    }
    
}
