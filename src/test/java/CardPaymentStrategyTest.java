import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CardPaymentStrategyTest {
    @Test
    void cardAddsTwoPercent() {
        assertEquals(102.0, new CardPaymentStrategy().apply(100.0), 0.000001);
    }
}
