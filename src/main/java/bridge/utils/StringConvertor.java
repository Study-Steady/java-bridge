package bridge.utils;

public class StringConvertor {
    private StringConvertor() {
    }

    public static int convertStringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static String convertIntegerToBridgeStatus(int number) {
        if (number == 0) {
            return "D";
        }
        return "U";
    }
}
