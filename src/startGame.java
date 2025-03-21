import java.util.Scanner;

public class startGame {
    private player player;
    private wagon wagon;
    private inventory inventory;
    private currency money;
    private map gameMap;
    private hunting hunting;
    private static Scanner scanner = new Scanner(System.in);

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
        hunting = new hunting();


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

        System.out.println("\nYou are in " + departureLocation + ".");
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

        visitStore();

        fastForwardToFortKearny();

        while (gameRunning) {
            // Display current day and location
            System.out.println("\n===== DAY " + daysTraveled + " =====");
            System.out.println("Current Location: " + gameMap.getCurrentLandmark());
            System.out.println("Distance traveled: " + distanceTraveled + " miles");
            System.out.println("Distance to next landmark: " + gameMap.getDistanceToNextLandmark() + " miles");

            // Update weather each day with a small chance of change
            currentWeather.updateWeather(daysTraveled, departureMonth);
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
                    rest();
                    break;

                case 3: // Look at inventory
                    System.out.println("----------Inventory----------");
                    inventory.displayInventory();
                    break;

                case 4: // Learn about history

                    break;

                case 5: // Exit game
                    System.out.println("Are you sure you want to quit? (Y/N)");
                    if (scanner.next().equalsIgnoreCase("Y")) {
                        gameRunning = false;
                    }
                    break;
            }

            if (inventory.getFoodAmount() < 500) {
                if (Math.random()*100+1 < 15) {
                    System.out.println("You have less than 500 pounds of food left!");
                    boolean validChoice = false;
                    while (!validChoice) {
                        System.out.println("Would you like to hunt for more food? (Y/N)");
                        String huntingChoice = scanner.nextLine();
                        if (huntingChoice.equalsIgnoreCase("Y")) {
                            hunting.hunt();
                            validChoice = true;
                        } else if (huntingChoice.equalsIgnoreCase("N")) {
                            validChoice = true;
                        } else {
                            System.out.println("Invalid choice. Please enter Y or N.");
                        }
                    }
                }
            }


            if (player.getHealth() <= 0) {
                System.out.println("\nYou have died from " + player.getCauseOfDeath() + ".");
                System.out.println("Many pioneers faced similar fates on the trail.");
                System.out.println("Game Over.");
                gameRunning = false;
            }

            daysTraveled++;
        }

        displayGameSummary(daysTraveled, distanceTraveled);
    }

    private void visitStore() {
        market store = new market(money, inventory);
        store.visitStore(departureLocation);
    }

    private void fastForwardToFortKearny() {
        int fortKearnyDistance = 0;
        String currentLandmark = "";

        for (int i = 0; i < gameMap.getLandmarkArraySize(); i++) {
            currentLandmark = gameMap.getLandmarkAtIndex(i);
            if (currentLandmark.contains("Fort Kearny")) {
                fortKearnyDistance = gameMap.getLandmarkDistanceAtIndex(i);
                break;
            }
        }

        int averageDailyDistance = 15;
        int daysToFortKearny = fortKearnyDistance / averageDailyDistance;

        if (departureMonth.equals("March")) {
            daysToFortKearny += 3;
        } else if (departureMonth.equals("July")) {
            daysToFortKearny -= 2;
        }

        int foodNeeded = 2 * daysToFortKearny;
        int foodAvailable = inventory.getFoodAmount();

        System.out.println("\n=====================================================");
        System.out.println("       JOURNEY TO FORT KEARNY - " + daysToFortKearny + " DAYS LATER       ");
        System.out.println("=====================================================");

        System.out.println("\nYour journey from " + departureLocation + " to Fort Kearny");
        System.out.println("takes " + daysToFortKearny + " days traveling at a steady pace.");

        if (foodAvailable >= foodNeeded) {
            inventory.consumeFood(foodNeeded);
            System.out.println("You consumed " + foodNeeded + " pounds of food during this time.");
        } else {
            System.out.println("You didn't have enough food for the journey (" + foodNeeded + " pounds needed).");
            System.out.println("Your party suffers from malnutrition, affecting everyone's health.");
            player.takeDamage(15, "Malnutrition");
            inventory.consumeFood(foodAvailable);
        }

        distanceTraveled = fortKearnyDistance;
        daysTraveled += daysToFortKearny;
        gameMap.updateLocationToDistance(distanceTraveled);

        System.out.println("\nYou have arrived at Fort Kearny, an important military post");
        System.out.println("along the Platte River. From here, you'll follow the river");
        System.out.println("west toward your destination, making daily decisions.");
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private void consumeDailyFood() {
        // Each person consumes 2 pounds of food per day
        int foodNeeded = 2;
        int foodAvailable = inventory.getFoodAmount();

        if (foodAvailable >= foodNeeded) {
            inventory.consumeFood(foodNeeded);
            System.out.println("You consumed " + foodNeeded + " pounds of food.");
        } else {
            System.out.println("WARNING: You don't have enough food! This will affect your health.");
            if (foodAvailable > 0) {
                inventory.consumeFood(foodAvailable);
                System.out.println("You consumed the last " + foodAvailable + " pounds of food.");
            }

            // Health penalty for insufficient food
            int healthLoss = 5 + (int)(Math.random() * 5); // 5-10 health loss
            player.takeDamage(healthLoss, "starvation");
            System.out.println("You lost " + healthLoss + " health due to hunger.");

            // Historical context for starvation
            System.out.println("\nHistorical Note: Food shortages were common on the trail.");
            System.out.println("Pioneers sometimes went days without proper meals, leading to");
            System.out.println("weakness and increased susceptibility to disease.");
        }
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

    private void checkWagonCondition() {
        if (wagon.getCondition() <= 0) {
            System.out.println("\nYour wagon has completely broken down!");
            System.out.println("Without a functioning wagon, you cannot continue your journey.");
            System.out.println("\nHistorical Note: Abandoned wagons were a common sight along the trail.");
            System.out.println("Pioneers often had to discard possessions or even entire wagons");
            System.out.println("when they became too damaged to continue.");

            // Game over
            player.takeDamage(100, "being stranded with a broken wagon");
        }
    }

    private void displayHistoricalInformation() {
        System.out.println("\n=====================================================");
        System.out.println("              HISTORICAL INFORMATION                ");
        System.out.println("=====================================================");

        // Random historical facts about the current trail
        String[] oregonTrailFacts = {
                "The Oregon Trail stretched about 2,170 miles from Independence, Missouri to Oregon's Willamette Valley.",
                "Between 1840 and 1860, more than 400,000 pioneers traveled the Oregon Trail seeking farmland and new opportunities.",
                "The journey typically took 4-6 months by wagon, with travelers walking most of the way.",
                "Wagon trains usually traveled 15-20 miles per day when conditions were good.",
                "Disease was the biggest killer on the trail, with cholera being particularly deadly.",
                "Contrary to popular belief, attacks by Native Americans were relatively rare. Only about 4% of pioneer deaths were due to conflicts."
        };

        String[] californiaTrailFacts = {
                "The California Trail branched from the Oregon Trail and became heavily used after the 1848 Gold Rush.",
                "Over 250,000 gold-seekers and farmers used the California Trail during the Gold Rush period.",
                "The most difficult stretch was the Sierra Nevada mountains, especially the 40-mile desert in Nevada.",
                "The Donner Party's tragic story happened on the California Trail when they became snowbound in the Sierra Nevada in 1846-47.",
                "Many California-bound pioneers abandoned their wagons and possessions to complete the difficult journey.",
                "The discovery of gold at Sutter's Mill in 1848 transformed California from a sparsely populated territory to a state by 1850."
        };

        String[] mormonTrailFacts = {
                "The Mormon Trail was used by members of the Church of Jesus Christ of Latter-day Saints fleeing religious persecution.",
                "The trail stretched 1,300 miles from Nauvoo, Illinois to Salt Lake Valley, Utah.",
                "Unlike other trails, the Mormon migration was highly organized, with carefully planned rest stops.",
                "Mormons used handcarts instead of wagons for part of their migration (1856-1860).",
                "The Mormon Trail followed the north side of the Platte River, while the Oregon Trail followed the south side.",
                "Brigham Young led the first group of Mormon pioneers to the Salt Lake Valley in 1847."
        };

        // Select appropriate facts based on chosen trail
        String[] currentTrailFacts = new String[0];
        switch (trail) {
            case "Oregon":
                currentTrailFacts = oregonTrailFacts;
                break;
            case "California":
                currentTrailFacts = californiaTrailFacts;
                break;
            case "Mormon":
                currentTrailFacts = mormonTrailFacts;
                break;
        }

        if (currentTrailFacts.length > 0) {
            System.out.println("\nFacts about the " + trail + " Trail:");
            int fact1 = (int)(Math.random() * currentTrailFacts.length);
            int fact2 = (fact1 + 1 + (int)(Math.random() * (currentTrailFacts.length - 1))) % currentTrailFacts.length;

            System.out.println("\n• " + currentTrailFacts[fact1]);
            System.out.println("\n• " + currentTrailFacts[fact2]);
        }

        String[] pioneerLifeFacts = {
                "Pioneer women typically wore cotton dresses, sunbonnets, and aprons. Men wore cotton shirts, vests, and trousers.",
                "A typical day on the trail started around 4 AM and ended with setting up camp around 4 PM.",
                "Pioneer children still had chores and sometimes school on the trail. They gathered buffalo chips (dried dung) for fuel.",
                "Pioneers often walked alongside their wagons to reduce weight and strain on the animals.",
                "Food staples included flour, bacon, coffee, dried beans, and dried fruit. Fresh meat came from hunting.",
                "Music and storytelling were important forms of entertainment around campfires at night."
        };

        System.out.println("\nDaily Life on the Trail:");
        System.out.println("\n• " + pioneerLifeFacts[(int)(Math.random() * pioneerLifeFacts.length)]);

        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private void displayIndependenceRockEndingContext() {
        System.out.println("\n=====================================================");
        System.out.println("            INDEPENDENCE ROCK REACHED!              ");
        System.out.println("=====================================================");

        System.out.println("\nCongratulations on reaching Independence Rock!");
        System.out.println("\nHistorical Note: Independence Rock was a crucial milestone on");
        System.out.println("all western trails. Known as the 'Register of the Desert,'");
        System.out.println("thousands of emigrants carved their names into its granite surface.");

        System.out.println("\nReaching this landmark by July 4th (Independence Day) was");
        System.out.println("considered essential for emigrants, as it meant they were on schedule");
        System.out.println("to cross the Rocky Mountains before winter snows made passage impossible.");

        System.out.println("\nThe Platte River portion of your journey is now complete.");
        System.out.println("From here, emigrants would continue on to South Pass, where the");
        System.out.println("Continental Divide presented the next major challenge of the journey west.");

        // Trail-specific additional context
        if (trail.equals("Oregon")) {
            System.out.println("\nOregon-bound emigrants would still face many challenges including");
            System.out.println("the Blue Mountains and the dangerous Columbia River before reaching");
            System.out.println("the Willamette Valley.");
        } else if (trail.equals("California")) {
            System.out.println("\nCalifornia-bound travelers faced the harsh 40-mile desert crossing");
            System.out.println("and the treacherous Sierra Nevada mountains, where the Donner Party");
            System.out.println("famously became trapped by early snowfall in 1846.");
        } else { // Mormon Trail
            System.out.println("\nMormon pioneers would continue through Echo Canyon before");
            System.out.println("finally reaching the Salt Lake Valley, where Brigham Young");
            System.out.println("famously declared 'This is the place' in July 1847.");
        }
    }

    private void displayGameSummary(int days, int distanceTraveled) {
        System.out.println("\n=====================================================");
        System.out.println("                  JOURNEY SUMMARY                    ");
        System.out.println("=====================================================");

        System.out.println("\nTrail Selected: " + trail + " Trail");
        System.out.println("Days on the trail: " + days);
        System.out.println("Total distance traveled: " + distanceTraveled + " miles");

        if (player.getHealth() > 0) {
            System.out.println("Final health: " + player.getHealth() + "/100");
            System.out.println("Remaining money: $" + money.getBalance());
            System.out.println("\nYou successfully completed the journey!");
        } else {
            System.out.println("Cause of death: " + player.getCauseOfDeath());
            System.out.println("\nYou died " + distanceTraveled + " miles into your journey.");
        }

        System.out.println("\nThank you for experiencing this important chapter in American history!");
        System.out.println("Would you like to play again? (Y/N)");
        if (scanner.next().equalsIgnoreCase("Y")) {
            startGame newGame = new startGame();
            Main.main(new String[0]);
        } else {
            System.out.println("Goodbye!");
        }

        // At the end, add this line to show the educational summary for completed journeys
        if (player.getHealth() > 0) {
            displayEndGameSummary(true);
        }
    }

    // Add to startGame class

    public void displayEndGameSummary(boolean success) {
        System.out.println("\n=====================================================");
        System.out.println("                   JOURNEY COMPLETE                  ");
        System.out.println("=====================================================");

        if (success) {
            System.out.println("\nCONGRATULATIONS! You've reached Independence Rock on the " + trail + " Trail!");

            if (trail.equals("Oregon")) {
                System.out.println("\nYou've successfully traveled 830 miles from " + departureLocation + ".");
                System.out.println("It's now " + calculateArrivalDate() + ", " + (1848 + (departureMonth.equals("July") ? 1 : 0)) + ".");
                System.out.println("\nHistorical Context: Independence Rock marked a crucial milestone for");
                System.out.println("Oregon-bound emigrants. From here, they would continue to South Pass,");
                System.out.println("Fort Bridger, and eventually face the challenging Blue Mountains");
                System.out.println("before reaching Oregon's Willamette Valley after another 1,340 miles.");
            } else if (trail.equals("California")) {
                System.out.println("\nYou've successfully traveled 830 miles from " + departureLocation + ".");
                System.out.println("It's now " + calculateArrivalDate() + ", " + (1848 + (departureMonth.equals("July") ? 1 : 0)) + ".");
                System.out.println("\nHistorical Context: After Independence Rock, California-bound");
                System.out.println("emigrants faced another 1,120 miles through South Pass,");
                System.out.println("the Great Basin Desert, and the Sierra Nevada mountains before");
                System.out.println("reaching the gold fields and farmlands of California.");
            } else { // Mormon Trail
                System.out.println("\nYou've successfully traveled 965 miles from " + departureLocation + ".");
                System.out.println("It's now " + calculateArrivalDate() + ", " + (1848 + (departureMonth.equals("July") ? 1 : 0)) + ".");
                System.out.println("\nHistorical Context: After Independence Rock, the Mormon pioneers");
                System.out.println("continued another 335 miles through South Pass and Echo Canyon");
                System.out.println("before finally establishing their new home in the Salt Lake Valley.");
            }
        } else {
            System.out.println("\nYour journey has ended before reaching your destination.");
            System.out.println("Cause: " + player.getCauseOfDeath());
            System.out.println("\nHistorical Context: Approximately 1 in 10 emigrants died on the trail,");
            System.out.println("with disease being the leading cause of death, followed by accidents.");
            System.out.println("Many trail diaries describe the heartbreak of burying loved ones along");
            System.out.println("the trail and then having to continue the journey the next day.");
        }

        System.out.println("\n----- JOURNEY STATISTICS -----");
        System.out.println("Miles traveled: " + this.distanceTraveled + " of " + this.totalTrailDistance);
        System.out.println("Days on the trail: " + this.daysTraveled);
        System.out.println("Food remaining: " + inventory.getFoodAmount() + " pounds");
        System.out.println("Money remaining: $" + money.getBalance());

    }
}