package bridge.model;

import bridge.utils.BridgeMaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static bridge.model.BridgeSymbol.*;

public class Bridge {

    private final List<String> bridge;
    private int pos;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
        pos = 0;
    }

    public static Bridge of(BridgeMaker bridgeMaker, int size) {
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    public void resetBridge() {
        this.pos = 0;
    }

    public boolean proceed(String userInput) {
        if (bridge.get(pos++).equals(userInput)) {
            return true;
        }
        return false;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public String getBridgeHistory() {
        StringBuilder sb = new StringBuilder();
        getBridgeStatusBySymbol(sb, UP);
        sb.append(NEW_LINE);
        getBridgeStatusBySymbol(sb, DOWN);
        return sb.toString();
    }

    private void getBridgeStatusBySymbol(StringBuilder sb, BridgeSymbol bridgeSymbol) {
        sb.append(BRIDGE_START.getSymbol());
        for (int i = 0; i <= pos; i++) {
            if (bridge.get(i).equals(bridgeSymbol.getSymbol())) {
                sb.append(MOVABLE.getSymbol());
                sb.append(BRIDGE_SEPARATOR.getSymbol());
                continue;
            }
            sb.append(EMPTY.getSymbol());
            sb.append(BRIDGE_SEPARATOR.getSymbol());
        }
        sb.append(BRIDGE_END.getSymbol());
    }
}