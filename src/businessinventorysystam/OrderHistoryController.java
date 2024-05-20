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
import javafx.stage.Stage;

public class OrderHistoryController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private ListView<String> ordersListDataLbl;
    @FXML
    private Button searchBtnID;
    @FXML
    private Button backBtnID;

    public void loadOrderData() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String listOfOrders = "SELECT * FROM orderdetails";
            resultSet = statement.executeQuery(listOfOrders);

            while (resultSet.next()) {
                String results
                        = "OrderDetails ID, " + resultSet.getString("OrderDetailsID") + "\n"
                        + "PricePerUnit, " + resultSet.getString("PricePerUnit") + "\n"
                        + "Qty, " + resultSet.getString("Qty") + "\n" 
                        + "TotalPrice, " + resultSet.getString("TotalPrice") + "\n" 
                        + "OrderID, " + resultSet.getString("OrderID") + "\n" 
                        + "ProductID, " + resultSet.getString("ProductID") + "\n" 
                        + "BillID, " + resultSet.getString("BillID") + "\n";
                this.ordersListDataLbl.getItems().addAll(results);
            }

            statement.close();
            resultSet.close();

            //
            statement = connection.createStatement();
            String listOrders = "SELECT * FROM qrcodeorderdetails";
            resultSet = statement.executeQuery(listOrders);

            while (resultSet.next()) {
                String results
                        = "OrderDetails ID, " + resultSet.getString("OrderDetailsID") + "\n"
                        + "PricePerUnit, " + resultSet.getString("PricePerUnit") + "\n"
                        + "Qty, " + resultSet.getString("Qty") + "\n" 
                        + "TotalPrice, " + resultSet.getString("TotalPrice") + "\n" 
                        + "OrderID, " + resultSet.getString("OrderID") + "\n" 
                        + "ProductID, " + resultSet.getString("ProductID") + "\n" 
                        + "BillID, " + resultSet.getString("BillID") + "\n";
                this.ordersListDataLbl.getItems().addAll(results);
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
        loadOrderData();
    }

    @FXML
    private void searchBtn(ActionEvent event) throws IOException {
        Parent searchInvoice = FXMLLoader.load(getClass().getResource("SearchInvoice.fxml"));
        Scene searchInvoiceScene = new Scene(searchInvoice);
        Stage searchInvoiceStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        searchInvoiceStage.setTitle("Search for detailed Invoice");
        searchInvoiceStage.hide();
        searchInvoiceStage.setScene(searchInvoiceScene);
        searchInvoiceStage.setHeight(375);
        searchInvoiceStage.setWidth(550);
        searchInvoiceStage.setResizable(false);
        searchInvoiceStage.show();
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
