
package Fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class Slice_Pincode_FXMLController implements Initializable {

    @FXML
    private Label availablePncodes;
    @FXML
    private RadioButton option1;
    @FXML
    private RadioButton option2;
    @FXML
    private RadioButton option3;
    @FXML
    private RadioButton option4;
    private ToggleGroup group=new ToggleGroup();
    @FXML
    private Label selectState;
    @FXML
     private ChoiceBox<String> selectStateChoiceBox=new ChoiceBox();
    @FXML
    private Label selectCity;
    @FXML
    private ChoiceBox<String> selectCityChoiceBox=new ChoiceBox();
    private final String[] city1={"Dhanbad","Ranchi","Bokaro"};
    private final String[] city2={"Gaya","Patna","Jehanabad"};
    private final String[] city3={"Panipat","Sonipat","Karnal","Gurugram"};
    @FXML
    private Button submitButton;
    public static String  selectedPincode;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ObservableList<String> list=selectStateChoiceBox.getItems();
        list.addAll("Jharkhand","Bihar","Haryana");
        
        
        //Disable Button primary
        option1.setVisible(false);
        option2.setVisible(false);
        option3.setVisible(false);
        option4.setVisible(false);
        submitButton.setVisible(false);
        
        // Add listener to the main choice box selection
        selectStateChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Update the options of the dependent choice box based on the selected value
            if (newValue.equals("Jharkhand")) {
                selectCityChoiceBox.setItems(FXCollections.observableArrayList(city1));
            } else if (newValue.equals("Bihar")) {
                // You can set a different set of options here if needed
                selectCityChoiceBox.setItems(FXCollections.observableArrayList(city2));
            }
            else if(newValue.equals("Haryana"))
                    {
                        selectCityChoiceBox.setItems(FXCollections.observableArrayList(city3));
                        }
            else
            {
                selectCityChoiceBox.getItems().clear(); // Clear the options
                selectCityChoiceBox.setDisable(true);
            }
            
            
        });
        
        
        
        
        //PIN CODE SELECTION AND EVENT HANDLING
        
        
        
         selectCityChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue.equals("Hisar")) {      
//               availablePncodes.setText("Pincodes available : HISAR"); 
//                // Show the related checkbox
//                option1.setVisible(true);
//                option1.setText("125033");
//                option2.setVisible(true);
//                option2.setText("125004"); 
//                option3.setVisible(true);
//                option3.setText("125005"); 
//                    
//                        //Set toggle group
//                        option1.setToggleGroup(group);
//                        option2.setToggleGroup(group);
//                        option3.setToggleGroup(group);
//                        
//                group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
//                    @Override
//                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
//                       RadioButton radio=(RadioButton)newValue;
//                       selectedPincode=radio.getText();
//                    }
//                            
//                });
//                submitButton.setOnAction(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//                        
//                        if (selectedPincode !=null) {
//                            try{
//                                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
//                                Stage stage=(Stage) availablePncodes.getScene().getWindow();
//                                Scene scene=new Scene(root);
//                                stage.setScene(scene);
//                                }
//                                catch(IOException e)
//                                {
//                                    e.printStackTrace();
//                                    System.exit(0);
//                                }                          
//                        }
//                        else
//                        {
//                            System.out.println("Pin code not selected");
//                        }
//                    }
//                });
//                        
//            }
            
             if(newValue.equals("Dhanbad")){
                availablePncodes.setText("Pincodes available : DHANBAD"); 
                submitButton.setVisible(true);
                option1.setVisible(true);
                option1.setText("828307");
                option2.setVisible(true);
                option2.setText("828124"); 
                option3.setVisible(true);
                option3.setText("828124"); 
                option4.setVisible(true);
                option4.setText("828104"); 
                    
                        option1.setToggleGroup(group);
                        option2.setToggleGroup(group);
                        option3.setToggleGroup(group);
                        option4.setToggleGroup(group);  
                        
                group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                       RadioButton radio=(RadioButton)newValue;
                       selectedPincode=radio.getText();
                    }
                            
                });
                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        if (selectedPincode !=null) {
                            //System.out.println("Pin code selected");
                            try{
                                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                                Stage stage=(Stage) availablePncodes.getScene().getWindow();
                                Scene scene=new Scene(root);
                                stage.setScene(scene);
                                }
                                catch(IOException e)
                                {
                                    e.printStackTrace();
                                    System.exit(0);
                                }                 
                           
                        }
                        else
                        {
                            System.out.println("Pin code not selected");
                        }
                    }
                });
            }
            
             else if(newValue.equals("Bokaro")){
                availablePncodes.setText("Pincodes available : BOKARO"); 
                submitButton.setVisible(true);
                option1.setVisible(true);
                option1.setText("827013");
                option2.setVisible(true);
                option2.setText("828134"); 
                option3.setVisible(true);
                option3.setText("828302"); 
                option4.setVisible(true);
                option4.setText("827001"); 
                
                        option1.setToggleGroup(group);
                        option2.setToggleGroup(group);
                        option3.setToggleGroup(group);
                        option4.setToggleGroup(group);   
                        
                group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                       RadioButton radio=(RadioButton)newValue;
                       selectedPincode=radio.getText();
                    }
                            
                });
                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        if (selectedPincode !=null) {
                           // System.out.println("Pin code selected");
                           try{
                                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                                Stage stage=(Stage) availablePncodes.getScene().getWindow();
                                Scene scene=new Scene(root);
                                stage.setScene(scene);
                                }
                                catch(IOException e)
                                {
                                    e.printStackTrace();
                                    System.exit(0);
                                }                 
                           
                        }
                        else
                        {
                            System.out.println("Pin code not selected");
                        }
                    }
                });
                
            }
            
            else if(newValue.equals("Ranchi")){
                availablePncodes.setText("Pincodes available : RANCHI"); 
                submitButton.setVisible(true);
                option1.setVisible(true);
                option1.setText("834002");
                option2.setVisible(true);
                option2.setText("835209"); 
                option3.setVisible(true);
                option3.setText("835301"); 
                option4.setVisible(true);
                option4.setText("835204"); 
                
                        option1.setToggleGroup(group);
                        option2.setToggleGroup(group);
                        option3.setToggleGroup(group);
                        option4.setToggleGroup(group); 
                        
                group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                       RadioButton radio=(RadioButton)newValue;
                       selectedPincode=radio.getText();
                       
                    }
                            
                });
                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        if (selectedPincode !=null) {
                            //System.out.println("Pin code selected");
                            try{
                                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                                Stage stage=(Stage) availablePncodes.getScene().getWindow();
                                Scene scene=new Scene(root);
                                stage.setScene(scene);
                                }
                                catch(IOException e)
                                {
                                    e.printStackTrace();
                                    System.exit(0);
                                }                 
                           
                        }
                        else
                        {
                            System.out.println("Pin code not selected");
                        }
                    }
                });
                                     
            }
            
            else if(newValue.equals("Gaya")){
                availablePncodes.setText("Pincodes available : GAYA"); 
                submitButton.setVisible(true);
                option1.setVisible(true);
                option1.setText("823001");
                option2.setVisible(true);
                option2.setText("824207"); 
                option3.setVisible(true);
                option3.setText("804403"); 
                option4.setVisible(true);
                option4.setText("824233"); 
                
                        option1.setToggleGroup(group);
                        option2.setToggleGroup(group);
                        option3.setToggleGroup(group);
                        option4.setToggleGroup(group); 
                    
                group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                       RadioButton radio=(RadioButton)newValue;
                       selectedPincode=radio.getText();
                    }
                            
                });
                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        if (selectedPincode !=null) {
                           // System.out.println("Pin code selected");
                           try{
                                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                                Stage stage=(Stage) availablePncodes.getScene().getWindow();
                                Scene scene=new Scene(root);
                                stage.setScene(scene);
                                }
                                catch(IOException e)
                                {
                                    e.printStackTrace();
                                    System.exit(0);
                                }                 
                           
                        }
                        else
                        {
                            System.out.println("Pin code not selected");
                        }
                    }
                });
                         
            }
            
            
            else if(newValue.equals("Jehanabad")){
                availablePncodes.setText("Pincodes available : JEHANABAD"); 
                submitButton.setVisible(true);
                option1.setVisible(true);
                option1.setText("804426");
                option2.setVisible(true);
                option2.setText("804405"); 
                option3.setVisible(true);
                option3.setText("804428"); 
                
                        option1.setToggleGroup(group);
                        option2.setToggleGroup(group);
                        option3.setToggleGroup(group);
                        
                group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                       RadioButton radio=(RadioButton)newValue;
                       selectedPincode=radio.getText();
                    }
                            
                });
                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        if (selectedPincode !=null) {
                           // System.out.println("Pin code selected");
                           try{
                                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                                Stage stage=(Stage) availablePncodes.getScene().getWindow();
                                Scene scene=new Scene(root);
                                stage.setScene(scene);
                                }
                                catch(IOException e)
                                {
                                    e.printStackTrace();
                                    System.exit(0);
                                }                 
                           
                        }
                        else
                        {
                            System.out.println("Pin code not selected");
                        }
                    }
                });
                               
            }
            
             else if(newValue.equals("Patna")){
                availablePncodes.setText("Pincodes available : PATNA"); 
                submitButton.setVisible(true);
                option1.setVisible(true);
                option1.setText("801507");
                option2.setVisible(true);
                option2.setText("801110"); 
                option3.setVisible(true);
                option3.setText("801108"); 
                option4.setVisible(true);
                option4.setText("801103"); 
                    
                        option1.setToggleGroup(group);
                        option2.setToggleGroup(group);
                        option3.setToggleGroup(group);
                        option4.setToggleGroup(group); 
                
                group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                       RadioButton radio=(RadioButton)newValue;
                       selectedPincode=radio.getText();
                    }
                            
                });
                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        if (selectedPincode !=null) {
                           // System.out.println("Pin code selected");
                           try{
                                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                                Stage stage=(Stage) availablePncodes.getScene().getWindow();
                                Scene scene=new Scene(root);
                                stage.setScene(scene);
                                }
                                catch(IOException e)
                                {
                                    e.printStackTrace();
                                    System.exit(0);
                                }                 
                           
                        }
                        else
                        {
                            System.out.println("Pin code not selected");
                        }
                    }
                });
            }
            
            
            else if(newValue.equals("Panipat")){
                availablePncodes.setText("Pincodes available : PANIPAT"); 
                submitButton.setVisible(true);
                option1.setVisible(true);
                option1.setText("132103");
                option2.setVisible(true);
                option2.setText("132140"); 
                option3.setVisible(true);
                option3.setText("132107"); 
                option4.setVisible(true);
                option4.setText("132105"); 
                    
                        option1.setToggleGroup(group);
                        option2.setToggleGroup(group);
                        option3.setToggleGroup(group);
                        option4.setToggleGroup(group);     
                        
                group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                       RadioButton radio=(RadioButton)newValue;
                       selectedPincode=radio.getText();
                    }
                            
                });
                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        if (selectedPincode !=null) {
                           // System.out.println("Pin code selected");
                           try{
                                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                                Stage stage=(Stage) availablePncodes.getScene().getWindow();
                                Scene scene=new Scene(root);
                                stage.setScene(scene);
                                }
                                catch(IOException e)
                                {
                                    e.printStackTrace();
                                    System.exit(0);
                                }                 
                           
                        }
                        else
                        {
                            System.out.println("Pin code not selected");
                        }
                    }
                });
            }
            
            else if(newValue.equals("Sonipat")){
                availablePncodes.setText("Pincodes available : SONIPAT");
                submitButton.setVisible(true);
                option1.setVisible(true);
                option1.setText("131101");
                option2.setVisible(true);
                option2.setText("131301"); 
                option3.setVisible(true);
                option3.setText("131409"); 
                option4.setVisible(true);
                option4.setText("131021"); 
                
                        option1.setToggleGroup(group);
                        option2.setToggleGroup(group);
                        option3.setToggleGroup(group);
                        option4.setToggleGroup(group);     
                        
                group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                @Override
                public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                   RadioButton radio=(RadioButton)newValue;
                   selectedPincode=radio.getText();
                    }
                            
                });
                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        if (selectedPincode !=null) {
                          //  System.out.println("Pin code selected");
                          try{
                                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                                Stage stage=(Stage) availablePncodes.getScene().getWindow();
                                Scene scene=new Scene(root);
                                stage.setScene(scene);
                                }
                                catch(IOException e)
                                {
                                    e.printStackTrace();
                                    System.exit(0);
                                }                 
                           
                        }
                        else
                        {
                            System.out.println("Pin code not selected");
                        }
                    }
                });
            }
            
             else if(newValue.equals("Karnal")){
                availablePncodes.setText("Pincodes available : KARNAL"); 
                submitButton.setVisible(true);
                option1.setVisible(true);
                option1.setText("132024");
                option2.setVisible(true);
                option2.setText("132157"); 
                option3.setVisible(true);
                option3.setText("132036"); 
                option4.setVisible(true);
                option4.setText("132117"); 
                        
                        option1.setToggleGroup(group);
                        option2.setToggleGroup(group);
                        option3.setToggleGroup(group);
                        option4.setToggleGroup(group);  
                        
                     group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                       RadioButton radio=(RadioButton)newValue;
                       selectedPincode=radio.getText();
                       
                    }
                            
                        });
                    submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        if (selectedPincode !=null) {
                           // System.out.println("Pin code selected");
                           try{
                                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                                Stage stage=(Stage) availablePncodes.getScene().getWindow();
                                Scene scene=new Scene(root);
                                stage.setScene(scene);
                                }
                                catch(IOException e)
                                {
                                    e.printStackTrace();
                                    System.exit(0);
                                }                 
                           
                        }
                        else
                        {
                            System.out.println("Pin code not selected");
                        }
                    }
                });
                
            }
            
             

             else if(newValue.equals("Gurugram")){
                availablePncodes.setText("Pincodes available : GURUGRAM"); 
                submitButton.setVisible(true);
                option1.setVisible(true);
                option1.setText("122005");
                option2.setVisible(true);
                option2.setText("122101"); 
                option3.setVisible(true);
                option3.setText("122503"); 
                option4.setVisible(true);
                option4.setText("122108"); 
                    
                        option1.setToggleGroup(group);
                        option2.setToggleGroup(group);
                        option3.setToggleGroup(group);
                        option4.setToggleGroup(group);    
                        
                        //Selected Pincode
                    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                       RadioButton radio=(RadioButton)newValue;
                       selectedPincode=radio.getText();  }                                                
                    });
                    submitButton.setOnAction((ActionEvent event) -> {
                        if (selectedPincode !=null) {
                            //System.out.println("Pin code selected");
                            try{
                                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                                Stage stage=(Stage) availablePncodes.getScene().getWindow();
                                Scene scene=new Scene(root);
                                stage.setScene(scene);
                                }
                                catch(IOException e)
                                {
                                    e.printStackTrace();
                                    System.exit(0);
                                }                 
                           
                        }
                        else
                        {
                            System.out.println("Pin code not selected");
                        }
                });
                
            }
            
            
            
            
           
            });
        
        
    }
        
        
       
        
            
        
        

   @FXML
   private void pinCodeSubmit(ActionEvent event) {
////        
////        //Pin code Details
////        
////       
////         
////        
////        //To show the selected pncode
////        if(selectedPincode!=null)
////        {
////            System.out.println(selectedPincode+" this is the final pincode");
////        }
////        else
////        {
////            System.out.println("Pin code is empty");
////        }
////        
////        }
   }
}
