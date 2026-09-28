public enum PaymentMethod {
    CASH,
    CARD,
    JAZZCASH,
    RAAST;

    public static PaymentMethod from(String value) {
        try {
            return value == null ? null : valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
