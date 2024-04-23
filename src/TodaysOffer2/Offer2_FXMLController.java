
package TodaysOffer2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/* 1. Any 3 pizza of small size respective their price.
   2. 1 7-Up cold drink worth 57
   3. 1 pasta moroccon pasta worth 179
*/

public class Offer2_FXMLController implements Initializable {

    @FXML
    private Button offer2ChooseButton;
    public static int Offer2ID=101;
    @FXML
    private Button backButton;
    



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void offer2Choose(ActionEvent event) {
         Offer2ID++;
        
         try{
                Parent root= FXMLLoader.load(getClass().getResource("/Main_Menu/Main_Menu_FXML.fxml"));
                Stage stage=(Stage) offer2ChooseButton.getScene().getWindow();
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
