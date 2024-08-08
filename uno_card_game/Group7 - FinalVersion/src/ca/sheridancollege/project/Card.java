/**
 * Modifier: Nathaniel
 * Date: july 28 2024
 */
public class Card {
    
    /**
     * Enumeration for the colors of the UNO cards.
     */
    public enum Color { RED, GREEN, BLUE, YELLOW, WILD }
    
    /**
     * Enumeration for the values of the UNO cards.
     */
    public enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
        DRAW_TWO, SKIP, REVERSE, WILD, WILD_DRAW_FOUR
    }

    /**
     * The color of the card.
     */
    private final Color color;
    
    /**
     * The value of the card.
     */
    private final Value value;

    /**
     * Constructs a Card with the specified color and value.
     * @param color the color of the card
     * @param value the value of the card
     */
    public Card(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    /**
     * Returns the color of the card.
     * @return the color of the card
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public Value getValue() {
        return value;
    }

    /**
     * Returns a string representation of the card.
     * @return a string representation of the card
     */
    @Override
    public String toString() {
        return color + " " + value;
    }
}



