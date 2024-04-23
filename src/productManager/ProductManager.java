package productManager;

import Main_Menu.ProductDetails;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static List<ProductDetails> productList = new ArrayList<>();
    private static List<ProductDetails> removedProducts = new ArrayList<>(); // List to track removed products

    // ... Other methods ...

    public static void removeProduct(ProductDetails product) {
        productList.remove(product);
        removedProducts.add(product); // Add the removed product to the list
    }

    // ... Other methods ...

    public static List<ProductDetails> getProductList() {
        return productList;
    }

    public static List<ProductDetails> getRemovedProducts() {
        return removedProducts;
    }
}
