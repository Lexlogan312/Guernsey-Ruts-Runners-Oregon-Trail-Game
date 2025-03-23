import java.util.Random;

public class hunting extends randomEvent{

        private player player;
        private Random random;

        public hunting(player player) {
            this.player = player;
            this.random = new Random();
        }

        public void hunt() {
            if (!player.getInventory().hasItem("weapon")) {
                System.out.println("You have no weapon to hunt with.");
                return;
            }

            item weapon = player.getInventory().getItemInUse("weapon");
            item ammo = player.getInventory().getItemInUse("ammo");

            if (ammo == null || player.getInventory().getItemQuantity(ammo) == 0) {
                System.out.println("You have no ammunition left!");
                return;
            }

            int ammoUsed = 1;  // Adjust as needed for different weapon types
            player.getInventory().removeItem(ammo, ammoUsed);

            int successChance = 50 + (weapon.getName().equalsIgnoreCase("rifle") ? 20 : 0); // Rifle increases chance
            boolean successfulHunt = random.nextInt(100) < successChance;

            if (successfulHunt) {
                int foodGained = random.nextInt(10) + 5; // Random amount of food
                item food = new item("food");
                player.getInventory().addItem(food, foodGained);
                System.out.println("You successfully hunted and gained " + foodGained + " lbs of food!");
            } else {
                System.out.println("You missed! No food gained.");
            }
        }
}
