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

public class AddProductsOnsiteLController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private Font x1;
    private TextField productNameID;
    @FXML
    private TextField prodctQtyID;
    @FXML
    private ComboBox<String> onsiteLocationCB;
    @FXML
    private ComboBox<String> SelectRowCBID;
    @FXML
    private ComboBox<String> SelectShelfNoCBID;
    @FXML
    private Button addProductBtnID;
    @FXML
    private Button backBtnID;
    @FXML
    private ComboBox<String> productNameCB;

    public void loadProductName() {
        //Loading the data to the Product Name List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String productNames = "SELECT * FROM products";
            resultSet = statement.executeQuery(productNames);

            while (resultSet.next()) {
                this.productNameCB.getItems().addAll(resultSet.getString("ProductName"));
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
                this.productNameCB.getItems().addAll(resultSet.getString("ProductName"));
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Removing the exisiting items.
        this.SelectRowCBID.getItems().remove("Item 1");
        this.SelectRowCBID.getItems().remove("Item 2");
        this.SelectRowCBID.getItems().remove("Item 3");
        this.SelectShelfNoCBID.getItems().remove("Item 1");
        this.SelectShelfNoCBID.getItems().remove("Item 2");
        this.SelectShelfNoCBID.getItems().remove("Item 3");
        this.onsiteLocationCB.getItems().remove("Item 1");
        this.onsiteLocationCB.getItems().remove("Item 2");
        this.onsiteLocationCB.getItems().remove("Item 3");
        this.productNameCB.getItems().remove("Item 1");
        this.productNameCB.getItems().remove("Item 2");
        this.productNameCB.getItems().remove("Item 3");

        loadProductName();
        loadQRProductName();
        this.onsiteLocationCB.getItems().addAll("Shop");
        this.SelectRowCBID.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        this.SelectShelfNoCBID.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    }

    @FXML
    private void productQty(ActionEvent event) {
    }

    @FXML
    private void onsiteLocationCB(ActionEvent event) {
    }

    @FXML
    private void SelectRowCB(ActionEvent event) {
    }

    @FXML
    private void SelectShelfNoCB(ActionEvent event) {
    }

    @FXML
    private void addProductBtn(ActionEvent event) {
        String onsiteLocation = this.onsiteLocationCB.getValue();
        String productName = this.productNameCB.getValue();
        String row = this.SelectRowCBID.getValue();
        String shelfNo = this.SelectShelfNoCBID.getValue();
        String productQty = this.prodctQtyID.getText();
        
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();

            //Add Products Query
            String onsiteAddProducts = "INSERT INTO onsite (onSiteName, ProductName, Row, ShelfNo, ProductQty) "
                    + "       VALUES ('" + onsiteLocation + "', '" + productName + "', '" + row + "', '" + shelfNo + "', '" + productQty + "')";

            statement.executeUpdate(onsiteAddProducts);
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void backBtn(ActionEvent event) throws IOException {
        Parent OnsiteLocation = FXMLLoader.load(getClass().getResource("OnsiteLocation.fxml"));
        Scene OnsiteLocationScene = new Scene(OnsiteLocation);
        Stage OnsiteLocationStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        OnsiteLocationStage.setTitle("Onsite Location");
        OnsiteLocationStage.setScene(OnsiteLocationScene);
        OnsiteLocationStage.setHeight(480);
        OnsiteLocationStage.setWidth(420);
        OnsiteLocationStage.setResizable(false);
    }

    @FXML
    private void productNameCB(ActionEvent event) {
    }

}
