import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentStrategyTest {
    @Test void cashHasNoFee() { assertEquals(100.0, new CashPaymentStrategy().apply(100.0)); }
    @Test void cardAddsTwoPercent() { assertEquals(102.0, new CardPaymentStrategy().apply(100.0)); }
    @Test void jazzCashAddsTen() { assertEquals(110.0, new JazzCashPaymentStrategy().apply(100.0)); }
    @Test void raastAddsTwelve() { assertEquals(112.0, new RaastPaymentStrategy().apply(100.0)); }
}
