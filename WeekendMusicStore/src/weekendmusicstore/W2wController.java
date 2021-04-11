/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weekendmusicstore;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hridoyak47
 */
public class W2wController implements Initializable {

    private Button nxtbutton;
    private AnchorPane anchorRoot;
    private StackPane parentContainer;

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tabPane1;
    @FXML
    private Tab tabPane2;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button exploreBtnWpage;
    @FXML
    private Button nextBtn1;
    @FXML
    private Button nextBtn2;
    @FXML
    private Tab tabPane0;
    @FXML
    private Button backBtn1;
    @FXML
    private Button backBtn2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void movetosecond(MouseEvent event) {

    }

    @FXML
    private void exploreBtnAction(MouseEvent event) throws IOException {
        tabPane.getSelectionModel().select(tabPane1);
    }

    @FXML
    private void nextBtn1Action(MouseEvent event) {
        tabPane.getSelectionModel().select(tabPane2);
    }

    @FXML
    private void backBtn1Action(MouseEvent event) {
        tabPane.getSelectionModel().select(tabPane0);
    }

    @FXML
    private void backBtn2Action(MouseEvent event) {
        tabPane.getSelectionModel().select(tabPane1);
    }

    @FXML
    private void nextBtn2Action(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(W2wController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = loader.getRoot();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Login Panel");
        stage.setX(0);
        stage.setY(0);
        stage.show();
    }

}
