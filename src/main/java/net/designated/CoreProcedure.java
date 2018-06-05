package net.designated;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CoreProcedure {

    private Screen screen = new StdScreen();

    private Gson gson = new Gson();

    private NumbersJsonDocument[] documents;

    public void start(String urlString) throws IOException {
        screen.println("Starting core procedure with: [" + urlString + "]!");
        InputStream is = downloadUrl(urlString);
        String jsonString = toString(is);
        screen.println("Read JSON: " + jsonString);

        // can throw JsonSyntaxException
        documents = gson.fromJson(jsonString, NumbersJsonDocument[].class);
        int grandTotal = 0;
        for (NumbersJsonDocument document : documents) {
            int[] numbers = document.numbers;
            int total = 0;
            for (int number : numbers) {
                total += number;
            }
            screen.println("Total for document: " + total);
            grandTotal += total;
        }
        screen.println("Grand total of all documents: " + grandTotal);
    }

    // from StackOverflow
    private InputStream downloadUrl(String urlString) throws IOException {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        return connection.getInputStream();
    }

    // from StackOverflow
    private String toString(InputStream is) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        final int CHARS_PER_PAGE = 5000; //counting spaces
        StringBuilder builder = new StringBuilder(CHARS_PER_PAGE);
        try {
            for(String line=br.readLine(); line!=null; line=br.readLine()) {
                builder.append(line);
                builder.append('\n');
            }
        } catch (IOException ignore) { }
        return builder.toString();
    }

    public void setScreen(Screen nextScreen) {
        if (nextScreen == null) {
            throw new IllegalArgumentException("Null not allowed.");
        }
        screen = nextScreen;
    }

    public NumbersJsonDocument[] getDocuments() {
        return documents;
    }
}
