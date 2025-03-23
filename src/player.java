import java.util.ArrayList;

public class player {
    private String name;
    private String gender;
    private double lastDamage = 0;
    private double currentDamage = 0;
    private health playerHealth;
    private String causeOfDeath;
    private int hunger;
    private int fatigue;
    private boolean isSick;
    private String illness;
    currency money;
    health health;
    food food;
    inventory inventory;
    weapon weapon;
    private ArrayList<oxen> oxenList;
    private ArrayList<food> foodList;

    public player() {
        playerHealth = new health(100);
        hunger = 100;
        fatigue = 0;
        isSick = false;
        illness = "None";
        oxenList = new ArrayList<>();
        this.foodList = new ArrayList<>();
    }

    public player(String name, String gender, double money) {
        this();
        this.name = name;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getDamage(double damageDone){
        lastDamage = currentDamage;
        return currentDamage = damageDone;
    }

    public double getHealth() {
        return playerHealth.getCurrentHealth();
    }

    public double getLastDamage() {
        return lastDamage;
    }

    public void takeDamage(int amount, String cause) {
        playerHealth.takeDamage(amount, cause);
        if (playerHealth.getCurrentHealth() <= 0) {
            causeOfDeath = cause;
        }
        lastDamage = amount;
    }

    public void takeDamage(int amount){
        takeDamage(amount, "Unknown");
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void heal(int amount) {
        playerHealth.heal(amount);
    }

    public boolean isAlive() {
        return playerHealth.isAlive();
    }

    public int getHunger() {
        return hunger;
    }

    public int addHunger(int amount){
        hunger += amount;
        return hunger;
    }

    public int removeHunger(int amount){
        hunger -= amount;
        if(hunger < 0) hunger = 0;
        return hunger;
    }
    public int getFatigue() {
        return fatigue;
    }

    public boolean isSick() {
        return isSick;
    }

    public String getIllness() {
        return illness;
    }

    public void rest(){
        fatigue += (int) Math.abs((fatigue + 10 * 0.5) / 2);
        playerHealth.heal(10);
        removeHunger(10);
    }

    public void displayStatus(){
        System.out.println("\n===== Player Status =====");
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Food: " + food + " lbs");
        System.out.println("Money: $" + money);
        System.out.println("=========================");
    }

    public void useItem(item item) {
        if (!inventory.hasItem(item.getName())) {
            System.out.println("You do not have a " + item.getName() + " to use.");
            return;
        }

        switch (item.getName().toLowerCase()) {
            case "medicine":
                if (health.getCurrentHealth() < 100) {
                    health.heal(Math.min(health.getCurrentHealth() + 20, 100));
                    inventory.removeItem(item, 1);
                    System.out.println("You used medicine. Health is now: " + health);
                } else {
                    System.out.println("Your health is already full.");
                }
                break;

            case "food":
                if (food.getQuantity() > 0) {
                    food.setQuantity(Math.max(food.getQuantity() - 5, 0));  // Eating food reduces supply
                    System.out.println("Your " + item.getName() + " gave you " + food.getNutrition() + " health");
                    System.out.println("You eat some food. Food left: " + food + " lbs");
                } else {
                    System.out.println("You have no food left!");
                }
                break;

            default:
                System.out.println("You cannot use " + item.getName() + ".");
                break;
        }
    }

    public inventory getInventory(){
        return inventory;
    }

    public item getItem(String itemName){
        return inventory.getItemInUse(itemName);
    }

    public double getCurrency(){
        return money.getBalance();
    }

    public void increaseCurrency(int amount){
        money.addMoney(amount);
    }

    public void decreaseCurrency(int amount){
        money.removeMoney(amount);
    }

    public void equipWeapon(weapon weapon) {
        this.weapon = weapon;
    }

    // Getter for weapon power
    public int getWeaponPower() {
        if (weapon != null) {
            return weapon.getPower();
        } else {
            return 0; // If the player has no weapon, return 0 attack power
        }
    }

    public void addOxen(oxen ox) {
        oxenList.add(ox);
    }

    // Decrease the health of an ox
    public void decreaseOxHealth(int amount) {
        if (oxenList.isEmpty()) {
            System.out.println("You have no oxen to decrease health for.");
            return;
        }

        // Assuming you want to decrease health for all oxen equally
        for (oxen ox : oxenList) {
            ox.takeDamage(amount);
            System.out.println("One of your oxen's health has decreased by " + amount + " points.");
            if (ox.getHealth() == 0) {
                System.out.println(ox.getName() + " has died.");
            }
        }
    }

    // Getter for oxen list size
    public int getOxenCount() {
        return oxenList.size();
    }

    public void AddFood(food food){
        this.foodList.add(food);
    }

    public void decreaseFood(food food, int amount){
        if(food == null){
            System.out.println("No food item selected.");
            return;
        }

        food.decreaseQuantity(amount);

        System.out.println("You have consumed " + amount + " units of " + food.getName() + ". Remaining food: " + food.getQuantity());
    }

    public int getFood(String foodName){
        for(food food : foodList){
            if(food.getName().equals(foodName)){
                return food.getQuantity();
            }
        }
        return 0;
    }

    public void decreaseFood(int amount){
        for(int i = 0; i < foodList.size(); i++){
            if(foodList.get(i).getQuantity() >= amount){
                foodList.get(i).decreaseQuantity(amount);
                return;
            }
        }
    }
}
