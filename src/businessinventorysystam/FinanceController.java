
package businessinventorysystam;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FinanceController implements Initializable {
    @FXML
    private Font x2;
    @FXML
    private Font x1;
    @FXML
    private Label BusinessBudgetLeftThisMonthLbl;
    @FXML
    private Label BusinessBudgetLeftLbl;
    @FXML
    private ProgressBar businessBudgetAnalyserBar;
    @FXML
    private Label businessBudgetAnalyserPercentageLbl;
    @FXML
    private Button downalodReportBusinessAccBtnID;
    @FXML
    private Label netIncomeMonthlyLbl;
    @FXML
    private ProgressBar incomeBar;
    @FXML
    private ProgressBar lossBar;
    @FXML
    private Label incomeUsedLbl;
    @FXML
    private Label lossUsedLbl;
    @FXML
    private Button profitLossDownloadReportBtnID;
    @FXML
    private PieChart expensesPieChart;
    @FXML
    private Button expensesDownloadReportBtnID;
    @FXML
    private ListView<?> expensesListView;
    @FXML
    private Button balanceDownloadFullReportBtnID;
    @FXML
    private Label balanceTotalCurrentAssetsLbl;
    @FXML
    private Label balanceTotalNonCurrentAssetsLbl;
    @FXML
    private Label balanceTotalAssetsLbl;
    @FXML
    private Label totalCurrentLiabLbl;
    @FXML
    private Label totalNonCurrentLiabLbl;
    @FXML
    private Label totalLiabLbl;
    @FXML
    private Label ownerCapitalLbl;
    @FXML
    private Label salesEarningLbl;
    @FXML
    private Label totalMoneyMadeLbl;
    @FXML
    private LineChart<?, ?> salesLineGraph;
    @FXML
    private Label salesMadeLbl;
    @FXML
    private Button downloadSalesReportBtnID;
    @FXML
    private ListView<?> cashInflowListView;
    @FXML
    private ListView<?> cashOutflowListView;
    @FXML
    private Button cashFlowDownloadReportBtnID;
    @FXML
    private Label endCashBalanceID;
    @FXML
    private Button backBtnID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void downalodReportBusinessAccBtn(ActionEvent event) throws IOException {
        Parent BusinessAccountReport = FXMLLoader.load(getClass().getResource("BusinessAccountViewFullReport.fxml"));
        Scene BusinessAccountReportScene = new Scene(BusinessAccountReport);
        Stage BusinessAccountReportStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        BusinessAccountReportStage.setTitle("View Full Report");
        BusinessAccountReportStage.hide();
        BusinessAccountReportStage.setScene(BusinessAccountReportScene);
        BusinessAccountReportStage.setHeight(860);
        BusinessAccountReportStage.setWidth(770);
        BusinessAccountReportStage.setResizable(false);
        BusinessAccountReportStage.show();
    }

    @FXML
    private void profitLossDownloadReportBtn(ActionEvent event) throws IOException {
        Parent ProfitLossReport = FXMLLoader.load(getClass().getResource("ProfitLossReport.fxml"));
        Scene ProfitLossReportScene = new Scene(ProfitLossReport);
        Stage ProfitLossReportStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ProfitLossReportStage.setTitle("View Full Report");
        ProfitLossReportStage.hide();
        ProfitLossReportStage.setScene(ProfitLossReportScene);
        ProfitLossReportStage.setHeight(860);
        ProfitLossReportStage.setWidth(770);
        ProfitLossReportStage.setResizable(false);
        ProfitLossReportStage.show();
    }

    @FXML
    private void expensesDownloadReportBtn(ActionEvent event) throws IOException {
        Parent ExpensesReport = FXMLLoader.load(getClass().getResource("ExpensesReport.fxml"));
        Scene ExpensesReportScene = new Scene(ExpensesReport);
        Stage ExpensesReportStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ExpensesReportStage.setTitle("View Full Report");
        ExpensesReportStage.hide();
        ExpensesReportStage.setScene(ExpensesReportScene);
        ExpensesReportStage.setHeight(860);
        ExpensesReportStage.setWidth(770);
        ExpensesReportStage.setResizable(false);
        ExpensesReportStage.show();
    }

    @FXML
    private void balanceDownloadFullReportBtn(ActionEvent event) throws IOException {
        Parent BalanceReport = FXMLLoader.load(getClass().getResource("BalanceReport.fxml"));
        Scene BalanceReportScene = new Scene(BalanceReport);
        Stage BalanceReportStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        BalanceReportStage.setTitle("View Full Report");
        BalanceReportStage.hide();
        BalanceReportStage.setScene(BalanceReportScene);
        BalanceReportStage.setHeight(860);
        BalanceReportStage.setWidth(770);
        BalanceReportStage.setResizable(false);
        BalanceReportStage.show();
    }

    @FXML
    private void downloadSalesReportBtn(ActionEvent event) throws IOException {
        Parent SalesReport = FXMLLoader.load(getClass().getResource("SalesReport.fxml"));
        Scene SalesReportScene = new Scene(SalesReport);
        Stage SalesReportStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SalesReportStage.setTitle("View Full Report");
        SalesReportStage.hide();
        SalesReportStage.setScene(SalesReportScene);
        SalesReportStage.setHeight(860);
        SalesReportStage.setWidth(770);
        SalesReportStage.setResizable(false);
        SalesReportStage.show();
    }

    @FXML
    private void cashFlowDownloadReportBtn(ActionEvent event) throws IOException {
        Parent CashFlowReport = FXMLLoader.load(getClass().getResource("CashFlowReport.fxml"));
        Scene CashFlowReportScene = new Scene(CashFlowReport);
        Stage CashFlowReportStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        CashFlowReportStage.setTitle("View Full Report");
        CashFlowReportStage.hide();
        CashFlowReportStage.setScene(CashFlowReportScene);
        CashFlowReportStage.setHeight(860);
        CashFlowReportStage.setWidth(770);
        CashFlowReportStage.setResizable(false);
        CashFlowReportStage.show();
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
