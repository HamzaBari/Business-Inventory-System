package businessinventorysystam;

import SQLConnection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SearchRemArivDelMiddlesexWController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private TextField searchTxt;
    @FXML
    private Font x1;
    @FXML
    private Button searchBtnID;
    @FXML
    private Label resultLbl;
    @FXML
    private Button closeBtnID;
    @FXML
    private Button archiveBtnID;
    @FXML
    private Button removeBtnID;
    @FXML
    private Button deleteBtnID;

    static ArrayList<String> list;

    public void searchProduct() {
        String searchProduct = this.searchTxt.getText();

        //Loading the data to the Product List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String warehouse = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Middlesex' AND ProductName = '" + searchProduct + "'";
            resultSet = statement.executeQuery(warehouse);

            while (resultSet.next()) {
                String row = resultSet.getString("ProductName") + "\t\t\t\t\t" + resultSet.getString("Shelf") + "\t\t\t\t\t" + resultSet.getString("Row") + "\t\t\t\t" + resultSet.getString("Qty");
                this.resultLbl.setText(row);
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
    }

    @FXML
    private void searchBtn(ActionEvent event) {
        searchProduct();
    }

    @FXML
    private void closeBtn(ActionEvent event) throws IOException {
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

    public void searchByName() {
        list = new ArrayList<>();
        try {
            String searchProducts = this.searchTxt.getText();
            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            String searchQuery = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Middlesex' AND ProductName = '" + searchProducts + "'";
            resultSet = statement.executeQuery(searchQuery);

            while (resultSet.next()) {
                String results = resultSet.getString("WarehouseLocation")
                        + " ,"
                        + resultSet.getString("ProductName")
                        + " ,"
                        + resultSet.getString("Shelf")
                        + " ,"
                        + resultSet.getString("Row")
                        + " ,"
                        + resultSet.getString("Qty");

                final double MAX_FONT_SIZE = 12.0; // define max font size you need
                this.resultLbl.setFont(new Font(MAX_FONT_SIZE)); // set to Label
                this.resultLbl.setText(results);

                String warehouseName = resultSet.getString("WarehouseLocation");
                String productName = resultSet.getString("ProductName");
                String shelf = resultSet.getString("Shelf");
                String row = resultSet.getString("Row");
                String qty = resultSet.getString("Qty");

                list.add(warehouseName);
                list.add(productName);
                list.add(shelf);
                list.add(row);
                list.add(qty);

                statement.close();
                resultSet.close();
                connection.close();

            }

        } catch (SQLException ex) {
            System.out.println("");
        }

    }

    @FXML
    private void archiveBtn(ActionEvent event) {
        searchByName();

        try {
            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            String warehouseName = list.get(0);
            String productName = list.get(1);
            String shelf = list.get(2);
            String row = list.get(3);
            String qty = list.get(4);

            String productStatus;
            if ("0".equals(qty)) {
                productStatus = "No";
            } else {
                productStatus = "Yes";
            }

            System.out.println(productStatus);

            //Code for the date.
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            //Getting current date
            Calendar cal = Calendar.getInstance();
            //Displaying current date in the desired format
            System.out.println("Current Date: " + sdf.format(cal.getTime()));

            //Number of Days to add
            cal.add(Calendar.DAY_OF_MONTH, 7);
            //Date after adding the days to the current date
            String date = sdf.format(cal.getTime());
            //Displaying the new Date after addition of Days to current date
            System.out.println("Date after Addition: " + date);

            String addProductQuery = "INSERT INTO archive (WarehouseLocation, ProductName, Shelf, Row, Qty, ProductStatus, AvaliableByWhen) "
                    + "       VALUES ('" + warehouseName + "', '" + productName + "', '" + shelf + "', '" + row + "', '" + qty + "', '" + productStatus + "', '" + date + "')";

            list.clear();
            statement.executeUpdate(addProductQuery);

            //Delete Query
            String productN = this.searchTxt.getText();

            String deleteSupplier = "DELETE FROM warehouses WHERE WarehouseLocation = 'Middlesex' AND ProductName = '" + productN + "'";
            statement.executeUpdate(deleteSupplier);

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ArchiveSuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removeBtn(ActionEvent event) {
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();

            String productName = this.searchTxt.getText();

            //Search
            statement = connection.createStatement();

            String searchQuery = "SELECT * FROM warehouses WHERE WarehouseLocation = 'Middlesex' AND ProductName = '" + productName + "'";
            resultSet = statement.executeQuery(searchQuery);

            ArrayList<Integer> passData = new ArrayList<>();
            while (resultSet.next()) {
                int result = resultSet.getInt("Qty");
                passData.add(result);
            }

            statement.close();
            resultSet.close();

            statement = connection.createStatement();

            //Reduce Query
            int r = passData.get(0);
            passData.clear();

            //Traced Error
            //System.out.println(r);
            int updateQty = r - 1;
            //System.out.println(updateQty);

            String deleteProduct = "UPDATE warehouses SET Qty = '" + updateQty + "' WHERE WarehouseLocation = 'Middlesex' AND ProductName = '" + productName + "'";
            statement.executeUpdate(deleteProduct);

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ArchiveSuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteBtn(ActionEvent event) {
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            //Delete Query
            String productName = this.searchTxt.getText();

            String deleteProduct = "DELETE FROM warehouses WHERE WarehouseLocation = 'Middlesex' AND ProductName = '" + productName + "'";
            statement.executeUpdate(deleteProduct);

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ArchiveSuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
