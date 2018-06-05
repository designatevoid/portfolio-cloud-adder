package net.designated;

public class DummyScreen implements Screen {

    private boolean hasPrinted = false;

    public boolean isEmpty() {
        return !hasPrinted;
    }

    public void println(String string) {
        hasPrinted = true;
    }
}
