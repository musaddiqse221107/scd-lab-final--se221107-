public final class PaymentStrategyFactory {
    private PaymentStrategyFactory() { }

    public static PaymentStrategy forMethod(PaymentMethod method) {
        if (method == null) {
            throw new IllegalArgumentException("Unknown payment method");
        }
        return switch (method) {
            case CASH -> new CashPaymentStrategy();
            case CARD -> new CardPaymentStrategy();
            case JAZZCASH -> new JazzCashPaymentStrategy();
            case RAAST -> new RaastPaymentStrategy();
        };
    }
}
