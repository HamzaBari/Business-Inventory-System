package businessinventorysystam;

import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicReference;
import com.github.sarxos.webcam.Webcam;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import SQLConnection.ConnectionClass;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScanQRProductCodeController implements Initializable {

    public Statement statement;
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    @FXML
    private Button scanButtonID;
    @FXML
    private Font x1;
    @FXML
    private Button exitBtnID;
    @FXML
    private ProgressIndicator loadID;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label resultID;
    @FXML
    private BorderPane CameraPane;

    private ImageView imgWebCamCapturedImage;
    private Webcam webCam = null;
    private boolean stopCamera = false;
    private final ObjectProperty<Image> imageProperty = new SimpleObjectProperty<>();
    @FXML
    private Label lodingLBL;

    public static ArrayList<String> list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgWebCamCapturedImage = new ImageView();
        this.CameraPane.setCenter(imgWebCamCapturedImage);
        //initializeWebCam();
        Platform.runLater(() -> this.setImageViewSize());
    }

    protected void setImageViewSize() {
        imgWebCamCapturedImage.setFitHeight(200);
        imgWebCamCapturedImage.setFitWidth(200);
        imgWebCamCapturedImage.prefHeight(200);
        imgWebCamCapturedImage.prefWidth(200);
        imgWebCamCapturedImage.setPreserveRatio(true);
    }

    protected void initializeWebCam() {

        Task<Void> webCamTask = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                webCam = Webcam.getWebcams().get(0);
                webCam.open();

                startWebCamStream();

                return null;
            }
        };

        Thread webCamThread = new Thread(webCamTask);
        webCamThread.setDaemon(true);
        webCamThread.start();

    }

    protected void startWebCamStream() {
        stopCamera = false;
        list = new ArrayList<>();

        Task<Void> task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {

                final AtomicReference<WritableImage> ref = new AtomicReference<>();
                Result result = null;
                BufferedImage img = null;

                while (!stopCamera) {
                    try {
                        if ((img = webCam.getImage()) != null) {

                            ref.set(SwingFXUtils.toFXImage(img, ref.get()));
                            img.flush();

                            Platform.runLater(() -> {
                                imageProperty.set(ref.get());
                            });
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    LuminanceSource source = new BufferedImageLuminanceSource(img);
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                    try {
                        result = new MultiFormatReader().decode(bitmap);
                    } catch (NotFoundException e) {
                        //Keep Empty
                    }

                    if (result != null) {
                        //System.out.println("Found: " + result.getText());
                        //System.out.println(result.getText());

                        StringTokenizer tokenizer = new StringTokenizer(result.getText(), ",");
                        while (tokenizer.hasMoreTokens()) {
                            String newline = tokenizer.nextToken();
                            list.add(newline);
                        }

                        //Add Products Query.
                        String ProductID = list.get(0);
                        String ProductName = list.get(1);
                        String ProductDescription = list.get(2);
                        String ProductPrice = list.get(3);
                        String ProductStatus = list.get(4);
                        String ProductTQty = list.get(5);
                        String SupplierID = list.get(6);
                        String OwnerID = list.get(7);

                        long pairOne = (long) (Math.random() * 100000000000000L);
                        long orderID = 5200000000000000L + pairOne;

                        long pairTwo = (long) (Math.random() * 100000000000000L);
                        long billID = 5200000000000000L + pairTwo;

                        long pairThree = (long) (Math.random() * 100000000000000L);
                        long orderDetailsID = 5200000000000000L + pairThree;

                        String BillPaid = "NULL";

                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = new Date();
                        String orderDate = formatter.format(date);

                        ConnectionClass connectionClass = new ConnectionClass();
                        connection = connectionClass.connectDB();

                        try {
                            statement = connection.createStatement();

                            //Add Products Query
                            String addProducts = "INSERT INTO qrcodescan (ProductID, ProductName, ProductDescription, ProductPrice, ProductStatus, ProductQty, SupplierID) "
                                    + "       VALUES ('" + ProductID + "', '" + ProductName + "', '" + ProductDescription + "', '" + ProductPrice + "', '" + ProductTQty + "', '" + ProductStatus + "', '" + SupplierID + "')";

                            statement.executeUpdate(addProducts);
                            statement.close();

                            statement = connection.createStatement();

                            String createOrder = "INSERT INTO qrcodeorder (OrderID, OrderDate, OwnerID) "
                                    + "        VALUES ('" + orderID + "', '" + orderDate + "', '" + OwnerID + "')";

                            statement.executeUpdate(createOrder);
                            statement.close();

                            statement = connection.createStatement();

                            String billIssued = "INSERT INTO qrcodebill (BillID, BillIssueDate, BillPaidDate) "
                                    + "        VALUES ('" + billID + "', '" + orderDate + "', '" + BillPaid + "')";

                            statement.executeUpdate(billIssued);
                            statement.close();

                            statement = connection.createStatement();

                            String orderDetails = "INSERT INTO qrcodeorderdetails (OrderDetailsID, PricePerUnit, Qty, TotalPrice, OrderID, ProductID, BillID) "
                                    + "        VALUES ('" + orderDetailsID + "', '" + ProductPrice + "', '" + ProductTQty + "', '" + ProductPrice + "', '" + orderID + "', '" + ProductID + "', '" + billID + "')";

                            statement.executeUpdate(orderDetails);
                            statement.close();

                            System.out.println("Product Added Successfully");

                            connection.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    }
                }
                return null;
            }
        };
        Thread th = new Thread(task);

        th.setDaemon(
                true);
        th.start();

        imgWebCamCapturedImage.imageProperty()
                .bind(imageProperty);
    }

    public void getResult(String s) {
        this.resultID.setText(s);
    }

    @FXML
    private void scanBtn(ActionEvent event) {

        Timeline timeline = new Timeline();
        if ("Scan".equals(this.scanButtonID.getText())) {
            timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(this.loadID.progressProperty(), 0)),
                    new KeyFrame(Duration.seconds(5), e -> {
                        //Executed on the completion.
                        this.lodingLBL.setText("Loaded");
                        this.loadID.setVisible(false);
                        initializeWebCam();
                        this.scanButtonID.setText("Stop");
                    }, new KeyValue(this.loadID.progressProperty(), 1))
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        } else if ("Stop".equals(this.scanButtonID.getText())) {
            stopCamera = true;
            webCam.close();
            this.scanButtonID.setText("Scan");
        }

    }

    @FXML
    private void exitBtn(ActionEvent event) throws IOException {
        Parent OrderSystem = FXMLLoader.load(getClass().getResource("OrderSystem.fxml"));
        Scene OrderSystemScene = new Scene(OrderSystem);
        Stage OrderSystemStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        OrderSystemStage.setTitle("Order System");
        OrderSystemStage.setScene(OrderSystemScene);
        OrderSystemStage.setHeight(996);
        OrderSystemStage.setWidth(1350);
        OrderSystemStage.setResizable(false);
    }

    @FXML
    private void load(MouseEvent event) {
    }

}
