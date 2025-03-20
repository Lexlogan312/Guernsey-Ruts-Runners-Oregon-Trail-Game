import java.util.Scanner;

public class startGame {
    private player player;
    private wagon wagon;
    private inventory inventory;
    private currency money;
    private map gameMap;
    private static Scanner scanner = new Scanner(System.in);

    // Add new variables for selection options
    private static String playerGender;
    private static String playerName;

    private static String trail;
    private static String departureLocation;
    private static String departureMonth;

    private int totalTrailDistance;
    private int daysTraveled;
    private int distanceTraveled;

    public startGame() {
        player = new player();
        inventory = new inventory();
        wagon = new wagon();
        gameMap = new map();

        displayWelcomeMessage();
        selectPlayerGender();
        selectTrail();
        selectDepartureMonth();
        setupInitialConditions();
    }

    public void displayWelcomeMessage() {
        System.out.println("=====================================================");
        System.out.println("               Perils Along the Platte               ");
        System.out.println("             A Historical Adventure Game             ");
        System.out.println("=====================================================");
        System.out.println("\nExperience the challenges faced by pioneers in the 1800s");
        System.out.println("as they traveled west seeking new opportunities.");
        System.out.println("\nThis journey will test your decision-making skills and");
        System.out.println("teach you about this important period in American history.");
        System.out.println("\nPress Enter to begin your adventure...");
        scanner.nextLine();
    }

    public void selectPlayerGender() {
        System.out.println("\n=====================================================");
        System.out.println("                CHARACTER SELECTION                  ");
        System.out.println("=====================================================");
        System.out.println("\nIn the 1800s, men and women faced different challenges");
        System.out.println("on the trail west. Your choice will affect some of the");
        System.out.println("situations you encounter.");

        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("\nSelect your character's gender:");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.print("\nEnter your choice (1-2): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                playerGender = "male";
                validChoice = true;
            } else if (choice.equals("2")) {
                playerGender = "female";
                validChoice = true;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        validChoice = false;
        while (!validChoice) {
            System.out.println("\nEnter your character's name:");
            String name = scanner.nextLine();

            if (!(name.equals(null))) {
                playerName = name;
                validChoice = true;
            } else {
                System.out.println("Invalid name. Please try again.");
            }
        }
        player.setGender(playerGender);
        player.setName(playerName);
    }

    public void selectTrail() {
        System.out.println("\n=====================================================");
        System.out.println("                   TRAIL SELECTION                   ");
        System.out.println("=====================================================");

        System.out.println("\nThere were several major routes west. Each trail had");
        System.out.println("different destinations, terrain, and challenges:");

        System.out.println("\n1. Oregon Trail (2,170 miles)");
        System.out.println("   Destination: Oregon's Willamette Valley");
        System.out.println("   Historical Note: Most popular route for farmers seeking fertile land");

        System.out.println("\n2. California Trail (1,950 miles)");
        System.out.println("   Destination: California's gold fields and farmlands");
        System.out.println("   Historical Note: Became heavily traveled after the 1848 Gold Rush");

        System.out.println("\n3. Mormon Trail (1,300 miles)");
        System.out.println("   Destination: Salt Lake Valley, Utah");
        System.out.println("   Historical Note: Used by Mormon pioneers fleeing religious persecution");

        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("\nWhich trail would you like to take? (1-3): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    trail = "Oregon";
                    departureLocation = "Independence, Missouri";
                    validChoice = true;
                    break;
                case "2":
                    trail = "California";
                    departureLocation = "Independence, Missouri";
                    validChoice = true;
                    break;
                case "3":
                    trail = "Mormon";
                    departureLocation = "Nauvoo, Illinois";
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        gameMap.setTrail(trail, departureLocation);

        System.out.println("\nYou have chosen to travel along the " + trail + " Trail.");
        System.out.println("Your journey will begin in " + departureLocation + ".");
    }

    public void selectDepartureMonth() {
        System.out.println("\n=====================================================");
        System.out.println("              DEPARTURE MONTH SELECTION              ");
        System.out.println("=====================================================");

        System.out.println("\nThe timing of your departure was crucial for pioneers.");
        System.out.println("Leave too early: face mud and flooding from spring rains.");
        System.out.println("Leave too late: risk being trapped in mountain snow.");
        System.out.println("\nMost emigrants departed between April and June.");

        String[] months = {"March", "April", "May", "June", "July"};

        System.out.println("\nSelect your departure month:");
        for (int i = 0; i < months.length; i++) {
            System.out.println((i+1) + ". " + months[i]);
        }

        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("\nEnter your choice (1-5): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 5) {
                    departureMonth = months[choice-1];
                    validChoice = true;

                    // Historical context based on month choice
                    switch (choice) {
                        case 1:
                            System.out.println("\nMarch: An early start, but you'll face muddy trails and swollen rivers.");
                            break;
                        case 2:
                            System.out.println("\nApril: A good balance - the trails are drying out and you'll have plenty of time.");
                            break;
                        case 3:
                            System.out.println("\nMay: The most popular month for departure - grass for animals is plentiful.");
                            break;
                        case 4:
                            System.out.println("\nJune: Still a good time to leave, but you'll need to maintain a steady pace.");
                            break;
                        case 5:
                            System.out.println("\nJuly: A late start - you'll need to hurry to cross mountains before winter.");
                            break;
                    }
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number between 1 and 5.");
            }
        }
    }

    public void setupInitialConditions() {
        System.out.println("\n=====================================================");
        System.out.println("                PREPARING FOR DEPARTURE              ");
        System.out.println("=====================================================");

        System.out.println("\nYou are now in " + departureLocation + ".");
        System.out.println("It is " + departureMonth + " 1848, and you're preparing to depart along the " + trail + ".");

        // Historical context based on starting location
        if (departureLocation.equals("Independence, Missouri")) {
            System.out.println("\nIndependence is bustling with activity as wagon trains form up.");
            System.out.println("The town is crowded with emigrants buying supplies for the journey.");
            System.out.println("Wagons, oxen, and provisions are selling at premium prices.");
        } else {
            System.out.println("\nNauvoo has been largely abandoned by the Mormons after");
            System.out.println("persecution and violence. Most are heading west to find");
            System.out.println("religious freedom in the Utah Territory.");
        }

        System.out.println("\nPress Enter to continue to equipping your wagon...");
        scanner.nextLine();

        money = new currency(1600); // Standard starting money
        System.out.println("\nYou have $" + money.getBalance() + " to spend on supplies for the journey.");

        // Continue with game setup
        beginJourney();
    }

    public void beginJourney() {
        boolean gameRunning = true;
        movement travel = new movement(gameMap, trail);
        weather currentWeather = new weather();
        currentWeather.setInitialWeather(departureMonth);

        totalTrailDistance = gameMap.getTotalDistance();
        daysTraveled = 1;
        distanceTraveled = 0;

        // Initial supplies purchase
        visitStore();

        while (gameRunning) {
            // Display current day and location
            System.out.println("\n===== DAY " + daysTraveled + " =====");
            System.out.println("Current Location: " + gameMap.getCurrentLandmark());
            System.out.println("Distance traveled: " + distanceTraveled + " miles");
            System.out.println("Distance to next landmark: " + gameMap.getDistanceToNextLandmark() + " miles");

            // Update weather each day with a small chance of change
            currentWeather.updateWeather();
            System.out.println("Weather: " + currentWeather.getCurrentWeather());

            // Daily food consumption
            consumeDailyFood();

            // Display status
            displayStatus();

            // Get user choice
            int choice = getUserChoice();

            switch (choice) {
                case 1: // Continue journey

                    break;

                case 2: // Rest

                    break;

                case 3: // Hunt

                    break;

                case 4: // Look at inventory

                    break;

                case 5: // Learn about history

                    break;

                case 6: // Exit game
                    System.out.println("Are you sure you want to quit? (Y/N)");
                    if (scanner.next().equalsIgnoreCase("Y")) {
                        gameRunning = false;
                    }
                    break;
            }

            // Check if game should end
            if (player.getHealth() <= 0) {
                System.out.println("\nYou have died from " + player.getCauseOfDeath() + ".");
                System.out.println("Many pioneers faced similar fates on the trail.");
                System.out.println("Game Over.");
                gameRunning = false;
            }

            // Advance day
            daysTraveled++;
        }
    }

    private void visitStore() {
        market store = new market(money, inventory);
        store.visitStore(departureLocation);
    }

    private void consumeDailyFood() {

    }

    private void displayStatus() {
        System.out.println("\n===== STATUS =====");
        System.out.println("Health: " + player.getHealth() + "/100");
        System.out.println("Money: $" + money.getBalance());
        System.out.println("Wagon Condition: " + wagon.getCondition() + "/100");
        System.out.println("Food: " + inventory.getFoodAmount() + " pounds");
    }

    private int getUserChoice() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Continue on the trail");
        System.out.println("2. Rest for the day");
        System.out.println("3. Hunt for food");
        System.out.println("4. Check inventory");
        System.out.println("5. Learn about the trail history");
        System.out.println("6. Quit game");

        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 6) {
                    return choice;
                } else {
                    System.out.println("Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number between 1 and 6.");
            }
        }
    }
}