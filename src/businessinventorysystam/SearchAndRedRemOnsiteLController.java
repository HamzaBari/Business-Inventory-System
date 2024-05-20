package businessinventorysystam;

import SQLConnection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SearchAndRedRemOnsiteLController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private TextField searchProductTxt;
    @FXML
    private Font x1;
    @FXML
    private Button searchBtnID;
    @FXML
    private ListView<String> resultID;
    @FXML
    private Button closeBtnID;
    @FXML
    private Button reduceBtnID;
    @FXML
    private Button removeBtnID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void searchBtn(ActionEvent event) {
        try {
            String searchProducts = this.searchProductTxt.getText();
            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            String searchQuery = "SELECT * FROM onsite WHERE ProductName = '" + searchProducts + "'";
            resultSet = statement.executeQuery(searchQuery);

            while (resultSet.next()) {
                String results = "Product Name " + resultSet.getString("ProductName")
                        + " ,"
                        + "RowNo " + resultSet.getString("Row")
                        + " ,"
                        + "ShelfNo " + resultSet.getString("ShelfNo")
                        + " ,"
                        + "Qty " + resultSet.getString("ProductQty");

                this.resultID.getItems().add(results);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(BusinessInventorySystam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void closeBtn(ActionEvent event) throws IOException {
        Parent OnsiteShop = FXMLLoader.load(getClass().getResource("OnsiteShop.fxml"));
        Scene OnsiteShopScene = new Scene(OnsiteShop);
        Stage OnsiteShopStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        OnsiteShopStage.setTitle("Onsite(Shop)");
        OnsiteShopStage.hide();
        OnsiteShopStage.setScene(OnsiteShopScene);
        OnsiteShopStage.setHeight(1400);
        OnsiteShopStage.setWidth(1200);
        OnsiteShopStage.setResizable(false);
        OnsiteShopStage.show();
    }

    //Reduce Product Quantity
    @FXML
    private void reduceBtn(ActionEvent event) {
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();

            String productName = this.searchProductTxt.getText();

            //Search
            statement = connection.createStatement();

            String searchQuery = "SELECT * FROM onsite WHERE ProductName = '" + productName + "'";
            resultSet = statement.executeQuery(searchQuery);

            ArrayList<Integer> passData = new ArrayList<>();
            while (resultSet.next()) {
                int result = resultSet.getInt("ProductQty");
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

            String deleteProduct = "UPDATE onsite SET ProductQty = '" + updateQty + "' WHERE ProductName = '" + productName + "'";
            statement.executeUpdate(deleteProduct);

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
            statement = connection.createStatement();

            //Delete Query
            String productName = this.searchProductTxt.getText();

            String deleteProduct = "DELETE FROM onsite WHERE ProductName = '" + productName + "'";
            statement.executeUpdate(deleteProduct);

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ArchiveSuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
