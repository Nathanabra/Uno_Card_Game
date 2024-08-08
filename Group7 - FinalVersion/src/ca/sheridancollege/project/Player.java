/**
 * Modifier: Nathaniel
 * Date: Aug 5 2024
 */
package ca.sheridancollege.project;

/*Importations */
import java.util.ArrayList;
import java.util.List;

/**
 * Player class thats represents a player in the UNO game.
 * Each player has a name and a hand of cards.
 */
public class Player {
    private String name;
    private List<Card> hand;

    /**
     * Constructors for a new Player with the specified name.
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    /**
     * Draws a card from the deck and adds it to the player's hand.
     * @param deck the deck to draw a card from
     */
    public void drawCard(Deck deck) {
        hand.add(deck.draw());
    }

    /**
     * Plays the specified card from the player's hand.
     * @param card the card to play
     */
    public void playCard(Card card) {
        hand.remove(card);
    }

    /**
     * Returns the player's hand of cards.
     * @return the player's hand of cards
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * Returns the name of the player.
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the player has won the game.
     * A player only wins if their hand is empty.
     * @return true if the player has won, false otherwise
     */
    public boolean hasWon() {
        return hand.isEmpty();
    }
}
