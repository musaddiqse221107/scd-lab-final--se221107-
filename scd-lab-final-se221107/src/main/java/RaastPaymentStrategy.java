public final class RaastPaymentStrategy implements PaymentStrategy {
    public static final double FIXED_FEE = 12.0;

    @Override
    public double apply(double amount) {
        return amount + FIXED_FEE;
    }
}
