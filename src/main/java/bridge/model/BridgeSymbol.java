package bridge.model;

public enum BridgeSymbol {

    BRIDGE_START("[ "),
    BRIDGE_END(" ]"),
    BRIDGE_SEPARATOR(" | "),
    MOVABLE("O"),
    UNMOVABLE("X"),
    UP("U"),
    DOWN("D"),
    EMPTY(" "),
    NEW_LINE("\n"),
    ;

    private final String symbol;

    BridgeSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
