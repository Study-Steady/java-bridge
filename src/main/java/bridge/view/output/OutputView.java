package bridge.view.output;

import static bridge.view.IOMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void printWelcomeMessage() {
        printer.print(WELCOME.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        printer.print(map);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String map, String result, int movingCount) {
        printer.print(FINAL_GAME_RESULT.getMessage());
        printer.print(map);
        printer.printEmptyLine();

        printer.print(IS_SUCCESS.getMessage() + ": " + result);
        printer.print(TOTAL_MOVING_COUNT.getMessage() + ": " + movingCount);
    }

    public void printErrorMessage(Exception e) {
        printer.print(e.getMessage());
    }
}
