
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

public class OnsiteLocationController implements Initializable {
    @FXML
    private Button addProductsID;
    @FXML
    private Button goToOnsiteLID;
    @FXML
    private Button mainMenuID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addProductsBtn(ActionEvent event) throws IOException {
        Parent AddProductsOnsiteLocation = FXMLLoader.load(getClass().getResource("AddProductsOnsiteL.fxml"));
        Scene AddProductsOnsiteLocationScene = new Scene(AddProductsOnsiteLocation);
        Stage AddProductsOnsiteLocationStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AddProductsOnsiteLocationStage.setTitle("Add Products to the Onsite Location");
        AddProductsOnsiteLocationStage.hide();
        AddProductsOnsiteLocationStage.setScene(AddProductsOnsiteLocationScene);
        AddProductsOnsiteLocationStage.setHeight(720);
        AddProductsOnsiteLocationStage.setWidth(740);
        AddProductsOnsiteLocationStage.setResizable(false);
        AddProductsOnsiteLocationStage.show();
    }

    @FXML
    private void goToOnsiteLBtn(ActionEvent event) throws IOException {
        Parent OnsiteShop = FXMLLoader.load(getClass().getResource("OnsiteShop.fxml"));
        Scene OnsiteShopScene = new Scene(OnsiteShop);
        Stage OnsiteShopStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        OnsiteShopStage.setTitle("Onsite(Shop)");
        OnsiteShopStage.hide();
        OnsiteShopStage.setScene(OnsiteShopScene);
        OnsiteShopStage.setHeight(1400);
        OnsiteShopStage.setWidth(1200);
        OnsiteShopStage.setResizable(false);
        OnsiteShopStage.show();
    }

    @FXML
    private void mainMenuBtn(ActionEvent event) throws IOException {
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
