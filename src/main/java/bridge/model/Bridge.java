package bridge.model;

import bridge.utils.BridgeMaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static bridge.model.BridgeSymbol.*;

public class Bridge {

    private final List<String> bridge;
    private final List<String> history;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.history = new ArrayList<>();
    }

    public static Bridge of(BridgeMaker bridgeMaker, int size) {
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    public void resetBridge() {
        this.history.clear();
    }

    public GameStatus proceed(String userInput) {
        history.add(userInput);
        if (!bridge.get(history.size() - 1).equals(userInput)) {
            return GameStatus.RETRY;
        }
        if (bridge.size() == history.size()) {
            return GameStatus.FINISH;
        }
        return GameStatus.NORMAL;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public boolean isBridgeGameSuccess() {
        return history.size() == bridge.size();
    }

    public String getBridgeHistory() {
        StringBuilder sb = new StringBuilder();
        getBridgeStatusBySymbol(sb, UP);
        sb.append(NEW_LINE.getSymbol());
        getBridgeStatusBySymbol(sb, DOWN);
        return sb.toString();
    }

    private void getBridgeStatusBySymbol(StringBuilder sb, BridgeSymbol bridgeSymbol) {
        sb.append(BRIDGE_START.getSymbol());
        for (int i = 0; i < history.size(); i++) {
            BridgeSymbol onMovable = MOVABLE, onUnmovable = EMPTY;
            if (!Objects.equals(history.get(i), bridge.get(i))) {
                onMovable = EMPTY;
                onUnmovable = UNMOVABLE;
            }

            if (bridge.get(i).equals(bridgeSymbol.getSymbol())) {
                sb.append(onMovable.getSymbol());
                sb.append(BRIDGE_SEPARATOR.getSymbol());
                continue;
            }
            sb.append(onUnmovable.getSymbol());
            sb.append(BRIDGE_SEPARATOR.getSymbol());
        }

        for (int i = 0; i < BRIDGE_SEPARATOR.getSymbol().length(); i++) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(BRIDGE_END.getSymbol());
    }
}
