public class weapon extends item {
    private int power;
    private int accuracy;

    public weapon(String name, int quantity) {
        super(name, 5, quantity);

        // Set power and accuracy based on weapon type
        if (name.contains("Rifle")) {
            this.power = 8;
            this.accuracy = 7;
        } else if (name.contains("Pistol")) {
            this.power = 5;
            this.accuracy = 5;
        } else {
            this.power = 3; // Basic weapons like knives
            this.accuracy = 9;
        }
    }

    public weapon(String name, int quantity, int power, int accuracy) {
        super(name, 5, quantity);
        this.power = power;
        this.accuracy = accuracy;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String toString() {
        return getName() + " (Power: " + power + ", Accuracy: " + accuracy + ", Qty: " + getQuantity() + ")";
    }

    public void displayHistoricalInfo() {
        System.out.println("\n=====================================================");
        System.out.println("            HISTORICAL WEAPON INFORMATION            ");
        System.out.println("=====================================================");

        System.out.println("\nFirearms on the Oregon Trail (1840s-1850s):");

        if (getName().contains("Rifle")) {
            System.out.println("\nRifles were essential tools for pioneers, used for hunting and protection.");
            System.out.println("Most common was the muzzle-loading percussion rifle that fired a");
            System.out.println("single shot. Loading required powder, a lead ball, and a percussion cap.");
            System.out.println("\nPopular models included:");
            System.out.println("- Hawken Rifle: Favored by mountain men and skilled hunters");
            System.out.println("- Kentucky/Pennsylvania Long Rifle: Accurate but slow to reload");
            System.out.println("- Model 1841 'Mississippi' Rifle: Used by military and civilians");
        } else if (getName().contains("Pistol")) {
            System.out.println("\nPistols were less common than rifles on the trail, but some");
            System.out.println("emigrants carried them for personal protection. They were less");
            System.out.println("practical for hunting due to limited range and stopping power.");
            System.out.println("\nTypical pistols of the era were:");
            System.out.println("- Colt Paterson: Early five-shot revolver");
            System.out.println("- Colt Walker: Powerful but heavy six-shot revolver");
            System.out.println("- Single-shot percussion pistols");
        } else {
            System.out.println("\nBeside firearms, pioneers carried various edged weapons:");
            System.out.println("- Large knives (Bowie knives) for hunting and utility purposes");
            System.out.println("- Tomahawks or hatchets for chopping wood and self-defense");
            System.out.println("- Basic hunting knives for skinning game and everyday tasks");
        }

        System.out.println("\nHistorical Note: Ammunition was precious and carefully conserved.");
        System.out.println("Many pioneers became skilled at molding their own bullets using");
        System.out.println("lead and bullet molds, as pre-made ammunition was limited.");
    }

    public static weapon createHuntingRifle(int quantity) {
        return new weapon("Hunting Rifle", quantity, 8, 7);
    }

    public static weapon createPistol(int quantity) {
        return new weapon("Pistol", quantity, 5, 5);
    }

    public static weapon createKnife(int quantity) {
        return new weapon("Hunting Knife", quantity, 3, 9);
    }
}