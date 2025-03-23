import java.util.Scanner;
import java.util.Random;

public class oxen {
    private String name; // Name of the oxen (optional, can be used for specific oxen)
    private int health;  // Health of the oxen
    private int maxHealth; // Max health of the oxen
    private boolean isAlive; // Whether the ox is alive or dead
    private int cost; // The cost to buy the ox
    private static final Random random = new Random(); // Random object for events (if needed)
    food food;

    // Constructor to initialize oxen with name, health, and cost
    public oxen(String name, int cost) {
        this.name = name;
        this.health = 100; // Default health for the ox
        this.maxHealth = 100;
        this.isAlive = true; // Ox starts alive
        this.cost = cost;
    }

    // Method to check if the ox is alive
    public boolean isAlive() {
        return isAlive;
    }

    // Method to feed the ox, which restores health
    public void feed() {
        if (isAlive) {
            int healthRestored = random.nextInt(20) + 10; // Restore a random amount of health
            health = Math.min(health + healthRestored, maxHealth); // Ensure health doesn't exceed max
            System.out.println(name + " has been fed and restored " + healthRestored + " health!");
        } else {
            System.out.println(name + " is no longer alive and cannot be fed.");
        }
    }

    // Method to make the ox "work" and lose some health based on usage
    public void work() {
        if (isAlive) {
            int damage = random.nextInt(10) + 5; // Oxen take some damage each time they work
            health -= damage;
            if (health <= 0) {
                health = 0;
                isAlive = false;
                System.out.println(name + " has died from exhaustion.");
            } else {
                System.out.println(name + " worked and lost " + damage + " health.");
            }
        } else {
            System.out.println(name + " is dead and cannot work.");
        }
    }

    // Method to check the ox's health status
    public void checkHealth() {
        if (isAlive) {
            System.out.println(name + "'s current health: " + health + "/" + maxHealth);
        } else {
            System.out.println(name + " is dead.");
        }
    }

    // Method to "buy" oxen (can be triggered from the main game logic)
    public void buyOxen(int cost) {
        System.out.println("You have bought an ox for " + cost + " dollars.");
    }

    // Getter for the ox's cost (useful if you are displaying cost to the player)
    public int getCost() {
        return cost;
    }

    // Getter for name (optional)
    public String getName() {
        return name;
    }

    // Getter for health (useful for other classes to check health)
    public int getHealth() {
        return health;
    }

    // Optional: Implement a toString() method to display ox details
    @Override
    public String toString() {
        return name + " (Health: " + health + "/" + maxHealth + ")";
    }

    public int takeDamage(int damage){
        health -= damage;
        if(health <= 0){
            health = 0;
            isAlive = false;
        }
        return damage;
    }

    public void decreaseFood(int amount) {
        if (food != null) {
            food.eat(amount);
            System.out.println(name + " has consumed " + amount + " units of food. Remaining food: " + food.getQuantity());
        } else {
            System.out.println(name + " has no food.");
        }
    }

    public food getFood(){
        return food;
    }
}


