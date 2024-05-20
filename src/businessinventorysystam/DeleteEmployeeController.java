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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DeleteEmployeeController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private TextField employeeNameTxt;
    @FXML
    private Font x1;
    @FXML
    private Button searchBtnID;
    @FXML
    private Label resultLBL;
    @FXML
    private Button closeBtnID;
    @FXML
    private Button deleteBtnID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void searchBtn(ActionEvent event) {
        try {
            String searchEmployee = this.employeeNameTxt.getText();
            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            String searchQuery = "SELECT * FROM employees WHERE Username = '" + searchEmployee + "'";
            resultSet = statement.executeQuery(searchQuery);

            while (resultSet.next()) {
                String results = String.format("%-2s %-2s %-2s %-2s %-2s %-2s %-2s %-2s %-2s",
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

                this.resultLBL.setText(results);
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
        Parent ViewEmployeesList = FXMLLoader.load(getClass().getResource("ViewEmployeesList.fxml"));
        Scene ViewEmployeesListScene = new Scene(ViewEmployeesList);
        Stage ViewEmployeesListStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ViewEmployeesListStage.setTitle("View Employees List");
        ViewEmployeesListStage.hide();
        ViewEmployeesListStage.setScene(ViewEmployeesListScene);
        ViewEmployeesListStage.setHeight(450);
        ViewEmployeesListStage.setWidth(1477);
        ViewEmployeesListStage.setResizable(false);
        ViewEmployeesListStage.show();
    }

    @FXML
    private void deleteBtn(ActionEvent event) {
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            //Delete Query
            String employeeeName = this.employeeNameTxt.getText();

            String deleteEmployee = "DELETE FROM employees WHERE Username = '" + employeeeName + "'";
            statement.executeUpdate(deleteEmployee);

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ArchiveSuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
