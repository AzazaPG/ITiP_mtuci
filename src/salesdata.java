

import java.util.ArrayList;
import java.util.List;

public class salesdata {
    public static List<String> getCommonProducts(String[][] sales) {
        List<String> commonProducts = new ArrayList<>();
        
        for (int j = 1; j < sales[0].length; j++) {
            boolean shopExists = true;
            
            for (int i = 1; i < sales.length; i++) {
                if (!containsShop(sales[i], sales[0][j])) {
                    shopExists = false;
                    break;
                }
            }
            
            if (shopExists) {
                commonProducts.add(sales[0][j]);
            }
        }
        
        return commonProducts;
    }
    
    public static boolean containsShop(String[] shops, String shop) {
        for (int i = 0; i < shops.length; i++) {
            if (shops[i].equals(shop)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        String[][] sales1 = {
            {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Banana", "Shop2", "Shop3", "Shop4"},
            {"Orange", "Shop1", "Shop3", "Shop4"},
            {"Pear", "Shop2", "Shop4"}
        };
        List<String> result1 = getCommonProducts(sales1);
        System.out.println(result1); // Output: [Apple]
        
        String[][] sales2 = {
            {"Fridge", "Shop2", "Shop3"},
            {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Laptop", "Shop3", "Shop4"},
            {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        };
        List<String> result2 = getCommonProducts(sales2);
        System.out.println(result2); // Output: [Microwave, Phone]
    }
}