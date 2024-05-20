package businessinventorysystam;

import SQLConnection.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OrderSystemController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private Font x1;
    @FXML
    private Font x2;
    @FXML
    private AnchorPane paneLayout;

    private DatePicker dp;
    private DatePicker cardIssueDateP;
    private DatePicker cardExpiryDateP;
    private ComboBox<String> productTypeID;
    @FXML
    private TextField productTypeNameID;
    @FXML
    private TextField productPerPricetxt;
    @FXML
    private TextField productQtyID;
    @FXML
    private TextField totalPriceID;
    @FXML
    private Button scanQRCodeID;
    @FXML
    private TextField productStatusIDtxt;
    @FXML
    private ComboBox<String> supplierTypeID;
    @FXML
    private TextField deliveryAddressTxt;
    @FXML
    private TextField postCodeTxt;
    @FXML
    private RadioButton businessPaymentID;
    @FXML
    private RadioButton othersPaymentID;
    @FXML
    private TextField cardNoTxt;
    @FXML
    private TextField securityNoTxt;
    @FXML
    private Button sendOrderBtn;
    @FXML
    private Button mainMenuBtn;
    @FXML
    private ComboBox<String> supplierNameID;
    @FXML
    private Label lblDeliveryDate;
    @FXML
    private Label lblOrderRes;
    @FXML
    private TextField productQtyAvaID;
    @FXML
    private TextArea productDescription;
    @FXML
    private TextField addProductID;
    @FXML
    private ComboBox<String> selectID;
    
    public static TextField postCodeT;

    public void loadSuppliersData() {
        //Loading the data to the Supplier List Table.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String listOfSuppliers = "SELECT * FROM suppliers";
            resultSet = statement.executeQuery(listOfSuppliers);

            while (resultSet.next()) {
                this.supplierTypeID.getItems().addAll(resultSet.getString("SupplierID"));
                this.supplierNameID.getItems().addAll(resultSet.getString("SupplierName"));
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadIDs() {
        //Loading the list of ids to the combo box.
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();
            String getIDs = "SELECT * FROM owners";
            resultSet = statement.executeQuery(getIDs);

            while (resultSet.next()) {
                this.selectID.getItems().addAll(resultSet.getString("OwnerID"));
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
        postCodeT = postCodeTxt;
        // Initialize the DatePicker for expected delivery date
        this.dp = new DatePicker();
        this.dp.setPromptText("Expected Delivery Date");
        this.dp.setLayoutX(658);
        this.dp.setLayoutY(200);

        this.cardIssueDateP = new DatePicker();
        this.cardIssueDateP.setPromptText("Card Issue Date");
        this.cardIssueDateP.setLayoutX(653);
        this.cardIssueDateP.setLayoutY(742);

        this.cardExpiryDateP = new DatePicker();
        this.cardExpiryDateP.setPromptText("Card Expiry Date");
        this.cardExpiryDateP.setLayoutX(993);
        this.cardExpiryDateP.setLayoutY(742);

        // Add DatePicker to layout
        this.paneLayout.getChildren().addAll(dp, cardIssueDateP, cardExpiryDateP);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.lblDeliveryDate.setText(formatter.format(date));

        //Radio Button for payments
        this.businessPaymentID.setOnAction((ActionEvent e) -> {
            if (businessPaymentID.isSelected()) {
                this.othersPaymentID.setSelected(false);
            } else if (!businessPaymentID.isSelected()) {
                businessPaymentID.setSelected(true);
            }
        });

        this.othersPaymentID.setOnAction((ActionEvent e) -> {
            if (othersPaymentID.isSelected()) {
                this.businessPaymentID.setSelected(false);
            } else if (!othersPaymentID.isSelected()) {
                othersPaymentID.setSelected(true);
            }
        });

        //Removing the exisiting items.
        this.supplierTypeID.getItems().remove("Item 1");
        this.supplierTypeID.getItems().remove("Item 2");
        this.supplierTypeID.getItems().remove("Item 3");
        this.supplierNameID.getItems().remove("Item 1");
        this.supplierNameID.getItems().remove("Item 2");
        this.supplierNameID.getItems().remove("Item 3");
        this.selectID.getItems().remove("Item 1");
        this.selectID.getItems().remove("Item 2");
        this.selectID.getItems().remove("Item 3");

        loadSuppliersData();
        loadIDs();

        this.productPerPricetxt.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                //Work out the total price.
                int price = Integer.parseInt(this.productPerPricetxt.getText());
                int qty = Integer.parseInt(this.productQtyID.getText());
                Integer totalPrice = price * qty;
                String TotalPrice = totalPrice.toString();
                this.totalPriceID.setText(TotalPrice);
                //System.out.println(TotalPrice);
            } catch (java.lang.NumberFormatException exp) {
                System.out.println("");
            }
        });

        this.productQtyID.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                //Work out the total price.
                int price = Integer.parseInt(this.productPerPricetxt.getText());
                int qty = Integer.parseInt(this.productQtyID.getText());
                Integer totalPrice = price * qty;
                String TotalPrice = totalPrice.toString();
                this.totalPriceID.setText(TotalPrice);
                //System.out.println(TotalPrice);
            } catch (java.lang.NumberFormatException exp) {
                System.out.println("");
            }
        });

        this.totalPriceID.setDisable(true);

    }

    @FXML
    private void scanQRCode(ActionEvent event) throws IOException {
        Parent scanQRCode = FXMLLoader.load(getClass().getResource("ScanQRProductCode.fxml"));
        Scene scanQRCodeScene = new Scene(scanQRCode);
        Stage scanQRCodeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scanQRCodeStage.setHeight(600);
        scanQRCodeStage.setWidth(334);
        scanQRCodeStage.setTitle("Scan QR Product Code");
        scanQRCodeStage.setScene(scanQRCodeScene);
        scanQRCodeStage.setResizable(false);
        scanQRCodeStage.show();
    }

    @FXML
    private void supplierType(ActionEvent event) {
    }

    @FXML
    private void businessPayment(ActionEvent event) {
    }

    @FXML
    private void othersPayment(ActionEvent event) {
    }

    //This is where the products are added to the system. 
    @FXML
    private void sendOrder(ActionEvent event) {
        ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        String productID = this.addProductID.getText();
        String productName = this.productTypeNameID.getText();
        String productPrice = this.productPerPricetxt.getText();
        String productQty = this.productQtyID.getText();
        String productDescription = this.productDescription.getText();
        String productStatus = this.productStatusIDtxt.getText();
        String productAvaQty = this.productQtyAvaID.getText();
        String supplierType = this.supplierTypeID.getValue();
        String supplierName = this.supplierNameID.getValue();
        String dateOrderedON = this.lblDeliveryDate.getText();
        LocalDate estimatedDeliveryDate = this.dp.getValue();
        String deliveryAddress = this.deliveryAddressTxt.getText();
        String postCode = this.postCodeTxt.getText();
        String cardIssueNumber = this.cardNoTxt.getText();
        String cardSecurityNumber = this.securityNoTxt.getText();
        LocalDate cardIssueDate = this.cardIssueDateP.getValue();
        LocalDate cardExpiryDate = this.cardExpiryDateP.getValue();
        String getOrderedByID = this.selectID.getValue();
        String TotalPrice = this.totalPriceID.getText();

        //Loading the data to the Supplier List Table.
        //ConnectionClass connectionClass = new ConnectionClass();
        connection = connectionClass.connectDB();

        try {
            statement = connection.createStatement();

            //Add Products Query
            String addProductOrder = "INSERT INTO products (ProductID, ProductName, ProductDescription, ProductPrice, ProductQty, ProductStatus, SupplierID) "
                    + "       VALUES ('" + productID + "', '" + productName + "', '" + productDescription + "', '" + productPrice + "', '" + productQty + "', '" + productStatus + "', '" + supplierType + "')";

            statement.executeUpdate(addProductOrder);
            statement.close();

            //Create Order Query
            statement = connection.createStatement();

            //Using the random class to generate an order id.
            long pairOne = (long) (Math.random() * 100000000000000L);
            long orderIDKey = 5200000000000000L + pairOne;

            String createOrder = "INSERT INTO orders (OrderID, OrderDate, OwnerID) "
                    + "        VALUES ('" + orderIDKey + "', '" + dateOrderedON + "', '" + getOrderedByID + "')";

            statement.executeUpdate(createOrder);
            statement.close();

            //Bill Issued Query
            statement = connection.createStatement();

            //Using the random class to generate an order id.
            long pairTwo = (long) (Math.random() * 100000000000000L);
            long billIDKey = 5200000000000000L + pairTwo;

            String BillPaid = "NULL";   //This value is empty for now will be updated once the bill is paid in the later sections of the software. 
            String billIssued = "INSERT INTO bill (BillID, BillIssueDate, BillPaidDate) "
                    + "        VALUES ('" + billIDKey + "', '" + dateOrderedON + "', '" + BillPaid + "')";

            statement.executeUpdate(billIssued);
            statement.close();

            //Order Details Query
            statement = connection.createStatement();

            //Using the random class to generate an order id.
            long pairThree = (long) (Math.random() * 100000000000000L);
            long orderDetailsIDKey = 5200000000000000L + pairThree;

            String orderDetails = "INSERT INTO orderdetails (OrderDetailsID, PricePerUnit, Qty, TotalPrice, OrderID, ProductID, BillID) "
                    + "        VALUES ('" + orderDetailsIDKey + "', '" + productPrice + "', '" + productQty + "', '" + TotalPrice + "', '" + orderIDKey + "', '" + productID + "', '" + billIDKey + "')";

            statement.executeUpdate(orderDetails);
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void mainMenuBtn(ActionEvent event) throws IOException {
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

    @FXML
    private void supplierName(ActionEvent event) {
    }

    public AnchorPane getPaneLayout() {
        return paneLayout;
    }

    public void setPaneLayout(AnchorPane paneLayout) {
        this.paneLayout = paneLayout;
    }

    public DatePicker getDp() {
        return dp;
    }

    public void setDp(DatePicker dp) {
        this.dp = dp;
    }

    public DatePicker getCardIssueDateP() {
        return cardIssueDateP;
    }

    public void setCardIssueDateP(DatePicker cardIssueDateP) {
        this.cardIssueDateP = cardIssueDateP;
    }

    public DatePicker getCardExpiryDateP() {
        return cardExpiryDateP;
    }

    public void setCardExpiryDateP(DatePicker cardExpiryDateP) {
        this.cardExpiryDateP = cardExpiryDateP;
    }

    public ComboBox<String> getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(ComboBox<String> productTypeID) {
        this.productTypeID = productTypeID;
    }

    public TextField getProductTypeNameID() {
        return productTypeNameID;
    }

    public void setProductTypeNameID(TextField productTypeNameID) {
        this.productTypeNameID = productTypeNameID;
    }

    public TextField getProductPerPricetxt() {
        return productPerPricetxt;
    }

    public void setProductPerPricetxt(TextField productPerPricetxt) {
        this.productPerPricetxt = productPerPricetxt;
    }

    public TextField getProductQtyID() {
        return productQtyID;
    }

    public void setProductQtyID(TextField productQtyID) {
        this.productQtyID = productQtyID;
    }

    public TextField getTotalPriceID() {
        return totalPriceID;
    }

    public void setTotalPriceID(TextField totalPriceID) {
        this.totalPriceID = totalPriceID;
    }

    public ComboBox<String> getSupplierTypeID() {
        return supplierTypeID;
    }

    public void setSupplierTypeID(ComboBox<String> supplierTypeID) {
        this.supplierTypeID = supplierTypeID;
    }

    public TextField getDeliveryAddressTxt() {
        return deliveryAddressTxt;
    }

    public void setDeliveryAddressTxt(TextField deliveryAddressTxt) {
        this.deliveryAddressTxt = deliveryAddressTxt;
    }

    public TextField getPostCodeTxt() {
        return postCodeTxt;
    }

    public void setPostCodeTxt(String postCodeTxt) {
        this.postCodeTxt.setText(postCodeTxt);
    }

    public RadioButton getBusinessPaymentID() {
        return businessPaymentID;
    }

    public void setBusinessPaymentID(RadioButton businessPaymentID) {
        this.businessPaymentID = businessPaymentID;
    }

    public RadioButton getOthersPaymentID() {
        return othersPaymentID;
    }

    public void setOthersPaymentID(RadioButton othersPaymentID) {
        this.othersPaymentID = othersPaymentID;
    }

    public TextField getCardNoTxt() {
        return cardNoTxt;
    }

    public void setCardNoTxt(TextField cardNoTxt) {
        this.cardNoTxt = cardNoTxt;
    }

    public Button getSendOrderBtn() {
        return sendOrderBtn;
    }

    public void setSendOrderBtn(Button sendOrderBtn) {
        this.sendOrderBtn = sendOrderBtn;
    }

    public Button getMainMenuBtn() {
        return mainMenuBtn;
    }

    public void setMainMenuBtn(Button mainMenuBtn) {
        this.mainMenuBtn = mainMenuBtn;
    }

    public ComboBox<String> getSupplierNameID() {
        return supplierNameID;
    }

    public void setSupplierNameID(ComboBox<String> supplierNameID) {
        this.supplierNameID = supplierNameID;
    }

    public Label getLblDeliveryDate() {
        return lblDeliveryDate;
    }

    public void setLblDeliveryDate(Label lblDeliveryDate) {
        this.lblDeliveryDate = lblDeliveryDate;
    }

    public Label getLblOrderRes() {
        return lblOrderRes;
    }

    public void setLblOrderRes(Label lblOrderRes) {
        this.lblOrderRes = lblOrderRes;
    }

    public TextField getProductQtyAvaID() {
        return productQtyAvaID;
    }

    public void setProductQtyAvaID(TextField productQtyAvaID) {
        this.productQtyAvaID = productQtyAvaID;
    }

    public TextArea getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(TextArea productDescription) {
        this.productDescription = productDescription;
    }

    public TextField getAddProductID() {
        return addProductID;
    }

    public void setAddProductID(TextField addProductID) {
        this.addProductID = addProductID;
    }

    public ComboBox<String> getSelectID() {
        return selectID;
    }

    public void setSelectID(ComboBox<String> selectID) {
        this.selectID = selectID;
    }

}
