import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderServiceBoundaryTest {
    private final OrderService service = new OrderService();

    @Test
    void emptyOrderIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> service.calculateSubtotal(new String[0], new int[0]));
    }

    @Test
    void unknownItemIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> service.calculateSubtotal(new String[]{"UNKNOWN"}, new int[]{1}));
    }
}
