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
import javafx.stage.Stage;

public class SearchDeleteJobController implements Initializable {
    
    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;
    
    @FXML
    private TextField searchJobTxt;
    @FXML
    private Button searchBtnID;
    @FXML
    private Label resultLbl;
    @FXML
    private Button backBtnID;
    @FXML
    private Button deleteBtnID;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void searchBtn(ActionEvent event) {
        String searchJob = this.searchJobTxt.getText();

        //Loading the data to the Product List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();
        
        try {
            statement = connection.createStatement();
            String searchJobs = "SELECT * FROM jobrole WHERE JobRoleID = '" + searchJob + "'";
            resultSet = statement.executeQuery(searchJobs);
            
            while (resultSet.next()) {
                String row = resultSet.getString("JobRoleID") + "\t" + resultSet.getString("JobRoleTitle") + "\t" + resultSet.getString("JobDescription");
                this.resultLbl.setText(row);
            }
            
            statement.close();
            resultSet.close();
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void backBtn(ActionEvent event) throws IOException {
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
    private void deleteBtn(ActionEvent event) {
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            connection = connectionClass.connectDB();
            statement = connection.createStatement();

            //Delete Query
            String deleteJob = this.searchJobTxt.getText();
            
            String deleteJobID = "DELETE FROM jobrole WHERE JobRoleID = '" + deleteJob + "'";
            String deleteJobName = "DELETE FROM jobrole WHERE JobRoleTitle = '" + deleteJob + "'";
            
            statement.executeUpdate(deleteJobID);
            statement.executeUpdate(deleteJobName);
            
            statement.close();
            connection.close();
            
        } catch (SQLException ex) {
            this.resultLbl.setText("Cannot Delete Employee Assigned - Please change employee details.");
            System.out.println("Cannot Delete Employee Assigned - Please change employee details.");
        }
    }
    
}
