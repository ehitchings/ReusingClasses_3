package ReusingClasses_3;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by evanhitchings on 9/14/16.
 */
public class InventoryManagerTest {

    InventoryManager inventoryManager = new InventoryManager();
    //Inventory inventory = new Inventory();
    Product talon = new Product ("Talon", 50.00, 6);
    Product battlecon = new Product ("BattleCon", 75.00, 1);
    Product foodChainMagnate = new Product ("Food Chain Magnate", 150.00, 3);
    Product woodenShips = new Product ("Wooden Ships and Iron Men", 40.00, 0);

    @Before
    public void setup(){
        inventoryManager.getInventory().add(talon);
        inventoryManager.getInventory().add(battlecon);
        inventoryManager.getInventory().add(foodChainMagnate);
        inventoryManager.getInventory().add(woodenShips);
    }

    @Test
    public void sellItemsTest(){
        assertEquals(100.00, inventoryManager.sellItems("Talon", 2), 0.00);
        assertEquals(450.00, inventoryManager.sellItems("Food Chain Magnate", 4), 0.00);
        assertNull(inventoryManager.sellItems("Wooden Ships and Iron Men", 1));
    }

    @Test
    public void receiveStockTest(){
        //string and int test
        inventoryManager.receiveStock("Wooden Ships and Iron Men", 3);
        assertEquals("Quantity of product was not changed appropriately.", 3, woodenShips.getQuantity());
        //Product test
        inventoryManager.receiveStock(battlecon);
        assertEquals("Quantity did not match after adding", 2, battlecon.getQuantity());
                //this.inventoryManager.getInventory().get(inventoryManager.getInventory().indexOf(battlecon)).getQuantity());

    }

    @Test
    public void removeStockTest(){
        inventoryManager.removeStock("Food Chain Magnate", 4);
        assertEquals("Stock was not removed", -1, foodChainMagnate.getQuantity());
    }

    @Test
    public void changePrice(){
        inventoryManager.changePrice("Wooden Ships and Iron Men", 50.00);
        assertEquals(50.00, woodenShips.getPrice(), 0.00);
}

}
