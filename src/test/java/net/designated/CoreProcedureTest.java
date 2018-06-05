package net.designated;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CoreProcedureTest {

    private CoreProcedure core;

    private Endpoint endpoint;

    @Before
    public void setUp() {
        core = new CoreProcedure();
        endpoint = new Endpoint();
        endpoint.run();
    }

    @After
    public void tearDown() {
        endpoint.stopServer();
    }

    @Test
    public void startEventuallyTerminates() throws IOException {
        core.start("http://localhost:8000/numbers?data=startEventuallyTerminates");
    }

    @Test
    public void startEmitsText() throws IOException {
        Screen screen = new DummyScreen();
        core.setScreen(screen);
        core.start("http://localhost:8000/numbers?data=emitsTextTest");
        Assert.assertFalse(screen.isEmpty());
    }

    @Test
    public void startAcceptsInput() throws IOException {
        core.start("http://localhost:8000/numbers?data=startAcceptsInput");
    }

    @Test
    public void startReadsJsonDocument() throws IOException {
        core.start("http://localhost:8000/numbers?data=readsJsonDocumentTest");
        Assert.assertNotNull(core.getDocuments());
    }

    @Test
    public void startReadsNonEmptyJsonDocument() throws IOException {
        core.start("http://localhost:8000/numbers?data=readsNonEmptyJsonDocumentTest");
        NumbersJsonDocument[] jsons = core.getDocuments();
        Assert.assertNotNull(jsons[0].numbers);
        Assert.assertTrue(jsons[0].numbers.length > 0);
    }
}
