package OmarAli.ECUTB;

import OmarAli.ECUTB.TDDinl2.Daos.PurchaseManager;
import OmarAli.ECUTB.TDDinl2.Daos.PurchaseStore;
import OmarAli.ECUTB.TDDinl2.Entity.Category;
import OmarAli.ECUTB.TDDinl2.Entity.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PurchaseManagerMockitoTest {
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
        category1 = new Category(1,"category1");
        category2 = new Category(2,"category2");

    }

    @Test
    public void sumOfMonthTest()
    {
        purchaseStore = mock(PurchaseStore.class);
        purchaseManager = new PurchaseManager( purchaseStore);

        when(purchaseStore.getPurchases(new Date(1967, Calendar.JANUARY, 0),
                new Date(1968, Calendar.JANUARY, 0)))
                .thenReturn(new Purchase[]{purchase1, purchase2});

        float[] expected1 = {1750, 0, 0};

        assertArrayEquals(expected1, purchaseManager.monthlyAverage(1967));
    }
    @Test
    public void monthlyAverageTest()
    {
        purchaseStore = mock(PurchaseStore.class);
        purchaseManager = new PurchaseManager( purchaseStore);

        when(purchaseStore.getPurchases(new Date(2019, 0, 0),
                new Date(2020, 0, 0)))
                .thenReturn(new Purchase[]{purchase1, purchase2});

        float[] expected1 = {1750, 0, 0};

        assertArrayEquals(expected1, purchaseManager.monthlyAverage(2019));
    }
    @Test
    public void yearlyAveragePerCategoryTest()
    {
        purchaseStore = mock(PurchaseStore.class);
        purchaseManager = new PurchaseManager( purchaseStore);

        when(purchaseStore.getAllCategories())
                .thenReturn(new Category[]{category1,category2});

        when(purchaseStore.getPurchases(new Date(1967, Calendar.JANUARY, 0),
                new Date(1968, Calendar.JANUARY, 0)))
                .thenReturn(new Purchase[]{purchase1, purchase2});

        float[] expected1 = {550,1200};

        assertArrayEquals(expected1, purchaseManager.yearlyAveragePerCategory(1967));}
}
