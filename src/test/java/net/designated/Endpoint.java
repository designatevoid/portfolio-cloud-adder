package net.designated;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

// original code from docs
public class Endpoint {

    HttpServer server;

    public void run() {
        try {
            server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/numbers", new MyHandler());
            server.setExecutor(null); // creates a default executor
            server.start();
        } catch (Exception e) {
            System.out.println("Exception! " + e);
            e.printStackTrace();
        }
    }

    public void stopServer() {
        System.out.println("Stopping Server...");
        if (server != null) {
            server.stop(3);
        }
    }

    static class MyHandler implements HttpHandler {
        private String jsonString = "[\n" +
                "  {\n" +
                "    \"numbers\" : [ 1, 1, 2, 3, 5, 7 ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"numbers\" : [ 12, 19, 31, 50, 81, 131 ]\n" +
                "  }\n" +
                "]";

        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = jsonString;
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
