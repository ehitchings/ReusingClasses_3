package ReusingClasses_3;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;


/**
 * Created by evanhitchings on 9/14/16.
 */
public class InventoryTest {

    Inventory inventory = new Inventory();
    Product talon = new Product ("Talon", 50.00, 6);
    Product battlecon = new Product ("BattleCon", 75.00, 1);
    Product foodChainMagnate = new Product ("Food Chain Magnate", 150.00, 3);
    Product woodenShips = new Product ("Wooden Ships and Iron Men", 40.00, 0);

    @Before
    public void setup(){
        inventory.add(talon);
        inventory.add(battlecon);
        inventory.add(foodChainMagnate);
        inventory.add(woodenShips);
    }

    @Test
    public void totalValueTest(){
        assertEquals(825.00, inventory.totalValue(), 0.00);
    }

    @Test
    public void totalItemsTest(){
        assertEquals(10, inventory.totalItems(), 0);
    }


}
