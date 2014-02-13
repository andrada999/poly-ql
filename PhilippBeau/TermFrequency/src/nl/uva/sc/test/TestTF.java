package nl.uva.sc.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;

import nl.uva.sc.parser.BookParser;
import nl.uva.sc.parser.Token;
import nl.uva.sc.parser.subscriber.TermFrequency;

import org.junit.Test;

public class TestTF {

    public static final String BOOK_FILENAME = "pride-and-prejudice.txt";

    @Test
    public void test() {

        TermFrequency index = new TermFrequency();
        BookParser bParser = new BookParser(new File(BOOK_FILENAME));
        bParser.subscribe(index);

        try {
            bParser.parse();
        } catch (IOException e) {
            fail("The book parser could not parse the given file \"" + BOOK_FILENAME + "\"");
        }

        List<Token> sortedTokenList = index.getSortedTokens();
        for (int i = 1; i < 26; ++i) {
            System.out.println(sortedTokenList.get(sortedTokenList.size() - i));
        }

    }
}
