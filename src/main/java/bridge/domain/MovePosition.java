package bridge.domain;

public class MovePosition {

    private static final int DEFAULT_POSITION = 1;

    private final int position;

    private MovePosition(int position) {
        this.position = position;
    }

    public static MovePosition defaultOf() {
        return new MovePosition(DEFAULT_POSITION);
    }

    public int getPosition() {
        return position;
    }

    public MovePosition moveNext() {
        return new MovePosition(this.position + 1);
    }

}
