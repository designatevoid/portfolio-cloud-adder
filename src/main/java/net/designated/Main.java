package net.designated;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CoreProcedure core = new CoreProcedure();

        String argument;
        if (args != null && args.length > 0) {
            argument = args[0];
        } else {
            argument = "www.dummyendpoint.com/numbers";
        }
        try {
            core.start(argument);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
