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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UpdateEmployeesDetailsController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private TextField usernameTxtID;
    @FXML
    private Font x1;
    @FXML
    private TextField passwordTxtID;
    @FXML
    private Button loadDetailsBtnID;
    @FXML
    private Label errorMsgLbl;
    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField firstnameTxt;
    @FXML
    private TextField lastnameTxt;
    @FXML
    private TextField addressTxt;
    @FXML
    private TextField postcodeTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField phonenumberTxt;
    @FXML
    private TextField passwordTxt;
    @FXML
    private Button updateDetailsBtnID;
    @FXML
    private Button backBtnID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void loadDetailsBtn(ActionEvent event) {
        try {
            String username = this.usernameTxtID.getText();
            String password = this.passwordTxtID.getText();

            ConnectionClass connectionClass = new ConnectionClass();

            //Search Orders
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            String searchQuery = "SELECT * FROM employees WHERE Username = '" + username + "' AND Password = '" + password + "'";
            resultSet = statement.executeQuery(searchQuery);

            while (resultSet.next()) {
                this.usernameTxt.setText(resultSet.getString("Username"));
                this.firstnameTxt.setText(resultSet.getString("Firstname"));
                this.lastnameTxt.setText(resultSet.getString("Lastname"));
                this.addressTxt.setText(resultSet.getString("Address"));
                this.postcodeTxt.setText(resultSet.getString("Postcode"));
                this.emailTxt.setText(resultSet.getString("Email"));
                this.phonenumberTxt.setText(resultSet.getString("Phonenumber"));
                this.passwordTxt.setText(resultSet.getString("Password"));
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
    private void updateDetailsBtn(ActionEvent event) {
        String username = this.usernameTxt.getText();
        String firstname = this.firstnameTxt.getText();
        String lastname = this.lastnameTxt.getText();
        String address = this.addressTxt.getText();
        String postcode = this.postcodeTxt.getText();
        String phonenumber = this.phonenumberTxt.getText();
        String password = this.passwordTxt.getText();
        String email = this.emailTxt.getText();

        //Database Query to update employee details.
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            String updateUsername = "UPDATE employees SET Username = '" + username + "' WHERE Username = '" + this.usernameTxtID.getText() + "' AND Password = '" + this.passwordTxtID.getText() + "'";
            String updateFirstname = "UPDATE employees SET Firstname = '" + firstname + "' WHERE Username = '" + this.usernameTxtID.getText() + "' AND Password = '" + this.passwordTxtID.getText() + "'";
            String updateLastname = "UPDATE employees SET Lastname = '" + lastname + "' WHERE Username = '" + this.usernameTxtID.getText() + "' AND Password = '" + this.passwordTxtID.getText() + "'";
            String updateAddress = "UPDATE employees SET Address = '" + address + "' WHERE Username = '" + this.usernameTxtID.getText() + "' AND Password = '" + this.passwordTxtID.getText() + "'";
            String updatePostcode = "UPDATE employees SET Postcode = '" + postcode + "' WHERE Username = '" + this.usernameTxtID.getText() + "' AND Password = '" + this.passwordTxtID.getText() + "'";
            String updatePhoneNo = "UPDATE employees SET Phonenumber = '" + phonenumber + "' WHERE Username = '" + this.usernameTxtID.getText() + "' AND Password = '" + this.passwordTxtID.getText() + "'";
            String updateEmail = "UPDATE employees SET Email = '" + email + "' WHERE Username = '" + this.usernameTxtID.getText() + "' AND Password = '" + this.passwordTxtID.getText() + "'";
            String updatePassword = "UPDATE employees SET Password = '" + password + "' WHERE Username = '" + this.usernameTxtID.getText() + "' AND Password = '" + this.passwordTxtID.getText() + "'";

            ArrayList<String> queries = new ArrayList<>();
            queries.add(updateUsername);
            queries.add(updateFirstname);
            queries.add(updateLastname);
            queries.add(updateAddress);
            queries.add(updatePostcode);
            queries.add(updatePhoneNo);
            queries.add(updateEmail);
            queries.add(updatePassword);
            
            //Update details one at a time an then click on the update button to update the details.

            /*
             statement.executeUpdate(updateUsername);
             statement.executeUpdate(updateFirstname);
             statement.executeUpdate(updateLastname);
             statement.executeUpdate(updateAddress);
             statement.executeUpdate(updatePostcode);
             statement.executeUpdate(updatePhoneNo);
             statement.executeUpdate(updateEmail);
             statement.executeUpdate(updatePassword);
             */
            for (int counter = 0; counter < queries.size(); counter++) {
                System.out.println(queries.get(counter));
                statement.executeUpdate(queries.get(counter));
            }

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(BusinessInventorySystam.class.getName()).log(Level.SEVERE, null, ex);
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
