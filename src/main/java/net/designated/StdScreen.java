package net.designated;

public class StdScreen implements Screen {

    private boolean hasPrinted = false;

    public boolean isEmpty() {
        return hasPrinted;
    }

    public void println(String string) {
        System.out.println(string);
        hasPrinted = true;
    }
}
