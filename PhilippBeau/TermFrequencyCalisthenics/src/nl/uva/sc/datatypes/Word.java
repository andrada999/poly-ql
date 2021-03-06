package nl.uva.sc.datatypes;

public class Word {

    private final String mWord;

    public Word(final String word) {
        mWord = word;
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof Word) {
            String wordString = ((Word) o).mWord;
            return mWord.equals(wordString);
        }

        return this.equals(o);
    }

    @Override
    public int hashCode() {
        return mWord.hashCode();
    }

    @Override
    public String toString() {
        return mWord;
    }

    /**
     * A word is empty, if its length is not bigger than 1. This is mainly a constraint by the book,
     * where they strip out all words no bigger than 1 even though "i" is a word in english
     * language.
     * 
     * @return True if the word is empty, False if not
     */
    public boolean isEmpty() {
        return (mWord.length() < 2);
    }
}
