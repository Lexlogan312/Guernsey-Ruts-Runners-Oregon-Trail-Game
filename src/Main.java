public class Main {
    public static void main(String[] args) {
        System.out.println("\n=====================================================");
        System.out.println("             Welcome to the Oregon Trail!            ");
        System.out.println("=====================================================");

        startGame game = new startGame();
        game.displayWelcomeMessage();
    }
}