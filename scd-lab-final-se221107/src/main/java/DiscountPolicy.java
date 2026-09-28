public final class DiscountPolicy {
    public static final double BULK_THRESHOLD = 1000.0;
    public static final double BULK_RATE = 0.05;
    public static final int LOYALTY_THRESHOLD = 17;
    public static final double LOYALTY_RATE = 0.12;

    private DiscountPolicy() { }

    public static double applyBulkDiscount(double subtotal) {
        return subtotal > BULK_THRESHOLD ? subtotal * (1 - BULK_RATE) : subtotal;
    }

    public static double applyLoyaltyDiscount(double afterBulk, int pastOrders) {
        return pastOrders >= LOYALTY_THRESHOLD
                ? afterBulk * (1 - LOYALTY_RATE)
                : afterBulk;
    }
}
