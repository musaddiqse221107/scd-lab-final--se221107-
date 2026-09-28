import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RaastPaymentTest {
    @Test
    void raastUsesPersonalisedFixedFee() {
        assertEquals(112.0, new RaastPaymentStrategy().apply(100.0), 0.000001);
    }
}
