package bridge.domain.dto;

import java.util.List;

public record BridgeMapDto(List<String> upBridgeMap, List<String> downBridgeMap, boolean isSucceed) {
}
