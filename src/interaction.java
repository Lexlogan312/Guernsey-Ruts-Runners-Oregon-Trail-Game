public class interaction {

    private player player;

    public interaction(player player) {
        this.player = player;
    }

    // Buy an item from a merchant
    public void buy(item item, int quantity, int pricePerItem) {
        int totalCost = pricePerItem * quantity;

        if (player.getCurrency() >= totalCost) {
            player.decreaseCurrency(totalCost);
            player.getInventory().addItem(item, quantity);
            System.out.println("You bought " + quantity + " " + item.getName() + "(s).");
        } else {
            System.out.println("You don't have enough currency to buy that.");
        }
    }

    // Sell an item to a merchant
    public void sell(item item, int quantity, int pricePerItem) {
        if (player.getInventory().hasItem(item.getName()) && player.getInventory().getItemQuantity(item) >= quantity) {
            int totalEarnings = pricePerItem * quantity;
            player.increaseCurrency(totalEarnings);
            player.getInventory().removeItem(item, quantity);
            System.out.println("You sold " + quantity + " " + item.getName() + "(s) for " + totalEarnings + " currency.");
        } else {
            System.out.println("You don't have enough " + item.getName() + " to sell.");
        }
    }

    // Trade items with another NPC
    public void trade(item playerItem, item npcItem, int playerItemQuantity, int npcItemQuantity) {
        // Ensure player has enough of the item
        if (player.getInventory().getItemQuantity(playerItem) >= playerItemQuantity) {
            // Remove player's item
            player.getInventory().removeItem(playerItem, playerItemQuantity);
            // Add NPC item to player's inventory
            player.getInventory().addItem(npcItem, npcItemQuantity);

            System.out.println("You traded " + playerItemQuantity + " " + playerItem.getName() + "(s) for " +
                    npcItemQuantity + " " + npcItem.getName() + "(s).");
        } else {
            System.out.println("You don't have enough " + playerItem.getName() + " to trade.");
        }
    }

    // Steal an item from an NPC
    public void steal(item item) {
        // Check success rate based on player attributes (e.g., a random chance)
        int successChance = 50; // Default success chance (can be increased based on player attributes)
        if (Math.random() * 100 < successChance) {
            if (player.getInventory().hasItem(item.getName())) {
                player.getInventory().removeItem(item, 1);
                System.out.println("You successfully stole a " + item.getName() + ".");
            } else {
                System.out.println("Stealing failed. No item found.");
            }
        } else {
            System.out.println("You failed to steal the item.");
        }
    }

    // Attack an NPC
    public void attack(NPC npc) {
        if (npc.getHealth() > 0) {
            int attackPower = player.getWeaponPower(); // Assuming player has weapons
            npc.decreaseHealth(attackPower);
            System.out.println("You attacked " + npc.getName() + " for " + attackPower + " damage.");
            if (npc.getHealth() <= 0) {
                System.out.println(npc.getName() + " is defeated.");
            }
        } else {
            System.out.println(npc.getName() + " has already been defeated.");
        }
    }

    // Talk to an NPC (dialogue or information exchange)
    public void talk(NPC npc) {
        // Example of random dialogue or benefits
        String[] dialogues = {
                "Hello there, traveler! Do you need supplies?",
                "The land ahead is dangerous, be careful.",
                "I'm willing to trade for some of your goods."
        };
        int dialogueIndex = (int) (Math.random() * dialogues.length);
        System.out.println(npc.getName() + " says: " + dialogues[dialogueIndex]);

        // Example of a trade option when talking
        if (Math.random() * 100 < 50) {
            System.out.println("The NPC offers you a trade.");
        } else {
            System.out.println("The NPC does not offer anything this time.");
        }
    }
}

