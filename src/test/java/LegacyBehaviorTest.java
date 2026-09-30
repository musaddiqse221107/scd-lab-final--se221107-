import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LegacyBehaviorTest {
    @BeforeEach
    void resetCounter() {
        Canteen.tokenCounter = 0;
    }

    @Test
    void cashOrderKeepsLegacyPrice() {
        Canteen canteen = new Canteen();
        assertEquals("T1,700.0",
                canteen.placeOrder("S1", new String[]{"BIRYANI"}, new int[]{2}, "CASH", 0));
    }

    @Test
    void mixedOrderKeepsLegacyPrices() {
        Canteen canteen = new Canteen();
        assertEquals("T1,950.0",
                canteen.placeOrder("S2",
                        new String[]{"SANDWICH", "CHAI", "SAMOSA"},
                        new int[]{2, 2, 1}, "CASH", 0));
    }

    @Test
    void bulkDiscountStillApplies() {
        Canteen canteen = new Canteen();
        assertEquals("T1,1026.0",
                canteen.placeOrder("S3",
                        new String[]{"BIRYANI", "SANDWICH", "CHAI"},
                        new int[]{2, 1, 2}, "CASH", 0));
    }

    @Test
    void cardSurchargeStillComesAfterBulkDiscount() {
        Canteen canteen = new Canteen();
        assertEquals("T1,1046.52",
                canteen.placeOrder("S4",
                        new String[]{"BIRYANI", "SANDWICH", "CHAI"},
                        new int[]{2, 1, 2}, "CARD", 0));
    }
}