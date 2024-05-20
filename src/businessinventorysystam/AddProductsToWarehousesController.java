
package businessinventorysystam;

import SQLConnection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddProductsToWarehousesController implements Initializable {
    
    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;
    
    @FXML
    private Font x1;
    @FXML
    private TextField productQtyTxt;
    @FXML
    private ComboBox<String> warehouseLocationID;
    @FXML
    private ComboBox<String> SelectShelfID;
    @FXML
    private ComboBox<String> SelectShelfNoID;
    @FXML
    private Button addProductID;
    @FXML
    private Button archiveProductLID;
    @FXML
    private Button backBtnID;
    @FXML
    private ComboBox<String> warehouseProductNameCB;
    
    public void loadProductName() {
        //Loading the data to the Product Name List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String productNames = "SELECT * FROM products";
            resultSet = statement.executeQuery(productNames);

            while (resultSet.next()) {
                this.warehouseProductNameCB.getItems().addAll(resultSet.getString("ProductName"));
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadQRProductName() {
        //Loading the data to the QR Product Name List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String productNames = "SELECT * FROM qrcodescan";
            resultSet = statement.executeQuery(productNames);

            while (resultSet.next()) {
                this.warehouseProductNameCB.getItems().addAll(resultSet.getString("ProductName"));
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addWarehouseLocation() {
        this.warehouseLocationID.getItems().addAll("Essex");
        this.warehouseLocationID.getItems().addAll("Sussex");
        this.warehouseLocationID.getItems().addAll("Middlesex");
        this.warehouseLocationID.getItems().addAll("Hampshire");
    }
    
    public void addShelfs() {
        this.SelectShelfID.getItems().addAll("A");
        this.SelectShelfID.getItems().addAll("B");
        this.SelectShelfID.getItems().addAll("C");
        this.SelectShelfID.getItems().addAll("D");
        this.SelectShelfID.getItems().addAll("E");
        this.SelectShelfID.getItems().addAll("F");
        this.SelectShelfID.getItems().addAll("G");
        this.SelectShelfID.getItems().addAll("H");
    }
    
    public void addShelfNo() {
        this.SelectShelfNoID.getItems().addAll("1");
        this.SelectShelfNoID.getItems().addAll("2");
        this.SelectShelfNoID.getItems().addAll("3");
        this.SelectShelfNoID.getItems().addAll("4");
        this.SelectShelfNoID.getItems().addAll("5");
        this.SelectShelfNoID.getItems().addAll("6");
        this.SelectShelfNoID.getItems().addAll("7");
        this.SelectShelfNoID.getItems().addAll("8");
        this.SelectShelfNoID.getItems().addAll("9");
        this.SelectShelfNoID.getItems().addAll("10");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Removing the exisiting items.
        this.warehouseProductNameCB.getItems().remove("Item 1");
        this.warehouseProductNameCB.getItems().remove("Item 2");
        this.warehouseProductNameCB.getItems().remove("Item 3");
        this.warehouseLocationID.getItems().remove("Item 1");
        this.warehouseLocationID.getItems().remove("Item 2");
        this.warehouseLocationID.getItems().remove("Item 3");
        this.SelectShelfID.getItems().remove("Item 1");
        this.SelectShelfID.getItems().remove("Item 2");
        this.SelectShelfID.getItems().remove("Item 3");
        this.SelectShelfNoID.getItems().remove("Item 1");
        this.SelectShelfNoID.getItems().remove("Item 2");
        this.SelectShelfNoID.getItems().remove("Item 3");
        
        loadProductName();
        loadQRProductName();
        addWarehouseLocation();
        addShelfs();
        addShelfNo();
        
    }   

    @FXML
    private void warehouseLocationCB(ActionEvent event) {
    }

    @FXML
    private void SelectShelfCB(ActionEvent event) {
    }

    @FXML
    private void SelectShelfNoCB(ActionEvent event) {
    }

    @FXML
    private void addProductBtn(ActionEvent event) {
        String warehouseLocation = this.warehouseLocationID.getValue();
        String productName = this.warehouseProductNameCB.getValue();
        String shelf = this.SelectShelfID.getValue();
        String shelfRowNo = this.SelectShelfNoID.getValue();
        String productQty = this.productQtyTxt.getText();
        
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();

            //Add Products Query
            String warehouseAddProducts = "INSERT INTO warehouses (WarehouseLocation, ProductName, Shelf, Row, Qty) "
                    + "       VALUES ('" + warehouseLocation + "', '" + productName + "', '" + shelf + "', '" + shelfRowNo + "', '" + productQty + "')";

            statement.executeUpdate(warehouseAddProducts);
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void archiveProductBtn(ActionEvent event) throws IOException {
        Parent ArchiveProducts = FXMLLoader.load(getClass().getResource("ArchiveProducts.fxml"));
        Scene ArchiveProductsscene = new Scene(ArchiveProducts);
        Stage ArchiveProductsscenestage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ArchiveProductsscenestage.setTitle("Archive Products List");
        ArchiveProductsscenestage.hide();
        ArchiveProductsscenestage.setScene(ArchiveProductsscene);
        ArchiveProductsscenestage.setHeight(520);
        ArchiveProductsscenestage.setWidth(720);
        ArchiveProductsscenestage.setResizable(false);
        ArchiveProductsscenestage.show();
    }

    @FXML
    private void backBtn(ActionEvent event) throws IOException {
        Parent Warehouses = FXMLLoader.load(getClass().getResource("WarehouseMenu.fxml"));
        Scene WarehousesScene = new Scene(Warehouses);
        Stage WarehousesStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        WarehousesStage.setTitle("Warehouse");
        WarehousesStage.setScene(WarehousesScene);
        WarehousesStage.setHeight(540);
        WarehousesStage.setWidth(540);
        WarehousesStage.setResizable(false);
    }
    
    
    
}
