public class Canteen {
    private final OrderService orderService;
    private final TokenGenerator tokenGenerator;

    public Canteen() {
        this(new OrderService(), new TokenGenerator());
    }

    public Canteen(OrderService orderService, TokenGenerator tokenGenerator) {
        if (orderService == null || tokenGenerator == null) {
            throw new IllegalArgumentException("Order service and token generator are required");
        }
        this.orderService = orderService;
        this.tokenGenerator = tokenGenerator;
    }

    public String placeOrder(String sid, String[] items, int[] qty, String pay, int pastOrders) {
        if (sid == null || sid.isBlank()) {
            throw new IllegalArgumentException("Student id is required");
        }
        PaymentMethod paymentMethod = PaymentMethod.from(pay);
        double total = orderService.calculateTotal(items, qty, paymentMethod, pastOrders);
        orderService.charge(total);
        return tokenGenerator.nextToken() + "," + total;
    }
}
