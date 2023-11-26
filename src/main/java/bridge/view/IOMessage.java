package bridge.view;

public enum IOMessage {
    WELCOME("다리 건너기 게임에 오신 것을 환영합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RESTART_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_GAME_RESULT("최종 게임 결과"),
    IS_SUCCESS("게임 성공 여부"),
    TOTAL_MOVING_COUNT("총 이동 횟수"),
    SUCCESS("성공"),
    FAIL("실패"),
    ;

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
