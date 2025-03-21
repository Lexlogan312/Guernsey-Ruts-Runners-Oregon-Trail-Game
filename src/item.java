public class item {
    private String name;
    private int weight;
    private int quantity;
    private int value;
    private int maximumQuantity;
    private boolean isPerishable;
    private boolean isDrinkable;
    private boolean isConsumable;
    private boolean isUsable;

    public item(String name, int weight, int quantity, int value, int maximumQuantity) {
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
        this.value = value;
        this.maximumQuantity = maximumQuantity;
    }

    public item(String name, int weight, int quantity, int maximumQuantity) {
        this(name, weight, quantity, 0, maximumQuantity);
    }

    public item(String name, int weight) {
        this(name, weight, 1, 0);
    }

    public item(String name, int i, int quantity) {
        this(name, i, quantity, 0);
    }

    public void setItemBoolean(boolean isDrinkable, boolean isConsumable, boolean isUsable, boolean isPerishable) {
        this.isDrinkable = isDrinkable;
        this.isConsumable = isConsumable;
        this.isUsable = isUsable;
        this.isPerishable = isPerishable;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public boolean isDrinkable(){
        return isDrinkable;
    }

    public boolean isConsumable(){
        return isConsumable;
    }

    public boolean isExpired() {
        if(Math.random() * 1 + 10 < 5){
            return true;
        }
        else return false;
    }

    public boolean isUsable(){
        return isUsable;
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

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
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