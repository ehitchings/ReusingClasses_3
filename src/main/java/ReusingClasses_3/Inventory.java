package ReusingClasses_3;

import java.util.ArrayList;

/**
 * Created by evanhitchings on 9/14/16.
 */
public class Inventory extends ArrayList<Product> {

    protected double totalValue(){
        double totalValue = 0.00;
        for(Product product : this){
            totalValue += (product.getPrice() * product.getQuantity());
        }
        return totalValue;
    }

    protected int totalItems(){
        int totalItems = 0;
        for(Product product : this){
            totalItems += product.getQuantity();
        }
        return totalItems;
    }
}
