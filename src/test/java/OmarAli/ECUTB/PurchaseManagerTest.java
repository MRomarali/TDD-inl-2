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
import static org.mockito.Mockito.when;

public class PurchaseManagerTest {

    private PurchaseManager purchaseManager;
    private PurchaseStore purchaseStore;
    private Purchase purchase1;
    private Purchase purchase2;
    Category category1;
    Category category2;
    @BeforeEach
    void setup(){
        purchaseStore = new PurchaseStore();
        purchaseManager = new PurchaseManager(purchaseStore);
        Date start = new Date(2067, Calendar.JANUARY,1);
        Date end = new Date(2019,Calendar.JANUARY,1);
        purchase1 = new Purchase(0,start, 2, "First purchase", 0);
        purchase2 = new Purchase(0,end, 1, "Second purchase", 2);
        category1 = new Category(0,"category1");
        category2 = new Category(1,"category2");

    }

    @Test
    public void canInstantiateClass(){
        assertNotNull(purchaseManager);
    }
    @Test
    public void sumOfMonthTest()
    {
        when(purchaseStore.getPurchases(new Date(2002,02,07), new Date(2005,06,06)))
                .thenReturn(new Purchase[]{
                purchase1, purchase2
                });
        assertEquals(500, purchaseManager.sumOfMonth(2002,06));

    }
    @Test
    public void monthlyAverageTest()
    {
        when(purchaseStore.getPurchases(new Date(2002,02,07), new Date(2005,06,06)))
                .thenReturn(new Purchase[]{
                        purchase1, purchase2
                });
        float[] expected = {4,3,2,66,4,2,11,100};
        assertArrayEquals(expected, purchaseManager.monthlyAverage(2002));
    }
    @Test
    public void yearlyAveragePerCategoryTest()
    {
        when(purchaseStore.getAllCategories()).thenReturn(new Category[]{category1, category2});
        when(purchaseStore.getPurchases(new Date(2002, 3, 5), new Date(2006, 06, 06)))
                .thenReturn(new Purchase[]{purchase1, purchase2});
        float[] expected = {10,20,30};
        assertArrayEquals(expected, purchaseManager.yearlyAveragePerCategory(2008));
    }
}
