public class wagon {
    private int condition;
    private int capacity;
    private boolean isBroken;
    private String wagonType;

    public wagon() {
        condition = 100;
        capacity = 2000;
        isBroken = false;
        wagonType = "Conestoga";
    }

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

    public int getCondition() {
        return condition;
    }

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

    public void repair(int amount) {
        condition += amount;
        if (condition > 100) {
            condition = 100;
        }

        if (condition > 0) {
            isBroken = false;
        }
    }

    public boolean isBroken() {
        return isBroken;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getWagonType() {
        return wagonType;
    }

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