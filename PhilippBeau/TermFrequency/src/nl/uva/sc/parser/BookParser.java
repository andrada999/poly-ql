package nl.uva.sc.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.parser.subscriber.BookParserSubscriber;

public class BookParser {

    private final File mBookFile;

    private final List<BookParserSubscriber> mSubscriber = new ArrayList<>();

    /**
     * Create a book parser
     * 
     * @param bookFile
     *            The book to parse
     */
    public BookParser(final File bookFile) {
        mBookFile = bookFile;
    }

    /**
     * Starts the parser with standard UTF-8 encoding
     * 
     * @throws IOException
     *             If the file is invalid or it cannot be parsed with UTF-8 encoding
     */
    public void parse() throws IOException {
        parse("UTF-8");
    }

    /**
     * Starts the parser
     * 
     * @throws IOException
     *             If the file is invalid or it cannot be parsed given the character encoding
     */
    public void parse(final String encoding) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                mBookFile), encoding));

        String line = null;
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll("[^a-zA-Z\\s]", " ");
            line = line.replaceAll("\\s+", " ");

            String[] words = line.split(" ");

            for (String word : words) {
                if (word.isEmpty() || word.length() == 1) continue;

                notifyListener(word.toLowerCase());
            }
        }

        reader.close();
    }

    /**
     * Notify all listeners about the last parsed word
     * 
     * @param word
     */
    private void notifyListener(final String word) {
        for (BookParserSubscriber subscriber : mSubscriber) {
            subscriber.nextWord(word);
        }
    }

    /**
     * Subscribe to the word listener list
     * 
     * @param subscriber
     * @return True if successful subscribed
     */
    public boolean subscribe(final BookParserSubscriber subscriber) {
        return mSubscriber.add(subscriber);
    }

    /**
     * Unsubscribe the given subscriber from the listener list
     * 
     * @param subscriber
     * @return True if successful unsubscribed
     */
    public boolean unsubscribe(final BookParserSubscriber subscriber) {
        return mSubscriber.remove(subscriber);
    }

}
