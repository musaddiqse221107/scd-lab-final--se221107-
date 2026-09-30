import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoyaltyBoundaryTest {
    @ParameterizedTest
    @CsvSource({
            "16, 1000.0",
            "17, 880.0",
            "18, 880.0"
    })
    void loyaltyBoundaryIsInclusive(int pastOrders, double expected) {
        assertEquals(expected,
                DiscountPolicy.applyLoyaltyDiscount(1000.0, pastOrders),
                0.000001);
    }

    @Test
    void bulkDiscountHappensBeforeLoyaltyDiscount() {
        double subtotal = 1200.0;
        double afterBulk = DiscountPolicy.applyBulkDiscount(subtotal);
        assertEquals(1003.2,
                DiscountPolicy.applyLoyaltyDiscount(afterBulk, 17),
                0.000001);
    }

    @Test
    void emptyOrderIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderService().calculateTotal(new String[0], new int[0], PaymentMethod.CASH, 0));
    }

    @Test
    void unknownItemIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderService().calculateTotal(
                        new String[]{"UNKNOWN"}, new int[]{1}, PaymentMethod.CASH, 0));
    }

    @Test
    void negativeOrderHistoryIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderService().calculateTotal(
                        new String[]{"CHAI"}, new int[]{1}, PaymentMethod.CASH, -1));
    }
}
