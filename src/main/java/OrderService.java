public final class OrderService {
    private final PaymentGateway paymentGateway;

    public OrderService() {
        this(new NoOpPaymentGateway());
    }

    public OrderService(PaymentGateway paymentGateway) {
        if (paymentGateway == null) {
            throw new IllegalArgumentException("Payment gateway is required");
        }
        this.paymentGateway = paymentGateway;
    }

    public double calculateSubtotal(String[] items, int[] qty) {
        validateOrder(items, qty);
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            MenuItem item = MenuItem.from(items[i]);
            if (item == null) {
                throw new IllegalArgumentException("Unknown menu item: " + items[i]);
            }
            total += item.price() * qty[i];
        }
        return total;
    }

    public double calculateTotal(String[] items, int[] qty, PaymentMethod paymentMethod, int pastOrders) {
        if (pastOrders < 0) {
            throw new IllegalArgumentException("Past order count cannot be negative");
        }
        double subtotal = calculateSubtotal(items, qty);
        double afterBulk = DiscountPolicy.applyBulkDiscount(subtotal);
        double afterLoyalty = DiscountPolicy.applyLoyaltyDiscount(afterBulk, pastOrders);
        return PaymentStrategyFactory.forMethod(paymentMethod).apply(afterLoyalty);
    }

    public void charge(double amount) {
        paymentGateway.charge(amount);
    }

    private void validateOrder(String[] items, int[] qty) {
        if (items == null || qty == null || items.length == 0 || items.length != qty.length) {
            throw new IllegalArgumentException("Order must contain matching non-empty items and quantities");
        }
        for (int quantity : qty) {
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be positive");
            }
        }
    }
}
