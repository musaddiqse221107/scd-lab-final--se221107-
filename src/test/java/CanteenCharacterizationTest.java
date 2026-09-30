import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CanteenCharacterizationTest {
    @Test
    void biryaniCashUsesMenuPrice() {
        Canteen canteen = new Canteen();
        assertEquals("T1,700.0", canteen.placeOrder(new String[]{"BIRYANI"}, new int[]{2}, "CASH", 0));
    }

    @Test
    void mixedItemsUseTheirLegacyPrices() {
        Canteen canteen = new Canteen();
        assertEquals("T1,950.0",
                canteen.placeOrder(new String[]{"SANDWICH", "CHAI", "SAMOSA"}, new int[]{2, 2, 1}, "CASH", 0));
    }

    @Test
    void bulkDiscountAppliesAboveThousand() {
        Canteen canteen = new Canteen();
        assertEquals("T1,1026.0",
                canteen.placeOrder(new String[]{"BIRYANI", "SANDWICH", "CHAI"}, new int[]{2, 1, 2}, "CASH", 0));
    }

    @Test
    void cardAddsTwoPercentAfterBulkDiscount() {
        Canteen canteen = new Canteen();
        assertEquals("T1,1046.52",
                canteen.placeOrder(new String[]{"BIRYANI", "SANDWICH", "CHAI"}, new int[]{2, 1, 2}, "CARD", 0));
    }

    @Test
    void jazzCashAddsTen() {
        Canteen canteen = new Canteen();
        assertEquals("T1,930.0",
                canteen.placeOrder(new String[]{"BIRYANI", "SANDWICH"}, new int[]{2, 1}, "JAZZCASH", 0));
    }
}
