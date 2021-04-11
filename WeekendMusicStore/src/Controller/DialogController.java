package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import Controller.MarketController;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Product;
import weekendmusicstore.WeekendMusicStore;

/**
 * FXML Controller class
 *
 * @author Raiyan
 */
public class DialogController implements Initializable {

    @FXML
    private Label productLabel2;
    @FXML
    private Label priceLabel2;
    @FXML
    private Button confirmButton;
    @FXML
    private Label catLabel2;
    @FXML
    private Label typeLabel2;
    @FXML
    private Button goBackButton;
    @FXML
    private Label idLabel;
    
    private Product selectedProduct;
    @FXML
    private ImageView productImage2;
    @FXML
    private ChoiceBox<String> colorChoiceBox;
    @FXML
    private Label lblUserName;
    
    ObservableList ChoiceBoxlist = FXCollections.observableArrayList();
    
   public void setUsernameLabel(String lbl){
        lblUserName.setText(lbl);
    }
   public void loadColorChoiceBox(){
        ChoiceBoxlist.removeAll(ChoiceBoxlist);
            String a = "Blue Pearl";
            String b = "80's Sunburst";
            String c = "Custom Yellow";
            String d = "White Frost";
            String e = "Matte Black";
        
        ChoiceBoxlist.addAll(a,b,c,d,e);
        colorChoiceBox.getItems().addAll(ChoiceBoxlist);
   }
    public void initData(int pid, String name, String price, String cat, String type, Image image) {
        //selectedProduct = product;
        productLabel2.setText(name);
        priceLabel2.setText(price);
        catLabel2.setText(cat);
        typeLabel2.setText(type);
        idLabel.setText(Integer.toString(pid));
        productImage2.setImage(image);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadColorChoiceBox();
    }    

    @FXML
    private void confirmButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/payment.fxml"));
        Parent root = loader.load();
        
        //access the controller and call a method
        PaymentController controller = loader.getController();
        controller.paymentInfo(idLabel.getText(), productLabel2.getText(),Double.parseDouble(priceLabel2.getText()), productImage2.getImage());
        //controller.paymentInfo("1111","wert",2.5);
        controller.setUsernameLabel(lblUserName.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Payment Information");
        stage.show();
    }

    @FXML
    private void goBackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void close(MouseEvent event) {
    }
    
}
