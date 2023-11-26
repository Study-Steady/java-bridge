package bridge;

import bridge.controller.BridgeGame;
import bridge.controller.BridgeGameController;
import bridge.utils.BridgeMaker;
import bridge.utils.BridgeRandomNumberGenerator;
import bridge.view.input.ConsoleReader;
import bridge.view.input.InputView;
import bridge.view.input.Reader;
import bridge.view.output.ConsolePrinter;
import bridge.view.output.OutputView;
import bridge.view.output.Printer;

public class Application {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();

        InputView inputView = new InputView(reader, printer);
        OutputView outputView = new OutputView(printer);

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker);

        BridgeGameController controller = new BridgeGameController(bridgeGame, inputView, outputView);
        controller.run();
    }
}
