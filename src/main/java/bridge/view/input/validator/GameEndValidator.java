package bridge.view.input.validator;

import bridge.util.BridgeConstant;
import bridge.view.input.error.InputError;
import bridge.view.input.error.InputIllegalArgumentException;

public class GameEndValidator {

    public String validate(String input) {
        if (input.isBlank()) {
            throw new InputIllegalArgumentException(InputError.INPUT_BLANK);
        }
        if (!(BridgeConstant.RESTART_GAME.equals(input) || BridgeConstant.QUIT_GAME.equals(input))) {
            throw new InputIllegalArgumentException(InputError.NOT_ACCEPTABLE_SELECT, BridgeConstant.RESTART_GAME,
                    BridgeConstant.QUIT_GAME);
        }
        return input;
    }
}
