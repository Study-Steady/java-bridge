package bridge.model;

import bridge.utils.BridgeMaker;
import bridge.utils.BridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeTest {

    private Bridge bridge;
    private BridgeMaker bridgeMaker;
    private final int BRIDGE_SIZE = 5;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeTest.TestNumberGenerator(newArrayList(1, 0, 1, 0, 1)));
        bridge = Bridge.of(bridgeMaker, BRIDGE_SIZE);
    }

    @DisplayName("다리를 제대로 건너면 상태를 NORMAL이다.")
    @Test
    void normalProceedNotFinishedTest() {
        // given
        List<String> normalUntil3 = List.of("U", "D", "U");
        GameStatus status;

        // when // then
        for (String s : normalUntil3) {
            status = bridge.proceed(s);
            assertThat(status).isEqualTo(GameStatus.NORMAL);
        }
    }

    @DisplayName("다리를 건너다가 잘못 건너면 RETRY 상태를 반환한다.")
    @Test
    void wrongChoiceTest() {
        // given
        List<String> normalUntil3 = List.of("U", "D", "D");
        GameStatus status = null;

        // when
        for (String s : normalUntil3) {
            status = bridge.proceed(s);
        }

        // then
        assertThat(status).isEqualTo(GameStatus.RETRY);
    }

    @DisplayName("다리를 제대로 건너면 상태를 NORMAL이다.")
    @Test
    void gameIsNormallyFinishedTest() {
        // given
        List<String> normalUntil3 = List.of("U", "D", "U", "D", "U");
        GameStatus status = null;

        // when
        for (String s : normalUntil3) {
            status = bridge.proceed(s);
        }

        // then
        assertThat(status).isEqualTo(GameStatus.FINISH);
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