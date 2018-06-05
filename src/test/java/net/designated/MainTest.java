package net.designated;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private Main main;

    @Test
    public void testMain() {
        String[] args = { "www.MainTest.com/numbers"};
        Main.main(args);
    }
}
