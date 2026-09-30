import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class LoyaltyGatewayTest {
    @Test
    void loyaltyTotalIsChargedExactlyOnce() {
        PaymentGateway gateway = Mockito.mock(PaymentGateway.class);
        OrderService service = new OrderService(gateway);

        double total = service.calculateTotal(
                new String[]{"BIRYANI"}, new int[]{2}, PaymentMethod.CASH, 17);

        service.charge(total);

        verify(gateway, times(1)).charge(616.0);
    }
}
