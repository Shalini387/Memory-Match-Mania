package game;

public class Card {

    private String value;
    private boolean faceUp;
    private boolean matched;

    public Card(String value) {
        this.value = value;
        this.faceUp = false;
        this.matched = false;
    }

    public String getValue() {
        return value;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }
}