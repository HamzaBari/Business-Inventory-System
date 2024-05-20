
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
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OnsiteShopController implements Initializable {
    
    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;
    
    @FXML
    private Font x1;
    @FXML
    private ListView<String> row1LV;
    @FXML
    private ListView<String> row2LV;
    @FXML
    private ListView<String> row3LV;
    @FXML
    private ListView<String> row4LV;
    @FXML
    private ListView<String> row5LV;
    @FXML
    private ListView<String> row6LV;
    @FXML
    private ListView<String> row7LV;
    @FXML
    private ListView<String> row8LV;
    @FXML
    private ListView<String> row9LV;
    @FXML
    private ListView<String> row10LV;
    @FXML
    private ListView<String> row11LV;
    @FXML
    private ListView<String> row12LV;
    
    public void row1() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 1";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row1LV.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void row2() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 2";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row2LV.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void row3() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 3";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row3LV.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void row4() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 4";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row4LV.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void row5() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 5";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row5LV.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void row6() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 6";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row6LV.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void row7() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 7";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row7LV.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void row8() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 8";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row8LV.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void row9() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 9";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row9LV.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void row10() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 10";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row10LV.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void row11() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 11";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row11LV.getItems().add(row);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void row12() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String onsite = "SELECT * FROM onsite WHERE Row = 12";
            resultSet = statement.executeQuery(onsite);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("ProductQty") + "\t\t\t\t" + resultSet.getString("ShelfNo");
                this.row12LV.getItems().add(row);
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
       row1();
       row2();
       row3();
       row4();
       row5();
       row6();
       row7();
       row8();
       row9();
       row10();
       row11();
       row12();
    }    

    @FXML
    private void searchBtn(ActionEvent event) throws IOException {
        Parent OnsiteShopSearchRedRem = FXMLLoader.load(getClass().getResource("SearchAndRedRemOnsiteL.fxml"));
        Scene OnsiteShopSearchRedRemScene = new Scene(OnsiteShopSearchRedRem);
        Stage OnsiteShopSearchRedRemStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        OnsiteShopSearchRedRemStage.setTitle("Search, Reduce, Remove, Products on the Onsite");
        OnsiteShopSearchRedRemStage.hide();
        OnsiteShopSearchRedRemStage.setScene(OnsiteShopSearchRedRemScene);
        OnsiteShopSearchRedRemStage.setHeight(450);
        OnsiteShopSearchRedRemStage.setWidth(700);
        OnsiteShopSearchRedRemStage.setResizable(false);
        OnsiteShopSearchRedRemStage.show();
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
    
    
}
