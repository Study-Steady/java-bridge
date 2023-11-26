package bridge.view.output;

public enum Output {

    START_BRIDGE_GAME("다리 건너기 게임을 시작합니다. \n"),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_SELECT_BRIDGE("이동할 칸을 선택해주세요. (위: %s, 아래: %s) \n"),
    INPUT_GAME_RESTART_OR_NOT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s) \n"),
    FINAL_RESULT("최종 게임 결과"),
    TOTAL_GAME_RESULT("게임 성공 여부: %s\n" + "총 시도한 횟수: %s");

    final String message;

    Output(String message) {
        this.message = message;
    }
}
