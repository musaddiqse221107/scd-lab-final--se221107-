public final class NoOpPaymentGateway implements PaymentGateway {
    @Override
    public void charge(double amount) {
        // Production adapter can be supplied here; default keeps the lab self-contained.
    }
}
