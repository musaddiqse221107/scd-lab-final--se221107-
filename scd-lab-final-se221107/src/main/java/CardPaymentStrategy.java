public final class CardPaymentStrategy implements PaymentStrategy {
    public static final double SURCHARGE_RATE = 0.02;

    @Override
    public double apply(double amount) {
        return amount * (1 + SURCHARGE_RATE);
    }
}
