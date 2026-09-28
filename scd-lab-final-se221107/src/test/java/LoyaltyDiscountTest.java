import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyaltyDiscountTest {
    @Test
    void loyaltyBoundaryAtSeventeenGetsTwelvePercent() {
        assertEquals(880.0, DiscountPolicy.applyLoyaltyDiscount(1000.0, 17), 0.000001);
    }

    @Test
    void belowSeventeenGetsNoLoyaltyDiscount() {
        assertEquals(1000.0, DiscountPolicy.applyLoyaltyDiscount(1000.0, 16), 0.000001);
    }
}
