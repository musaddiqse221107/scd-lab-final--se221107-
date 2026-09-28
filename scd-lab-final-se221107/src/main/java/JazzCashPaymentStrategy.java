public final class JazzCashPaymentStrategy implements PaymentStrategy {
    public static final double FIXED_FEE = 10.0;

    @Override
    public double apply(double amount) {
        return amount + FIXED_FEE;
    }
}
