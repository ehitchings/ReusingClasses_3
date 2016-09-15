package ReusingClasses_3;

import java.util.ArrayList;

/**
 * Created by evanhitchings on 9/14/16.
 */
public class InventoryManager {

    private Inventory inventory;


    public InventoryManager() {
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Double sellItems(String item, int quantity){
        for (Product product : this.inventory){
            if (product.getId().equalsIgnoreCase(item)){
                if(product.getQuantity() <= 0){
                    break;
                }
                if (quantity > product.getQuantity()){
                    int remaining = quantity - product.getQuantity();
                    System.out.println("Only " + product.getQuantity() + " items available. Selling all available stock.");
                    quantity = product.getQuantity();
                }
                Double total = product.getPrice() * quantity;
                product.setQuantity(product.getQuantity() - quantity);
                System.out.println("Sold " + quantity + " items for a total of " + total + ".");
                return total;

            }
        }
        System.out.println("Item not in inventory");
        return null;

    }


    public void changePrice(String productId, double newPrice){
        for (Product product : this.inventory){
            if (product.getId().equalsIgnoreCase(productId)){
                product.setPrice(newPrice);
                break;
            }
        }

    }

    public void receiveStock(String productName, int shipment){
        for(Product product : this.getInventory()){
            if(product.getId().equalsIgnoreCase(productName)){
                product.setQuantity(product.getQuantity() + shipment);
                break;
            }

        }
    }

    public void receiveStock(Product productToAdd){
        for(Product product : this.getInventory()){
            if(product.getId().equalsIgnoreCase(productToAdd.getId())){
                System.out.println("Adding " + productToAdd.getQuantity() + " to existing stock.");
                product.setQuantity(product.getQuantity() + productToAdd.getQuantity());
                break;
            }
        }
        System.out.println("Adding product to stock.");
        this.getInventory().add(productToAdd);
    }

    public void removeStock(String productName, int shrink){
        for(Product product : this.getInventory()){
            if(product.getId().equalsIgnoreCase(productName)){
                product.setQuantity(product.getQuantity() - shrink);
                if (product.getQuantity() < 0){
                    System.out.println("Quantity is now negative. Ensure that all recent shipments have been entered into inventory");
                }
                break;
            }
        }
        System.out.println("Product not found");

    }
}
