
package application;

import Constants.adminDetails;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdminLoginController implements Initializable {

    @FXML
    private TextField adminUsername;
    @FXML
    private PasswordField adminPassword;
    @FXML
    private Button adminLoginButton;
    @FXML
    private Label alertMessage;
    @FXML
    private StackPane rootStackPane; 
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//      
        // TODO
    }    

    @FXML
    private void adminLogin(ActionEvent event) throws IOException{
        
        String username=adminUsername.getText();
        String password=adminPassword.getText();
        if(username.trim().equalsIgnoreCase(adminDetails.username) && password.trim().equalsIgnoreCase(adminDetails.password))
        {   
            alertMessage.setText("Login Successfull");
           
           
           try{
                Parent root= FXMLLoader.load(getClass().getResource("/Fxml/Slice_Pincode_FXML.fxml"));
                Stage stage=(Stage) adminPassword.getScene().getWindow();
                Scene scene=new Scene(root);
                stage.setScene(scene);
           }
           catch(IOException e)
           {
               e.printStackTrace();
               System.exit(0);
           }
        }
        
        else if(username.isEmpty() && password.isEmpty())
                {
                    alertMessage.setText("Please enter your data");
                }
        else
        {
            alertMessage.setText("Wrong Credential !");
            System.out.println("admin login fail");
        }
        System.out.println(username);
        System.out.println(password);
        System.out.println("Hello world");
    }

    @FXML
    private void adminLogin(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            adminLoginButton.fire();
    }
    }
       
}

