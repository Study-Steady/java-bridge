package bridge.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {

    @Override
    public String inputOneLine() {
        return Console.readLine();
    }
}
