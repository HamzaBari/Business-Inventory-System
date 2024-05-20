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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserAuthenticationController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private Font x1;
    @FXML
    private TextField txtFirstname;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPhonenumber;
    @FXML
    private TextField txtSetUsername;
    @FXML
    private TextField txtLastname;
    @FXML
    private TextField txtPostcode;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSetPassword;
    @FXML
    private Font x2;
    @FXML
    private TextField txtEnterUsername;
    @FXML
    private TextField txtEnterPassword;
    @FXML
    private Label LblErrFirstname;
    @FXML
    private Label LblErrAddress;
    @FXML
    private Label LblErrPhonenumber;
    @FXML
    private Label LblErrSetUsername;
    @FXML
    private Label LblErrLastname;
    @FXML
    private Label LblErrPostcode;
    @FXML
    private Label LblErrEmail;
    @FXML
    private Label LblErrSetPassword;
    @FXML
    private Label lblSuccessOrErrorMsgReg;
    @FXML
    private Label lblSuccessOrErrorMsgLgn;
    @FXML
    private TextField txtOwnerID;
    @FXML
    private Label lblErrOwnerID;
    @FXML
    private Label lblLoginSuccess;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickRegister(ActionEvent event) {
        //Register the user to the System.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        ArrayList<String> userData = new ArrayList<>();

        String firstname = this.txtFirstname.getText();
        String lastname = this.txtLastname.getText();
        String address = this.txtAddress.getText();
        String postcode = this.txtPostcode.getText();
        String phonenumber = this.txtPhonenumber.getText();
        String email = this.txtEmail.getText();
        String username = this.txtSetUsername.getText();
        String password = this.txtSetPassword.getText();
        String ownerID = this.txtOwnerID.getText();

        if (firstname.isEmpty()) {
            this.LblErrFirstname.setStyle("-fx-text-fill: red;");
            this.LblErrFirstname.setText("Missing Field");
        } else {
            userData.add(firstname);
            this.LblErrFirstname.setText("");
        }

        if (lastname.isEmpty()) {
            this.LblErrLastname.setStyle("-fx-text-fill: red;");
            this.LblErrLastname.setText("Missing Field");
        } else {
            userData.add(lastname);
            this.LblErrLastname.setText("");
        }

        if (address.isEmpty()) {
            this.LblErrAddress.setStyle("-fx-text-fill: red;");
            this.LblErrAddress.setText("Missing Field");
        } else {
            userData.add(address);
            this.LblErrAddress.setText("");
        }

        if (postcode.isEmpty()) {
            this.LblErrPostcode.setStyle("-fx-text-fill: red;");
            this.LblErrPostcode.setText("Missing Field");
        } else {
            userData.add(postcode);
            this.LblErrPostcode.setText("");
        }

        if (phonenumber.isEmpty()) {
            this.LblErrPhonenumber.setStyle("-fx-text-fill: red;");
            this.LblErrPhonenumber.setText("Missing Field");
        } else {
            userData.add(phonenumber);
            this.LblErrPhonenumber.setText("");
        }

        if (email.isEmpty()) {
            this.LblErrEmail.setStyle("-fx-text-fill: red;");
            this.LblErrEmail.setText("Missing Field");
        } else {
            userData.add(email);
            this.LblErrEmail.setText("");
        }

        if (username.isEmpty()) {
            this.LblErrSetUsername.setStyle("-fx-text-fill: red;");
            this.LblErrSetUsername.setText("Missing Field");
        } else {
            userData.add(username);
            this.LblErrSetUsername.setText("");
        }

        if (password.isEmpty()) {
            this.LblErrSetPassword.setStyle("-fx-text-fill: red;");
            this.LblErrSetPassword.setText("Missing Field");
        } else {
            userData.add(password);
            this.LblErrSetPassword.setText("");
        }

        if (ownerID.isEmpty()) {
            this.lblErrOwnerID.setStyle("-fx-text-fill: red;");
            this.lblErrOwnerID.setText("Missing Field");
        } else {
            userData.add(ownerID);
            this.LblErrSetPassword.setText("");
        }

        if (userData.size() == 9) {
            String fn = userData.get(0);
            String ln = userData.get(1);
            String adr = userData.get(2);
            String pc = userData.get(3);
            String pn = userData.get(4);
            String el = userData.get(5);
            String un = userData.get(6);
            String pw = userData.get(7);
            String oi = userData.get(8);

            //Database Query to register owners.
            try {

                if (oi.startsWith("O")) {
                    statement = connection.createStatement();

                    //Add Owner
                    String registerUserQuery = "INSERT INTO owners (OwnerID, Firstname, Lastname, Address, Postcode, Phonenumber, Email, Username, Password, JobRoleID) "
                            + "       VALUES ('" + oi + "', '" + fn + "', '" + ln + "', '" + adr + "', '" + pc + "', '" + pn + "', '" + el + "', '" + un + "', '" + pw + "', '" + "JB01" + "')";

                    statement.executeUpdate(registerUserQuery);
                    statement.close();

                } else if (oi.startsWith("E")) {
                    statement = connection.createStatement();
                    //Add Employee
                    int salary = 0;
                    //JB00 is just set as defualt for the employees which will be chnaged when the employee gets assiged to it's actual job e.g., manager position e.g., JB03 - Store/Onsite Manager.
                    String registerUserEmployeeQuery = "INSERT INTO employees (EmployeeID, Firstname, Lastname, Address, Postcode, Phonenumber, Email, MonthlySalary, Username, Password, JobRoleID) "
                            + "       VALUES ('" + oi + "', '" + fn + "', '" + ln + "', '" + adr + "', '" + pc + "', '" + pn + "', '" + el + "', '" + salary + "', '" + un + "', '" + pw + "', '" + "JB00" + "')";

                    statement.executeUpdate(registerUserEmployeeQuery);
                    statement.close();
                }

                connection.close();
                userData.clear();

            } catch (SQLException ex) {
                Logger.getLogger(BusinessInventorySystam.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.lblSuccessOrErrorMsgReg.setStyle("-fx-text-fill: green;");
            this.lblSuccessOrErrorMsgReg.setText("Account Registered");

        } else {
            this.lblSuccessOrErrorMsgReg.setStyle("-fx-text-fill: red;");
            this.lblSuccessOrErrorMsgReg.setText("Account Not Registered Fields Missing");
            userData.clear();
        }

    }

    @FXML
    private void clickLogin(ActionEvent event) throws IOException, InterruptedException {
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        //Database Query User Login.
        String username = this.txtEnterUsername.getText();
        String password = this.txtEnterPassword.getText();

        if (username.equals("") && password.equals("")) {
            this.lblSuccessOrErrorMsgLgn.setStyle("-fx-text-fill: red;");
            this.lblSuccessOrErrorMsgLgn.setText("Incorrect Username or Password");
        } else {

            //Database Query to register owners.
            try {

                preparedStatement = connection.prepareStatement("SELECT * FROM owners WHERE Username = ? AND Password = ?");
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {

                    try {
                        this.lblLoginSuccess.setStyle("-fx-text-fill: green;");
                        this.lblLoginSuccess.setText("Login Successful - Wait 3 seconds to be redirected!");
                        System.out.println("Login Successful - Wait 3 seconds to be redirected!");
                        statement = connection.createStatement();
                        String userType = "Owner";
                        String userQuery = "UPDATE loggedinusr SET UserType = '" + userType + "' WHERE LoginID = 'L001'";
                        statement.executeUpdate(userQuery);
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                    //Check the data validation to see if the user, is registered or not, and also if the user's password is correct or not.
                    Parent mainMenu = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                    Scene mainMenuScene = new Scene(mainMenu);
                    Stage mainMenustage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    mainMenustage.setTitle("Main Menu");
                    mainMenustage.hide();
                    mainMenustage.setScene(mainMenuScene);
                    mainMenustage.setHeight(544.8);
                    mainMenustage.setWidth(727);
                    mainMenustage.setResizable(false);
                    mainMenustage.show();

                } else {
                    this.lblSuccessOrErrorMsgLgn.setStyle("-fx-text-fill: red;");
                    this.lblSuccessOrErrorMsgLgn.setText("Incorrect Username or Password");
                    this.txtEnterUsername.clear();
                    this.txtEnterPassword.clear();
                    this.txtEnterUsername.requestFocus();
                }

                preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE Username = ? AND Password = ?");
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {

                    try {
                        this.lblLoginSuccess.setStyle("-fx-text-fill: green;");
                        this.lblLoginSuccess.setText("Login Successful - Wait 3 seconds to be redirected!");
                        System.out.println("Login Successful - Wait 3 seconds to be redirected!");
                        statement = connection.createStatement();
                        String userType = "Employee";
                        String userQuery = "UPDATE loggedinusr SET UserType = '" + userType + "' WHERE LoginID = 'L001'";
                        statement.executeUpdate(userQuery);
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                    //Check the data validation to see if the user, is registered or not, and also if the user's password is correct or not.
                    Parent mainMenu = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                    Scene mainMenuScene = new Scene(mainMenu);
                    Stage mainMenustage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    mainMenustage.setTitle("Main Menu");
                    mainMenustage.hide();
                    mainMenustage.setScene(mainMenuScene);
                    mainMenustage.setHeight(544.8);
                    mainMenustage.setWidth(727);
                    mainMenustage.setResizable(false);
                    mainMenustage.show();

                } else {
                    this.lblSuccessOrErrorMsgLgn.setStyle("-fx-text-fill: red;");
                    this.lblSuccessOrErrorMsgLgn.setText("Incorrect Username or Password");
                    this.txtEnterUsername.clear();
                    this.txtEnterPassword.clear();
                    this.txtEnterUsername.requestFocus();
                }

                statement.close();
                preparedStatement.close();
                resultSet.close();
                connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(BusinessInventorySystam.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void txtOwner(ActionEvent event) {
    }

}
