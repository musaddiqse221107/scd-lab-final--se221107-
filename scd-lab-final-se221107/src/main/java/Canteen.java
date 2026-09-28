public class Canteen {
    public static int tokenCounter = 0;
    private final OrderService orderService;

    public Canteen() {
        this(new OrderService());
    }

    public Canteen(OrderService orderService) {
        this.orderService = orderService;
    }

    public String placeOrder(String sid, String[] items, int[] qty, String pay, int pastOrders) {
        PaymentMethod paymentMethod = PaymentMethod.from(pay);
        double total = orderService.calculateTotal(items, qty, paymentMethod, pastOrders);
        orderService.charge(total);
        tokenCounter++;
        String token = "T" + tokenCounter;
        return token + "," + total;
    }
}
