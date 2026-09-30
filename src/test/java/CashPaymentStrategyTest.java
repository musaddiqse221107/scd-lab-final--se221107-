import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CashPaymentStrategyTest {
    @Test
    void cashDoesNotAddFee() {
        assertEquals(100.0, new CashPaymentStrategy().apply(100.0));
    }
}
