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
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {

    public Statement statement;
    public Connection connection;
    public ResultSet resultSet;

    @FXML
    private Font x1;
    @FXML
    private Font x2;
    @FXML
    private Label lblLoggedInUsr;
    @FXML
    private Button suppliersBtnId;
    @FXML
    private Button ordersBtnId;
    @FXML
    private Button warehousesBtnId;
    @FXML
    private Button employeesBtnId;
    @FXML
    private Button jobsBtnId;
    @FXML
    private Button onsiteBtnId;
    @FXML
    private Button orderslistBtnId;
    @FXML
    private Button business_drpBtnId;
    @FXML
    private Button financeBtnId;
    @FXML
    private Button helpGuideBtnId;
    @FXML
    private Button logoutBtnId;

    private String userLoggedin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Get User Type.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String listOfSuppliers = "SELECT * FROM loggedinusr";
            resultSet = statement.executeQuery(listOfSuppliers);

            while (resultSet.next()) {
                String results = resultSet.getString("UserType");
                System.out.println(results);

                //Stopping Employees From Accessing sections which are not required according to one of the software requirement. 
                if (results.startsWith("E")) {
                    this.suppliersBtnId.setDisable(true);
                    this.ordersBtnId.setDisable(true);
                    this.orderslistBtnId.setDisable(true);
                    this.financeBtnId.setDisable(true);
                }

            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void suppliersBtn(ActionEvent event) throws IOException {
        Parent Suppliers = FXMLLoader.load(getClass().getResource("Suppliers.fxml"));
        Scene SuppliersScene = new Scene(Suppliers);
        Stage SuppliersStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SuppliersStage.setTitle("Suppliers");
        SuppliersStage.setScene(SuppliersScene);
        SuppliersStage.setHeight(860);
        SuppliersStage.setWidth(1390);
        SuppliersStage.setResizable(false);
    }

    @FXML
    private void ordersBtn(ActionEvent event) throws IOException {
        Parent OrderSystem = FXMLLoader.load(getClass().getResource("OrderSystem.fxml"));
        Scene OrderSystemScene = new Scene(OrderSystem);
        Stage OrderSystemStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        OrderSystemStage.setTitle("Order System");
        OrderSystemStage.setScene(OrderSystemScene);
        OrderSystemStage.setHeight(996);
        OrderSystemStage.setWidth(1350);
        OrderSystemStage.setResizable(false);
    }

    @FXML
    private void warehousesBtn(ActionEvent event) throws IOException {
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
    private void employeesBtn(ActionEvent event) throws IOException {
        Parent Employees = FXMLLoader.load(getClass().getResource("Employees.fxml"));
        Scene EmployeesScene = new Scene(Employees);
        Stage EmployeesStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        EmployeesStage.setTitle("Employees");
        EmployeesStage.setScene(EmployeesScene);
        EmployeesStage.setHeight(580);
        EmployeesStage.setWidth(800);
        EmployeesStage.setResizable(false);
    }

    @FXML
    private void jobsBtn(ActionEvent event) throws IOException {
        Parent Job = FXMLLoader.load(getClass().getResource("Job.fxml"));
        Scene JobScene = new Scene(Job);
        Stage JobStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        JobStage.setTitle("Job");
        JobStage.setScene(JobScene);
        JobStage.setHeight(640);
        JobStage.setWidth(490);
        JobStage.setResizable(false);
    }

    @FXML
    private void onsiteBtn(ActionEvent event) throws IOException {
        Parent OnsiteLocation = FXMLLoader.load(getClass().getResource("OnsiteLocation.fxml"));
        Scene OnsiteLocationScene = new Scene(OnsiteLocation);
        Stage OnsiteLocationStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        OnsiteLocationStage.setTitle("Onsite Location");
        OnsiteLocationStage.setScene(OnsiteLocationScene);
        OnsiteLocationStage.setHeight(480);
        OnsiteLocationStage.setWidth(420);
        OnsiteLocationStage.setResizable(false);
    }

    @FXML
    private void orderslistBtn(ActionEvent event) throws IOException {
        Parent OrderListSystem = FXMLLoader.load(getClass().getResource("OrderHistory.fxml"));
        Scene OrderListScene = new Scene(OrderListSystem);
        Stage OrderListStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        OrderListStage.setTitle("Order History");
        OrderListStage.setScene(OrderListScene);
        OrderListStage.setHeight(575);
        OrderListStage.setWidth(734);
        OrderListStage.setResizable(false);
    }

    @FXML
    private void business_drpBtn(ActionEvent event) throws IOException {
        Parent businessDRP = FXMLLoader.load(getClass().getResource("BusinessDRPs.fxml"));
        Scene businessDRPScene = new Scene(businessDRP);
        Stage businessDRPStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        businessDRPStage.setTitle("Business/DRP Plans");
        businessDRPStage.setScene(businessDRPScene);
        businessDRPStage.setHeight(370);
        businessDRPStage.setWidth(412);
        businessDRPStage.setResizable(false);
    }

    @FXML
    private void financeBtn(ActionEvent event) throws IOException {
        Parent Finance = FXMLLoader.load(getClass().getResource("Finance.fxml"));
        Scene FinanceScene = new Scene(Finance);
        Stage FinanceStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FinanceStage.setTitle("Finance");
        FinanceStage.setScene(FinanceScene);
        FinanceStage.setHeight(970);
        FinanceStage.setWidth(1476);
        FinanceStage.setResizable(false);
    }

    @FXML
    private void helpGuideBtn(ActionEvent event) throws IOException {
        Parent HelpGuide = FXMLLoader.load(getClass().getResource("HelpGuide.fxml"));
        Scene HelpGuideScene = new Scene(HelpGuide);
        Stage HelpGuideStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelpGuideStage.setTitle("Help Guide");
        HelpGuideStage.setScene(HelpGuideScene);
        HelpGuideStage.setHeight(820);
        HelpGuideStage.setWidth(750);
        HelpGuideStage.setResizable(false);
    }

    @FXML
    private void logoutBtn(ActionEvent event) throws IOException {
        Parent UserAuthentication = FXMLLoader.load(getClass().getResource("UserAuthentication.fxml"));
        Scene UserAuthenticationScene = new Scene(UserAuthentication);
        Stage UserAuthenticationStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        UserAuthenticationStage.setTitle("Registration & Login");
        UserAuthenticationStage.hide();
        UserAuthenticationStage.setScene(UserAuthenticationScene);
        UserAuthenticationStage.setHeight(540);
        UserAuthenticationStage.setWidth(938);
        UserAuthenticationStage.setResizable(false);
        UserAuthenticationStage.show();
    }

}
