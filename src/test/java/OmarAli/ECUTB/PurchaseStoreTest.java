package OmarAli.ECUTB;


import OmarAli.ECUTB.TDDinl2.Daos.PurchaseStore;
import OmarAli.ECUTB.TDDinl2.Entity.Category;
import OmarAli.ECUTB.TDDinl2.Entity.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class PurchaseStoreTest
{
    /**
     * Rigorous Test :-)
     */
    PurchaseStore purchaseStore;
    Purchase purchase1;
    Purchase purchase2;
    Category category1;
    Category category2;
    @BeforeEach
    public void setUp(){
        purchaseStore = new PurchaseStore();

        Date start = new Date(2067, Calendar.JANUARY,1);
        Date end = new Date(2019,Calendar.JANUARY,1);
        purchase1 = new Purchase(1,start, 1, "First purchase", 1);
        purchase2 = new Purchase(2,end, 2, "Second purchase", 2);
        purchaseStore.addPurchase(purchase1);
        purchaseStore.addPurchase(purchase2);
        category1 = new Category(1,"category1");
        category2 = new Category(2,"category2");
        purchaseStore.addCategory(category1);
        purchaseStore.addCategory(category2);
    }
    @Test
    public void getPurchasesTest()
    {
        Purchase[] expected = {purchase1, purchase2};
        Date start = new Date(2019,Calendar.JUNE,6);
        Date end = new Date(2020,Calendar.MAY,5);

        assertArrayEquals(expected, purchaseStore.getPurchases(start,end) );

    }
    @Test
    public void getPurchasesByCategoryTest()
    {
        Purchase[] expected = {purchase1, purchase2};
        Date start = new Date(2019,Calendar.JUNE,6);
        Date end = new Date(2020,Calendar.MAY,5);
        assertArrayEquals(expected, purchaseStore.getPurchasesByCategory(start,end, 1));

    }
    @Test
    public void getAllCategoriesTest()
    {
        Category[] expected = {category1,category2};
        assertArrayEquals(expected, purchaseStore.getAllCategories());
        assertTrue( true );
    }
}
