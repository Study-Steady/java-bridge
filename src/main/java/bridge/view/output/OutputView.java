package bridge.view.output;

import bridge.domain.dto.BridgeMapDto;
import bridge.view.output.formetter.OutputFormatter;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeMapDto bridgeMapDto) {
        System.out.println(new OutputFormatter().formatProgressMap(bridgeMapDto.upBridgeMap()));
        System.out.println(new OutputFormatter().formatProgressMap(bridgeMapDto.downBridgeMap()));
        System.out.println();
    }

    public void printMessage(Output output) {
        System.out.println(output.message);
    }

    public void printMessage(Output output, Object... args) {
        System.out.printf(output.message, args);
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
