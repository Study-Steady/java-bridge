package bridge.controller;

import bridge.model.BridgeSymbol;
import bridge.model.GameStatus;
import bridge.view.IOMessage;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;

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
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.initBridgeGame(bridgeSize);
        while (bridgeGame.getGameStatus() == GameStatus.NORMAL) {
            play();
        }
    }

    protected void play() {
        String userInput = inputView.readMoving();
        outputView.printMap(bridgeGame.move(userInput));

        if (bridgeGame.getGameStatus() == GameStatus.FINISH) {
            return;
        }

        if (bridgeGame.getGameStatus() == GameStatus.RETRY) {
            String userCommand = inputView.readGameCommand();
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
}
