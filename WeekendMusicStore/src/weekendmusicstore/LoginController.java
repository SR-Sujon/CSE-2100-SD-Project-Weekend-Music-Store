/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weekendmusicstore;

import Controller.MarketController;
import Utils.DBConnection;
import Utils.sendOTP;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import java.util.regex.Pattern;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.util.Duration;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.mail.MessagingException;
/**
 * FXML Controller class
 *
 * @author Sujon
 */
public class LoginController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TabPane tabPaneLogin;
    @FXML
    private Tab TabSignIn;
    @FXML
    private Button btnSignIn;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblLogInError;
    @FXML
    private Tab TabSignUp;
    @FXML
    private TextField NewTxtEmail_ID;
    @FXML
    private TextField NewTxtUsername;
    @FXML
    private PasswordField NewTxtPassword;
    @FXML
    private Button btnSignUp;
    @FXML
    private Label lblCreateAccount;
    @FXML
    private Pane slidingPane;
    @FXML
    private Label lblSignIn;
    @FXML
    private Label lblSignUp;
    @FXML
    private Label lblStatus;
    @FXML
    private Label signInError;
    @FXML
    private Label InvalidEmail;
    @FXML
    private Label InvalidUsername;
    @FXML
    private Label InvalidPassword;
    @FXML
    private TextField txtAddress;
    
    String query;
    private Stage stage;
    private Scene scene;
    private Parent root;
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private TextField lblFirstName;
    @FXML
    private TextField lblSecondName;
    @FXML
    private TextField lblMobileNo;
    @FXML
    private TextField lblVerifyMobile;
    private Button btnSendOTP;
    @FXML
    private Label lblForgotPassword;
    @FXML
    private Tab tabOTP;
    @FXML
    private TextField lblVerifyEmail;
    @FXML
    private Button btnVerify;
    @FXML
    private Tab tabReset;
    @FXML
    private TextField lblNewPassword;
    @FXML
    private TextField lblConfirmPassword;
    @FXML
    private Button btnPassReset;
    @FXML
    private Label lblResetPassNotMatch;

    /**
     * Initialise the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public LoginController() throws SQLException {
        con = DBConnection.DBcon();
    }
    @FXML
    private void openCreateAccountScene(MouseEvent event) {
        OpenSignUpTab();
    }

    @FXML
    private void OpenSignInTab(MouseEvent event) {
        TranslateTransition toLeftAnimation = new TranslateTransition(new Duration(500), lblStatus);
        toLeftAnimation.setToX(slidingPane.getTranslateX());
        toLeftAnimation.play();
        toLeftAnimation.setOnFinished((ActionEvent event2) -> {
            lblStatus.setText("SIGN IN");
        });
        tabPaneLogin.getSelectionModel().select(TabSignIn);
    }

    @FXML
    private void OpenSignUpTab(MouseEvent event){
        OpenSignUpTab();
    }
    private void OpenSignUpTab() {
        //slide lable left to right

        TranslateTransition toRightAnimation = new TranslateTransition(new Duration(500), lblStatus);
        toRightAnimation.setToX(slidingPane.getTranslateX() + slidingPane.getPrefWidth() - lblStatus.getPrefWidth());
        toRightAnimation.play();
        toRightAnimation.setOnFinished((ActionEvent event1) -> {
            lblStatus.setText("SIGN UP");
        });
        tabPaneLogin.getSelectionModel().select(TabSignUp);
    }
    
        @FXML
    private void OpenOTPtab(MouseEvent event) {
        tabPaneLogin.getSelectionModel().select(tabOTP);
    }
    
    private String CheckIfUsernameTaken() throws SQLException{
        String newusername = NewTxtUsername.getText();
        query = "SELECT COUNT(`username`) as CS FROM `users` WHERE `username` = ?";
       
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, newusername);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
             int Count = resultSet.getInt("CS");
             if(Count!=0)
                 return "UserName_Is_taken!";
        }
        return "UserName_is_Empty";
    }
    
    
    
    @FXML
    private void handleButtons(MouseEvent event) throws SQLException, IOException, MessagingException {
        if (event.getSource() == btnSignIn) {
            //ADMIN LOGIN
            if (logIn().equals("SuccessAdmin")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Admin/AdminPage.fxml"));
                loader.load();
               
                AdminPageController apc = loader.getController();
                apc.setUsernameLabel(txtUsername.getText());
                
                Parent parent = loader.getRoot();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Admin Panel");
                stage.setX(0);
                stage.setY(0);
                stage.show();                          
                
            }
            //USER LOGIN
            else if(logIn().equals("SuccessUser")){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/views/market.fxml"));
                loader.load();
               
                MarketController mac = loader.getController();
                mac.setUsernameLabel(txtUsername.getText());
                
                Parent parent = loader.getRoot();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Home Panel");
                stage.setX(0);
                stage.setY(0);
                stage.show();
            }
        } else if (event.getSource() == btnSignUp) {
            //SIGN UP HERE
            String check = CheckIfUsernameTaken();
            if(check.equals("UserName_Is_taken!")){
                       Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setHeaderText(null);
                        alert.setTitle("Information!");
                        alert.setContentText("This username is taken.\nPlease, try a new username.!");
                        alert.setX(750);
                        alert.setY(350);
                        alert.showAndWait();
            }
            else if(check.equals("UserName_is_Empty")){
                SignUp();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Sign Up Successful!");
                        alert.setContentText("Now, please, SIGN IN with your new account.");
                        alert.setX(750);
                        alert.setY(350);
                        alert.showAndWait();
            }
            

        }
        else if(event.getSource() == btnVerify){
                VerifyQuery();
        }
        else if(event.getSource()== btnPassReset){
                ResetPassword();
        }
    }


    public void ResetPassword() throws SQLException{
        String email = lblVerifyEmail.getText();
        String mobile = lblVerifyMobile.getText();
        String newPass = lblNewPassword.getText();
        String confirmPass = lblConfirmPassword.getText();
        
        if(newPass.equals(confirmPass)){
            lblResetPassNotMatch.setText("");
            
            
            query = "UPDATE `users` SET `password`= ? WHERE `users`.`email` = ? AND `users`.`mobile` = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, newPass);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, mobile);
            preparedStatement.execute();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Reset Successful");
            alert.setContentText("Password is updated Successfully!");
            alert.setX(750);
            alert.setY(350);
            alert.showAndWait();
            
            tabPaneLogin.getSelectionModel().select(TabSignIn);
            
        }else{
            lblResetPassNotMatch.setText("Passwords don't match. Try Again!");
        }
    }
    
    public void VerifyQuery() throws SQLException{
        String email = lblVerifyEmail.getText();
        String mobile = lblVerifyMobile.getText();
        
        query = "SELECT * FROM users WHERE email = ? AND mobile = ?";
        
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, mobile);
                resultSet = preparedStatement.executeQuery();
                
                if(resultSet.next()){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Found!");
                        alert.setContentText("Identity verified!\nPlease, Reset your password.");
                        alert.setX(750);
                        alert.setY(350);
                        alert.showAndWait();
                        
                        tabPaneLogin.getSelectionModel().select(tabReset);
                        
                } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Not Found!");
                        alert.setContentText("Email and Mobile no. don't match.\nVerification failed!");
                        alert.setX(750);
                        alert.setY(350);
                        alert.showAndWait();
                }
    }

    private String logIn() {

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        //QUERY 
        String sqlAdmin = "SELECT * FROM admins WHERE email = ? AND password = ? OR username = ? AND password = ?";
        String sqlUser = "SELECT * FROM users WHERE email = ? AND password = ? OR username = ? AND password = ?";
        String who = null;

        try {
            for (int i = 1; i <= 2; i++) {
                // i = 1 : Query Admin Table
                // i = 2 : Query User Table
                if (i == 1) {
                    who = sqlAdmin;
                } else if (i == 2) {
                    who = sqlUser;
                }

                preparedStatement = con.prepareStatement(who);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, username);
                preparedStatement.setString(4, password);
                resultSet = preparedStatement.executeQuery();

                // Check whether it exists on Admin Table
                if (i == 1 && !resultSet.next()) {
                    // Not Found on Admin Table. Go -> User Table
                    continue;
                } else if (i == 1) { // Found on Admin Table
                    lblLogInError.setTextFill(Color.GREEN);
                    lblLogInError.setText("Sign In successful!");
                    return "SuccessAdmin";

                } else if (i == 2 && !resultSet.next()) { //Not Found on Admin table nor users
                    lblLogInError.setTextFill(Color.TOMATO);
                    lblLogInError.setText("Invalid username or password!");
                    return "Error";

                } else if (i == 2) { // Found on User Table
                    lblLogInError.setTextFill(Color.GREEN);
                    lblLogInError.setText("Sign In successful!");
                    return "SuccessUser";
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void SignUp() {
        String mobileNo = lblMobileNo.getText();
        String newemail = NewTxtEmail_ID.getText();
        String newusername = NewTxtUsername.getText();
        String newpassword = NewTxtPassword.getText();
        String address = txtAddress.getText();
        
        if(mobileNo.isEmpty() || newemail.isEmpty() || newusername.isEmpty() || newpassword.isEmpty() || address.isEmpty()){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("ERROR!");
                        alert.setContentText("Please, fill up all fields!");
                        alert.setX(750);
                        alert.setY(350);
                        alert.showAndWait();
                        return;
        }
        
        //Insert 
        String sqlInsert = "INSERT INTO `users`(`email`, `username`, `password`, `address`, `mobile`) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sqlInsert);
            preparedStatement.setString(1, newemail);
            preparedStatement.setString(2, newusername);
            preparedStatement.setString(3, newpassword);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, mobileNo);
            preparedStatement.executeUpdate();

            signInError.setTextFill(Color.GREEN);
            signInError.setText("Sign Up successful!");

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void emailValidation() {
        String ne = NewTxtEmail_ID.getText();

        String PATTERN = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(ne);
        if (!match.matches()) {
            InvalidEmail.setTextFill(Color.RED);
            InvalidEmail.setText("Invalid Email");
        } else {
            InvalidEmail.setText(null);
        }

    }

    @FXML
    public void usernameValidation() {

        String nu = NewTxtUsername.getText();

        String PATTERN = "^[a-zA-Z0-9_-]{5,16}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(nu);
        if (!match.matches()) {
            InvalidUsername.setTextFill(Color.RED);
            InvalidUsername.setText("*Username must be 6-16 characters long!");
        } else {
            InvalidUsername.setText(null);
        }

    }

    @FXML
    public void passwordValidation() {
        String np = NewTxtPassword.getText();

        String PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(np);
        if (!match.matches()) {
            InvalidPassword.setTextFill(Color.RED);
            InvalidPassword.setText("*Password length must be 8-16 mix of\ndigits & letters,can contain $/!/_/-");
        } else {
            InvalidPassword.setText(null);
        }

    }



}
