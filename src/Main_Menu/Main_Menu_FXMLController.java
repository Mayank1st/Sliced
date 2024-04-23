
package Main_Menu;

import CheckOut.CheckOut_FXMLController;
import Summary_and_Promo.Summary_and_PromoFXMLController;
import TodaysOffer1.Offer1_FXMLController;
import TodaysOffer2.Offer2_FXMLController;
import TodaysOffer3.Offer3_FXMLController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import productManager.ProductManager;



public class Main_Menu_FXMLController implements Initializable {

    @FXML
    private Button mainMenuVegSlide1Image1;
    @FXML
    private Button mainMenuVegSlide1Image2;
    @FXML
    private Button mainMenuVegSlide1Image3;
    @FXML
    private Button mainMenuVegSlide1Image1Cart;
    @FXML
    private Button mainMenuVegSlide1Image2Cart;
    @FXML
    private Button mainMenuVegSlide1Image3Cart;
    @FXML
    private Button mainMenuVegSlide2Image1;
    @FXML
    private Button mainMenuVegSlide2Image2;
    @FXML
    private Button mainMenuVegSlide2Image3;
    @FXML
    private Button mainMenuVegSlide2Image1Cart;
    @FXML
    private Button mainMenuVegSlide2Image2Cart;
    @FXML
    private Button mainMenuVegSlide2Image3Cart;
    @FXML
    private Button mainMenuVegSlide3Image1;
    @FXML
    private Button mainMenuVegSlide3Image1Cart;
    @FXML
    private Button mainMenuVegSlide3Image2Cart;
    @FXML
    private Button mainMenuNonVegSlide1Image11;
    @FXML
    private Button mainMenuNonVegSlide1Image2;
    @FXML
    private Button mainMenuNonVegSlide1Image3;
    @FXML
    private Button mainMenuNonVegSlide1Image1Cart;
    @FXML
    private Button mainMenuNonVegSlide1Image2Cart;
    @FXML
    private Button mainMenuNonVegSlide1Image3Cart;
    @FXML
    private Button mainMenuNonVegSlide2Image1;
    @FXML
    private Button mainMenuNonVegSlide2Image2A;
    @FXML
    private Button mainNonVegMenuSlide2Image3;
    @FXML
    private Button mainMenuNonVegSlide2Image1Cart;
    @FXML
    private Button mainMenuNonVegSlide2Image2Cart;
    @FXML
    private Button mainMenuNonVegSlide2Image3Cart;
    @FXML
    private Button mainMenuBevSlide1Image1;
    @FXML
    private Button mainMenuBevSlide1Image3;
    @FXML
    private Button mainMenuBevSlide1Image1Cart;
    @FXML
    private Button mainMenuBevSlide1Image2Cart;
    @FXML
    private Button mainMenuBevSlide1Image3Cart;
    @FXML
    private Button mainMenuBevSlide3Image1;
    @FXML
    private Button mainMenuBevSlide3Image1Cart;
    @FXML
    private Button mainMenuPastaSlide1Image1;
    @FXML
    private Button mainMenuPastaSlide1Image2;
    @FXML
    private Button mainMenuPastaSlide1Image3;
    @FXML
    private Button mainMenuPastaSlide1Image1Cart;
    @FXML
    private Button mainMenuPastaSlide1Image2Cart;
    private Dialog dialog=new Dialog();
    @FXML
    private Button mainMenuPastaSlide1Image3Cart;
    public static String Prod_ID;
    public static String Prod_Name;
    public static String Image_Path;
    public static String Prod_Description;
    public static Integer Product_Quantity;
    public static int Prod_amount;
    public static String Prod_Size;
    public static int Size_small;
    public static int Size_medium;
    public static int Size_large;
    public static int Cart_number=0;
    public static int clicked=0;
    public static Button Remove_Button;
    private Button addToCart;
    @FXML
    private Button goToCartButton;
    public static  ArrayList<ProductDetails> productList = new ArrayList<>();
    @FXML
    private Tab vegTabButton;
    @FXML
    private Tab nonVegTabButton;
    @FXML
    public  Tab bevTabButton;
    @FXML
    public  Tab pastaTabButton;
    @FXML
    private Button mainMenuVegSlide3Image2;
    @FXML
    private Button goToTodaysOffer;
    @FXML
    private Button mainMenuBevSlide1Image2;
    public int amountAdd=0;

   
    
   
    
    public void stuffDetails(String Prod_ID,String Prod_Name, String Image_Path,String Prod_Description)
    {
       
        try{
            Parent root= FXMLLoader.load(getClass().getResource("/Product_Details/Product_DetailsFXML.fxml"));
            Stage stage=(Stage) mainMenuVegSlide1Image1.getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            }
            catch(IOException e)
            {
                e.printStackTrace();
                System.exit(0);
            }                          
                        
    }
    
//   @FXML
//    private void addProductButtonAction(ActionEvent event) {
//        // Create a new ProductDetails instance
//        ProductDetails newProduct = new ProductDetails("Prod123", "New Product", 1, 10, "Medium", new Button("Remove"));
//
//        // Add the new product to the ProductManager
//        ProductManager.addProduct(newProduct);
//    }


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ProductDetails.setFromProductDetailsController(false);
        //For delaying the alert message.
        Platform.runLater(this::showMainMenuOpeningAlert);
        if(Offer2_FXMLController.Offer2ID==102 || Offer1_FXMLController.Offer1ID==101 )
        {
            mainMenuImageButtonDisable();
        }
        if( Offer3_FXMLController.Offer3ID==103){
            pastaTabButton.setDisable(true);
            vegTabButton.setDisable(true);
            bevTabButton.setDisable(true);
            
        }
       
    }    
    
    
    private void showMainMenuOpeningAlert() {
         //MAIN MENU OPENING SCREEN INFORMATION DIALOG
        Alert main_menu_opening_alert=new Alert(AlertType.INFORMATION);
//        String AlertString="""
//                              -Click on "Add to cart" for quick buy.
//                           
//                              -Click on Product's image for customized buy.
//                           """;
        String AlertString="   -Click on \"Add to cart\" for quick buy.\n" +
                           "   -Click on Product's image for customized buy.\n";
        main_menu_opening_alert.setContentText(AlertString);
        main_menu_opening_alert.showAndWait();
        
    }

    @FXML
    private void mainMenuVegSlide1Image1Action(ActionEvent event) {
        Prod_ID="111";
        Prod_Name="PEPPY PANEER";
        Prod_amount=0;
        Size_small=299;
        Size_medium=539;
        Size_large=600;
        Image_Path="/Veg/Peppy_Paneer.jpg";
        Prod_Description="Chunky paneer with crisp capsicum and spicy red pepper - quite a mouthful!";
        Image image=new Image("/Veg/Peppy_Paneer.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            
            
        }

        
    }

    @FXML
    private void mainMenuVegSlide1Image2Action(ActionEvent event) {
        Prod_ID="112";
        Prod_Name="FARM HOUSE";
        Prod_amount=0;  
        Size_small=299;
        Size_medium=539;
        Size_large=600;
        Image_Path="/Veg/Farmhouse.jpg";
        Prod_Description="A pizza that goes ballistic on veggies! Check out this mouth watering overload of crunchy, crisp capsicum, succulent mushrooms and fresh tomatoes.";
        Image image=new Image("/Veg/Farmhouse.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            
            
        }
        

    }

    @FXML
    private void mainMenuVegSlide1Image3Action(ActionEvent event) {
        Prod_ID="113";
        Prod_Name="MARGHERITA";
        Prod_amount=0;
        Size_small=139;
        Size_medium=289;
        Size_large=339;
        Image_Path="/Veg/Margherita.jpg";
        Prod_Description="A hugely popular margherita, with a deliciously tangy single cheese topping.";
        Image image=new Image("/Veg/Farmhouse.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
           
            
        }
    }

    @FXML
    private void mainMenuVegSlide1Image1CartAction(ActionEvent event) {
        mainMenuVegSlide1Image1Cart.setDisable(true); 
        Prod_ID="111";
        Prod_Name="PEPPY PANEER";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=539;
        Prod_amount=Size_medium;
       
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");           
            Prod_amount=299;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
               
    }
    @FXML
    private void mainMenuVegSlide1Image2CartAction(ActionEvent event) {
        mainMenuVegSlide1Image2Cart.setDisable(true);
        Prod_ID="112";
        Prod_Name="FARM HOUSE";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=539;
        Prod_amount=Size_medium;
        
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
           // productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
           // addToCartAction();
            
        }
        else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=299;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
            productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            addToCartAction();  
        }
        
    }
    

    @FXML
    private void mainMenuVegSlide1Image3CartAction(ActionEvent event) {
        mainMenuVegSlide1Image3Cart.setDisable(true);
        Prod_ID="113";
        Prod_Name="MARGHERITA";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=289;
        Prod_amount=Size_medium;
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
           // productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
           // addToCartAction();
            
        }
        else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=139;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else{
            productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            addToCartAction();
        }
          
    }

    @FXML
    private void mainMenuVegSlide2Image1Action(ActionEvent event) {
        Prod_ID="121";
        Prod_Name="MEXICAN GREEN WAVE";
        Prod_amount=0;
        Size_small=434;
        Size_medium=708;
        Size_large=790;
        Image_Path="/Veg/Mexican_Green_Wave.jpg";
        Prod_Description="A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes and jalapeno with a liberal sprinkling of exotic Mexican herbs.";
        Image image=new Image("/Veg/Mexican_Green_Wave.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuVegSlide2Image2Action(ActionEvent event) {
        Prod_ID="122";
        Prod_Name="DELUXE VEGGIE";
        Prod_amount=0;  
        Size_small=359;
        Size_medium=609;
        Size_large=700;
        Prod_Description="For a vegetarian looking for a BIG treat that goes easy on the spices, this one's got it all.. The onions, the capsicum, those delectable mushrooms - with paneer and golden corn to top it all.";
        Image_Path="/Veg/Deluxe_Veggie.jpg";
        Image image=new Image("/Veg/Deluxe_Veggie.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuVegSlide2Image3Action(ActionEvent event) {
        Prod_ID="123";
        Prod_Name="VEG EXTRAVAGANZA";
        Prod_amount=0;  
        Size_small=459;
        Size_medium=549;
        Size_large=600;
        Image_Path="/Veg/Veg_Extravaganz.jpg";
        Prod_Description="A pizza that decidedly staggers under an overload of golden corn, exotic black olives, crunchy onions, crisp capsicum, succulent mushrooms, juicyfresh tomatoes and jalapeno - with extra cheese to go all around.";
        Image image=new Image("/Veg/Veg_Extravaganz.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuVegSlide2Image1CartAction(ActionEvent event) {
        mainMenuVegSlide2Image1Cart.setDisable(true);
        Prod_ID="121";   
        Prod_Name="MEXICAN GREEN WAVE";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=708;
        Prod_amount=Size_medium;
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=434;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
        
    }

    @FXML
    private void mainMenuVegSlide2Image2CartAction(ActionEvent event) {
        mainMenuVegSlide2Image2Cart.setDisable(true);
        Prod_ID="122";
        Prod_Name="DELUXE VEGGIE";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=609;
        Prod_amount=Size_medium;
       if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
       else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=359;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
           // productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    @FXML
    private void mainMenuVegSlide2Image3CartAction(ActionEvent event) {
        mainMenuVegSlide2Image3Cart.setDisable(true);
        Prod_ID="123";
        Prod_Name="VEG EXTRAVAGANZA";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=549;
        Prod_amount=Size_medium;
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
           // productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=459;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    @FXML
    private void mainMenuVegSlide3Image1Action(ActionEvent event) {
        Prod_ID="131";
        Prod_Name="VEGGIE PARADISE";
        Prod_amount=0;   
        Size_small=359;
        Size_medium=609;
        Size_large=710;
        Prod_Description="Goldern Corn, Black Olives, Capsicum & Red Paprika.";
        Image_Path="/Veg/Digital_Veggie_Paradise.jpg";
        Image image=new Image("/Veg/Digital_Veggie_Paradise.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
           
            
        }
    }

    @FXML
    private void mainMenuVegSlide3Image2Action(ActionEvent event) {
        Prod_ID="132";
        Prod_Name="INDIAN TANDOORI PANEER";
        Prod_amount=0;  
        Size_small=249;
        Size_medium=459;
        Size_large=559;
        Image_Path="/Veg/IndianTandooriPaneer.jpg";
        Prod_Description="It is hot. It is spicy. It is oh-so-Indian. Tandoori paneer with capsicum I red paprika I mint mayo.";
        Image image=new Image("/Veg/IndianTandooriPaneer.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
           
            
        }
    }

    @FXML
    private void mainMenuVegSlide3Image1CartAction(ActionEvent event) {
        mainMenuVegSlide3Image1Cart.setDisable(true);
        Prod_ID="131";
        Prod_Name="VEGGIE PARADISE";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=609;
        Prod_amount=Size_medium;
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=359;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    @FXML
    private void mainMenuVegSlide3Image2CartAction(ActionEvent event) {
        mainMenuVegSlide3Image2Cart.setDisable(true);
        Prod_ID="132";
        Prod_Name="INDIAN TANDOORI PANEER";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=459;
        Prod_amount=Size_medium;
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=249;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    //NON-VEG Section
    
    @FXML
    private void mainMenuNonVegSlide1Image1Action(ActionEvent event) {
        Prod_ID="211";
        Prod_Name="CHICKEN DOMINATOR";
        Prod_amount=0;  
        Size_small=434;
        Size_medium=708;
        Size_large=800;
        Image_Path="/NonVeg/ChickenDominaator.png";
        Prod_Description="Treat your taste buds with Double Pepper Barbecue Chicken, Peri-Peri Chicken, Chicken Tikka & Grilled Chicken Rashers.";
        Image image=new Image("/NonVeg/ChickenDominaator.png");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuNonVegSlide1Image2Action(ActionEvent event) {
        Prod_ID="212";
        Prod_Name="NON VEG SUPREME";
        Prod_amount=0; 
        Size_small=409;
        Size_medium=689;
        Size_large=730;
        Image_Path="/NonVeg/NonVegSupreme.png";
        Prod_Description="Bite into supreme delight of Black Olives, Onions, Grilled Mushrooms, Pepper BBQ Chicken, Peri-Peri Chicken, Grilled Chicken Rashers.";
        Image image=new Image("/NonVeg/NonVegSupreme.png");
        mainMenuVegSlide1Image2.setText("SELECTED");
        mainMenuVegSlide1Image2.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            
            
        }
    }

    @FXML
    private void mainMenuNonVegSlide1Image3Action(ActionEvent event) {
        Prod_ID="213";
        Prod_Name="CHICKEN GOLDEN DELIGHT";
        Prod_amount=0;   
        Size_small=409;
        Size_medium=689;
        Size_large=730;
        Image_Path="/NonVeg/ChickenGoldenDelight.png";
        Prod_Description="Mmm! Barbeque chicken with a topping of golden corn loaded with extra cheese. Worth its weight in gold!";
        Image image=new Image("/NonVeg/ChickenGoldenDelight.png");
        mainMenuVegSlide1Image3.setText("SELECTED");
        mainMenuVegSlide1Image3.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            
            
        }
    }

    @FXML
    private void mainMenuNonVegSlide1Image1CartAction(ActionEvent event) {
        
        mainMenuNonVegSlide1Image1Cart.setDisable(true);
        Prod_ID="211";
        Prod_Name="CHICKEN DOMINATOR";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=708;
        Prod_amount=Size_medium;
        
       if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
       else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=434;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
       
        else if(Offer3_FXMLController.Offer3ID==103){
            System.out.println("Hello offer3");
            Prod_amount=800;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer3Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    @FXML
    private void mainMenuNonVegSlide1Image2CartAction(ActionEvent event) {
       
        mainMenuNonVegSlide1Image2Cart.setDisable(true);
        Prod_ID="212";
        Prod_Name="NON VEG SUPREME";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=689;
        Prod_amount=Size_medium;
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=409;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else if(Offer3_FXMLController.Offer3ID==103){
            System.out.println("Hello offer3");
            Prod_amount=730;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer3Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }
    @FXML
    private void mainMenuNonVegSlide1Image3CartAction(ActionEvent event) {
        
        mainMenuNonVegSlide1Image3Cart.setDisable(true);
        Prod_ID="213";
        Prod_Name="CHICKEN GOLDEN DELIGHT";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=689;
        Prod_amount=Size_medium;
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Prod_amount=399;
            Offer1Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=409;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else if(Offer3_FXMLController.Offer3ID==103){
            System.out.println("Hello offer3");
            Prod_amount=730;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer3Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    @FXML
    private void mainMenuNonVegSlide2Image1Action(ActionEvent event) {
        Prod_ID="221";
        Prod_Name="CHICKEN FIESTA";
        Prod_amount=0;
        Size_small=409;
        Size_medium=689;
        Size_large=730;
        Image_Path="/NonVeg/ChickenFiesta.png";
        Prod_Description="Grilled Chicken Rashers I Peri-Peri Chicken I Onion I Capsicum.";
        Image image=new Image("/NonVeg/ChickenFiesta.png");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuNonVegSlide2Image2Action(ActionEvent event) {
        Prod_ID="222";
        Prod_Name="INDI CHICKEN TIKKA";
         Prod_amount=0;
        Size_small=399;
        Size_medium=434;
        Size_large=530;
        Image_Path="/NonVeg/IndiChickenTikka.png";
        Prod_Description="The wholesome flavour of tandoori masala with Chicken tikka I onion I red paprika I mint mayo.";
        Image image=new Image("/NonVeg/IndiChickenTikka.png");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainNonVegMenuSlide2Image3Action(ActionEvent event) {
        Prod_ID="223";
        Prod_Name="CREAMY TOMATO PASTA PIZZA";
        Size_small=532;
        Size_medium=788;
        Size_large=830;
        Prod_amount=0;
        Image_Path="/NonVeg/CreamyTomatoPPVG.jpg";
        Prod_Description="Loaded with a delicious creamy tomato pasta topping , green capsicum, crunchy red and yellow bell peppers and black olives.";
        Image image=new Image("/NonVeg/CreamyTomatoPPVG.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuNonVegSlide2Image1CartAction(ActionEvent event) {
        mainMenuNonVegSlide2Image1Cart.setDisable(true);
        Prod_ID="221";
        Prod_Name="CHICKEN FIESTA";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=689;
        Prod_amount=Size_medium;
       if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
       else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=409;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
       else if(Offer3_FXMLController.Offer3ID==103){
            System.out.println("Hello offer3");
            Prod_amount=730;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer3Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    @FXML
    private void mainMenuNonVegSlide2Image2CartAction(ActionEvent event) {
        mainMenuNonVegSlide2Image2Cart.setDisable(true);
        Prod_ID="222";
        Prod_Name="INDI CHICKEN TIKKA";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=434;
        Prod_amount=Size_medium;
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
           // productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=399;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else if(Offer3_FXMLController.Offer3ID==103){
            System.out.println("Hello offer3");
            Prod_amount=530;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer3Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }    }

    @FXML
    private void mainMenuNonVegSlide2Image3CartAction(ActionEvent event) {
        mainMenuNonVegSlide2Image3Cart.setDisable(true);
        Prod_ID="223";
        Prod_Name="CREAMY TOMATO PASTA PIZZA";
        Product_Quantity=1;
        Prod_Size="M";
        Size_medium=788;
        Prod_amount=Size_medium;
       if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            Prod_amount=399;
            Offer1Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
       else if(Offer2_FXMLController.Offer2ID==102){
            System.out.println("Hello offer2");
            Prod_amount=532;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer2Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
       else if(Offer3_FXMLController.Offer3ID==103){
            System.out.println("Hello offer3");
            Prod_amount=830;
            System.out.println("Product Ammount : "+Prod_amount);
            Offer3Action(Prod_amount);
            //productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    @FXML
    private void mainMenuBevSlide1Image1Action(ActionEvent event) {
        Prod_ID="311";
        Prod_Name="7 UP(400 ml)";
        Size_medium=57;
        Prod_amount=Size_medium;
        Image_Path="/Bevreges/7up.png";
        Prod_Description="Refreshing Moments with 7up 400ml";
        Image image=new Image("/Bevreges/7up.png");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuBevSlide1Image2Action(ActionEvent event) {
        Prod_ID="312";
        Prod_Name="MIRINDA(400 ml)";
        Size_medium=57;
        Prod_amount=Size_medium;
        Image_Path="/Bevreges/mirinda.png";
        Prod_Description="Refreshing Moments with Mirinda 400ml";
        Image image=new Image("/Bevreges/mirinda.png");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuBevSlide1Image3Action(ActionEvent event) {
        Prod_ID="313";
        Prod_Name="PEPSI(400 ml)";
        Size_medium=57;
        Prod_amount=Size_medium;
        Image_Path="/Bevreges/pepsi.png";
        Prod_Description="Refreshing Moments with Pepsi 400ml";
        Image image=new Image("/Bevreges/pepsi.png");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuBevSlide1Image1CartAction(ActionEvent event) {
        
        mainMenuBevSlide1Image1Cart.setDisable(true);
        Prod_ID="311";
        Prod_Name="7 UP(400 ml)";
        Product_Quantity=1;
        Prod_Size="400 ml";
        Size_medium=57;
        Prod_amount=Size_medium;
       if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
           // bevTabButton.setDisable(true);
           // pastaTabButton.setDisable(true);
            //Offer1Action();
            Prod_amount=0;
            productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    @FXML
    private void mainMenuBevSlide1Image2CartAction(ActionEvent event) {
        mainMenuBevSlide1Image2Cart.setDisable(true);
        Prod_ID="312";
        Prod_Name="MIRINDA(400 ml)";
        Product_Quantity=1;
        Prod_Size="400 ml";
        Size_medium=57;
        Prod_amount=Size_medium;
      if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
           // bevTabButton.setDisable(true);
           // pastaTabButton.setDisable(true);
            //Offer1Action();
            Prod_amount=0;
            productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }   
    }

    @FXML
    private void mainMenuBevSlide1Image3CartAction(ActionEvent event) {
        mainMenuBevSlide1Image3Cart.setDisable(true);
        Prod_ID="313";
        Prod_Name="PEPSI(400 ml)";
        Product_Quantity=1;
        Prod_Size="400 ml";
        Size_medium=57;
        Prod_amount=Size_medium;
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
           // bevTabButton.setDisable(true);
           // pastaTabButton.setDisable(true);
            //Offer1Action();
            Prod_amount=0;
            productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    @FXML
    private void mainMenuBevSlide3Image1Action(ActionEvent event) {
        Prod_ID="331";
        Prod_Name="LIPTON REFRESHER(250 ml)";
        Size_medium=60;
        Prod_amount=Size_medium;
        Image_Path="/Bevreges/lipton.png";
        Prod_Description="Refreshing Moments with Lipton 250ml";
        Image image=new Image("/Bevreges/lipton.png");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuBevSlide3Image1CartAction(ActionEvent event) {
        mainMenuBevSlide3Image1Cart.setDisable(true);
        Prod_ID="331";
        Prod_Name="LIPTON REFRESHER(250 ml)";
        Size_medium=57;
        Prod_amount=Size_medium;
        Product_Quantity=1;
        Prod_Size="250 ml";
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
           // bevTabButton.setDisable(true);
           // pastaTabButton.setDisable(true);
            //Offer1Action();
            Prod_amount=0;
            productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        } 
    }

    @FXML
    private void mainMenuPastaSlide1Image1Action(ActionEvent event) {
        Prod_ID="411";
        Prod_Name="MOROCCAN SPICE PASTA VEG";
        Size_medium=179;
        Prod_amount=Size_medium;
        Image_Path="/Pasta/MoroccanPastaVeg.jpg";
        Prod_Description="Instant Fusilli Pasta, Harissa Sauce, Onion, Mushroom, Olives, Parsley sprinkle.";
        Image image=new Image("/Pasta/MoroccanPastaVeg.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuPastaSlide1Image2Action(ActionEvent event) {
        Prod_ID="412";
        Prod_Name="TIKKA MASALA PASTA VEG";
        Size_medium=189;
        Prod_amount=Size_medium;
        Image_Path="/Pasta/PaneerTikkaMasala_N.jpg";
        Prod_Description="Instant Fusilli Pasta, Spicy Red dressing, Onion, Paneer Tikka, Parsley sprinkle .";
        Image image=new Image("/Pasta/PaneerTikkaMasala_N.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
           // Offer1Action();
            
        }
    }

    @FXML
    private void mainMenuPastaSlide1Image3Action(ActionEvent event) {
        Prod_ID="413";
        Prod_Name="CREAMY TOMATO PASTA VEG";
        Size_medium=159;
        Prod_amount=Size_medium;
        Image_Path="/Pasta/CreamyTomatoVeg_N.jpg";
        Prod_Description="Instant Fusilli Pasta, Creamy Culinary Dressing, Onion, Olive, Green Capsicum, Parsley sprinkle.";
        Image image=new Image("/Pasta/CreamyTomatoVeg_N.jpg");
        mainMenuVegSlide1Image1.setText("SELECTED");
        mainMenuVegSlide1Image1.setDisable(true); //yaha pe toggle button ka use karna thik rahega selected/remove ke liye
        stuffDetails(Prod_ID,Prod_Name,Image_Path,Prod_Description);
        addToCartAction();
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //Offer1Action();
            
        }
    }
    
    @FXML
    private void mainMenuPastaSlide1Image1CartAction(ActionEvent event) {
        mainMenuPastaSlide1Image1Cart.setDisable(true);
        Prod_ID="411";
        Prod_Name="MOROCCAN SPICE PASTA VEG";
        Product_Quantity=1;
        Prod_Size="F";
        Size_medium=179;
        Prod_amount=Size_medium;
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
           // bevTabButton.setDisable(true);
           // pastaTabButton.setDisable(true);
//            Offer1Action();
//            Prod_amount=0;
            productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    @FXML
    private void mainMenuPastaSlide1Image2CartAction(ActionEvent event) {
        mainMenuPastaSlide1Image2Cart.setDisable(true);
        Prod_ID="412";
        Prod_Name="TIKKA MASALA PASTA VEG";
        Product_Quantity=1;
        Prod_Size="F";
        Size_medium=189;
        Prod_amount=Size_medium;
       if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //bevTabButton.setDisable(true);
            //pastaTabButton.setDisable(true);
//            Offer1Action();
//            Prod_amount=0;
            productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        } 
    }

    @FXML
    private void mainMenuPastaSlide1Image3CartAction(ActionEvent event) {
        mainMenuPastaSlide1Image3Cart.setDisable(true);
        Prod_ID="413";
        Prod_Name="CREAMY TOMATO PASTA VEG";
        Product_Quantity=1;
        Prod_Size="F";
        Prod_amount=170;
        Size_medium=159;
        if(Offer1_FXMLController.Offer1ID==101)
        {
            System.out.println("Hello offer1");
            //bevTabButton.setDisable(true);
            //pastaTabButton.setDisable(true);
//            Offer1Action();
//            Prod_amount=0;
            productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
            
            //addToCartAction();            
        }
        
        else
        {
        productListAction(Prod_ID,Prod_Name,Product_Quantity, Prod_amount,Prod_Size);
        addToCartAction();
        }
    }

    public void addToCartAction() {
            Cart_number++;
            if(Cart_number==1){
            dialog.setTitle("Cart");
            dialog.setContentText("Checkout/Cart for payment.");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.show();
            }
            //System.out.println("Hello Cart"+Cart_number);
            //Cart_number.setFill(Color.RED);
            goToCartButton.setText("Cart "+Cart_number);
            
                
    }
    
    public void productListAction(String Prod_ID,String Prod_Name,Integer Product_Quantity,int Prod_amount,String Prod_Size)
    {
        if(Offer2_FXMLController.Offer2ID==102)
        {
            if(clicked==3)
            {
            ProductDetails product = new ProductDetails(Prod_ID, Prod_Name, Product_Quantity, Prod_amount,Prod_Size,Remove_Button);
            productList.add(product);
            }
//            else{
//                productList.clear();
//            }
        }
        
        else if(Offer1_FXMLController.Offer1ID==101){
            if(clicked==2)
            {
            ProductDetails product = new ProductDetails(Prod_ID, Prod_Name, Product_Quantity, Prod_amount,Prod_Size,Remove_Button);
            productList.add(product);
            }
            
        }
        
        else if(Offer3_FXMLController.Offer3ID==103){
            if(clicked==1)
            {
            ProductDetails product = new ProductDetails(Prod_ID, Prod_Name, Product_Quantity, Prod_amount,Prod_Size,Remove_Button);
            productList.add(product);
            }
            
        }
        
        else{
        /// Create a new ProductDetails object with the provided parameters
        ProductDetails product = new ProductDetails(Prod_ID, Prod_Name, Product_Quantity, Prod_amount,Prod_Size,Remove_Button);

       //Add the new ProductDetails object to the productList
        productList.add(product);
        }
        System.out.println("Size of product List : "+productList.size());
    }

    @FXML
    private void goToCartButtonAction(ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("/CheckOut/CheckOut_FXML.fxml"));
            Stage stage=(Stage) mainMenuVegSlide1Image1.getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            }
            catch(IOException e)
            {
                e.printStackTrace();
                System.exit(0);
            }                       
}
    
    
    public void Offer1Action(int Prod_amount)
    {
        clicked++;
        Prod_ID="OFF1";
        Prod_Name="COMBO PACK";
        Product_Quantity=1;
        amountAdd=amountAdd+Prod_amount;
        Prod_Size="M";
        goToCartButton.setText("Cart "+clicked);
        
        if(clicked==2)
        {
            //goToCartButton.setDisable(false);
             //productList.clear();
            System.out.println("Final offer 2 ammount : "+(amountAdd));
            productListAction(Prod_ID,Prod_Name,Product_Quantity,(amountAdd),Prod_Size);
            
    
           
        }
        if(clicked%2!=0 && clicked>2)
        {
            
            productList.clear();
            dialog.setTitle("Cart");
            dialog.setContentText("only 2 selections possible for this offer.  "+Prod_Name);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.show();
            //goToCartButton.setDisable(true);
            System.out.println("Value of count :"+clicked);
            clicked=0;
              
            
        }
    }
    
    public void Offer2Action(int Prod_amount)
    {
        clicked++;
        Prod_ID="OFF2";
        Prod_Name="FAMILY FEST";
        Product_Quantity=1;
        amountAdd=amountAdd+Prod_amount;
        Prod_Size="S";
        goToCartButton.setText("Cart "+clicked);
        if(clicked==3)
        {
            //goToCartButton.setDisable(false);
             //productList.clear();
            
            System.out.println("Final offer 2 ammount : "+(amountAdd+57+179));
            
            //Summary_and_PromoFXMLController.discountLabel.setText("20%");
            productListAction(Prod_ID,Prod_Name,Product_Quantity,(amountAdd+57+179),Prod_Size);
    
           
        }
       else if(clicked%3!=0 && clicked>3)
        {
            
            productList.clear();
            dialog.setTitle("Cart");
            dialog.setContentText("only 3 selections possible for this offer.  "+Prod_Name);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.show();
            
            System.out.println("Value of count :"+clicked);
            clicked=0;
        }
    }
    
    public void Offer3Action(int Prod_amount)
    {
        clicked++;
        Prod_ID="OFF3";
        Prod_Name="WEEKEND SPECIAL";
        Product_Quantity=1;
        amountAdd=amountAdd+Prod_amount;
        Prod_Size="L";
        goToCartButton.setText("Cart "+clicked);
        
        if(clicked==1)
        {
            //goToCartButton.setDisable(false);
             //productList.clear();
            System.out.println("Final offer 2 ammount : "+(amountAdd+57+159));
            productListAction(Prod_ID,Prod_Name,Product_Quantity,(amountAdd+57+159),Prod_Size);
            
    
           
        }
        if(clicked>1)
        {
            
            productList.clear();
            dialog.setTitle("Cart");
            dialog.setContentText("only 1 selections possible for this offer.  "+Prod_Name);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.show();
            //goToCartButton.setDisable(true);
            System.out.println("Value of count :"+clicked);
            clicked=0;
              
            
        }
    }

    @FXML
    private void vegTabButtonAction(Event event) {
    }

    @FXML
    private void nonVegTabButtonAction(Event event) {
    }

    @FXML
    private void bevTabButtonAction(Event event) {
        //bevTabButton.setDisable(true);
    }

    @FXML
    private void pastaTabButtonAction(Event event) {
    }

    @FXML
    private void goToTodaysOfferAction(ActionEvent event) {
            
            clicked=0;
            Cart_number=0;
        
         try{
                Parent root= FXMLLoader.load(getClass().getResource("/Todays_Menu/Todays_Menu_FXML.fxml"));
                Stage stage=(Stage) mainMenuVegSlide1Image1.getScene().getWindow();
                Scene scene=new Scene(root);
                stage.setScene(scene);
           }
           catch(IOException e)
           {
               e.printStackTrace();
               System.exit(0);
           }
    }
    
    private void mainMenuImageButtonDisable()
    {
        //TAB BUTTONS
            pastaTabButton.setDisable(true);
            bevTabButton.setDisable(true);
//            if(pastaTabButton.isDisabled() || bevTabButton.isDisabled());
//            {
//                Alert alert=new Alert(AlertType.WARNING);
//                alert.setContentText("Offer Section is not for Pizza and Bevreges!");
//                alert.showAndWait();
//                
//            }
           
        
           

         //VEG ITEMS
            mainMenuVegSlide1Image1.setDisable(true);
            mainMenuVegSlide1Image1.setOpacity(1.0);  //opacity lies between 0.0 and 1.0 (0.0 means no visible) (0.1 means full visible).
            mainMenuVegSlide1Image2.setDisable(true);
            mainMenuVegSlide1Image2.setOpacity(1.0);
            mainMenuVegSlide1Image3.setDisable(true);
            mainMenuVegSlide1Image3.setOpacity(1.0);
            mainMenuVegSlide2Image1.setDisable(true);
            mainMenuVegSlide2Image1.setOpacity(1.0);  //opacity lies between 0.0 and 1.0 (0.0 means no visible) (0.1 means full visible).
            mainMenuVegSlide2Image2.setDisable(true);
            mainMenuVegSlide2Image2.setOpacity(1.0);
            mainMenuVegSlide2Image3.setDisable(true);
            mainMenuVegSlide2Image3.setOpacity(1.0);
            mainMenuVegSlide3Image1.setDisable(true);
            mainMenuVegSlide3Image1.setOpacity(1.0);  //opacity lies between 0.0 and 1.0 (0.0 means no visible) (0.1 means full visible).
            mainMenuVegSlide3Image2.setDisable(true);
            mainMenuVegSlide3Image2.setOpacity(1.0);
         
        //NON VEG ITEMS
            mainMenuNonVegSlide1Image11.setDisable(true);
            mainMenuNonVegSlide1Image11.setOpacity(1.0);  
            mainMenuNonVegSlide1Image2.setDisable(true);
            mainMenuNonVegSlide1Image2.setOpacity(1.0);  
            mainMenuNonVegSlide1Image3.setDisable(true);
            mainMenuNonVegSlide1Image3.setOpacity(1.0);  
            mainMenuNonVegSlide2Image1.setDisable(true);
            mainMenuNonVegSlide2Image1.setOpacity(1.0);  
            mainMenuNonVegSlide2Image2A.setDisable(true);
            mainMenuNonVegSlide2Image2A.setOpacity(1.0);  
            mainNonVegMenuSlide2Image3.setDisable(true);
            mainNonVegMenuSlide2Image3.setOpacity(1.0);  
            
        //BEVREGES ITEMS
            
            mainMenuBevSlide1Image1.setDisable(true);
            mainMenuBevSlide1Image1.setOpacity(1.0);
            mainMenuBevSlide1Image2.setDisable(true);
            mainMenuBevSlide1Image2.setOpacity(1.0);
            mainMenuBevSlide1Image3.setDisable(true);
            mainMenuBevSlide1Image3.setOpacity(1.0);
            mainMenuBevSlide3Image1.setDisable(true);
            mainMenuBevSlide3Image1.setOpacity(1.0);
            
        //PASTA ITEMS
        
            mainMenuPastaSlide1Image1.setDisable(true);
            mainMenuPastaSlide1Image1.setOpacity(1.0);
            mainMenuPastaSlide1Image2.setDisable(true);
            mainMenuPastaSlide1Image2.setOpacity(1.0);
            mainMenuPastaSlide1Image3.setDisable(true);
            mainMenuPastaSlide1Image3.setOpacity(1.0);
            
            
    }
      
      
    

    
    
}


