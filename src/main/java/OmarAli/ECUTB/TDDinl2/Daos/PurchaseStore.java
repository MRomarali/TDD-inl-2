package OmarAli.ECUTB.TDDinl2.Daos;

import OmarAli.ECUTB.TDDinl2.Entity.Category;
import OmarAli.ECUTB.TDDinl2.Entity.Purchase;
import OmarAli.ECUTB.TDDinl2.Interfaces.IPurchaseStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PurchaseStore implements IPurchaseStore {
    private List<Category> categories = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<>();

    public void addCategory(Category category){
        categories.add(category);
    }
    public void addPurchase(Purchase purchase){
        purchases.add(purchase);
    }

    public PurchaseStore() {
    }

    @Override
    public Purchase[] getPurchases(Date startDate, Date endDate) {
        Purchase[] purchasesArray;
        purchasesArray = purchases.stream()
                .filter(purchase -> purchase.getDate().after(startDate)
                && purchase.getDate().before(endDate))
                .toArray(Purchase[]::new);
        return purchasesArray;
    }

    @Override
    public Purchase[] getPurchasesByCategory(Date start, Date end, int catId) {
        var purchases = getPurchases(start, end);
        return Arrays.stream(purchases)
                .filter(purchase -> purchase.getCategoryId() == catId)
                .toArray(Purchase[]::new);
    }

    @Override
    public Category[] getAllCategories() {
        return categories.toArray(Category[]::new);
    }
}
