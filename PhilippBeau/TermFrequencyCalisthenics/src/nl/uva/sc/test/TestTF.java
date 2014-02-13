package nl.uva.sc.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.parser.BookParser;
import nl.uva.sc.parser.Token;
import nl.uva.sc.parser.subscriber.TermFrequency;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestTF {

    public static final String BOOK_FILENAME = "pride-and-prejudice.txt";

    public static final List<Token> mTrueIndex = new ArrayList<>();

    @BeforeClass
    public static void startUp() {
        mTrueIndex.add(new Token("mr", 786));
        mTrueIndex.add(new Token("elizabeth", 635));
        mTrueIndex.add(new Token("very", 488));
        mTrueIndex.add(new Token("darcy", 418));
        mTrueIndex.add(new Token("such", 395));
        mTrueIndex.add(new Token("mrs", 343));
        mTrueIndex.add(new Token("much", 329));
        mTrueIndex.add(new Token("more", 327));
        mTrueIndex.add(new Token("bennet", 323));
        mTrueIndex.add(new Token("bingley", 306));
        mTrueIndex.add(new Token("jane", 295));
        mTrueIndex.add(new Token("miss", 283));
        mTrueIndex.add(new Token("one", 275));
        mTrueIndex.add(new Token("know", 239));
        mTrueIndex.add(new Token("before", 229));
        mTrueIndex.add(new Token("herself", 227));
        mTrueIndex.add(new Token("though", 226));
        mTrueIndex.add(new Token("well", 224));
        mTrueIndex.add(new Token("never", 220));
        mTrueIndex.add(new Token("sister", 218));
        mTrueIndex.add(new Token("soon", 216));
        mTrueIndex.add(new Token("think", 211));
        mTrueIndex.add(new Token("now", 209));
        mTrueIndex.add(new Token("time", 203));
        mTrueIndex.add(new Token("good", 201));
    }

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
            Token current = sortedTokenList.get(sortedTokenList.size() - i);
            Token shouldBeSame = mTrueIndex.get(i - 1);

            System.out.println(sortedTokenList.get(sortedTokenList.size() - i));

            assertTrue("Wrong word at position " + i,
                    current.getWord().equals(shouldBeSame.getWord()));

            assertTrue("Wrong frequency at position " + i,
                    current.getFrequency() == shouldBeSame.getFrequency());
        }
    }
}
