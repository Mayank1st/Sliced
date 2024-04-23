package Bill_Generate;

import Fxml.Slice_Pincode_FXMLController;
import Summary_and_Promo.Summary_and_PromoFXMLController;
import static Summary_and_Promo.Summary_and_PromoFXMLController.finalPizza;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Bill_GenerateFXMLController implements Initializable {

    @FXML
    private VBox vbox; // Your VBox containing buyRectangle
   
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private Text buyText;
    @FXML
    private Button receiptGenerateButton;
    @FXML
    private VBox footerBuyVbox;
    @FXML
    private Text footerBuyText;
    @FXML
    private Label buyLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Apply the "Thank You" text styling
        buyText.setFill(Color.WHITE);

        // Set up the blinking animation
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(buyText.opacityProperty(), 0)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(buyText.opacityProperty(), 1)),
                new KeyFrame(Duration.seconds(1.5), new KeyValue(buyText.opacityProperty(), 0))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    
    
    
        //Footer Marquee animation
        footerBuyText.setFill(Color.WHITE);
        // Create a TranslateTransition to move the Text node
        TranslateTransition marqueeTransition = new TranslateTransition(Duration.seconds(10), footerBuyText);
        marqueeTransition.setFromX(-800); // Starting position outside the screen
        marqueeTransition.setToX(800);  // Ending position outside the screen
        marqueeTransition.setCycleCount(TranslateTransition.INDEFINITE); // Repeat indefinitely

        // Start the marquee animation
        marqueeTransition.play();
    }
    @FXML
    private void receiptGenerateButtonAction(ActionEvent event) {
        
        //PROMPT MESSAGE ON THE LABEL
        buyLabel.setText("Receipt Generated, Check your HomeScreen/Desktop to see the Receipt.");
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the date and time using a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        
        try{
             //File sliceFile=new File("sliceBuyReceipt.txt");
            //sliceFile.createNewFile();
//            String receiptString="""
//                                 -----------------------------------------------
//                                      THANK YOU FOR PURCHASING WITH SLICE!
//                                 ----------------------------------------------- \n"""
//                                 
//                                 +"   Current date and time: " + formattedDateTime+"\n\n"
//                                 +"   Order Summary :\n"
//                                 +"      -Product Name..................."+Summary_and_PromoFXMLController.productNameForReceipt+"\n"
//                                 +"      -Product Quantity..............."+Summary_and_PromoFXMLController.productquantityForReceipt+"\n"
//                                 +"      -Discount......................."+0+"\n"
//                                 +"      -GST............................"+Summary_and_PromoFXMLController.gst+"\n"
//                                 +"      -Total.........................."+Summary_and_PromoFXMLController.finalPizza+"\n\n"
//                                 +"  Shipping PinCode : " + Slice_Pincode_FXMLController.selectedPincode+"\n\n"
//                                 +"""
//                                     Thank you for choosing our products. If you have
//                                     any questions or need assistance, please contact
//                                     our customer support at mayankk1st@gmail.com.
//                                  
//                                     ©MaYaNk
//                                  """
//                                 ;
//                                         
            String receiptString="                                                 \n"+
                                " -----------------------------------------------  \n"+
                                "      THANK YOU FOR PURCHASING WITH SLICE!        \n"+
                                " ----------------------------------------------- \n"
                                 
                                 +"   Current date and time: " + formattedDateTime+"\n\n"
                                 +"   Order Summary :\n"
                                 +"      -Product Name..................."+Summary_and_PromoFXMLController.productNameForReceipt+"\n"
                                 +"      -Product Quantity..............."+Summary_and_PromoFXMLController.productquantityForReceipt+"\n"
                                 +"      -Discount......................."+Summary_and_PromoFXMLController.productDiscountForReceipt+"\n"
                                 +"      -GST............................"+Summary_and_PromoFXMLController.gst+"\n"
                                 +"      -Total.........................."+Summary_and_PromoFXMLController.finalPizza+"\n\n"
                                 +"  Shipping PinCode : " + Slice_Pincode_FXMLController.selectedPincode+"\n\n"
                                 +"                                                  \n"
                                 +"    Thank you for choosing our products. If you have \n"
                                 +"    any questions or need assistance, please contact \n" 
                                 +"    our customer support at mayankk1st@gmail.com.    \n\n"
                                 +"    ©MaYaNk                                           "; 
                             
    
                                      
            String desktopPath = System.getProperty("user.home") + "/Desktop";
            String filePath = desktopPath + "/sliceBuyReceipt.txt"; // Concatenate the desktop path with the desired file name
            FileWriter sliceFilewriter=new FileWriter(filePath);
            sliceFilewriter.write(receiptString);
            sliceFilewriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Unable to create a new file");
        }
    }
}
