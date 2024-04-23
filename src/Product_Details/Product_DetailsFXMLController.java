
package Product_Details;

import Main_Menu.Main_Menu_FXMLController;
import static Main_Menu.Main_Menu_FXMLController.Image_Path;
import static Main_Menu.Main_Menu_FXMLController.Prod_Description;
import static Main_Menu.Main_Menu_FXMLController.Prod_ID;
import static Main_Menu.Main_Menu_FXMLController.Prod_Name;
import static Main_Menu.Main_Menu_FXMLController.Prod_Size;
import static Main_Menu.Main_Menu_FXMLController.Prod_amount;
import static Main_Menu.Main_Menu_FXMLController.Remove_Button;
import static Main_Menu.Main_Menu_FXMLController.productList;
import Main_Menu.ProductDetails;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Product_DetailsFXMLController implements Initializable, EventHandler<ActionEvent>{

    @FXML
    private Label productName;
    @FXML
    private Label productDescription;
    @FXML
    private ImageView productImage;
    @FXML
    private Button goToMainMenu;
    @FXML
    private Spinner<Integer> quantitySpinner=new Spinner();
    @FXML
    public  CheckBox topping1=new CheckBox();
    @FXML
    public  CheckBox topping2=new CheckBox();
    @FXML
    public  CheckBox topping3= new CheckBox();
    @FXML
    public  CheckBox topping4=new CheckBox();
    @FXML
    private Button checkOutButton;
    @FXML
    private int Product_Quantity;
    private int top=0;
    private int Final_topping_value=0;
    public static  ArrayList<ProductDetails> productList = new ArrayList<>();
    public static  ArrayList<ProductDetails> detailedProductList = new ArrayList<>();
    private TableView<ProductDetails> chckOuttable;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         String Prod_ID=Main_Menu_FXMLController.Prod_ID;
         System.out.println("Product ID(mk) :"+Prod_ID);
        // detailedProductList.add(0,Prod_Name);
         String Prod_Name=Main_Menu_FXMLController.Prod_Name +"  @"+ Main_Menu_FXMLController.Size_medium;
         System.out.println("Product Name(mk) :"+Prod_Name);
         //detailedProductList.add(1,Prod_Name);
         productName.setText(Prod_Name);
         String path=Main_Menu_FXMLController.Image_Path;  
         Image image = new Image(Image_Path);
         productImage.setImage(image);
         String Description=Main_Menu_FXMLController.Prod_Description;
         productDescription.setText(Description);
         int Prod_amount=Main_Menu_FXMLController.Prod_amount;
         System.out.println("Product Ammount(mk) :"+Prod_amount);
         //productDescription.setText(Prod_amount);
         
         //QUANTITY DETAILS
         SpinnerValueFactory<Integer> valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
         quantitySpinner.setValueFactory(valueFactory);
         
         //Adding Listener
         quantitySpinner.valueProperty().addListener(new ChangeListener<Integer>(){
             @Override
             public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
               
               //detailedProductList.add(2,Product_Quantity);
                 Product_Quantity=quantitySpinner.getValue(); 
                 System.out.println("Quantity Value : "+Product_Quantity);
                 
             }  
             
           });
         
         
         //TOPPING SELECTION
         
         if("412".equals(Main_Menu_FXMLController.Prod_ID)||"411".equals(Main_Menu_FXMLController.Prod_ID) ||
            "413".equals(Main_Menu_FXMLController.Prod_ID)||"311".equals(Main_Menu_FXMLController.Prod_ID)||"312".equals(Main_Menu_FXMLController.Prod_ID)||
            "313".equals(Main_Menu_FXMLController.Prod_ID) || "411".equals(Main_Menu_FXMLController.Prod_ID)){ 
          topping1.setDisable(true);
          topping2.setDisable(true);
          topping3.setDisable(true);
          topping4.setDisable(true);
       }
         else{
         topping1.setOnAction( this);
         topping2.setOnAction( this);
         topping3.setOnAction( this);
         topping4.setOnAction( this);   
         }
         
         
    
    }    

    
    @Override
    public void handle(ActionEvent event) {
    
        String selectedTopping1="selected data :";
        String selectedTopping2="selected data :";
        String selectedTopping3="selected data :";
        String selectedTopping4="selected data :";
        if(topping1.isSelected())
        {
            selectedTopping1=topping1.getText();
            //detailedProductList.add(selectedTopping1);
            top=top+60;
           // System.out.println(selectedTopping1);
        }
        if(topping2.isSelected())
        {
            selectedTopping2=topping2.getText();
           // detailedProductList.add(selectedTopping2);
           top=top+45;
           // System.out.println(selectedTopping2);
        }
        if(topping3.isSelected())
        {
            selectedTopping3=topping3.getText();
            top=top+30;
            //detailedProductList.add(selectedTopping3);
            //System.out.println(selectedTopping3);
        }
        if(topping4.isSelected())
        {
            selectedTopping4=topping4.getText();
            top=top+50;
           // detailedProductList.add(selectedTopping4);
            //System.out.println(selectedTopping4);
        }
        System.out.println("Final topping value : "+top);
        Final_topping_value=top;
        //System.out.println("amount+topping : "+Prod_amount);
        top=0;
        
       
    }
    


    @FXML
    private void checkOutButtonAction(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();
        //dialog.setTitle("Select th");
        dialog.setHeaderText("Select the size");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        ToggleGroup radioGroup = new ToggleGroup();

        RadioButton option1 = new RadioButton("S");
        RadioButton option2 = new RadioButton("M");
        RadioButton option3 = new RadioButton("L");

        option1.setToggleGroup(radioGroup);
        option2.setToggleGroup(radioGroup);
        option3.setToggleGroup(radioGroup);
        option2.setSelected(true);
        
        VBox vbox = new VBox(10, option1, option2, option3);
        dialog.getDialogPane().setContent(vbox);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
                Prod_Size=selectedRadioButton.getText();
                 //detailedProductList.add(3,Prod_Size);
                 
                 if(selectedRadioButton.getText()=="S")
                {
                    int selected_Size=Main_Menu_FXMLController.Size_small;
                     Prod_amount=selected_Size;
                     Prod_amount=(Prod_amount+Final_topping_value)*Product_Quantity;
                     Prod_Size=selectedRadioButton.getText();
                }
                 if(selectedRadioButton.getText()=="M")
                {
                    int selected_Size=Main_Menu_FXMLController.Size_medium;
                    Prod_amount=selected_Size;
                    Prod_amount=(Prod_amount+Final_topping_value)*Product_Quantity;
                    Prod_Size=selectedRadioButton.getText();
                }
                  if(selectedRadioButton.getText()=="L")
                {
                    int selected_Size=Main_Menu_FXMLController.Size_large;
                    Prod_amount=selected_Size;
                   Prod_amount=(Prod_amount+Final_topping_value)*Product_Quantity;
                    Prod_Size=selectedRadioButton.getText();
                }


                if (selectedRadioButton != null) {
                  //  Prod_Size=selectedRadioButton.getText();
                    System.out.println("product Size :"+Prod_Size);
                    //detailedProductList.add(3,Prod_Size);
                    return selectedRadioButton.getText();
                } else {
                    return "No option selected.";
                }
                
            }
            return null;
        });
        
        dialog.showAndWait().ifPresent(result -> System.out.println("Selected option: " + result));
        ProductDetails product = new ProductDetails(Prod_ID, Prod_Name, Product_Quantity, Prod_amount,Prod_Size,Remove_Button);

       //Add the new ProductDetails objec0t to the productList
        productList.add(product);
        System.out.println("Size of product List(Mayank) : "+productList.size());
        
        
         try{
            Parent root= FXMLLoader.load(getClass().getResource("/CheckOut/CheckOut_FXML.fxml"));
            Stage stage=(Stage) productName.getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            }
            catch(IOException e)
            {
                e.printStackTrace();
                System.exit(0);
            }               

        
    }
    
    @FXML
    private void goToMainMenuAction(ActionEvent event) {
        
        try{
            Parent root= FXMLLoader.load(getClass().getResource("/Main_Menu/Main_Menu_FXML.fxml"));
            Stage stage=(Stage) productName.getScene().getWindow();
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

