package bridge.exception;

public enum ExceptionSymbol {

    PREFIX("[ERROR] "),
    ;

    private final String value;

    ExceptionSymbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
