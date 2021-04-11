/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weekendmusicstore;

import Admin.inventory;
import Admin.users;
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
import static javafx.application.Platform.exit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Admin.UserEditController;
import Admin.payment;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Sujon
 */
public class AdminPageController implements Initializable {

    //VARIABLES
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    users userVariable = null;
    inventory inventoryVariable = null;
    private boolean update;
    private Stage stage;
    private Scene scene;
    private Parent root;

    // FX:IDS
    @FXML
    private TableColumn<users, String> cusID;
    @FXML
    private TableColumn<users, String> userName;
    @FXML
    private TableColumn<users, String> email;
    @FXML
    private TableColumn<users, String> mobile;
    
    @FXML
    private TableView<users> usertable;
    @FXML
    private Button refreshTable;

    ObservableList<users> usersList = FXCollections.observableArrayList();

    @FXML
    private Button searchUser;
    @FXML
    private TextField searchText;
    @FXML
    private TableColumn<users, String> address;
    @FXML
    private Button addUser;
    @FXML
    private LineChart<?, ?> chartSold;
    @FXML
    private NumberAxis Y;
    @FXML
    private CategoryAxis X;
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnUsers;
    @FXML
    private TabPane tabPaneAdmin;
    @FXML
    private Tab UsersInfoTab;
    @FXML
    private Tab DashboardTab;
    @FXML
    private Button btnInventory;
    @FXML
    private Button btnSales;
    @FXML
    private Tab InventoryTab;
    @FXML
    private Tab SalesTab;
    @FXML
    private Pane inventoryPane;
    @FXML
    private Pane infoPanel;
    @FXML
    private ChoiceBox<String> productCategoriesBox;

    ObservableList ChoiceBoxlist = FXCollections.observableArrayList();
    @FXML
    private TableColumn<inventory, String> pid;
    @FXML
    private TableColumn<inventory, String> p_name;
    @FXML
    private TableColumn<inventory, String> category;
    @FXML
    private TableColumn<inventory, String> quantity;
    @FXML
    private TableColumn<inventory, String> unit_price;
    @FXML
    private TableColumn<inventory, String> type;

    ObservableList inventoryLists = FXCollections.observableArrayList();
    @FXML
    private TableView<?> inventoryTable;
    @FXML
    private Button addBtnInvent;
    @FXML
    private Button editBtnInvent;
    @FXML
    private Button deleteBtnInvent;
    @FXML
    private Button clearBtnInvent;
    @FXML
    private Button refreshBtnInvent;
    @FXML
    private Button searchBtnInvent;
    @FXML
    private TextField PID;
    @FXML
    private TextField P_NAME;
    @FXML
    private TextField UNIT_PRICE;
    @FXML
    private TextField QUANTITY;

    ObservableList<inventory> iLists;

    @FXML
    private Button signOut;
    @FXML
    private Button deleteUser;
    @FXML
    private Button updateTableBtn;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblNoOfCustomers;
    @FXML
    private Label lblStringNo;
    @FXML
    private Label lblKeysNo;
    @FXML
    private Label lblPercussionNo;
    @FXML
    private TextField TYPE;
    @FXML
    private TableColumn<payment, String> trxID;
    @FXML
    private TableColumn<payment, String> payPID;
    @FXML
    private TableColumn<payment, String> payPname;
    @FXML
    private TableColumn<payment, String> payQuantity;
    @FXML
    private TableColumn<payment, String> payUsername;
    @FXML
    private TableColumn<payment, String> payCardNo;
    private TableColumn<payment, String> payPin;
    @FXML
    private TableColumn<payment, String> payAmount;
    @FXML
    private TableColumn<payment, String> payCardHolder;
    @FXML
    private TableColumn<payment, String> cardExpiryDate;

    ObservableList paymentLists = FXCollections.observableArrayList();

    @FXML
    private TableView<?> paymentTable;
    @FXML
    private TextField txtSearchPayment;
    @FXML
    private Button searchTrxID;
    @FXML
    private Button refreshTablePayment;
    @FXML
    private Label lblSalesSum;
    @FXML
    private Label lblProductsSold;
    @FXML
    private Label lblStringSold;
    @FXML
    private Label lblKeysSold;
    @FXML
    private Label lblPercussionSold;
    @FXML
    private Label lblTotalStock;
    @FXML
    private Button deleteUser1;


    /**
     * INITIALISES the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            loadDate();
            loadChoices();
            loadInventory();
            loadPaymentTable();
            refreshTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // USERNAME TAG ON TOP RIGHT SIDE OF PAGE
    public void setUsernameLabel(String lbl) {
        lblUsername.setText(lbl);
    }

    // SIGN OUT BUTTON
    @FXML
    public void SwitchScenesSignout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login Panel");
        stage.setX(0);
        stage.setY(0);
        stage.show();
    }

    //USER PANEL 
    @FXML
    private void OpenUsersTab(MouseEvent event) throws SQLException {
        tabPaneAdmin.getSelectionModel().select(UsersInfoTab);
        refreshTable();
    }

    public void loadDate() throws SQLException {

        connection = DBConnection.DBcon();
        cusID.setCellValueFactory(new PropertyValueFactory<>("id"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        userName.setCellValueFactory(new PropertyValueFactory<>("username"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    }

    @FXML
    public void refreshTable(MouseEvent event) throws SQLException {
        refreshTable();
    }

    public void refreshTable() throws SQLException {
        usersList.clear();

        query = "SELECT * FROM users";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            usersList.add(new users(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("address"),
                    resultSet.getString("mobile")));
            usertable.setItems(usersList);
        }
    }

    @FXML
    private void searchUser(MouseEvent event) throws SQLException {
        usersList.clear();
        String stext = searchText.getText();
        query = "SELECT * FROM users WHERE email = ? OR username = ? OR id = ? OR address = ?";
        connection = DBConnection.DBcon();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, stext);
        preparedStatement.setString(2, stext);
        preparedStatement.setString(3, stext);
        preparedStatement.setString(4, stext);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            usersList.add(new users(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("address"),
                    resultSet.getString("mobile")));
            usertable.setItems(usersList);
        }
    }

    @FXML
    private void addUser(MouseEvent event) {
        try {

            Parent parent = FXMLLoader.load(getClass().getResource("/Admin/userEdit.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Add User Panel");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteUsersAction(MouseEvent event) throws SQLException {
        userVariable = (users) usertable.getSelectionModel().getSelectedItem();
        query = "DELETE FROM `users` WHERE `users`.`id` = " + userVariable.getId();

        connection = DBConnection.DBcon();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        refreshTable();
    }

    // NEED TO FIX
    @FXML
    public void UpdateTable(MouseEvent event) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Admin/userEdit.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        UserEditController aUC = loader.getController();
        aUC.setUpdate(true);
        userVariable = null;
        userVariable = (users) usertable.getSelectionModel().getSelectedItem();
        
        if(userVariable == null){
                // INFORMATION ALERT BOX
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARNING!");
                alert.setContentText("Please, select a row first!");
                alert.setX(750);
                alert.setY(350);
                alert.showAndWait();
        }
        else {
        aUC.setTextField(String.valueOf(userVariable.getId()),userVariable.getUsername(),userVariable.getEmail(), userVariable.getAddress(),userVariable.getMobile());

        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
        }
        

    }

    //DASHBOARD PANEL
    @FXML
    private void OpenDashboardTab(MouseEvent event) {
        tabPaneAdmin.getSelectionModel().select(DashboardTab);
        chartSold.getData().clear();
        XYChart.Series S = new XYChart.Series<>();
        S.setName("Strings");

        XYChart.Series S1 = new XYChart.Series<>();
        S1.setName("Keys");

        XYChart.Series S2 = new XYChart.Series<>();
        S2.setName("Percussion");

        

        S.getData().add(new XYChart.Data<>("Jan", 10));
        S.getData().add(new XYChart.Data<>("Feb", 30));
        S.getData().add(new XYChart.Data<>("Mar", 20));
        S.getData().add(new XYChart.Data<>("Apr", 50));
        S.getData().add(new XYChart.Data<>("May", 70));
        S.getData().add(new XYChart.Data<>("June", 85));
        S.getData().add(new XYChart.Data<>("July", 91));
        S.getData().add(new XYChart.Data<>("Aug", 55));
        S.getData().add(new XYChart.Data<>("Sep", 61));
        S.getData().add(new XYChart.Data<>("Oct", 71));
        S.getData().add(new XYChart.Data<>("Nov", 81));
        S.getData().add(new XYChart.Data<>("Dec", 93));
        

        S1.getData().add(new XYChart.Data<>("Jan", 16));
        S1.getData().add(new XYChart.Data<>("Feb", 36));
        S1.getData().add(new XYChart.Data<>("Mar", 40));
        S1.getData().add(new XYChart.Data<>("Apr", 70));
        S1.getData().add(new XYChart.Data<>("May", 50));
        S1.getData().add(new XYChart.Data<>("June", 85));
        S1.getData().add(new XYChart.Data<>("July", 61));
        S1.getData().add(new XYChart.Data<>("Aug", 73));
        S1.getData().add(new XYChart.Data<>("Sep", 78));
        S1.getData().add(new XYChart.Data<>("Oct", 88));
        S1.getData().add(new XYChart.Data<>("Nov", 82));
        S1.getData().add(new XYChart.Data<>("Dec", 80));
       

        S2.getData().add(new XYChart.Data<>("Jan", 27));
        S2.getData().add(new XYChart.Data<>("Feb", 39));
        S2.getData().add(new XYChart.Data<>("Mar", 56));
        S2.getData().add(new XYChart.Data<>("Apr", 78));
        S2.getData().add(new XYChart.Data<>("May", 43));
        S2.getData().add(new XYChart.Data<>("June", 89));
        S2.getData().add(new XYChart.Data<>("July", 49));
        S2.getData().add(new XYChart.Data<>("Aug", 59));
        S2.getData().add(new XYChart.Data<>("Sep", 69));
        S2.getData().add(new XYChart.Data<>("Oct", 79));
        S2.getData().add(new XYChart.Data<>("Nov", 89));
        S2.getData().add(new XYChart.Data<>("Dec", 99));

        chartSold.getData().addAll(S, S1, S2);

        try {
            //CUSTOMER COUNT 
            CustomerCount();
            ProductsInStock();
            SalesSumCount();
            ProductsSoldCount();
            ProductsSold();
        } catch (SQLException ex) {
            Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CustomerCount() throws SQLException {
        query = "SELECT COUNT(`username`) as CS FROM `users`";
        connection = DBConnection.DBcon();
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int Count = resultSet.getInt("CS");
            lblNoOfCustomers.setText(String.valueOf(Count));
        }

    }
    
      private void SalesSumCount() throws SQLException {
                DecimalFormat df2 = new DecimalFormat("#.##");
                df2.setRoundingMode(RoundingMode.UP);
        query = "SELECT SUM(`amount`) as CS FROM `payment`";
        connection = DBConnection.DBcon();
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            double Count = resultSet.getDouble("CS");
                    String st = df2.format(Count);
            lblSalesSum.setText(st);
        }

    }
        
    private void ProductsSoldCount() throws SQLException {

        query = "SELECT SUM(`quantity`) as CS FROM `payment`";
        connection = DBConnection.DBcon();
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int Count = resultSet.getInt("CS");
            lblProductsSold.setText(String.valueOf(Count));
        }
    }  

    private void ProductsInStock() throws SQLException {
        String P_catg = "Strings";
        connection = DBConnection.DBcon();

        query = "SELECT SUM(`quantity`) as CS FROM inventory WHERE  category = ?";
        preparedStatement = connection.prepareStatement(query);

        for (int i = 1; i <= 3; i++) {
            if (i == 1) {
                P_catg = "Strings";
            } else if (i == 2) {
                P_catg = "Keys";
            } else if (i == 3) {
                P_catg = "Percussion";
            }

            preparedStatement.setString(1, P_catg);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int sum = resultSet.getInt("CS");
                if (i == 1) {
                    lblStringNo.setText(String.valueOf(sum));
                } else if (i == 2) {
                    lblKeysNo.setText(String.valueOf(sum));
                } else if (i == 3) {
                    lblPercussionNo.setText(String.valueOf(sum));
                }
            }
        }
    }
    
        private void ProductsSold() throws SQLException {
        String P_catg = "";
        connection = DBConnection.DBcon();

        query = "SELECT SUM(`payment`.`quantity`) as CS FROM `inventory`,`payment` WHERE `payment`.`pid` = `inventory`.`pid` AND `inventory`.`category` = ?";
        preparedStatement = connection.prepareStatement(query);

        for (int i = 1; i <= 3; i++) {
            if (i == 1) {
                P_catg = "Strings";
            } else if (i == 2) {
                P_catg = "Keys";
            } else if (i == 3) {
                P_catg = "Percussion";
            }

            preparedStatement.setString(1, P_catg);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int sum = resultSet.getInt("CS");
                if (i == 1) {
                    lblStringSold.setText(String.valueOf(sum));
                } else if (i == 2) {
                    lblKeysSold.setText(String.valueOf(sum));
                } else if (i == 3) {
                    lblPercussionSold.setText(String.valueOf(sum));
                }
            }
        }
    }

    //INVENTORY PANEL
    @FXML
    private void OpenInventoryTab(MouseEvent event) throws SQLException {
        tabPaneAdmin.getSelectionModel().select(InventoryTab);
        refreshInventory();
        setTextFieldsValueWithTableview();
    }

    private void loadChoices() {
        ChoiceBoxlist.removeAll(ChoiceBoxlist);
        String a = "Strings";
        String b = "Keys";
        String c = "Percussion";
        ChoiceBoxlist.addAll(a, b, c);
        productCategoriesBox.getItems().addAll(ChoiceBoxlist);
    }

    private void loadInventory() throws SQLException {
        connection = DBConnection.DBcon();
        pid.setCellValueFactory(new PropertyValueFactory<>("pid"));
        p_name.setCellValueFactory(new PropertyValueFactory<>("p_name"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        unit_price.setCellValueFactory(new PropertyValueFactory<>("unit_price"));
    }

    @FXML
    private void addInventory(MouseEvent event) throws SQLException {
        inventoryLists.clear();
        String Pid = PID.getText();
        String P_name = P_NAME.getText();
        String P_catg = productCategoriesBox.getValue();
        String P_type = TYPE.getText();
        String Quantity = QUANTITY.getText();
        String U_price = UNIT_PRICE.getText();

        if (Pid.isEmpty() || P_name.isEmpty() || P_catg.isEmpty() || P_type.isEmpty() || Quantity.isEmpty() || U_price.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Input feilds cannot be empty!\nPlease, fill up all.");
            alert.setTitle("Error");
            alert.showAndWait();
        } else {

            query = "INSERT INTO `inventory`(`pid`, `p_name`, `category`, `type` ,`quantity`, `unit_price`) VALUES (?,?,?,?,?,?)";
            connection = DBConnection.DBcon();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Pid);
            preparedStatement.setString(2, P_name);
            preparedStatement.setString(3, P_catg);
            preparedStatement.setString(4, P_type);
            preparedStatement.setString(5, Quantity);
            preparedStatement.setString(6, U_price);
            preparedStatement.executeUpdate();
            refreshInventory();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Successful!");
            alert.setContentText("Information's Added Successfully!");
            alert.showAndWait();
        }
    }

    @FXML
    private void editInventory(MouseEvent event) {

    }

    @FXML
    private void deleteInventory(MouseEvent event) throws SQLException {

        inventoryVariable = (inventory) inventoryTable.getSelectionModel().getSelectedItem();
        query = "DELETE FROM `inventory` WHERE `inventory`.`pid` = " + inventoryVariable.getPid();

        connection = DBConnection.DBcon();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        refreshInventory();
    }

    @FXML
    private void clearInventory(MouseEvent event) {
        PID.clear();
        P_NAME.clear();
        productCategoriesBox.setValue(null);
        TYPE.clear();
        QUANTITY.clear();
        UNIT_PRICE.clear();
    }

    @FXML
    private void refreshInventory() throws SQLException {
        inventoryLists.clear();

        query = "SELECT * FROM inventory";
        connection = DBConnection.DBcon();
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            inventoryLists.add(new inventory(
                    resultSet.getInt("pid"),
                    resultSet.getString("p_name"),
                    resultSet.getString("category"),
                    resultSet.getString("type"),
                    resultSet.getInt("quantity"),
                    resultSet.getDouble("unit_price")));
            inventoryTable.setItems(inventoryLists);
        }
    }

    private void refreshInventory(MouseEvent event) throws SQLException {
        refreshInventory();
    }

    @FXML
    private void searchInventory(MouseEvent event) throws SQLException {
        inventoryLists.clear();
        String Pid = PID.getText();
        String P_name = P_NAME.getText();
        String P_catg = productCategoriesBox.getValue();
        String P_type = TYPE.getText();
        String Quantity = QUANTITY.getText();
        String U_price = UNIT_PRICE.getText();

        query = "SELECT * FROM inventory WHERE pid = ? OR p_name = ? OR category = ? OR type = ? OR quantity = ? OR unit_price = ?";
        connection = DBConnection.DBcon();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, Pid);
        preparedStatement.setString(2, P_name);
        preparedStatement.setString(3, P_catg);
        preparedStatement.setString(4, P_type);
        preparedStatement.setString(5, Quantity);
        preparedStatement.setString(6, U_price);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            inventoryLists.add(new inventory(
                    resultSet.getInt("pid"),
                    resultSet.getString("p_name"),
                    resultSet.getString("category"),
                    resultSet.getString("type"),
                    resultSet.getInt("quantity"),
                    resultSet.getDouble("unit_price")));
            inventoryTable.setItems(inventoryLists);
        }
    }

    private void setTextFieldsValueWithTableview() {
        inventoryTable.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                inventoryVariable = (inventory) inventoryTable.getSelectionModel().getSelectedItem();
                PID.setText(String.valueOf(inventoryVariable.getPid()));
                P_NAME.setText(inventoryVariable.getP_name());
                productCategoriesBox.setValue(inventoryVariable.getCategory());
                QUANTITY.setText(String.valueOf(inventoryVariable.getQuantity()));
                UNIT_PRICE.setText(String.valueOf(inventoryVariable.getUnit_price()));
            }
        });
    }


    //SALES PANEL
    @FXML
    private void OpenSalesTab(MouseEvent event) throws SQLException {
        tabPaneAdmin.getSelectionModel().select(SalesTab);
        refreshPaymentTable();
    }

    private void refreshPaymentTable() throws SQLException {
        paymentLists.clear();

        query = "SELECT * FROM `payment`";
        connection = DBConnection.DBcon();
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            paymentLists.add(new payment(
                    resultSet.getInt("trxid"),
                    resultSet.getInt("pid"),
                    resultSet.getString("pname"),
                    resultSet.getInt("quantity"),
                    resultSet.getString("user_name"),
                    resultSet.getString("cardholder"),
                    resultSet.getString("cardnumber"),
                    resultSet.getDate("expirydate"),
                    resultSet.getDouble("amount")));
            paymentTable.setItems(paymentLists);
        }
    }

    public void loadPaymentTable() throws SQLException {
        connection = DBConnection.DBcon();
        trxID.setCellValueFactory(new PropertyValueFactory<>("trxid"));
        payPID.setCellValueFactory(new PropertyValueFactory<>("pid"));
        payPname.setCellValueFactory(new PropertyValueFactory<>("pname"));
        payQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        payUsername.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        payCardHolder.setCellValueFactory(new PropertyValueFactory<>("cardholder"));
        payCardNo.setCellValueFactory(new PropertyValueFactory<>("cardnumber"));
        cardExpiryDate.setCellValueFactory(new PropertyValueFactory<>("expirydate"));
        payAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    @FXML
    private void searchPayment(MouseEvent event) {

    }

    @FXML
    private void refreshPaymentTableAction(MouseEvent event) throws SQLException {
        refreshPaymentTable();
    }

}
