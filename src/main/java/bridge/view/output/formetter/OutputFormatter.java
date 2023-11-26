package bridge.view.output.formetter;

import java.util.List;

public class OutputFormatter {

    private static final String SUCCEED = "성공";
    private static final String FAIL = "실패";
    private static final String MAP_START_SYMBOL = "[ ";
    private static final String MAP_END_SYMBOL = " ]";
    private static final String DELIMITER_SYMBOL = " | ";

    public String formatGameResult(boolean isSucceedGame) {
        if (isSucceedGame) {
            return SUCCEED;
        }
        return FAIL;
    }

    public String formatProgressMap(List<String> bridge) {
        return MAP_START_SYMBOL + String.join(DELIMITER_SYMBOL, bridge) + MAP_END_SYMBOL;
    }
}
