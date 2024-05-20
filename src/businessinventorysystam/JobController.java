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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JobController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private Font x1;
    @FXML
    private TextField jobIDTxt;
    @FXML
    private TextField jobNameTxt;
    @FXML
    private TextArea jobDescriptionTxt;
    @FXML
    private Button saveBtnID;
    @FXML
    private Button searchDeleteBtnID;
    @FXML
    private Button backBtnID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void saveBtn(ActionEvent event) {
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        String JobID = this.jobIDTxt.getText();
        String JobName = this.jobNameTxt.getText();
        String JobDescription = this.jobDescriptionTxt.getText();

        //Database Query to add jobs.
        try {

            statement = connection.createStatement();

            String addJobsQuery = "INSERT INTO jobrole (JobRoleID, JobRoleTitle, JobDescription) "
                    + "       VALUES ('" + JobID + "', '" + JobName + "', '" + JobDescription + "')";

            statement.executeUpdate(addJobsQuery);
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println("SQL Exception: Error");
            Logger.getLogger(BusinessInventorySystam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchDeleteBtn(ActionEvent event) throws IOException {
        Parent SearchDeleteJob = FXMLLoader.load(getClass().getResource("SearchDeleteJob.fxml"));
        Scene SearchDeleteJobScene = new Scene(SearchDeleteJob);
        Stage SearchDeleteJobStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SearchDeleteJobStage.setTitle("Search & Delete Job");
        SearchDeleteJobStage.hide();
        SearchDeleteJobStage.setScene(SearchDeleteJobScene);
        SearchDeleteJobStage.setHeight(340);
        SearchDeleteJobStage.setWidth(570);
        SearchDeleteJobStage.setResizable(false);
        SearchDeleteJobStage.show();
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
