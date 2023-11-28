package bridge.controller;

import bridge.model.BridgeSymbol;
import bridge.model.GameStatus;
import bridge.view.IOMessage;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;

import java.util.function.Supplier;

public class BridgeGameController {

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        welcome();
        playBridgeGame();
        showResult();
    }

    private void welcome() {
        outputView.printWelcomeMessage();
    }

    private void playBridgeGame() {
        int bridgeSize = readBridgeSize(); // inputView.readBridgeSize();
        bridgeGame.initBridgeGame(bridgeSize);
        while (bridgeGame.getGameStatus() == GameStatus.NORMAL) {
            play();
        }
    }

    protected void play() {
        String userInput = readMoving(); // inputView.readMoving();
        outputView.printMap(bridgeGame.move(userInput));

        if (bridgeGame.getGameStatus() == GameStatus.FINISH) {
            return;
        }

        if (bridgeGame.getGameStatus() == GameStatus.RETRY) {
            String userCommand = readGameCommand(); // inputView.readGameCommand();
            if (userCommand.equals(BridgeSymbol.RESTART.getSymbol())) {
                bridgeGame.retry();
            }
        }
    }

    private void showResult() {
        IOMessage isSuccess = IOMessage.SUCCESS;
        if (bridgeGame.getGameStatus() == GameStatus.RETRY) {
            isSuccess = IOMessage.FAIL;
        }
        outputView.printResult(bridgeGame.getBridgeHistory(), isSuccess.getMessage(), bridgeGame.getRound());
    }

    private <T> T process(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return process(supplier);
        }
    }

    private int readBridgeSize() {
        return process(inputView::readBridgeSize);
    }

    private String readMoving() {
        return process(inputView::readMoving);
    }

    private String readGameCommand() {
        return process(inputView::readGameCommand);
    }
}
