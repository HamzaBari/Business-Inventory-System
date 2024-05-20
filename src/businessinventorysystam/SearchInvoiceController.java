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

public class SearchInvoiceController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private TextField inputIDtxt;
    @FXML
    private Button searchBtnID;
    @FXML
    private Font x1;
    @FXML
    private Label resultLbl;
    @FXML
    private Button exitBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void searchBtn(ActionEvent event) {
        try {
            String searchInvoice = this.inputIDtxt.getText();
            ConnectionClass connectionClass = new ConnectionClass();
            
            //Search Orders
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            String searchQuery = "SELECT * FROM orders WHERE OrderID = '" + searchInvoice + "'";
            resultSet = statement.executeQuery(searchQuery);

            while (resultSet.next()) {
                String results = resultSet.getString("OrderID")
                        + " ,"
                        + resultSet.getString("OrderDate")
                        + " ,"
                        + resultSet.getString("OwnerID");

                final double MAX_FONT_SIZE = 12.0; // define max font size you need
                this.resultLbl.setFont(new Font(MAX_FONT_SIZE)); // set to Label
                this.resultLbl.setText(results);

                statement.close();
                resultSet.close();
                connection.close();
            }
            
            //QR Code Orders
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            String searchQuery2 = "SELECT * FROM qrcodeorder WHERE OrderID = '" + searchInvoice + "'";
            resultSet = statement.executeQuery(searchQuery2);

            while (resultSet.next()) {
                String results = resultSet.getString("OrderID")
                        + " ,"
                        + resultSet.getString("OrderDate")
                        + " ,"
                        + resultSet.getString("OwnerID");

                final double MAX_FONT_SIZE = 12.0; // define max font size you need
                this.resultLbl.setFont(new Font(MAX_FONT_SIZE)); // set to Label
                this.resultLbl.setText(results);

                statement.close();
                resultSet.close();
                connection.close();
            }

        } catch (SQLException ex) {
            System.out.println("");
        }
    }

    @FXML
    private void exitBtn(ActionEvent event) throws IOException {
        Parent OrderListSystem = FXMLLoader.load(getClass().getResource("OrderHistory.fxml"));
        Scene OrderListScene = new Scene(OrderListSystem);
        Stage OrderListStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        OrderListStage.setTitle("Order History");
        OrderListStage.setScene(OrderListScene);
        OrderListStage.setHeight(575);
        OrderListStage.setWidth(734);
        OrderListStage.setResizable(false);
    }

}
