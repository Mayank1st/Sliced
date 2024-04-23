package CheckOut;

import Main_Menu.Main_Menu_FXMLController;
import static Main_Menu.Main_Menu_FXMLController.clicked;
import productManager.ProductManager;
import Main_Menu.ProductDetails;
import Product_Details.Product_DetailsFXMLController;
import Summary_and_Promo.Summary_and_PromoFXMLController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import productManager.ProductManager;

public class CheckOut_FXMLController implements Initializable {

    @FXML
    private TableView<ProductDetails> checkoutTable;
    @FXML
    private TableColumn<ProductDetails, String> idColumn;
    @FXML
    private TableColumn<ProductDetails, String> nameColumn;
    @FXML
    private TableColumn<ProductDetails, Integer> quantityColumn;
    @FXML
    private TableColumn<ProductDetails, String> amountColumn;
    @FXML
    private TableColumn<ProductDetails, Label> sizeColumn;
    @FXML
    private TableColumn<ProductDetails, Button> removeColumn;
    @FXML
    private Button mainMenu;
    @FXML
    private Button placeOrderButton;
    @FXML
    public static String TableName = null;
    public static double TableAmount;
    public static int tableViewErrorMessage=0;

    @FXML
    public void removeProductButtonAction(ActionEvent event) {
        ProductDetails selectedProduct = checkoutTable.getSelectionModel().getSelectedItem();

        if (selectedProduct != null) {
            // Remove the selected product from the ProductManager's productList
            
            ProductManager.removeProduct(selectedProduct);
            checkoutTable.getItems().remove(selectedProduct);
        } else {
            // Handle case when no product is selected
        }
    }   

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //quantityColumn.setCellFactory(getQuantityCellFactory());
        // placeOrderButton.setDisable(true);
        

        

        // Access the data from both controllers' productList
        ArrayList<ProductDetails> dataList = new ArrayList<>(Product_DetailsFXMLController.productList);
        dataList.addAll(Main_Menu_FXMLController.productList);

        // Remove products that have been removed from the table
        dataList.removeAll(ProductManager.getRemovedProducts());

        // Convert ArrayList to ObservableList
        ObservableList<ProductDetails> observableList = FXCollections.observableArrayList(dataList);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("Prod_ID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Prod_Name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("Product_Quantity"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("Prod_Size"));
        removeColumn.setCellValueFactory(new PropertyValueFactory<>("Remove_Button"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("Prod_amount"));
               
        

//        // ... Continue with setting up the removeColumn ...
         removeColumn.setCellFactory(param -> new TableCell<ProductDetails, Button>() {
            private final Button removeButton = new Button("Remove");

            {
                removeButton.setOnAction(event -> {
                    ProductDetails selectedProduct = getTableView().getItems().get(getIndex());

                    if (selectedProduct != null) {
                        Main_Menu_FXMLController.Cart_number--;
                        Main_Menu_FXMLController.clicked=0;
                        System.out.println("CART Number after removal "+Main_Menu_FXMLController.Cart_number);
                        ProductManager.removeProduct(selectedProduct);
                        checkoutTable.getItems().remove(selectedProduct);
                    } else {
                        // Handle case when no product is selected
                    }
                });
            }

            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    setGraphic(removeButton);
                   
                }
            }
        });


        checkoutTable.setItems(observableList);
        Platform.runLater(this::showMainMenuOpeningAlert);
        
        
//        //  FETCHING DATA FROM PRODUCT AMMOUNT FOR USING INSIDE DYNAMIC SPINNER.
//        ObservableList<ProductDetails> items = checkoutTable.getItems();
//        TableAmount = 0.0;
//        for (ProductDetails item : items) {
//        double amount = item.getProd_amount(); // Assuming getProd_amount() method exists in ProductDetails class
//        TableAmount = amount;
//        System.out.println("Total Amount: " + TableAmount);
//        amount=0;
//        }
    }

    
    
    private void showMainMenuOpeningAlert() {
         //MAIN MENU OPENING SCREEN INFORMATION DIALOG
        Alert main_menu_opening_alert=new Alert(Alert.AlertType.INFORMATION);
//        String AlertString="""
//                              -Select the "item" then click on "Place Order" button.
//                           """;
        String AlertString="                                                       \n"+
                           "   -Select the 'item' then click on 'Place Order' button.";
                           
        main_menu_opening_alert.setContentText(AlertString);
        main_menu_opening_alert.showAndWait();
        
    }


    @FXML
    private void goToMainMenuAction(ActionEvent event) {
         try{
            Parent root= FXMLLoader.load(getClass().getResource("/Main_Menu/Main_Menu_FXML.fxml"));
            Stage stage=(Stage) checkoutTable.getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            }
            catch(IOException e)
            {
                e.printStackTrace();
                System.exit(0);
            }               

    }
    
//   private Callback<TableColumn<ProductDetails, Integer>, TableCell<ProductDetails, Integer>> getQuantityCellFactory() {
//    return col -> new TableCell<ProductDetails, Integer>() {
//        private final Spinner<Integer> spinner = new Spinner<>(1, 10, 1);
//
//        {
//            spinner.setEditable(true);
//            spinner.valueProperty().addListener((observable, oldValue, newValue) -> {
//                if (isEditing()) {
//                    commitEdit(newValue);                    
//                }
//                //TableAmount=TableAmount*newValue;
////                System.out.println("Table amount after dynamic quantity : "+TableAmount);
////                System.out.println("Spinner value changed: " + newValue);
//            });
//            spinner.setEditable(false);  
//        }
//
//        @Override
//        public void updateItem(Integer item, boolean empty) {
//            super.updateItem(item, empty);
//
//            if (empty || item == null) {
//                setGraphic(null);
//            } else {
//                spinner.getValueFactory().setValue(item);
//                setGraphic(spinner);
//            }
//        }

//        @Override
//        public void startEdit() {
//            super.startEdit();
//            setText(null);
//            setGraphic(spinner);
//        }
//
//        @Override
//        public void cancelEdit() {
//            super.cancelEdit();
//            setGraphic(spinner);
//        }
//
//        @Override
//        public void commitEdit(Integer value) {
//            super.commitEdit(value);
//            int newValue = spinner.getValue();
//            System.out.println("spinner dynamic :"+newValue);
//            setGraphic(spinner);
//        }
//    };
//}

    

    @FXML
    private void placeOrderButtonAction(ActionEvent event) {
        try{
            //Parent root= FXMLLoader.load(getClass().getResource("/Summary_and_Promo/Summary_and_PromoFXML.fxml"));
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/Summary_and_Promo/Summary_and_PromoFXML.fxml"));
                Parent root = loader.load();
                // Get the controller of the Summary_and_PromoFXML
                Summary_and_PromoFXMLController summaryController = loader.getController();
                // Get the product name from the selected item and set it in the Summary_and_PromoFXMLController
            
              // Get the selected item from the checkoutTable
            ProductDetails productDetails = checkoutTable.getSelectionModel().getSelectedItem();
            if (productDetails != null) {    
                summaryController.setProductName(productDetails.getProd_Name());
                summaryController.setproductAmount(productDetails.getProd_amount());
                summaryController.setproductQuantity(productDetails.getProduct_Quantity());
            }
            else{
               
                tableViewErrorMessage++;
                System.out.println("table++"+tableViewErrorMessage);
                System.out.println("Not selected");
                Alert alert=new Alert(AlertType.INFORMATION);
                alert.setContentText("Did not selected any product in the cart, Please select !");
                //tableViewErrorMessage=0;
                //Optional<ButtonType> result = alert.showAndWait();
               // Summary_and_PromoFXMLController.tableViewErrorMessage.setText("Hello");
//               if(summaryController != null){
//                summaryController.setErrorMifessage("Did not select any product. Please select a product.");     }          
            }
             Stage stage=(Stage) mainMenu.getScene().getWindow();
             Scene scene=new Scene(root);
             stage.setScene(scene);
                                            

            
            }
            catch(IOException e)
            {
                e.printStackTrace();
                System.exit(0);
            } 
        
    }
    
   
}


