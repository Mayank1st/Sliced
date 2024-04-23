
package Todays_Menu;

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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tooltip;

public class Todays_Menu_FXMLController implements Initializable {

    @FXML
    private Button todaysItem1;
    @FXML
    private Button todaysItem2;
    @FXML
    private Button todaysItem3;
    @FXML
    private Button mainMenu;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //todaysItem3.setDisable(true);
        Tooltip tooltip=new Tooltip();
        Platform.runLater(this::showTodaysMenuOpeningAlert);
        
        LocalDate currentDate = LocalDate.now();
        
        // Get the day of the week
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        
        // Convert the day of the week to a localized string (e.g., "Sunday", "Monday", etc.)
        String dayOfWeekString = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
        
        System.out.println("Today is " + dayOfWeekString);
        
        if(dayOfWeekString.equals("Saturday")||dayOfWeekString.equals("Sunday"))
        {
            todaysItem3.setDisable(false);
            tooltip.setText("Today is "+dayOfWeekString+",Enjoy the offer !");
            todaysItem3.setTooltip(tooltip);
        }
        else
        {
           
            tooltip.setText("Today is "+dayOfWeekString+",Please visit again on Weekends!");
            todaysItem3.setTooltip(tooltip);
             todaysItem3.setDisable(true);
        }
        
        
    }    
    //Real Time Inclusion for WeekEnd Offer(Offer-3)
    // Get the current date
    private void showTodaysMenuOpeningAlert()
    {
        //Dilogue box for Weekend Offer
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setHeaderText("WEEKEND OFFER!");
        alert.setContentText("WEEKEND Offer is only available for SATURDAY AND SUNDAY");
        alert.showAndWait();
    }

    @FXML
    private void todaysItem1_Action(ActionEvent event) {
        try{
                Parent root= FXMLLoader.load(getClass().getResource("/TodaysOffer1/Offer1_FXML.fxml"));
                Stage stage=(Stage) todaysItem1.getScene().getWindow();
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
    private void todaysItem2_Action(ActionEvent event) {
        
         try{
                Parent root= FXMLLoader.load(getClass().getResource("/TodaysOffer2/Offer2_FXML.fxml"));
                Stage stage=(Stage) todaysItem2.getScene().getWindow();
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
    private void todaysItem3_Action(ActionEvent event) {
        try{
                Parent root= FXMLLoader.load(getClass().getResource("/TodaysOffer3/Offer3_FXML.fxml"));
                Stage stage=(Stage) todaysItem3.getScene().getWindow();
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
    private void gotoMainMenu(ActionEvent event) {
         try{
                Parent root= FXMLLoader.load(getClass().getResource("/Main_Menu/Main_Menu_FXML.fxml"));
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
