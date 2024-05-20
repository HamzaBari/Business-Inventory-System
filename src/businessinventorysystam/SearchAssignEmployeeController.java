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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchAssignEmployeeController implements Initializable {

    @FXML
    private TextField nameTxt;
    @FXML
    private Button searchBtnID;
    @FXML
    private Label errorMsgLbl;
    @FXML
    private ComboBox<String> assignJobCBID;
    @FXML
    private TextField monthlyWageTxt;
    @FXML
    private Label usernameLBL;
    @FXML
    private Label firstnameLBL;
    @FXML
    private Label lastnameLBL;
    @FXML
    private Label addressLBL;
    @FXML
    private Label postcodeLBL;
    @FXML
    private Label emailLBL;
    @FXML
    private Label phoneNoLBL;
    @FXML
    private Button saveBtnID;
    @FXML
    private Button backBtnID;

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    public void loadJobs() {
        //Loading the data to the Job Name/ID List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String JobNames = "SELECT * FROM jobrole";
            resultSet = statement.executeQuery(JobNames);

            while (resultSet.next()) {
                this.assignJobCBID.getItems().addAll(resultSet.getString("JobRoleID"));
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
        //Removing the exisiting items.
        this.assignJobCBID.getItems().remove("Item 1");
        this.assignJobCBID.getItems().remove("Item 2");
        this.assignJobCBID.getItems().remove("Item 3");
        
        loadJobs();
    }

    @FXML
    private void searchBtn(ActionEvent event) {
        try {
            String searchUser = this.nameTxt.getText();
            ConnectionClass connectionClass = new ConnectionClass();

            //Search Orders
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            String searchQuery = "SELECT * FROM employees WHERE Username = '" + searchUser + "'";
            resultSet = statement.executeQuery(searchQuery);

            while (resultSet.next()) {
                this.usernameLBL.setText(resultSet.getString("Username"));
                this.firstnameLBL.setText(resultSet.getString("Firstname"));
                this.lastnameLBL.setText(resultSet.getString("Lastname"));
                this.addressLBL.setText(resultSet.getString("Address"));
                this.postcodeLBL.setText(resultSet.getString("Postcode"));
                this.emailLBL.setText(resultSet.getString("Email"));
                this.phoneNoLBL.setText(resultSet.getString("Phonenumber"));
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            this.errorMsgLbl.setText("Error Getting User");
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void assignJobCB(ActionEvent event) {
    }

    @FXML
    private void saveBtn(ActionEvent event) {
        try {
            int getSalary = Integer.parseInt(this.monthlyWageTxt.getText());

            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            String update = "UPDATE employees SET MonthlySalary = '" + getSalary + "' WHERE Username = '" + this.usernameLBL.getText() + "'";
            String updateJob = "UPDATE employees SET JobRoleID = '" + this.assignJobCBID.getValue() + "' WHERE Username = '" + this.usernameLBL.getText() + "'";
            
            statement.executeUpdate(update);
            statement.executeUpdate(updateJob);

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ArchiveSuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void backBtn(ActionEvent event) throws IOException {
        Parent Employees = FXMLLoader.load(getClass().getResource("Employees.fxml"));
        Scene EmployeesScene = new Scene(Employees);
        Stage EmployeesStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        EmployeesStage.setTitle("Employees");
        EmployeesStage.setScene(EmployeesScene);
        EmployeesStage.setHeight(580);
        EmployeesStage.setWidth(800);
        EmployeesStage.setResizable(false);
    }

}
