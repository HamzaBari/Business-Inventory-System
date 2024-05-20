package businessinventorysystam;

import SQLConnection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

public class SearchSuppliersController implements Initializable {

    public Statement statement;
    public Connection connection;
    public ResultSet resultSet;

    @FXML
    private Font x1;
    @FXML
    private TextField searchSuppliersTxt;
    @FXML
    private Button searchSuppliersBtn;
    @FXML
    private Button closeBtnId;
    @FXML
    private Label resultLbl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void searchSuppliersBtn(ActionEvent event) {
        ArrayList<String> list = new ArrayList<>();
        try {
            String searchSuppliers = this.searchSuppliersTxt.getText();
            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            String searchQuery = "SELECT * FROM suppliers WHERE SupplierName = '" + searchSuppliers + "'";
            resultSet = statement.executeQuery(searchQuery);

            while (resultSet.next()) {
                String results = resultSet.getString("SupplierName")
                        + " ,"
                        + resultSet.getString("SupplierType")
                        + " ,"
                        + resultSet.getString("SupplierAddress")
                        + " ,"
                        + resultSet.getString("SupplierEmail")
                        + " ,"
                        + resultSet.getString("SupplierPhoneNo");

                final double MAX_FONT_SIZE = 12.0; // define max font size you need
                this.resultLbl.setFont(new Font(MAX_FONT_SIZE)); // set to Label
                this.resultLbl.setText(results);

                String id = resultSet.getString("SupplierID");
                String name = resultSet.getString("SupplierName");
                String type = resultSet.getString("SupplierType");
                String address = resultSet.getString("SupplierAddress");
                String email = resultSet.getString("SupplierEmail");
                String phoneNo = resultSet.getString("SupplierPhoneNo");

                list.add(id);
                list.add(name);
                list.add(type);
                list.add(address);
                list.add(email);
                list.add(phoneNo);

                statement.close();
                resultSet.close();
                connection.close();

            }

        } catch (SQLException ex) {
            Logger.getLogger(BusinessInventorySystam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void closeBtn(ActionEvent event) throws IOException {
        Parent Suppliers = FXMLLoader.load(getClass().getResource("Suppliers.fxml"));
        Scene SuppliersScene = new Scene(Suppliers);
        Stage SuppliersStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SuppliersStage.setTitle("Suppliers");
        SuppliersStage.setScene(SuppliersScene);
        SuppliersStage.setHeight(1000);
        SuppliersStage.setWidth(1390);
        SuppliersStage.setResizable(false);
    }

}
