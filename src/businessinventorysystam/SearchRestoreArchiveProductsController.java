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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SearchRestoreArchiveProductsController implements Initializable {

    @FXML
    private Button closeBtnID;
    @FXML
    private Font x1;
    @FXML
    private TextField searchTxt;
    @FXML
    private Button searchBtnID;
    @FXML
    private Label resultLbl;
    @FXML
    private Font x2;
    @FXML
    private Button restoreWarehouseBtnID;
    @FXML
    private ComboBox<String> onsiteRowCB;
    @FXML
    private ComboBox<String> onsiteShelfCB;
    @FXML
    private Button restoreOnsiteBtn;
    @FXML
    private TextField onsiteProductQty;
    @FXML
    private TextField onsiteLocationTxt;
    @FXML
    private ComboBox<String> warehouseLocationCB;
    @FXML
    private ComboBox<String> warehouseShelfNoCB;
    @FXML
    private ComboBox<String> warehouseRowNoCB;

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private TextField productWName;
    @FXML
    private TextField productOName;
    @FXML
    private TextField productWQty;
    
    public void addWarehouseLocation() {
        this.warehouseLocationCB.getItems().addAll("Essex");
        this.warehouseLocationCB.getItems().addAll("Sussex");
        this.warehouseLocationCB.getItems().addAll("Middlesex");
        this.warehouseLocationCB.getItems().addAll("Hampshire");
    }
    
    public void addShelfs() {
        this.warehouseShelfNoCB.getItems().addAll("A");
        this.warehouseShelfNoCB.getItems().addAll("B");
        this.warehouseShelfNoCB.getItems().addAll("C");
        this.warehouseShelfNoCB.getItems().addAll("D");
        this.warehouseShelfNoCB.getItems().addAll("E");
        this.warehouseShelfNoCB.getItems().addAll("F");
        this.warehouseShelfNoCB.getItems().addAll("G");
        this.warehouseShelfNoCB.getItems().addAll("H");
    }
    
    public void addShelfNo() {
        this.warehouseRowNoCB.getItems().addAll("1");
        this.warehouseRowNoCB.getItems().addAll("2");
        this.warehouseRowNoCB.getItems().addAll("3");
        this.warehouseRowNoCB.getItems().addAll("4");
        this.warehouseRowNoCB.getItems().addAll("5");
        this.warehouseRowNoCB.getItems().addAll("6");
        this.warehouseRowNoCB.getItems().addAll("7");
        this.warehouseRowNoCB.getItems().addAll("8");
        this.warehouseRowNoCB.getItems().addAll("9");
        this.warehouseRowNoCB.getItems().addAll("10");
        this.warehouseRowNoCB.getItems().addAll("11");
        this.warehouseRowNoCB.getItems().addAll("12");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Removing the exisiting items.
        this.warehouseLocationCB.getItems().remove("Item 1");
        this.warehouseLocationCB.getItems().remove("Item 2");
        this.warehouseLocationCB.getItems().remove("Item 3");
        this.warehouseShelfNoCB.getItems().remove("Item 1");
        this.warehouseShelfNoCB.getItems().remove("Item 2");
        this.warehouseShelfNoCB.getItems().remove("Item 3");
        this.warehouseRowNoCB.getItems().remove("Item 1");
        this.warehouseRowNoCB.getItems().remove("Item 2");
        this.warehouseRowNoCB.getItems().remove("Item 3");
        this.onsiteRowCB.getItems().remove("Item 1");
        this.onsiteRowCB.getItems().remove("Item 2");
        this.onsiteRowCB.getItems().remove("Item 3");
        this.onsiteShelfCB.getItems().remove("Item 1");
        this.onsiteShelfCB.getItems().remove("Item 2");
        this.onsiteShelfCB.getItems().remove("Item 3");
        
        this.onsiteRowCB.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        this.onsiteShelfCB.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        
        addWarehouseLocation();
        addShelfs();
        addShelfNo();
    }

    @FXML
    private void closeBtn(ActionEvent event) throws IOException {
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
    private void searchBtn(ActionEvent event) {
        String searchProduct = this.searchTxt.getText();

        //Loading the data to the Product List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();
        
        //ArrayList<String> l = new ArrayList<>();

        try {
            statement = connection.createStatement();
            String archive = "SELECT * FROM archive WHERE ProductName = '" + searchProduct + "'";
            resultSet = statement.executeQuery(archive);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t" + resultSet.getString("Shelf") + "\t\t" + resultSet.getString("Row") + "\t\t" + resultSet.getString("Qty");
                this.resultLbl.setText(row);
                //l.add(resultSet.getString("Qty"));
                this.productWQty.setText(resultSet.getString("Qty"));
                this.onsiteProductQty.setText(resultSet.getString("Qty"));
            }

            //Set both of the textfields
            this.productWName.setText(searchProduct);
            this.productOName.setText(searchProduct);

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void restoreWarehouseBtnID(ActionEvent event) {
        String warehouseLocation = this.productWName.getText();
        String productName = this.warehouseLocationCB.getValue();
        String shelf = this.warehouseShelfNoCB.getValue();
        String shelfRowNo = this.warehouseRowNoCB.getValue();
        String productQty = this.productWQty.getText();
        
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();

            //Add Products Query
            String warehouseAddProducts = "INSERT INTO warehouses (WarehouseLocation, ProductName, Shelf, Row, Qty) "
                    + "       VALUES ('" + productName + "', '" + warehouseLocation + "', '" + shelf + "', '" + shelfRowNo + "', '" + productQty + "')";

            statement.executeUpdate(warehouseAddProducts);
            
            String value = this.searchTxt.getText();
            System.out.println(value);
            
            //Delete Query
            String delete = "DELETE FROM archive WHERE ProductName = '" + value + "'";
            statement.executeUpdate(delete);
            
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void restoreOnsiteBtn(ActionEvent event) {
        String onsiteLocation = this.productOName.getText();
        String productName = this.onsiteLocationTxt.getText();
        String row = this.onsiteRowCB.getValue();
        String shelfNo = this.onsiteShelfCB.getValue();
        String productQty = this.onsiteProductQty.getText();
        
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();

            //Add Products Query
            String onsiteAddProducts = "INSERT INTO onsite (onSiteName, ProductName, Row, ShelfNo, ProductQty) "
                    + "       VALUES ('" + productName + "', '" + onsiteLocation + "', '" + row + "', '" + shelfNo + "', '" + productQty + "')";

            statement.executeUpdate(onsiteAddProducts);
            
            String value = this.searchTxt.getText();
            System.out.println(value);
            
            //Delete Query
            String delete = "DELETE FROM archive WHERE ProductName = '" + value + "'";
            statement.executeUpdate(delete);
            
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
