package bridge.view.input.validator;

import bridge.util.BridgeConstant;
import bridge.view.input.error.InputError;
import bridge.view.input.error.InputIllegalArgumentException;

public class BridgeSelectValidator {

    public String validate(String input) {
        if (input.isBlank()) {
            throw new InputIllegalArgumentException(InputError.INPUT_BLANK);
        }

        if (!(BridgeConstant.SELECT_UP.equals(input) || BridgeConstant.SELECT_DOWN.equals(input))) {
            throw new InputIllegalArgumentException(InputError.NOT_ACCEPTABLE_SELECT, BridgeConstant.SELECT_UP,
                    BridgeConstant.SELECT_DOWN);
        }
        return input;
    }
}
