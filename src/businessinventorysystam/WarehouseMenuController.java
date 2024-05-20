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

public class WarehouseMenuController implements Initializable {

    @FXML
    private Button essexWBtnID;
    @FXML
    private Button sussexWBtnID;
    @FXML
    private Button middlesexWBtnID;
    @FXML
    private Button hampshireWBtnID;
    @FXML
    private Button addProductsBtnID;
    @FXML
    private Button archiveProductsBtnID;
    @FXML
    private Button backBtnID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void essexWBtn(ActionEvent event) throws IOException {
        Parent essexWarehouse = FXMLLoader.load(getClass().getResource("EssexWarehouse.fxml"));
        Scene essexWarehousescene = new Scene(essexWarehouse);
        Stage essexWarehousestage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        essexWarehousestage.setTitle("Essex Warehouse");
        essexWarehousestage.hide();
        essexWarehousestage.setScene(essexWarehousescene);
        essexWarehousestage.setHeight(1280);
        essexWarehousestage.setWidth(1200);
        essexWarehousestage.setResizable(false);
        essexWarehousestage.show();
    }

    @FXML
    private void sussexWBtn(ActionEvent event) throws IOException {
        Parent sussexWarehouse = FXMLLoader.load(getClass().getResource("sussexWarehouse.fxml"));
        Scene sussexWarehousescene = new Scene(sussexWarehouse);
        Stage sussexWarehousestage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sussexWarehousestage.setTitle("Sussex Warehouse");
        sussexWarehousestage.hide();
        sussexWarehousestage.setScene(sussexWarehousescene);
        sussexWarehousestage.setHeight(1280);
        sussexWarehousestage.setWidth(1200);
        sussexWarehousestage.setResizable(false);
        sussexWarehousestage.show();
    }

    @FXML
    private void middlesexWBtn(ActionEvent event) throws IOException {
        Parent middlesexWarehouse = FXMLLoader.load(getClass().getResource("MiddlesexWarehouse.fxml"));
        Scene middlesexWarehousescene = new Scene(middlesexWarehouse);
        Stage middlesexWarehousestage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        middlesexWarehousestage.setTitle("Middlesex Warehouse");
        middlesexWarehousestage.hide();
        middlesexWarehousestage.setScene(middlesexWarehousescene);
        middlesexWarehousestage.setHeight(1280);
        middlesexWarehousestage.setWidth(1200);
        middlesexWarehousestage.setResizable(false);
        middlesexWarehousestage.show();
    }

    @FXML
    private void hampshireWBtn(ActionEvent event) throws IOException {
        Parent HampshireWarehouse = FXMLLoader.load(getClass().getResource("HampshireWarehouse.fxml"));
        Scene HampshireWarehousescene = new Scene(HampshireWarehouse);
        Stage HampshireWarehousestage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HampshireWarehousestage.setTitle("Hampshire Warehouse");
        HampshireWarehousestage.hide();
        HampshireWarehousestage.setScene(HampshireWarehousescene);
        HampshireWarehousestage.setHeight(1280);
        HampshireWarehousestage.setWidth(1200);
        HampshireWarehousestage.setResizable(false);
        HampshireWarehousestage.show();
    }

    @FXML
    private void addProductsBtn(ActionEvent event) throws IOException {
        Parent addProductsWarehouse = FXMLLoader.load(getClass().getResource("AddProductsToWarehouses.fxml"));
        Scene addProductsWarehousesscene = new Scene(addProductsWarehouse);
        Stage addProductsWarehousesstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addProductsWarehousesstage.setTitle("Add products to warehouses");
        addProductsWarehousesstage.hide();
        addProductsWarehousesstage.setScene(addProductsWarehousesscene);
        addProductsWarehousesstage.setHeight(720);
        addProductsWarehousesstage.setWidth(740);
        addProductsWarehousesstage.setResizable(false);
        addProductsWarehousesstage.show();
    }

    @FXML
    private void archiveProductsBtn(ActionEvent event) throws IOException {
        Parent ArchiveProducts = FXMLLoader.load(getClass().getResource("ArchiveProducts.fxml"));
        Scene ArchiveProductsscene = new Scene(ArchiveProducts);
        Stage ArchiveProductsscenestage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ArchiveProductsscenestage.setTitle("Archive Products List");
        ArchiveProductsscenestage.hide();
        ArchiveProductsscenestage.setScene(ArchiveProductsscene);
        ArchiveProductsscenestage.setHeight(540);
        ArchiveProductsscenestage.setWidth(720);
        ArchiveProductsscenestage.setResizable(false);
        ArchiveProductsscenestage.show();
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
