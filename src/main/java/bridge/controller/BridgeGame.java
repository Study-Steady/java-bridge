package bridge.controller;

import bridge.model.Bridge;
import bridge.model.GameStatus;
import bridge.utils.BridgeMaker;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private Bridge bridge;
    private GameStatus gameStatus;
    private int round;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        this.gameStatus = GameStatus.NORMAL;
        this.round = 0;
    }

    public void initBridgeGame(int size) {
        this.bridge = Bridge.of(bridgeMaker, size);
        System.out.println(bridge.getBridge().toString());
        this.gameStatus = GameStatus.NORMAL;
        this.round = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String userInput) {
        gameStatus = bridge.proceed(userInput);
        return bridge.getBridgeHistory();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridge.resetBridge();
        this.gameStatus = GameStatus.NORMAL;
        this.round++;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getRound() {
        return round;
    }

    public String getBridgeHistory() {
        return bridge.getBridgeHistory();
    }
}
