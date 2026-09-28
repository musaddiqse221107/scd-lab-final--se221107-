import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoundaryParameterizedTest {
    @ParameterizedTest
    @ValueSource(ints = {16, 17, 18})
    void loyaltyBoundaryValues(int pastOrders) {
        double expected = pastOrders >= 17 ? 880.0 : 1000.0;
        assertEquals(expected, DiscountPolicy.applyLoyaltyDiscount(1000.0, pastOrders), 0.000001);
    }
}
