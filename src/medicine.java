public class medicine extends item {
    private int healingPower;
    public medicine(String name, int quantity) {
        super(name, 1, quantity);

        // Different healing power based on medicine type
        if (name.contains("Advanced")) {
            this.healingPower = 25;
        } else {
            this.healingPower = 20; // Basic medicine
        }
    }

    public void useMedicine(player player) {
        System.out.println("Using " + this.getName() + " on " + player.getName() + ".");

        player.heal(healingPower);

        System.out.println("Healed " + player.getName() + " for " + healingPower + " points.");
        System.out.println("New health: " + player.getHealth());
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public String toString() {
        return getName() + " (Healing: " + healingPower + ", Qty: " + getQuantity() + ")";
    }

    public void displayHistoricalMedicalInfo() {
        System.out.println("\n=====================================================");
        System.out.println("          HISTORICAL MEDICINE ON THE TRAIL           ");
        System.out.println("=====================================================");

        System.out.println("\nMedical care in the 1840s-1850s was primitive by today's standards:");
        System.out.println("- Few trained doctors were available on the trail");
        System.out.println("- Folk remedies and herbal medicines were commonly used");
        System.out.println("- Bloodletting was still practiced for many ailments");
        System.out.println("- Laudanum (opium tincture) was used for pain relief");
        System.out.println("- Diseases like cholera, dysentery, and typhoid were common and deadly");
        System.out.println("- Injuries from accidents were often fatal due to infection");

        System.out.println("\nCommon medicines carried by pioneers:");
        System.out.println("- Quinine (for malaria and fevers)");
        System.out.println("- Calomel (mercury chloride, used as a purgative)");
        System.out.println("- Epsom salts (for various digestive issues)");
        System.out.println("- Peppermint oil (for stomach ailments)");
        System.out.println("- Camphor (for skin conditions and as a disinfectant)");

        System.out.println("\nAn estimated 1 in 10 emigrants died during the journey west,");
        System.out.println("with disease being the most common cause of death.");
    }

    public static medicine createBasicMedicine(int quantity) {
        return new medicine("Basic Medicine", quantity);
    }

    public static medicine createAdvancedMedicine(int quantity) {
        return new medicine("Advanced Medicine", quantity);
    }
}