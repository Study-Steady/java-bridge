package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.dto.BridgeMapDto;
import bridge.util.BridgeConstant;
import bridge.view.input.InputView;
import bridge.view.output.Output;
import bridge.view.output.OutputView;
import bridge.view.output.formetter.OutputFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private List<String> bridge;
    private boolean isGaming;

    private int playTime;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        gameStart();
    }

    private void gameStart() {
        outputView.printMessage(Output.START_BRIDGE_GAME);
        int bridgeSize = getBridgeLength();
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        initBridgeSelect();
    }

    private void initBridgeSelect() {
        playTime++;
        BridgeGame bridgeGame = new BridgeGame(bridge);
        BridgeMapDto bridgeMapDto = new BridgeMapDto(new ArrayList<>(), new ArrayList<>(), true);

        move(bridgeGame, bridgeMapDto);
    }

    private void move(BridgeGame bridgeGame, BridgeMapDto bridgeMapDto) {
        while (!isGaming) {
            String command = getBridgeSelection();
            BridgeMapDto bridgeResult = bridgeGame.play(bridgeMapDto, command);
            showBridgeMapProgress(bridgeResult);
            if (!bridgeResult.isSucceed()) {
                checkBeginOrEndCommand(bridgeResult);
                break;
            }
            if (isEnd(bridgeResult.upBridgeMap().size(), bridge.size())) {
                showTotalBridgeGameResult(bridgeResult);
                break;
            }
        }
    }

    private void showBridgeMapProgress(BridgeMapDto bridgeResult) {
        outputView.printResult(bridgeResult);
    }

    private void showTotalBridgeGameResult(BridgeMapDto bridgeResult) {
        outputView.printMessage(Output.FINAL_RESULT);
        showBridgeMapProgress(bridgeResult);
        outputView.printMessage(Output.TOTAL_GAME_RESULT, new OutputFormatter().formatGameResult(
                bridgeResult.isSucceed()), playTime);
    }

    private boolean isEnd(int nowBridgeSize, int bridgeSize) {
        return nowBridgeSize == bridgeSize;
    }

    private void checkBeginOrEndCommand(BridgeMapDto bridgeResult) {
        outputView.printMessage(Output.INPUT_GAME_RESTART_OR_NOT, BridgeConstant.RESTART_GAME,
                BridgeConstant.QUIT_GAME);
        String command = getEndOrBeginCommand();
        if (BridgeConstant.RESTART_GAME.equals(command)) {
            initBridgeSelect();
        }
        if (BridgeConstant.QUIT_GAME.equals(command)) {
            isGaming = false;
            showTotalBridgeGameResult(bridgeResult);
        }
    }

    private String getEndOrBeginCommand() {
        return receiveValidatedInput(inputView::readGameCommand);
    }

    private String getBridgeSelection() {
        outputView.printMessage(Output.INPUT_SELECT_BRIDGE, BridgeConstant.SELECT_UP, BridgeConstant.SELECT_DOWN);

        return receiveValidatedInput(inputView::readMoving);
    }

    private int getBridgeLength() {
        outputView.printMessage(Output.INPUT_BRIDGE_LENGTH);

        return receiveValidatedInput(inputView::readBridgeSize);
    }

    private <T> T receiveValidatedInput(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return receiveValidatedInput(inputSupplier);
        }
    }
}
