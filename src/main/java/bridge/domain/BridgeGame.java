package bridge.domain;

import bridge.domain.dto.BridgeMapDto;
import bridge.util.BridgeConstant;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private List<String> upBridge;
    private List<String> downBridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeMapDto play(BridgeMapDto bridgeMapDto, String command) {
        upBridge = bridgeMapDto.upBridgeMap();
        downBridge = bridgeMapDto.downBridgeMap();
        return move(command, upBridge.size());
    }

    public BridgeMapDto move(String command, int size) {
        if (BridgeConstant.SELECT_UP.equals(command)) {
            downBridge.add(BridgeConstant.BLANK);
            boolean isSucceed = checkPassable(command, size, upBridge);
            return new BridgeMapDto(upBridge, downBridge, isSucceed);
        }
        upBridge.add(BridgeConstant.BLANK);
        boolean isSucceed = checkPassable(command, size, downBridge);
        return new BridgeMapDto(upBridge, downBridge, isSucceed);
    }

    private boolean checkPassable(String command, int size, List<String> bridge) {
        if (isPassable(command, size)) {
            bridge.add(BridgeConstant.SUCCEED_SYMBOL);
            return true;
        }
        bridge.add(BridgeConstant.FAIL_SYMBOL);
        return false;
    }

    private boolean isPassable(String command, int size) {
        return bridge.get(size).equals(command);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
