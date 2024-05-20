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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SuppliersController implements Initializable {

    public Statement statement;
    public Connection connection;
    public ResultSet resultSet;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Font x2;
    @FXML
    private Font x1;
    @FXML
    private TextField supplierNametxt;
    @FXML
    private ComboBox<String> supplierSelectTypedropdown;
    @FXML
    private TextField supplierAddresstxt;
    @FXML
    private TextField supplierEmailtxt;
    @FXML
    private TextField supplierPhonenumbertxt;
    @FXML
    private Button btnAddSupplier;
    @FXML
    private Button searchSuppliersBtnId;
    @FXML
    private Button backToMUBtn;
    @FXML
    private Button archiveSupplierBtn;
    @FXML
    private Button deleteSupplierBtn;
    @FXML
    private Button supplierResBtn;
    @FXML
    private TextField supplierIDtxt;
    @FXML
    private ListView<String> listOfSuppliersView;
    @FXML
    private ListView<String> listOfArchiveSuppliersView;

    public void loadSuppliersData() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String listOfSuppliers = "SELECT * FROM suppliers";
            resultSet = statement.executeQuery(listOfSuppliers);

            while (resultSet.next()) {
                String results = String.format("%-24s %-20s %-58s %-60s %-52s",
                        resultSet.getString("SupplierName"),
                        resultSet.getString("SupplierType"),
                        resultSet.getString("SupplierAddress"),
                        resultSet.getString("SupplierEmail"),
                        resultSet.getString("SupplierPhoneNo")
                );

                this.listOfSuppliersView.getItems().addAll(results);

            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadArchiveSuppliersData() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String listOfSuppliers = "SELECT * FROM archivesuppliers";
            resultSet = statement.executeQuery(listOfSuppliers);

            while (resultSet.next()) {
                
                String results = String.format("%-24s %-20s %-58s %-60s %-52s",
                        resultSet.getString("SupplierName"),
                        resultSet.getString("SupplierType"),
                        resultSet.getString("SupplierAddress"),
                        resultSet.getString("SupplierPhoneNo"),
                        resultSet.getString("SupplierEmail")
                );

                this.listOfArchiveSuppliersView.getItems().addAll(results);

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
        this.scrollPane.setVvalue(1.0);

        //Removing the exisiting items.
        this.supplierSelectTypedropdown.getItems().remove("Item 1");
        this.supplierSelectTypedropdown.getItems().remove("Item 2");
        this.supplierSelectTypedropdown.getItems().remove("Item 3");

        //Adding the new list of suppliers to the checkbox component. 
        this.supplierSelectTypedropdown.getItems().add("Hardware");
        this.supplierSelectTypedropdown.getItems().add("Drinks");
        this.supplierSelectTypedropdown.getItems().add("Foods");
        this.supplierSelectTypedropdown.getItems().add("Stationery");
        this.supplierSelectTypedropdown.getItems().add("Eletrical");
        this.supplierSelectTypedropdown.getItems().add("Tools");
        this.supplierSelectTypedropdown.getItems().add("Health");
        this.supplierSelectTypedropdown.getItems().add("Cleaning");
        this.supplierSelectTypedropdown.getItems().add("Cutlery ");
        this.supplierSelectTypedropdown.getItems().add("Furniture");
        this.supplierSelectTypedropdown.getItems().add("Services");
        this.supplierSelectTypedropdown.getItems().add("Sub-Contractors");
        this.supplierSelectTypedropdown.getItems().add("Distrabuters");
        this.supplierSelectTypedropdown.getItems().add("Importers");

        loadSuppliersData();

        loadArchiveSuppliersData();
    }

    @FXML
    private void drag(MouseEvent event) {
    }

    @FXML
    private void selectType(ActionEvent event) {

    }

    @FXML
    private void addSupplier(ActionEvent event) {
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        String supplierID = this.supplierIDtxt.getText();
        String supplierName = this.supplierNametxt.getText();
        String supplierType = this.supplierSelectTypedropdown.getValue();
        String supplierAddress = this.supplierAddresstxt.getText();
        String supplierEmail = this.supplierEmailtxt.getText();
        String supplierPhonenumber = this.supplierPhonenumbertxt.getText();

        //Database Query to add suppliers.
        try {

            statement = connection.createStatement();

            String addSupplierQuery = "INSERT INTO suppliers (SupplierID, SupplierName, SupplierType, SupplierAddress, SupplierPhoneNo, SupplierEmail) "
                    + "       VALUES ('" + supplierID + "', '" + supplierName + "', '" + supplierType + "', '" + supplierAddress + "', '" + supplierPhonenumber + "', '" + supplierEmail + "')";

            statement.executeUpdate(addSupplierQuery);
            statement.close();
            connection.close();

            this.listOfSuppliersView.getItems().clear();
            loadSuppliersData();

            this.supplierIDtxt.clear();
            this.supplierNametxt.clear();
            this.supplierSelectTypedropdown.setValue("Enter Supplier Type");
            this.supplierAddresstxt.clear();
            this.supplierEmailtxt.clear();
            this.supplierPhonenumbertxt.clear();

        } catch (SQLException ex) {
            System.out.println("SQL Exception: Error");
            Logger.getLogger(BusinessInventorySystam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void searchSuppliersBtn(ActionEvent event) throws IOException {
        Parent SearchSuppliers = FXMLLoader.load(getClass().getResource("SearchSuppliers.fxml"));
        Scene SearchSuppliersScene = new Scene(SearchSuppliers);
        Stage SearchSuppliersStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SearchSuppliersStage.setTitle("Search Suppliers");
        SearchSuppliersStage.hide();
        SearchSuppliersStage.setScene(SearchSuppliersScene);
        SearchSuppliersStage.setHeight(285);
        SearchSuppliersStage.setWidth(636);
        SearchSuppliersStage.setResizable(false);
        SearchSuppliersStage.show();
    }

    @FXML
    private void backToMU(ActionEvent event) throws IOException {
        Parent MainMenu = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene MainMenuScene = new Scene(MainMenu);
        Stage MainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        MainMenuStage.setTitle("Main Menu");
        MainMenuStage.hide();
        MainMenuStage.setScene(MainMenuScene);
        MainMenuStage.setHeight(580);
        MainMenuStage.setWidth(727);
        MainMenuStage.setResizable(false);
        MainMenuStage.show();
    }

    @FXML
    private void archiveSupplier(ActionEvent event) throws IOException {
        Parent ArchiveSuppliers = FXMLLoader.load(getClass().getResource("ArchiveSuppliers.fxml"));
        Scene ArchiveSuppliersScene = new Scene(ArchiveSuppliers);
        Stage ArchiveSuppliersStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ArchiveSuppliersStage.setTitle("Archive Suppliers");
        ArchiveSuppliersStage.hide();
        ArchiveSuppliersStage.setScene(ArchiveSuppliersScene);
        ArchiveSuppliersStage.setHeight(285);
        ArchiveSuppliersStage.setWidth(636);
        ArchiveSuppliersStage.setResizable(false);
        ArchiveSuppliersStage.show();
    }

    @FXML
    private void deleteBtn(ActionEvent event) throws IOException {
        Parent DeleteSuppliers = FXMLLoader.load(getClass().getResource("deleteSupplier.fxml"));
        Scene DeleteSuppliersScene = new Scene(DeleteSuppliers);
        Stage DeleteSuppliersStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        DeleteSuppliersStage.setTitle("Delete Suppliers");
        DeleteSuppliersStage.hide();
        DeleteSuppliersStage.setScene(DeleteSuppliersScene);
        DeleteSuppliersStage.setHeight(285);
        DeleteSuppliersStage.setWidth(636);
        DeleteSuppliersStage.setResizable(false);
        DeleteSuppliersStage.show();
    }

    @FXML
    private void resBtn(ActionEvent event) throws IOException {
        Parent RestoreSuppliers = FXMLLoader.load(getClass().getResource("RestoreSupplier.fxml"));
        Scene RestoreSuppliersScene = new Scene(RestoreSuppliers);
        Stage RestoreSuppliersStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RestoreSuppliersStage.setTitle("Restore Suppliers");
        RestoreSuppliersStage.hide();
        RestoreSuppliersStage.setScene(RestoreSuppliersScene);
        RestoreSuppliersStage.setHeight(285);
        RestoreSuppliersStage.setWidth(636);
        RestoreSuppliersStage.setResizable(false);
        RestoreSuppliersStage.show();
    }

}
