package bridge.view.validator;

import java.util.regex.Pattern;

public final class DigitsOnlyValidator {
    private static final Pattern DIGITS_ONLY = Pattern.compile("[0-9]+");
    private static final String FORMAT_EXCEPTION_MESSAGE = "숫자(양의 정수)만 입력 가능합니다.";

    private DigitsOnlyValidator() {
    }

    public static void validate(String input) {
        if (!matchesPattern(input, DIGITS_ONLY)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean matchesPattern(String input, Pattern pattern) {
        return pattern.matcher(input).matches();
    }
}