package bridge.controller;

import bridge.model.GameStatus;
import bridge.utils.BridgeMaker;
import bridge.utils.BridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private final int BRIDGE_SIZE = 5;
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 1, 0, 1)));
        bridgeGame = new BridgeGame(bridgeMaker);
    }

    @DisplayName("게임을 초기화 하면 라운드 횟수가 1 증가한다.")
    @Test
    void resetTest() {
        // given
        bridgeGame.initBridgeGame(BRIDGE_SIZE);

        // when
        bridgeGame.retry();

        // then
        assertThat(bridgeGame.getRound()).isEqualTo(2);
    }

    @DisplayName("다리를 제대로 건너면 상태를 NORMAL이다.")
    @Test
    void normalProceedTest() {
        // given
        bridgeGame.initBridgeGame(BRIDGE_SIZE);
        List<String> normalUntil3 = List.of("U", "D", "U");

        // when
        normalUntil3.forEach(bridgeGame::move);

        // then
        assertThat(bridgeGame.getGameStatus()).isEqualTo(GameStatus.NORMAL);
    }

    @DisplayName("틀리면 게임 상태를 RETRY로 변경한다.")
    @Test
    void wrongProceedTest() {
        // given
        bridgeGame.initBridgeGame(BRIDGE_SIZE);
        List<String> normalUntil3 = List.of("U", "D", "D");

        // when
        normalUntil3.forEach(bridgeGame::move);

        // then
        assertThat(bridgeGame.getGameStatus()).isEqualTo(GameStatus.RETRY);
    }

    @DisplayName("다리를 건너면 게임 상태를 FINISH로 변경한다.")
    @Test
    void normalEndTest() {
        // given
        bridgeGame.initBridgeGame(BRIDGE_SIZE);
        List<String> normalUntil3 = List.of("U", "D", "U", "D", "U");

        // when
        normalUntil3.forEach(bridgeGame::move);

        // then
        assertThat(bridgeGame.getGameStatus()).isEqualTo(GameStatus.FINISH);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}