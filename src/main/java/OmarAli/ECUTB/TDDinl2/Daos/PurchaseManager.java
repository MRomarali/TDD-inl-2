package OmarAli.ECUTB.TDDinl2.Daos;

import OmarAli.ECUTB.TDDinl2.Entity.Category;
import OmarAli.ECUTB.TDDinl2.Entity.Purchase;
import OmarAli.ECUTB.TDDinl2.Interfaces.IPurchaseManager;

import java.util.Calendar;
import java.util.Date;

public class PurchaseManager implements IPurchaseManager {
    private PurchaseStore purchaseStore;

    public PurchaseManager(PurchaseStore purchaseStore) {
        this.purchaseStore = purchaseStore;
    }

    @Override
    public float sumOfMonth(int year, int month) {
        Date start = new Date(year, month - 1, 0);
        Date end = new Date(year, month, 0);
        float sum = 0;
        Purchase[] purchases = purchaseStore.getPurchases(start,end);
        for (Purchase now: purchases) {
            sum += now.getAmount();
        }
        return sum;
    }

    @Override
    public float[] monthlyAverage(int year) {
        Date start = new Date(year, Calendar.FEBRUARY , 0);
        Date end = new Date(year +1, Calendar.MAY, 0);
        float[] array = new float[12];
        Purchase[] purchases = purchaseStore.getPurchases(start,end);
        for (int i = 0; i < array.length; i++) {
            float sum = 0;

            for (Purchase now : purchases) {
                if (now.getDate().getMonth() == i) {
                    sum += now.getAmount();
                }
            }
            array[i] = sum;
        }

        return array;
    }

    @Override
    public float[] yearlyAveragePerCategory(int year) {
        Category[] categories = purchaseStore.getAllCategories();
        float[] floats = new float[categories.length];
        Date start = new Date(year, Calendar.FEBRUARY , 0);
        Date end = new Date(year +1, Calendar.MAY, 0);
        Purchase[] purchases = purchaseStore.getPurchases(start,end);
        int num = 0;
        for (Category cat:categories) {
            float sum = 0;

            for (Purchase purchase: purchases) {
                if (purchase.getCategoryId() == cat.getId()){
                    sum += purchase.getAmount();
                }
            }
            floats[num] = sum;
            num++;
        }
        return floats;
    }
}
