package businessinventorysystam;

import SQLConnection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.stage.Stage;

public class ArchiveProductsController implements Initializable {

    public Statement statement;
    public Connection connection;
    public ResultSet resultSet;

    @FXML
    private Button backBtnID;
    @FXML
    private TableView<String> archiveTbl;
    @FXML
    private Button searchBtnID;
    @FXML
    private ListView<String> archiveList;

    public void loadArchiveData() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String listOfOrders = "SELECT * FROM archive";
            resultSet = statement.executeQuery(listOfOrders);

            while (resultSet.next()) {
                String results = resultSet.getString("ProductName") +  "\t\t\t\t\t\t\t\t" + resultSet.getString("Qty");
                this.archiveList.getItems().addAll(results);
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
        loadArchiveData();
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

    @FXML
    private void searchBtn(ActionEvent event) throws IOException {
        Parent SearchRestoreArchive = FXMLLoader.load(getClass().getResource("SearchRestoreArchiveProducts.fxml"));
        Scene SearchRestoreArchiveScene = new Scene(SearchRestoreArchive);
        Stage SearchRestoreArchiveStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SearchRestoreArchiveStage.setTitle("Search, Restore, & Archive Products");
        SearchRestoreArchiveStage.setScene(SearchRestoreArchiveScene);
        SearchRestoreArchiveStage.setHeight(600);
        SearchRestoreArchiveStage.setWidth(660);
        SearchRestoreArchiveStage.setResizable(false);
    }

}
