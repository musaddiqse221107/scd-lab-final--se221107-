import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyaltyDiscountServiceTest {
    @Test
    void seventeenOrdersGetsPersonalisedTwelvePercentDiscount() {
        OrderService service = new OrderService();
        assertEquals(616.0,
                service.calculateTotal(new String[]{"BIRYANI"}, new int[]{2}, PaymentMethod.CASH, 17),
                0.000001);
    }
}
