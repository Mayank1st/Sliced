
package Main_Menu;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;


public class ProductDetails {
    public SimpleStringProperty Prod_ID;
    public SimpleStringProperty Prod_Name;
    public int Product_Quantity;
    public int Prod_amount;
    public SimpleStringProperty Prod_Size;
    public Button Remove_Button;
    private static boolean isFromProductDetailsController = false;
        
    
   public static boolean isFromProductDetailsController() {
        return isFromProductDetailsController;
    }

    public static void setFromProductDetailsController(boolean value) {
        isFromProductDetailsController = value;
    }
    
    
   public  ProductDetails(String Prod_ID,String Prod_Name,int Product_Quantity,int Prod_amount,String Prod_Size,Button Remove_Button)
    {
        this.Prod_ID=new SimpleStringProperty(Prod_ID);
        this.Prod_Name=new SimpleStringProperty(Prod_Name);
        this.Product_Quantity= Product_Quantity;//since humne product quantity me string value liya hai Main_menu me but yaha pe humne spinner ko integer tag diya hai isiliye parseInt() ka use krke humne string to int me convert kiya
        this.Prod_amount=Prod_amount; 
        this.Prod_Size=new SimpleStringProperty(Prod_Size);
        this.Remove_Button=new Button("Remove");   //ye button text "Remove" display screen me button pe display hota hai
        
    }
    
    //Return the ID
    public String getProd_ID()
    {
        return Prod_ID.get();
    }
    public void setProd_ID(String Prod_ID)
    {
        this.Prod_ID.set(Prod_ID);
    }
    
    
    //returning the product name
    public String getProd_Name()
    {
        return Prod_Name.get();
    }
    public void setProd_Name(String Prod_Name)
    {
        this.Prod_Name.set(Prod_Name);
    }
    
    //return the quantity
    public int getProduct_Quantity()
    {
        return Product_Quantity;
    }
    public void setProduct_Quantity(int Product_Quantity)
    {
        this.Product_Quantity=Product_Quantity;
    }
    public int productQuantityProperty() {
        return Product_Quantity;
    }
    
    //return the amount
    public int getProd_amount()
    {
        return Prod_amount;
    }
    public void setProd_amount(int Prod_amount)
    {
        this.Prod_amount=Prod_amount;
    }
    
    public String getProd_Size()
    {
        return Prod_Size.get();
    }
    public void setProd_Size(String Prod_Size)
    {
        this.Prod_Size.set(Prod_Size);
    }
     public Button getRemove_Button()
    {
        return Remove_Button;
    }
    public void setRemove_Button(Button Remove_Button)
    {
        this.Remove_Button=Remove_Button;
    }
    
}


