package termProject;

/**
 * Wagon Class of the Perils Along the Platte Game
 * Represents the player's wagon with attributes such as condition, capacity, and type.
 * Manages wagon damage, repairs, and provides historical information about wagon types.
 *
 * @author : Alex Randall, Chase McCluskey, Painter Drury, and Domenic Pilla
 * @version : 1.0
 * @date : 03/25/2025
 * @file : wagon.java
 */
public class wagon {
    private int condition;
    private int capacity;
    private boolean isBroken;
    private String wagonType;

    /**
     * Default constructor for creating a standard wagon.
     * Initializes a Conestoga wagon with default values for condition and capacity.
     */
    public wagon() {
        condition = 100;
        capacity = 2000;
        isBroken = false;
        wagonType = "Conestoga";
    }

    /**
     * Constructor for creating a specific type of wagon.
     * Sets capacity based on the wagon type selected.
     * 
     * @param wagonType The type of wagon ("Conestoga", "Prairie Schooner", or "Farm Wagon")
     */
    public wagon(String wagonType) {
        this();
        this.wagonType = wagonType;

        if (wagonType.equals("Conestoga")) {
            capacity = 2500;
        } else if (wagonType.equals("Prairie Schooner")) {
            capacity = 2000;
        } else if (wagonType.equals("Farm Wagon")) {
            capacity = 1500;
        }
    }

    /**
     * Gets the current condition of the wagon.
     * 
     * @return The wagon condition value (0-100)
     */
    public int getCondition() {
        return condition;
    }

    /**
     * Reduces the wagon's condition by the specified amount.
     * Sets the wagon to broken status if condition reaches zero.
     * 
     * @param amount The amount of damage to apply
     */
    public void damage(int amount) {
        condition -= amount;
        if (condition <= 0) {
            condition = 0;
            isBroken = true;
            System.out.println("Your wagon has broken down completely!");
        } else if (condition < 20) {
            System.out.println("Warning: Your wagon is in critical condition!");
            System.out.println("You should repair it soon.");
        }
    }

    /**
     * Repairs the wagon, increasing its condition by the specified amount.
     * Caps condition at 100 and restores the wagon from broken status if applicable.
     * 
     * @param amount The amount of condition to restore
     */
    public void repair(int amount) {
        condition += amount;
        if (condition > 100) {
            condition = 100;
        }

        if (condition > 0) {
            isBroken = false;
        }
    }

    /**
     * Checks if the wagon is currently broken.
     * 
     * @return true if the wagon is broken, false otherwise
     */
    public boolean isBroken() {
        return isBroken;
    }

    /**
     * Gets the maximum carrying capacity of the wagon.
     * 
     * @return The carrying capacity in pounds
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the type of wagon.
     * 
     * @return The wagon type name
     */
    public String getWagonType() {
        return wagonType;
    }

    /**
     * Displays information about the wagon to the player.
     * Includes type, condition, capacity, and warning messages if needed.
     */
    public void displayWagonInfo() {
        System.out.println("\n=====================================================");
        System.out.println("                  YOUR WAGON                        ");
        System.out.println("=====================================================");

        System.out.println("Type: " + wagonType);
        System.out.println("Condition: " + condition + "/100");
        System.out.println("Carrying Capacity: " + capacity + " pounds");

        if (condition < 20) {
            System.out.println("\nWARNING: Your wagon needs urgent repairs!");
        } else if (condition < 50) {
            System.out.println("\nYour wagon is showing signs of wear and should be repaired soon.");
        }

        System.out.println("\nHistorical Note: " + getWagonHistoricalInfo());
    }

    /**
     * Provides historical information about the current wagon type.
     * 
     * @return A string containing historical context about the wagon type
     */
    private String getWagonHistoricalInfo() {
        if (wagonType.equals("Conestoga")) {
            return "Conestoga wagons were large, heavy freight wagons developed in Pennsylvania. " +
                    "They were rarely used by Oregon Trail emigrants as they were too heavy for the journey.";
        } else if (wagonType.equals("Prairie Schooner")) {
            return "Prairie Schooners were the most common wagons used on the Oregon Trail. " +
                    "Smaller and lighter than Conestogas, they were covered with white canvas that " +
                    "resembled a ship's sail, hence the 'schooner' name.";
        } else {
            return "Most emigrants used converted farm wagons with canvas covers added. " +
                    "These were about 10 feet long and 4 feet wide, with a weight capacity " +
                    "of about 1,600 pounds of supplies.";
        }
    }
}