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
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HampshireWarehouseController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TableView<String> shelfATbl;

    @FXML
    private TableView<String> shelfCTbl;

    @FXML
    private TableView<String> shelfETbl;

    @FXML
    private TableView<String> shelfGTbl;

    @FXML
    private TableView<String> shelfBTbl;

    @FXML
    private TableView<String> shelfDTbl;

    @FXML
    private TableView<String> shelfFTbl;

    @FXML
    private TableView<String> shelfHTbl;

    @FXML
    private Button searchBtnID;
    @FXML
    private Button backBtnID;

    @FXML
    private ListView<String> shelfA;
    @FXML
    private ListView<String> shelfC;
    @FXML
    private ListView<String> shelfE;
    @FXML
    private ListView<String> shelfG;
    @FXML
    private ListView<String> shelfB;
    @FXML
    private ListView<String> shelfD;
    @FXML
    private ListView<String> shelfF;
    @FXML
    private ListView<String> shelfH;

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    public void shelfA() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Hampshire' AND Shelf = 'A'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.shelfA.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void shelfB() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Hampshire' AND Shelf = 'B'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.shelfB.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void shelfC() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Hampshire' AND Shelf = 'C'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.shelfC.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void shelfD() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Hampshire' AND Shelf = 'D'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.shelfD.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void shelfE() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Hampshire' AND Shelf = 'E'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.shelfE.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void shelfF() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Hampshire' AND Shelf = 'F'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.shelfF.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void shelfG() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Hampshire' AND Shelf = 'G'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.shelfG.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void shelfH() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Hampshire' AND Shelf = 'H'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.shelfH.getItems().add(row);
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
        shelfA();
        shelfB();
        shelfC();
        shelfD();
        shelfE();
        shelfF();
        shelfG();
        shelfH();
    }

    @FXML
    private void searchBtn(ActionEvent event) throws IOException {
        Parent search = FXMLLoader.load(getClass().getResource("SearchRemArivDelHampshireW.fxml"));
        Scene searchScene = new Scene(search);
        Stage searchStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        searchStage.setTitle("Search, Archive, Delete, or Remove Products in this warehouse");
        searchStage.setScene(searchScene);
        searchStage.setHeight(450);
        searchStage.setWidth(700);
        searchStage.setResizable(false);
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
