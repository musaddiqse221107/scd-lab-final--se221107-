import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JazzCashPaymentStrategyTest {
    @Test
    void jazzCashAddsFixedFee() {
        assertEquals(110.0, new JazzCashPaymentStrategy().apply(100.0), 0.000001);
    }
}
