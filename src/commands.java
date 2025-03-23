import java.util.Scanner;

public class commands {
    private player player;
    private inventory inventory;
    private movement movement;
    private hunting hunting;
    private trading trading;
    private wagon wagon;

    public commands(player player, inventory inventory, movement movement, hunting hunting, trading trading, wagon wagon) {
        this.player = player;
        this.inventory = inventory;
        this.movement = movement;
        this.hunting = hunting;
        this.trading = trading;
        this.wagon = wagon;
    }

    public void processCommand(String input) {
        String[] words = input.toLowerCase().split("\\s+"); // Split input into words
        if (words.length == 0) {
            System.out.println("Enter a valid command.");
            return;
        }

        String command = words[0]; // First word is the main command

        switch (command) {
            case "go":
            case "move":
                handleMovement(words);
                break;
            case "hunt":
                hunting.hunt();
                break;
            case "trade":
                trading.initiateTrade();
                break;
            case "check":
                handleCheckCommand(words);
                break;
            case "use":
                handleUseCommand(words);
                break;
            case "climb":
                if (words.length > 1) {
                    System.out.println("You attempt to climb the " + words[1] + ".");
                } else {
                    System.out.println("Climb what?");
                }
                break;
            case "quit":
                System.out.println("Exiting game...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command.");
                break;
        }
    }

    private void handleMovement(String[] words) {
        if (words.length < 3) {
            System.out.println("Specify a direction and distance. Example: 'go north 30 miles'");
            return;
        }

        String direction = words[1]; // Second word should be the direction
        int distance;

        try {
            distance = Integer.parseInt(words[2]); // Third word should be the distance
            movement.travel(direction, distance);
        } catch (NumberFormatException e) {
            System.out.println("Invalid distance. Example: 'go north 30 miles'");
        }
    }

    private void handleCheckCommand(String[] words) {
        if (words.length < 2) {
            System.out.println("Check what? (inventory/status/wagon)");
            return;
        }
        switch (words[1]) {
            case "inventory":
                inventory.displayInventory();
                break;
            case "status":
                player.displayStatus();
                break;
            case "wagon":
                wagon.checkWagon();
                break;
            default:
                System.out.println("Unknown check command.");
                break;
        }
    }

    private void handleUseCommand(String[] words) {
        if (words.length < 2) {
            System.out.println("Use what?");
            return;
        }
        player.useItem(words[1]); // Example: "use medicine"
    }

    public void startCommandLoop() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            processCommand(input);
        }
    }
}