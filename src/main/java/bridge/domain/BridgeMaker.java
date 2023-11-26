package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            addBridge(bridge);
        }
        return bridge;
    }

    private void addBridge(List<String> bridge) {
        int bridgeNumber = bridgeNumberGenerator.generate();
        if (isUpper(bridgeNumber)) {
            bridge.add("U");
        }
        if (isLower(bridgeNumber)) {
            bridge.add("D");
        }
    }

    private boolean isUpper(int bridgeNumber) {
        if (bridgeNumber == 1) {
            return true;
        }
        return false;
    }

    private boolean isLower(int bridgeNumber) {
        if (bridgeNumber == 0) {
            return true;
        }
        return false;
    }
}