public final class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public double apply(double amount) {
        return amount;
    }
}
