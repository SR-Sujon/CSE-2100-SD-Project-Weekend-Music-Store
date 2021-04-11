package Controller;

import Utils.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Product;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.sql.Date;
/**
 * FXML Controller class
 *
 * @author Raiyan
 */
public class PaymentController implements Initializable {

    @FXML
    private Label productNameLabel3;
    @FXML
    private Label unitPriceLabel;
    @FXML
    private Label subTotalLabel;
    @FXML
    private DatePicker expiryDate;
    @FXML
    private Button checkOutButton;
    @FXML
    private Button goBackButton2;
    @FXML
    private Label pidLabel2;
    @FXML
    private ImageView finalImg;
    @FXML
    private ChoiceBox<String> quantityChoiceBox;
    
    ObservableList ChoiceBoxlist = FXCollections.observableArrayList();
    @FXML
    private Button setButton;
    @FXML
    private TextField paymentCardNo;
    @FXML
    private PasswordField paymentPin;
    @FXML
    private Label lblUserName;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private TextField cardHoldersName;
    
   public void setUsernameLabel(String lbl){
        lblUserName.setText(lbl);
    }
    
    public void paymentInfo(String pid, String name, double unitPrice, Image image) {
        pidLabel2.setText(pid);
        productNameLabel3.setText(name);
        unitPriceLabel.setText(Double.toString(unitPrice));
        finalImg.setImage(image);
    }
    
    

    @FXML
    private void checkOutButtonAction(ActionEvent event) {
        try {
            Insert();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goBackButton2Action(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void loadQuantityChoiceBox() {
        ChoiceBoxlist.removeAll(ChoiceBoxlist);
        String a = "1";
        String b = "2";
        String c = "3";
        String d = "4";
        String e = "5";
        String f = "6";
        String g = "7";
        String h = "8";
        String i = "9";
        String j = "10";
        
        ChoiceBoxlist.addAll(a,b,c,d,e,f,g,h,i,j);
        quantityChoiceBox.getItems().addAll(ChoiceBoxlist);
        //subTotalView();
    }
    
    public void subTotalView(){
                String quantity = quantityChoiceBox.getValue();
                DecimalFormat df2 = new DecimalFormat("#.##");
                df2.setRoundingMode(RoundingMode.UP);
                double q = Double.parseDouble(quantity);
                double unitPrice = Double.parseDouble(unitPriceLabel.getText());

                double subTotal = q*unitPrice;
                String ST = df2.format(subTotal);
                subTotalLabel.setText(ST);
    }

    @Override
        public void initialize(URL url, ResourceBundle rb) {
        // TODO
       loadQuantityChoiceBox();
       
    }

    @FXML
    private void setButtonAction(ActionEvent event) {

            subTotalView();

    }
        
    private void Insert() throws SQLException{
        String pid = pidLabel2.getText();
        String pname = productNameLabel3.getText();
        String quantity = quantityChoiceBox.getValue();
        String username = lblUserName.getText();
        String cardHName = cardHoldersName.getText();
        String cardNo = paymentCardNo.getText();
        String date = String.valueOf(expiryDate.getValue());
        String pin = paymentPin.getText();
        String amount = subTotalLabel.getText();
       
        if(cardNo.isEmpty() || pin.isEmpty() || subTotalLabel.getText().equals("00.00")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Input feilds cannot be empty!\nPlease, fill up all.");
            alert.setTitle("Error");
            alert.showAndWait();
        }
        else {
            
        query = "INSERT INTO `payment`(`pid`, `pname`, `quantity`, `user_name`,`cardholder`, `cardnumber`,`expirydate`, `pin`, `amount`) VALUES (?,?,?,?,?,?,?,?,?)";
        connection = DBConnection.DBcon();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, pid);
        preparedStatement.setString(2, pname);
        preparedStatement.setString(3, quantity);
        preparedStatement.setString(4, username);
        preparedStatement.setString(5, cardHName);
        preparedStatement.setString(6, cardNo);
        preparedStatement.setString(7, date);
        preparedStatement.setString(8, pin);
        preparedStatement.setString(9, amount);
        preparedStatement.executeUpdate();
        
        
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setHeaderText(null);
       alert.setTitle("Successful!");
       alert.setContentText("Payment Successful!\nYour shipping will arrive in 3-4 working Days. Thank You for purchasing from WMS!\n\nTo get free shipping, order over 3 products adding $20!");
       alert.showAndWait();
       
    }
        
    }

}
