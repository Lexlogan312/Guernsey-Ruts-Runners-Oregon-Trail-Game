public class NPC {
    private String name;
    private int health;
    private int maxHealth;
    private int currency;
    private inventory inventory;

    // Constructor to initialize NPC attributes
    public NPC(String name, int maxHealth, int currency) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Initially, the NPC has full health
        this.currency = currency;
        this.inventory = new inventory(); // NPC's inventory (optional, could store items)
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void decreaseHealth(int amount) {
        this.health = Math.max(0, this.health - amount); // Prevent negative health
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public inventory getInventory() {
        return inventory;
    }

    public void addItemToInventory(item item, int quantity) {
        inventory.addItem(item, quantity);
    }

    // NPC interaction methods

    // Talk to the NPC (random dialogue or trade offer)
    public void talk() {
        String[] dialogues = {
                "Hello there, traveler! Do you need supplies?",
                "The land ahead is dangerous, be careful.",
                "I'm willing to trade for some of your goods."
        };

        int dialogueIndex = (int) (Math.random() * dialogues.length);
        System.out.println(name + " says: " + dialogues[dialogueIndex]);

        // Example of random trade offer (this could trigger a trade or just a chat)
        if (Math.random() * 100 < 50) {
            System.out.println("The NPC offers to trade with you.");
        } else {
            System.out.println("The NPC doesn't have anything to offer right now.");
        }
    }

    // Check if NPC has enough currency
    public boolean hasEnoughCurrency(int amount) {
        return this.currency >= amount;
    }

    // Add currency to NPC
    public void addCurrency(int amount) {
        this.currency += amount;
    }

    // Remove currency from NPC
    public void removeCurrency(int amount) {
        if (this.currency >= amount) {
            this.currency -= amount;
        }
    }

    // NPC attack method (for attacking player)
    public void attack(player player) {
        int attackPower = 10; // Default attack power, can be enhanced based on NPC type
        player.takeDamage(attackPower);
        System.out.println(name + " attacks you for " + attackPower + " damage!");
    }

    // NPC's response after being attacked
    public void reactToAttack(player player) {
        if (this.health <= 0) {
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " says: 'You will regret this!'");
        }
    }
}
