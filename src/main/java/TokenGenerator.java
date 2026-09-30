public final class TokenGenerator {
    private int tokenCounter;

    public String nextToken() {
        tokenCounter++;
        return "T" + tokenCounter;
    }
}
