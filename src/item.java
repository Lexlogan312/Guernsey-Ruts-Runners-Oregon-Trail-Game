public class item {
    private String name;
    private int weight;
    private int quantity;
    private int value;

    public item(String name, int weight, int quantity, int value) {
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
        this.value = value;
    }

    public item(String name, int weight, int quantity) {
        this(name, weight, quantity, 0);
    }

    public item(String name, int weight) {
        this(name, weight, 1, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
        if (this.quantity < 0) {
            this.quantity = 0;
        }
    }

    public int getValue() {
        return value;
    }

    public int getTotalWeight() {
        return weight * quantity;
    }

    public int getTotalValue() {
        return value * quantity;
    }

    public String toString() {
        return name + " (Qty: " + quantity + ", Weight: " + weight + " lbs each)";
    }
}