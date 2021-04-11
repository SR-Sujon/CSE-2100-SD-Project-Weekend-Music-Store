/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Utils.DBConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import Admin.users;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import weekendmusicstore.AdminPageController;

/**
 * FXML Controller class
 *
 * @author Sujon
 */
public class UserEditController implements Initializable {

    @FXML
    private Button saveBtn;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    users userVariable = null;
    boolean update = false;
    @FXML
    private TextField addUsertxtUsername;
    @FXML
    private TextField addUsertxtEmail;
    @FXML
    private TextField addUsertxtAddress;
    @FXML
    private PasswordField addUsertxtPassword;
    @FXML
    private TextField userIDtxt;
    @FXML
    private TextField addUserMobile;

    public TextField getUserIDtxt() {
        return userIDtxt;
    }

    public void setUserIDtxt(TextField userIDtxt) {
        this.userIDtxt = userIDtxt;
    }

    public boolean isUpdate() {
        return this.update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public TextField getAddUsertxtUsername() {
        return addUsertxtUsername;
    }

    public void setAddUsertxtUsername(TextField addUsertxtUsername) {
        this.addUsertxtUsername = addUsertxtUsername;
    }

    public TextField getAddUsertxtEmail() {
        return addUsertxtEmail;
    }

    public void setAddUsertxtEmail(TextField addUsertxtEmail) {
        this.addUsertxtEmail = addUsertxtEmail;
    }

    public TextField getAddUsertxtAddress() {
        return addUsertxtAddress;
    }

    public void setAddUsertxtAddress(TextField addUsertxtAddress) {
        this.addUsertxtAddress = addUsertxtAddress;
    }

    public PasswordField getAddUsertxtPassword() {
        return addUsertxtPassword;
    }

    public void setAddUsertxtPassword(PasswordField addUsertxtPassword) {
        this.addUsertxtPassword = addUsertxtPassword;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void setTextField(String id, String n, String e, String add, String mob) {
        userIDtxt.setText(id);
        addUsertxtUsername.setText(n);
        addUsertxtEmail.setText(e);
        addUsertxtAddress.setText(add);
        addUserMobile.setText(mob);
    }

    @FXML
    private void saveUserDetail(MouseEvent event) throws SQLException {
      
        String name = addUsertxtUsername.getText();
        String email = addUsertxtEmail.getText();
        String address = addUsertxtAddress.getText();
        String password = addUsertxtPassword.getText();
        String userID = userIDtxt.getText();
        String mobile = addUserMobile.getText();

        if (mobile.isEmpty() || name.isEmpty() || email.isEmpty() || address.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("Please, fill up all the fields!");
            alert.setX(750);
            alert.setY(350);
            alert.showAndWait();
        } else if (update == false) {
            Insert();

        } else {
            connection = DBConnection.DBcon();
            query = "UPDATE `users` SET `email`=?,`username`=?,`password`=?,`address`=?, `mobile`=? WHERE `users`.`id`=" + Integer.parseInt(userID);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, mobile);
            preparedStatement.execute();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Updated!");
            alert.setContentText("Information is updated Successfully!");
            alert.setX(750);
            alert.setY(350);
            alert.showAndWait();
        }
    }

    @FXML
    private void clearText(MouseEvent event) {
        addUsertxtUsername.clear();
        addUsertxtEmail.clear();
        addUsertxtAddress.clear();
        addUsertxtPassword.clear();
        addUserMobile.clear();
        userIDtxt.clear();
    }

    private void Insert() throws SQLException {
        connection = DBConnection.DBcon();
        String ID = userIDtxt.getText();
        String name = addUsertxtUsername.getText();
        String email = addUsertxtEmail.getText();
        String address = addUsertxtAddress.getText();
        String password = addUsertxtPassword.getText();
        String mobile = addUserMobile.getText();
        query = "INSERT INTO `users`(`id`,`email`, `username`, `password`, `address`, `mobile`) VALUES (?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, ID);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, name);
        preparedStatement.setString(4, password);
        preparedStatement.setString(5, address);
        preparedStatement.setString(6, mobile);
        preparedStatement.executeUpdate();

        // INFORMATION ALERT BOX
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Inserted!");
        alert.setContentText("Information is updated Successfully!");
        alert.setX(750);
        alert.setY(350);
        alert.showAndWait();

    }

}
