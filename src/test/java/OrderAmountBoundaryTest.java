import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderAmountBoundaryTest {
    @Test
    void subtotalOfExactlyOneThousandGetsNoBulkDiscount() {
        assertEquals(1000.0,
                DiscountPolicy.applyBulkDiscount(1000.0),
                0.000001);
    }

    @Test
    void subtotalAboveOneThousandGetsBulkDiscount() {
        assertEquals(950.95,
                DiscountPolicy.applyBulkDiscount(1001.0),
                0.000001);
    }
}
