package Workshop.WS9;

public class DictionaryWord {
    private String word;
    private String meanings;

    public DictionaryWord(String word, String meanings) {
        this.word = word;
        this.meanings = meanings;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeanings() {
        return meanings;
    }

    public void setMeanings(String meanings) {
        this.meanings = meanings;
    }

    public String toString() {
        return this.word + "\t" + this.meanings;
    }
}
