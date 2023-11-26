package bridge.view.input.error;

public enum InputError {

    NOT_ACCEPTABLE_BRIDGE_LENGTH("다리 길이는 숫자여야 합니다."),
    INPUT_BLANK("입력한 값이 빈 칸 입니다."),
    NOT_ACCEPTABLE_BRIDGE_RANGE("다리 길이는 %s와 %s 사이의 길이여야 합니다."),
    NOT_ACCEPTABLE_SELECT("%s와 %s 중 하나를 입력해야 합니다."),
    ;

    final String message;

    InputError(String message) {
        this.message = message;
    }
}
