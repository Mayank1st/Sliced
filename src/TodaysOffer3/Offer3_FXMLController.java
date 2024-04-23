
package TodaysOffer3;

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

/* 1. Any 1 Non-Veg pizza of Large size respective their price.
   2. 1 Pepsi cold drink worth 57
   3. 1 pasta Creamy Tomato pasta worth 159
*/

public class Offer3_FXMLController implements Initializable {

    @FXML
    private Button offer3ChooseButton;
    public static int Offer3ID=102;
    @FXML
    private Button backButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void offer3Choose(ActionEvent event) {
        Offer3ID++;
        
         try{
                Parent root= FXMLLoader.load(getClass().getResource("/Main_Menu/Main_Menu_FXML.fxml"));
                Stage stage=(Stage) offer3ChooseButton.getScene().getWindow();
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
