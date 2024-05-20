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
import javafx.stage.Stage;

public class EmployeesController implements Initializable {

    public Statement statement;
    public Connection connection;
    public ResultSet resultSet;

    @FXML
    private Button searchEmployeesID;
    @FXML
    private Button updateEmployeesID;
    @FXML
    private Button viewEmployeesID;
    @FXML
    private Button backBtnID;

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
                    this.searchEmployeesID.setDisable(true);
                    this.viewEmployeesID.setDisable(true);
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
    private void searchEmployeesBtn(ActionEvent event) throws IOException {
        Parent SearchAssignEmployee = FXMLLoader.load(getClass().getResource("SearchAssignEmployee.fxml"));
        Scene SearchAssignEmployeeScene = new Scene(SearchAssignEmployee);
        Stage SearchAssignEmployeeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SearchAssignEmployeeStage.setTitle("Assign Employee A Job");
        SearchAssignEmployeeStage.hide();
        SearchAssignEmployeeStage.setScene(SearchAssignEmployeeScene);
        SearchAssignEmployeeStage.setHeight(575);
        SearchAssignEmployeeStage.setWidth(790);
        SearchAssignEmployeeStage.setResizable(false);
        SearchAssignEmployeeStage.show();
    }

    @FXML
    private void updateEmployeesBtn(ActionEvent event) throws IOException {
        Parent UpdateEmployeesDetails = FXMLLoader.load(getClass().getResource("UpdateEmployeesDetails.fxml"));
        Scene SearchAssignEmployeeScene = new Scene(UpdateEmployeesDetails);
        Stage UpdateEmployeesDetailsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        UpdateEmployeesDetailsStage.setTitle("Update Employees Details");
        UpdateEmployeesDetailsStage.hide();
        UpdateEmployeesDetailsStage.setScene(SearchAssignEmployeeScene);
        UpdateEmployeesDetailsStage.setHeight(815);
        UpdateEmployeesDetailsStage.setWidth(765);
        UpdateEmployeesDetailsStage.setResizable(false);
        UpdateEmployeesDetailsStage.show();
    }

    @FXML
    private void viewEmployeesBtn(ActionEvent event) throws IOException {
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
