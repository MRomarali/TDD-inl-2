package OmarAli.ECUTB;

import OmarAli.ECUTB.TDDinl2.Daos.PurchaseManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PurchaseManagerTest {

    private PurchaseManager purchaseManager;
    @BeforeEach
    void setup(){
        purchaseManager = new PurchaseManager();
    }

    @Test
    public void canInstantiateClass(){
        assertNotNull(purchaseManager);
    }
    @Test
    public void sumOfMonthTest()
    {
        assertEquals(1000,purchaseManager.sumOfMonth(2010, 3));
    }
    @Test
    public void monthlyAverageTest()
    {
    }
    @Test
    public void yearlyAveragePerCategoryTest()
    {
    }
}
