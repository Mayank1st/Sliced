
package TodaysOffer1;

import Main_Menu.Main_Menu_FXMLController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/* 1. Any 2 pizza of price 399.
*/

public class Offer1_FXMLController implements Initializable {

    @FXML
    private Button backButton;
    public static int Offer1ID=100;
    @FXML
    private Button offer1ChooseButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // Main_Menu_FXMLController.bevTabButton.setDisable(true);
        // TODO
    }    
    

    @FXML
    private void offer1Choose(ActionEvent event) {
        
            Offer1ID++;
            
        
         try{
                Parent root= FXMLLoader.load(getClass().getResource("/Main_Menu/Main_Menu_FXML.fxml"));
                Stage stage=(Stage) backButton.getScene().getWindow();
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
    private void backToTodaysOffer(ActionEvent event) {
        try{
                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                Stage stage=(Stage) backButton.getScene().getWindow();
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
