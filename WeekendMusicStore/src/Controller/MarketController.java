package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import weekendmusicstore.WeekendMusicStore;
import weekendmusicstore.MyListener;
import model.Product;
import weekendmusicstore.AdminPageController;
import weekendmusicstore.LoginController;
import Controller.DialogController;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MarketController implements Initializable {
    private List<Product> products = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label productNameLable;
    @FXML
    private Label productPriceLabel;
    @FXML
    private ImageView productImg;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private VBox chosenProductCard;
    @FXML
    private Label catLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Button signOutButton;
    @FXML
    private Button buyNowButton;
    @FXML
    private Label pidLabel;
    @FXML
    private Label lblUserName;
    
    public void setUsernameLabel(String lbl){
        lblUserName.setText(lbl);
    }

    private List<Product> getData() {
        List<Product> products = new ArrayList<>();
        Product product;

        //Guitars
        
        product = new Product();
        product.setPid(1001);
        product.setName("Gibson Les Paul");
        product.setPrice(2499.99);
        product.setImgSrc("/images/Guitars/ELECTRIC/gibsonlespaul.png");
        product.setColor("B17625");
        product.setCategory("Strings");
        product.setType("Electric");
        products.add(product);

        product = new Product();
        product.setPid(1002);
        product.setName("Fender Stratocaster");
        product.setPrice(2999.99);
        product.setImgSrc("/images/Guitars/ELECTRIC/fenderstrat.jpg");
        product.setColor("F56628");
        product.setCategory("Strings");
        product.setType("Electric");
        products.add(product);

        product = new Product();
        product.setPid(1003);
        product.setName("Epiphone LP Standard");
        product.setPrice(1599.99);
        product.setImgSrc("/images/Guitars/ELECTRIC/epiphonelespaul.jpg");
        product.setColor("F5A728");
        product.setCategory("Strings");
        product.setType("Electric");
        products.add(product);

        product = new Product();
        product.setPid(1013);
        product.setName("Gibson SG 1963");
        product.setPrice(3299.99);
        product.setImgSrc("/images/Guitars/ELECTRIC/gibsonsg.png");
        product.setColor("5A0A0A");
        product.setCategory("Strings");
        product.setType("Electric");
        products.add(product);

        product = new Product();
        product.setPid(1014);
        product.setName("Gibson ES-335");
        product.setPrice(1999.99);
        product.setImgSrc("/images/Guitars/ELECTRIC/gibsones.png");
        product.setColor("FF6400");
        product.setCategory("Strings");
        product.setType("Semi-Electric");
        products.add(product);
        
        product = new Product();
        product.setPid(1004);
        product.setName("Ibanez ART-100");
        product.setPrice(899.99);
        product.setImgSrc("/images/Guitars/ELECTRIC/ibanezlespaul.jpg");
        product.setColor("CF200E");
        product.setCategory("Strings");
        product.setType("Electric");
        products.add(product);
        
        product = new Product();
        product.setPid(1005);
        product.setName("Epiphone J-45");
        product.setPrice(269.99);
        product.setImgSrc("/images/Guitars/Acoustic/epiphonej45.jpg");
        product.setColor("444241");
        product.setCategory("Strings");
        product.setType("Acoustic");
        products.add(product);

        product = new Product();
        product.setPid(1006);
        product.setName("Gibson J-50 Classic");
        product.setPrice(299.99);
        product.setImgSrc("/images/Guitars/Acoustic/gibsonj50.jpg");
        product.setColor("BFAF13");
        product.setCategory("Strings");
        product.setType("Acoustic");
        products.add(product);

        product = new Product();
        product.setPid(1007);
        product.setName("Ibanez GA3 Nylon");
        product.setPrice(229.99);
        product.setImgSrc("/images/Guitars/Acoustic/Ibanez Nylon.png");
        product.setColor("FB5D03");
        product.setCategory("Strings");
        product.setType("Acoustic");
        products.add(product);

        product = new Product();
        product.setPid(1008);
        product.setName("Rickenbacker 4003S");
        product.setPrice(999.99);
        product.setImgSrc("/images/Guitars/BASS/4003S.jpg");
        product.setColor("AEB6BF");
        product.setCategory("Strings");
        product.setType("Bass");
        products.add(product);

        product = new Product();
        product.setPid(1009);
        product.setName("Fender Duff McKagen");
        product.setPrice(1099.99);
        product.setImgSrc("/images/Guitars/BASS/fenderbass.jpg");
        product.setColor("27E27B");
        product.setCategory("Strings");
        product.setType("Bass");
        products.add(product);

        product = new Product();
        product.setPid(1010);
        product.setName("Ibanez SR");
        product.setPrice(699.99);
        product.setImgSrc("/images/Guitars/BASS/ibanezbass.jpg");
        product.setColor("3A57A6");
        product.setCategory("Strings");
        product.setType("Bass");
        products.add(product);

        product = new Product();
        product.setPid(1011);
        product.setName("Yamaha TRBX500");
        product.setPrice(299.99);
        product.setImgSrc("/images/Guitars/BASS/yamahabass.jpg");
        product.setColor("0894CE");
        product.setCategory("Strings");
        product.setType("Bass");
        products.add(product);
        
        product = new Product();
        product.setPid(1012);
        product.setName("Cordoba Ukulele");
        product.setPrice(99.99);
        product.setImgSrc("/images/Guitars/Ukulele/cordoba.png");
        product.setColor("A37434");
        product.setCategory("Strings");
        product.setType("Ukulele");
        products.add(product);
        
        product = new Product();
        product.setPid(1015);
        product.setName("Maharaja Sitar");
        product.setPrice(499.99);
        product.setImgSrc("/images/Guitars/sitar.png");
        product.setColor("3F1B03");
        product.setCategory("Strings");
        product.setType("Sitar");
        products.add(product);
        
        //Keyboards
        
        product = new Product();
        product.setPid(2001);
        product.setName("Nord Stage");
        product.setPrice(5399.99);
        product.setImgSrc("/images/Keyboard/Live Keyboards/NORD.jpg");
        product.setColor("");
        product.setCategory("Keys");
        product.setType("Live");
        products.add(product);
        
        product = new Product();
        product.setPid(2002);
        product.setName("Korg Kronos LS");
        product.setPrice(3699.99);
        product.setImgSrc("/images/Keyboard/Live Keyboards/korg.png");
        product.setColor("");
        product.setCategory("Keys");
        product.setType("Live");
        products.add(product);
        
        product = new Product();
        product.setPid(2003);
        product.setName("Yamaha PSR-295");
        product.setPrice(129.99);
        product.setImgSrc("/images/Keyboard/Live Keyboards/yamaha.jpg");
        product.setColor("");
        product.setCategory("Keys");
        product.setType("Live");
        products.add(product);
        
        product = new Product();
        product.setPid(2004);
        product.setName("Roland V-Combo");
        product.setPrice(299.99);
        product.setImgSrc("/images/Keyboard/Live Keyboards/roland.jpg");
        product.setColor("");
        product.setCategory("Keys");
        product.setType("Live");
        products.add(product);
        
        product = new Product();
        product.setPid(2005);
        product.setName("Yamaha Classical Grand");
        product.setPrice(14999.99);
        product.setImgSrc("/images/Keyboard/PIANO/yamaha grand.jpg");
        product.setColor("");
        product.setCategory("Keys");
        product.setType("Piano");
        products.add(product);
        
        product = new Product();
        product.setPid(2006);
        product.setName("Steinway Grand");
        product.setPrice(99999.99);
        product.setImgSrc("/images/Keyboard/PIANO/steinway.jpg");
        product.setColor("");
        product.setCategory("Keys");
        product.setType("Piano");
        products.add(product);
        
        product = new Product();
        product.setPid(2007);
        product.setName("Akai MPK Mini");
        product.setPrice(199.99);
        product.setImgSrc("/images/Keyboard/MIDI keyboard/akai.jpg");
        product.setColor("");
        product.setCategory("Keys");
        product.setType("MIDI");
        products.add(product);
        
        product = new Product();
        product.setPid(2008);
        product.setName("Alesis VI25");
        product.setPrice(249.99);
        product.setImgSrc("/images/Keyboard/MIDI keyboard/alesisVI25.png");
        product.setColor("");
        product.setCategory("Keys");
        product.setType("MIDI");
        products.add(product);
        
        product = new Product();
        product.setPid(2009);
        product.setName("Surasree Custom Harmonium");
        product.setPrice(999.99);
        product.setImgSrc("/images/Keyboard/Harmonium/harm.jpg");
        product.setColor("");
        product.setCategory("Keys");
        product.setType("Harmonium");
        products.add(product);
        
        
        //Drums
        
        product = new Product();
        product.setPid(3001);
        product.setName("Tama Club JAM 9pcs");
        product.setPrice(19999.99);
        product.setImgSrc("/images/Drums/tama.png");
        product.setColor("");
        product.setCategory("Percussion");
        product.setType("Acoustic drums");
        products.add(product);
        
        product = new Product();
        product.setPid(3002);
        product.setName("Pearl Roadshow RS 5pcs");
        product.setPrice(24999.99);
        product.setImgSrc("/images/Drums/pearl.png");
        product.setColor("");
        product.setCategory("Percussion");
        product.setType("Acoustic drums");
        products.add(product);
        
        product = new Product();
        product.setPid(3003);
        product.setName("Zildjan (Cymbals) \nCrash, Splash, Hi-Hats, Ride, China");
        product.setPrice(949.99);
        product.setImgSrc("/images/Drums/cymbal.png");
        product.setColor("");
        product.setCategory("Percussion");
        product.setType("Acoustic drums");
        products.add(product);
        
        product = new Product();
        product.setPid(3004);
        product.setName("Alesis Nitro Mesh");
        product.setPrice(549.99);
        product.setImgSrc("/images/Drums/anm.jpg");
        product.setColor("");
        product.setCategory("Percussion");
        product.setType("Electric drums");
        products.add(product);

        product = new Product();
        product.setPid(3005);
        product.setName("Roland TD-1DMK");
        product.setPrice(649.99);
        product.setImgSrc("/images/Drums/roland.jpg");
        product.setColor("");
        product.setCategory("Percussion");
        product.setType("Electric drums");
        products.add(product);
        
        product = new Product();
        product.setPid(3006);
        product.setName("Yamaha DTX402K");
        product.setPrice(449.99);
        product.setImgSrc("/images/Drums/yesyamaha.jpg");
        product.setColor("");
        product.setCategory("Percussion");
        product.setType("Electric drums");
        products.add(product);
        
        product = new Product();
        product.setPid(3007);
        product.setName("Cajon");
        product.setPrice(39.99);
        product.setImgSrc("/images/Drums/cajon.jpg");
        product.setColor("");
        product.setCategory("Percussion");
        product.setType("Cajon");
        products.add(product);
        
        product = new Product();
        product.setPid(3008);
        product.setName("Surasree Tabla");
        product.setPrice(69.99);
        product.setImgSrc("/images/Drums/tabla.jpg");
        product.setColor("");
        product.setCategory("Percussion");
        product.setType("Tabla");
        products.add(product);
        
        product = new Product();
        product.setPid(3009);
        product.setName("Tambourine");
        product.setPrice(19.99);
        product.setImgSrc("/images/Drums/t2.jpg");
        product.setColor("");
        product.setCategory("Percussion");
        product.setType("Tambourine");
        products.add(product);
        
        return products;
    }

    @FXML
    public void signOutButtonAction(ActionEvent event) throws IOException{
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("/weekendmusicstore/Login.fxml"));
         loader.load();
        
                Parent parent = loader.getRoot();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Login panel");
                stage.setX(0);
                stage.setY(0);
                stage.show();
                

    }
    
    private void setChosenProduct(Product product) {
        pidLabel.setText(Integer.toString(product.getPid()));
        productNameLable.setText(product.getName());
        productPriceLabel.setText(Double.toString(product.getPrice()));
        catLabel.setText(product.getCategory());
        typeLabel.setText(product.getType());
        image = new Image(getClass().getResourceAsStream(product.getImgSrc()));
        productImg.setImage(image);
        chosenProductCard.setStyle("-fx-background-color: #" + product.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }
    
    @FXML
    private void buyNowButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dialog.fxml"));
        Parent root = loader.load();
        
        //access the controller and call a method
        DialogController controller = loader.getController();
        controller.initData(Integer.parseInt(pidLabel.getText()),productNameLable.getText(),productPriceLabel.getText(),catLabel.getText(),typeLabel.getText(),productImg.getImage());
        controller.setUsernameLabel(lblUserName.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Product Information");
        stage.show();
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        products.addAll(getData());
        if (products.size() > 0) {
            setChosenProduct(products.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Product product) {
                    setChosenProduct(product);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < products.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(products.get(i),myListener);

                if (column == 5) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
