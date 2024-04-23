package Summary_and_Promo;

import CheckOut.CheckOut_FXMLController;
import static CheckOut.CheckOut_FXMLController.tableViewErrorMessage;
import Main_Menu.Main_Menu_FXMLController;
import static Main_Menu.Main_Menu_FXMLController.Prod_ID;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Summary_and_PromoFXMLController implements Initializable {

    @FXML
    private Label productNameLabel;
    @FXML
    private Label basePriceLabel;
    @FXML
    private Label discountLabel;
    @FXML
    private Label gstLabel;
    @FXML
    private Label deliveryLabel;
    @FXML
    private TextField promoCodeTextField;
    @FXML
    private Button promoCodeTextFieldButton;
    @FXML
    private  Label promoCodeLabel;
    @FXML
    private Label totalLabel;
    public static float gst;
    private float delivery;
    public static float promoCodeValue;
    public static double finalPizza;
    private double discountedValue;
    public static String  productNameForReceipt;
    public static String productDiscountForReceipt;
    public static int productquantityForReceipt;
    private static final DecimalFormat decfor = new DecimalFormat("0.00");  
    @FXML
    private Button gotoCartButton;
    @FXML
    private Button gotoPaymentButton;
    @FXML
    private Button goToMainMenuButton;
    @FXML
    private Label tableViewErrorMessage;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        if(Main_Menu_FXMLController.Prod_ID.equals("OFF1") ||Main_Menu_FXMLController.Prod_ID.equals("OFF2")  )
        {
            
            System.out.println("Offer 2 checked");
            promoCodeTextField.setDisable(true);
            promoCodeTextFieldButton.setDisable(true);
            promoCodeLabel.setText("Promo Code is not applicable in special offers !");
            discountLabel.setText("20%");
            productDiscountForReceipt="20%";
            
        }
        else if(Main_Menu_FXMLController.Prod_ID.equals("OFF3"))
        {
            System.out.println("Offer 3 checked");
            promoCodeTextField.setDisable(true);
            promoCodeTextFieldButton.setDisable(true);
            promoCodeLabel.setText("Promo Code is not applicable in special offers !");
            discountLabel.setText("10%");
            productDiscountForReceipt="10%";
        }
        else{
            discountLabel.setText("0");
        }
        
        System.out.println("value of tableViewErrorMessage : "+CheckOut_FXMLController.tableViewErrorMessage);
//            if(CheckOut_FXMLController.tableViewErrorMessage==1)
//            {
//                System.out.println("value of tableViewErrorMessage : "+tableViewErrorMessage);
//                promoCodeLabel.setText("ERROR");
//            }
    }
    


    public void setProductName(String productName) {
        productNameForReceipt=productName;
        productNameLabel.setText(productName);
        //productNameLabel.setTextFill(javafx.scene.paint.Color.RED);
    }
    public void getProdQuantity(int Product_Quantity) {
        
       // productNameLabel.setText(productName);
        //productNameLabel.setTextFill(javafx.scene.paint.Color.RED);
    }
    public void setproductQuantity(int product_Quantity) {      
        productquantityForReceipt=product_Quantity;
    }
    public void setproductAmount(int productAmount) {
        
        //BASE PRICE
        basePriceLabel.setText(String.valueOf(productAmount));
        //productNameLabel.setTextFill(javafx.scene.paint.Color.RED);
        float pizzaBasePrice= Integer.parseInt(basePriceLabel.getText());
       // System.out.println("base price pizza :"+pizzaBasePrice);
       
       //GST AMMOUNT CALCULATION
        gst=(float) (pizzaBasePrice*0.18);
        String gstText=decfor.format(gst);
        //System.out.println("GST value : "+decfor.format(gst));
        //String gstText=Double.toString(gst);
        gstLabel.setText(gstText);
        //System.out.println("Gst value : "+gst);
        
       //DELIVERY CHARGES CALCULATION
       if(pizzaBasePrice>500){
           delivery=20.0f;
           deliveryLabel.setText("20");
       }
       else if(pizzaBasePrice<500){
           delivery=40.0f;
           deliveryLabel.setText("40");
       }
       
       //PROMO CODE CALCULATION
       promoCodeTextFieldButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String promoCode = promoCodeTextField.getText().trim();
                float promoCodeValue = 0.0f; // Default value in case of invalid input
                
                if (promoCode.equalsIgnoreCase("SLICE40")) {
                    promoCodeValue = 0.4f;
                    promoCodeValue=pizzaBasePrice*promoCodeValue;
                    discountLabel.setText("40%");
                    productDiscountForReceipt="40%";
                    promoCodeLabel.setText("SLICE40 Promo Code Applied Successfully");
                } else if (promoCode.equalsIgnoreCase("SLICE50")) {
                    promoCodeValue = 0.5f;
                    promoCodeValue=pizzaBasePrice*promoCodeValue;
                    discountLabel.setText("50%");
                    System.out.println("50%");
                     productDiscountForReceipt="50%";
                    promoCodeLabel.setText("SLICE50 Promo Code Applied Successfully");
                } else if (promoCode.equalsIgnoreCase("SLICE100")) {
                    promoCodeValue = 100f;
                    discountLabel.setText("100 Rs.");
                    productDiscountForReceipt="100 Rs.";
                    promoCodeLabel.setText("SLICE100 Promo Code Applied Successfully");
                    promoCodeValue=pizzaBasePrice-promoCodeValue;
                } else {
                    System.out.println("INVALID CODE");
                    discountLabel.setText("0");
                    productDiscountForReceipt="0";
                    promoCodeLabel.setText("INVALID CODE !");
                }
                
                //FINAL PIZZA PRICE WITH PROMO CODE
                System.out.println("Promo Code Value: " + promoCodeValue);
                finalPizza=TotalPizzaPrice(promoCodeValue,pizzaBasePrice,delivery,gst);
                String finalPizzaAmountText=decfor.format(finalPizza);
                totalLabel.setText(finalPizzaAmountText+" Rs.");
            }
        });
       

       //FINAL PIZZA PRICE WITHOUT PROMO CODE
        finalPizza=TotalPizzaPrice(0.0f,pizzaBasePrice,delivery,gst); 
         if(Main_Menu_FXMLController.Prod_ID.equals("OFF2") || Main_Menu_FXMLController.Prod_ID.equals("OFF1"))
        {
            discountedValue=0.2*finalPizza;
            finalPizza=finalPizza-discountedValue;
        }
         else if(Main_Menu_FXMLController.Prod_ID.equals("OFF3"))
         {
            discountedValue=0.1*finalPizza;
            finalPizza=finalPizza-discountedValue;
         }
         
        String finalPizzaAmountText=decfor.format(finalPizza);
        System.out.println("Final Pizza price : "+finalPizza);
        totalLabel.setText(finalPizzaAmountText+" Rs.");
       
       
       
    }

   
    private double TotalPizzaPrice(float promoCodeValue,float pizzaBasePrice,float delivery,float gst  )
    {
        double finalPizza=pizzaBasePrice-promoCodeValue+delivery+gst;
        return finalPizza;
    }

    @FXML
    private void promoCodeTextFieldAction(ActionEvent event) {
    }

    @FXML
    private void promoCodeTextFieldButtonAction(ActionEvent event) {
        
    }

    @FXML
    private void gotoCartButtonAction(ActionEvent event) {
        
         try{
            Parent root= FXMLLoader.load(getClass().getResource("/CheckOut/CheckOut_FXML.fxml"));
            Stage stage=(Stage) productNameLabel.getScene().getWindow();
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
    private void gotoPaymentButtonAction(ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("/Bill_Generate/Bill_GenerateFXML.fxml"));
            Stage stage=(Stage) productNameLabel.getScene().getWindow();
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
    private void goToMainMenuButtonAction(ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("/Main_Menu/Main_Menu_FXML.fxml"));
            Stage stage=(Stage) productNameLabel.getScene().getWindow();
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
