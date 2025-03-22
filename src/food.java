public class food extends item {
    private int nutrition;
    private boolean perishable;

    public food(String name, int weight, int nutrition) {
        super(name, weight);
        this.nutrition = nutrition;
        this.perishable = false;
    }

    public food(String name, int weight, int nutrition, boolean perishable) {
        super(name, weight);
        this.nutrition = nutrition;
        this.perishable = perishable;
    }

    public food(String name, int weight, int quantity, int nutrition, boolean perishable) {
        super(name, weight, quantity);
        this.nutrition = nutrition;
        this.perishable = perishable;
    }

    public void eat() {
        System.out.println("You eat the " + this.getName() + ".");
        System.out.println("Nutrition value: " + nutrition);
    }

    public int getNutrition() {
        return nutrition;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public boolean isExpired() {
        return Math.random() < 0.1; // 10% chance food is expired
    }

    public String toString() {
        String description = super.toString();
        if (perishable) {
            description += " (Perishable)";
        }
        return description;
    }

    // Add some common food items
    public static food createBacon(int quantity) {
        return new food("Bacon", 10, quantity, 6, false);
    }


}