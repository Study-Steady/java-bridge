package bridge.view.output;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printEmptyLine() {
        System.out.println();
    }
}
