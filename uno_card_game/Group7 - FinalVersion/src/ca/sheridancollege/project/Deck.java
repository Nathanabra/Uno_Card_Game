/**
 * Modifier: Nathaniel
 * Date: july 30 2024
 */
package ca.sheridancollege.project;

/*Importations */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Deck class represents a deck of UNO cards.
 * It handles initialization, shuffling, and drawing cards.
 */
public class Deck {
    /**
     * A list of cards in the deck.
     */
    private List<Card> cards;

    /**
     * Constructs a new Deck, initializes it with UNO cards, and shuffles it.
     */
    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    /**
     * Initializes the deck with UNO cards.
     * this includes (red, green, blue, yellow), excluding the wild cards
     */
    private void initializeDeck() {
        for (Card.Color color : Card.Color.values()) {
            if (color != Card.Color.WILD) {
                for (Card.Value value : Card.Value.values()) {
                    if (value != Card.Value.WILD && value != Card.Value.WILD_DRAW_FOUR) {
                        cards.add(new Card(color, value));
                        if (value != Card.Value.ZERO) {
                            cards.add(new Card(color, value));
                        }
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    cards.add(new Card(color, Card.Value.WILD));
                    cards.add(new Card(color, Card.Value.WILD_DRAW_FOUR));
                }
            }
        }
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Draws a card from the deck.
     * @return the card drawn from the top of the deck
     */
    public Card draw() {
        return cards.remove(cards.size() - 1);
    }

    /**
     * Returns the number of cards remaining in the deck.
     * @return the number of cards remaining in the deck
     */
    public int size() {
        return cards.size();
    }
}


