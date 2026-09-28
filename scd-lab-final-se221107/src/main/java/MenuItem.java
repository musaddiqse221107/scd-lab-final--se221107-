public enum MenuItem {
    BIRYANI(350),
    SANDWICH(220),
    CHAI(80),
    SAMOSA(60);

    private final double price;

    MenuItem(double price) {
        this.price = price;
    }

    public double price() {
        return price;
    }

    public static MenuItem from(String value) {
        try {
            return value == null ? null : valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
