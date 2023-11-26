package bridge.view.input.validator;

import bridge.view.input.error.InputError;
import bridge.view.input.error.InputIllegalArgumentException;

public class BridgeSizeValidator {

    private static final int MIN_BRIDGE_NUMBER = 3;
    private static final int MAX_BRIDGE_NUMBER = 20;

    public int validate(String input) {
        int bridgeNumber = validateIsNumber(input);

        if (input.isBlank()) {
            throw new InputIllegalArgumentException(InputError.INPUT_BLANK);
        }
        if (bridgeNumber > MAX_BRIDGE_NUMBER || bridgeNumber < MIN_BRIDGE_NUMBER) {
            throw new InputIllegalArgumentException(InputError.NOT_ACCEPTABLE_BRIDGE_RANGE, MIN_BRIDGE_NUMBER,
                    MAX_BRIDGE_NUMBER);
        }
        return bridgeNumber;
    }

    private int validateIsNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputIllegalArgumentException(InputError.NOT_ACCEPTABLE_BRIDGE_LENGTH);
        }
    }
}
