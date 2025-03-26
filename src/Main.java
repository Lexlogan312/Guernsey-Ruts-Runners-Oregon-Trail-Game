package termProject;

/**
 * Main Class of the Perils Along the Platte Game
 * Entry point for the game application that initializes and starts the game.
 *
 * @author : Alex Randall, Chase McCluskey, Painter Drury, and Domenic Pilla
 * @version : 1.0
 * @date : 03/25/2025
 * @file : Main.java
 */
public class Main {
    /**
     * Main method that serves as the entry point for the application.
     * Creates a new startGame instance and begins the game.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("\n=====================================================");
        System.out.println("         Welcome to Perils Along the Platte!         ");
        System.out.println("=====================================================");

        startGame game = new startGame();
        game.displayWelcomeMessage();
    }
}