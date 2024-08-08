/**
 * Modifier: Nathaniel
 * Date: Aug 2 2024
 */
package ca.sheridancollege.project;

/*Importations */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the UNO game logic and handles the game flow.
 */
public class Game {
    private Deck deck;
    private List<Player> players;
    private Card topCard;
    private int currentPlayerIndex;

    /**
     * Constructs a new Game instance and initializes the deck and player list.
     */
    public Game() {
        deck = new Deck();
        players = new ArrayList<>();
        currentPlayerIndex = 0;
    }

    /**
     * Registers a new player with the specified name.
     * @param name the name of the player
     */
    public void registerPlayer(String name) {
        players.add(new Player(name));
    }

    /**
     * Starts the game, dealing initial hands and managing the game loop.
     */
    public void startGame() {
        // Deal initial hands
        for (int i = 0; i < 7; i++) {
            for (Player player : players) {
                player.drawCard(deck);
            }
        }
        topCard = deck.draw();

        // Main loop for the game
        boolean gameEnded = false;
        Scanner scanner = new Scanner(System.in);
        while (!gameEnded) {
            // Get the current player and display their turn details
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println(currentPlayer.getName() + "'s turn. Top card: " + topCard);
            System.out.println("Your hand: " + currentPlayer.getHand());

            // Prompt the player to choose a card to play or draw a card
            System.out.print("Choose a card to play (index) or type 'draw' to draw a card: ");
            String input = scanner.nextLine();
            // Handle player input
            if (input.equalsIgnoreCase("draw")) {
                currentPlayer.drawCard(deck);
            } else {
                // Player chooses a card by index
                try {
                    int cardIndex = Integer.parseInt(input);
                    Card chosenCard = currentPlayer.getHand().get(cardIndex);

                    // Check if the chosen card can be played
                    if (canPlayCard(chosenCard, topCard)) {
                        topCard = chosenCard;
                        currentPlayer.playCard(chosenCard);
                    } else {
                        System.out.println("Invalid card. You must draw a card.");
                        currentPlayer.drawCard(deck);
                    }
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                     // Handle invalid input (not a number or out of range)
                    System.out.println("Invalid input. You must draw a card.");
                    currentPlayer.drawCard(deck);
                }
            }
            // Check if the current player has won
            if (currentPlayer.hasWon()) {
                System.out.println(currentPlayer.getName() + " wins!");
                gameEnded = true;
            } else {
                // Move to the next player
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }
        }
        scanner.close();
    }

    /**
     * Checks if the chosen card can be played on top of the current top card.
     * @param chosenCard the card chosen by the player
     * @param topCard the current top card
     * @return true if the chosen card can be played, false otherwise
     */
    private boolean canPlayCard(Card chosenCard, Card topCard) {
        return chosenCard.getColor() == topCard.getColor() ||
               chosenCard.getValue() == topCard.getValue() ||
               chosenCard.getColor() == Card.Color.WILD;
    }

    /**
     * The main method to run the game. Will prompts for the number of players and their names,
     * then starts the game.
     */
    public static void main(String[] args) {
        Game game = new Game();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String playerName = scanner.nextLine();
            game.registerPlayer(playerName);
        }

        game.startGame();
    }
}

