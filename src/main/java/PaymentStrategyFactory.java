import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class PaymentStrategyFactory {
    private static final Map<PaymentMethod, Supplier<PaymentStrategy>> REGISTRY =
            new EnumMap<>(PaymentMethod.class);

    static {
        REGISTRY.put(PaymentMethod.CASH, CashPaymentStrategy::new);
        REGISTRY.put(PaymentMethod.CARD, CardPaymentStrategy::new);
        REGISTRY.put(PaymentMethod.JAZZCASH, JazzCashPaymentStrategy::new);
        REGISTRY.put(PaymentMethod.RAAST, RaastPaymentStrategy::new);
    }

    private PaymentStrategyFactory() {
    }

    public static PaymentStrategy forMethod(PaymentMethod method) {
        if (method == null || !REGISTRY.containsKey(method)) {
            throw new IllegalArgumentException("Unknown payment method");
        }
        return REGISTRY.get(method).get();
    }
}
