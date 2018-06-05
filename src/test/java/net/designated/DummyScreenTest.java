package net.designated;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyScreenTest {

    private Screen dummyScreen;

    @Before
    public void setUp() {
        dummyScreen = new DummyScreen();
    }

    @Test
    public void dummyScreenStartsEmpty() {
        Assert.assertTrue(dummyScreen.isEmpty());
    }

    @Test
    public void dummyScreenNotEmptyAfterPrint() {
        dummyScreen.println("literally anything");
        Assert.assertFalse(dummyScreen.isEmpty());
    }
}
