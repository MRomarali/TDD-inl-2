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
        purchase1 = new Purchase(0,start, 2, "First purchase", 0);
        purchase2 = new Purchase(0,end, 1, "Second purchase", 2);
        category1 = new Category(0,"category1");
        category2 = new Category(1,"category2");
    }
    @Test
    public void getPurchasesTest()
    {
        /*
        Purchase purchase = new Purchase(1, calendar,150.0f,"Purchase1",1);
        Purchase[] purchases = new Purchase[]{purchase};
        */


        Purchase[] expected = {purchase1, purchase2};
        Date start = new Date(2019,Calendar.JUNE,6);
        Date end = new Date(2020,Calendar.MAY,5);

        assertEquals(expected, purchaseStore.getPurchases(start,end) );

    }
    @Test
    public void getPurchasesByCategoryTest()
    {
        Purchase[] expected = {purchase1, purchase2};
        Date start = new Date(2019,Calendar.JUNE,6);
        Date end = new Date(2020,Calendar.MAY,5);
        assertEquals(expected, purchaseStore.getPurchasesByCategory(start,end, 1));

    }
    @Test
    public void getAllCategoriesTest()
    {
        Category[] expected = {category1,category2};
        assertArrayEquals(expected, purchaseStore.getAllCategories());
        assertTrue( true );
    }
}
