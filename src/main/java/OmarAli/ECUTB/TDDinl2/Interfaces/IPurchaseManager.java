package OmarAli.ECUTB.TDDinl2.Interfaces;

public interface IPurchaseManager {
    /**
     * Calculate the sum of all purchases for a month.
     * @param year
     * @param month
     */
    float sumOfMonth(int year, int month);
    /**
     * For a specified year, calculate each months average purchases.
     * @param year
     * @return Array of averages per month.
     */
    float[] monthlyAverage(int year);
    /**
     * For a specified year, calculate each category's average purchases.
     * @param year
     * @return Array of averages per category.
     */
    float[] yearlyAveragePerCategory(int year);
}
