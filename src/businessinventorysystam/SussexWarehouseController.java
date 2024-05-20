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

public class SussexWarehouseController implements Initializable {
    
    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

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
    private ListView<String> ShelfA;
    @FXML
    private ListView<String> ShelfC;
    @FXML
    private ListView<String> ShelfE;
    @FXML
    private ListView<String> ShelfG;
    @FXML
    private ListView<String> ShelfH;
    @FXML
    private ListView<String> ShelfF;
    @FXML
    private ListView<String> ShelfD;
    @FXML
    private ListView<String> ShelfB;
    
    public void shelfA() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Sussex' AND Shelf = 'A'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.ShelfA.getItems().add(row);
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
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Sussex' AND Shelf = 'B'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.ShelfB.getItems().add(row);
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
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Sussex' AND Shelf = 'C'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.ShelfC.getItems().add(row);
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
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Sussex' AND Shelf = 'D'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.ShelfD.getItems().add(row);
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
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Sussex' AND Shelf = 'E'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.ShelfE.getItems().add(row);
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
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Sussex' AND Shelf = 'F'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.ShelfF.getItems().add(row);
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
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Sussex' AND Shelf = 'G'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.ShelfG.getItems().add(row);
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
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Sussex' AND Shelf = 'H'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.ShelfH.getItems().add(row);
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
        Parent search = FXMLLoader.load(getClass().getResource("SearchRemArivDelSussexW.fxml"));
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
