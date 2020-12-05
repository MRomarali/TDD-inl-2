package OmarAli.ECUTB;

import OmarAli.ECUTB.TDDinl2.Daos.PurchaseManager;
import OmarAli.ECUTB.TDDinl2.Daos.PurchaseStore;
import OmarAli.ECUTB.TDDinl2.Entity.Category;
import OmarAli.ECUTB.TDDinl2.Entity.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseManagerTest {

     PurchaseManager purchaseManager;
     PurchaseStore purchaseStore;
     Purchase purchase1;
     Purchase purchase2;
    Category category1;
    Category category2;
    @BeforeEach
    void setup(){
        purchaseStore = new PurchaseStore();
        purchaseManager = new PurchaseManager(purchaseStore);
        Date start = new Date(1967, Calendar.JANUARY,1);
        Date end = new Date(2019,Calendar.JANUARY,1);
        purchase1 = new Purchase(1,start, 550, "First purchase", 1);
        purchase2 = new Purchase(2,end, 1200, "Second purchase", 2);
        purchaseStore.addPurchase(purchase1);
        purchaseStore.addPurchase(purchase2);
        category1 = new Category(1,"category1");
        category2 = new Category(2,"category2");
        purchaseStore.addCategory(category1);
        purchaseStore.addCategory(category2);
    }

    @Test
    public void canInstantiateClass(){
        assertNotNull(purchaseManager);
    }
    @Test
    public void sumOfMonthTest()
    {
        assertEquals(1200, purchaseManager.sumOfMonth(2019,1));
        assertEquals(550, purchaseManager.sumOfMonth(1967,1));
    }
    @Test
    public void monthlyAverageTest()
    {
        float[] expected1 = {10,10,10};
        float[] expected2 = {10,10,10};
        assertArrayEquals(expected1, purchaseManager.monthlyAverage(1967));
        assertArrayEquals(expected2, purchaseManager.monthlyAverage(2019));
    }
    @Test
    public void yearlyAveragePerCategoryTest()
    {
        float[] expected1 = {10,10};
        float[] expected2 = {10,10};
        assertArrayEquals(expected1, purchaseManager.yearlyAveragePerCategory(2010));
        assertArrayEquals(expected2, purchaseManager.yearlyAveragePerCategory(2020));

    }
}
