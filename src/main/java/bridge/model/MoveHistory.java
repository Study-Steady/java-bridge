package bridge.model;

import static bridge.model.MovingCommand.DOWN_MOVING;
import static bridge.model.MovingCommand.UP_MOVING;

import java.util.stream.Stream;

public enum MoveHistory {
    UP_TRUE(UP_MOVING, true),
    UP_FALSE(UP_MOVING, false),
    DOWN_TRUE(DOWN_MOVING, true),
    DOWN_FALSE(DOWN_MOVING, false);

    private final MovingCommand movingCommand;
    private final boolean movable;

    MoveHistory(MovingCommand movingCommand, boolean movable) {
        this.movingCommand = movingCommand;
        this.movable = movable;
    }

    public static MoveHistory of(MovingCommand movingCommand, boolean movable) {
        return Stream.of(values())
                .filter(moveHistory -> moveHistory.movingCommand == movingCommand && moveHistory.movable == movable)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이동하고자 하는 명령어와 이동 가능 여부에 적합하지 않습니다."));
    }
}
