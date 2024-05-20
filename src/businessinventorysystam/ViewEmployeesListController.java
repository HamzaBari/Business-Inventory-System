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
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewEmployeesListController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private ListView<String> employeeList;
    @FXML
    private Font x1;
    @FXML
    private Button deleteBtnID;
    @FXML
    private Button backBtnID;

    public void loadEmployeesData() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String loadEmployees = "SELECT * FROM employees";
            resultSet = statement.executeQuery(loadEmployees);

            while (resultSet.next()) {
                String results = String.format("%-24s %-30s %-30s %-40s %-30s %-30s %-30s %-30s %-30s",
                        resultSet.getString("EmployeeID"),
                        resultSet.getString("Firstname"),
                        resultSet.getString("Lastname"),
                        resultSet.getString("Address"),
                        resultSet.getString("Postcode"),
                        resultSet.getString("Phonenumber"),
                        resultSet.getString("Email"),
                        resultSet.getString("JobRoleID"),
                        resultSet.getString("MonthlySalary")
                );
                this.employeeList.getItems().addAll(results);
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
        loadEmployeesData();
    }

    @FXML
    private void deleteBtn(ActionEvent event) throws IOException {
        Parent DeleteEmployees = FXMLLoader.load(getClass().getResource("DeleteEmployee.fxml"));
        Scene DeleteEmployeesScene = new Scene(DeleteEmployees);
        Stage DeleteEmployeesStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        DeleteEmployeesStage.setTitle("Delete Employees");
        DeleteEmployeesStage.setScene(DeleteEmployeesScene);
        DeleteEmployeesStage.setHeight(320);
        DeleteEmployeesStage.setWidth(690);
        DeleteEmployeesStage.setResizable(false);
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
