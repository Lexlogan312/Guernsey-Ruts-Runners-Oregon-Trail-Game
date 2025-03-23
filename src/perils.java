import java.util.Random;

public class perils {
    private player player;  // The player involved in the peril events
    private Random random;  // Random object to simulate chance events

    // Constructor to initialize the Perils class with the player
    public perils(player player) {
        this.player = player;
        this.random = new Random();
    }

    // Method to simulate an accident (Humans, Animals, Wagon)
    public void accident() {
        int chance = random.nextInt(100);
        if (chance < 30) {  // 30% chance of an accident
            System.out.println("An accident occurred!");
            // Example: Randomly choose what is damaged (Wagon, Ox, or Human)
            int event = random.nextInt(3);
            switch (event) {
                case 0:
                    System.out.println("The wagon was damaged! Repairing costs 20 dollars.");
                    player.decreaseCurrency(20);
                    break;
                case 1:
                    System.out.println("One of your oxen was injured! It needs rest.");
                    player.decreaseOxHealth(10);  // Decreases ox health
                    break;
                case 2:
                    System.out.println("You were injured! Lose 5 health.");
                    player.takeDamage(5);  // Decrease player health
                    break;
            }
        }
    }

    // Method to simulate illness (Humans and Animals)
    public void illness() {
        int chance = random.nextInt(100);
        if (chance < 25) {  // 25% chance of illness
            System.out.println("An illness has struck your group!");
            int event = random.nextInt(2);
            switch (event) {
                case 0:
                    System.out.println("A human member is sick! Lose 10 health.");
                    player.takeDamage(10);  // Decrease player health
                    break;
                case 1:
                    System.out.println("One of your oxen is sick! It loses 10 health.");
                    player.decreaseOxHealth(10);  // Decrease ox health
                    break;
            }
        }
    }

    // Method to simulate pregnancy (Humans)
    public void pregnancy() {
        int chance = random.nextInt(100);
        if (chance < 15) {  // 15% chance of pregnancy
            System.out.println("A human member is pregnant! They will need rest.");
            player.takeDamage(10);  // Decreases the human's health due to pregnancy
            System.out.println("The human member's health is temporarily reduced by 10.");
        }
    }

    // Method to simulate river crossing
    public void riverCrossing() {
        int chance = random.nextInt(100);
        if (chance < 50) {  // 50% chance of a difficult river crossing
            System.out.println("You are crossing a river...");
            if (random.nextInt(100) < 50) {
                System.out.println("The wagon got stuck in the river!");
                player.decreaseCurrency(10);  // Costs money to repair the wagon
                System.out.println("Repairing the wagon costs 10 dollars.");
            } else {
                System.out.println("The crossing was successful!");
            }
        } else {
            System.out.println("The river crossing was calm, no problems.");
        }
    }

    // Method to simulate supply issues (Lost, Stolen, Rancid)
    public void supplies() {
        int chance = random.nextInt(100);
        if (chance < 20) {  // 20% chance of supply issue
            System.out.println("There was a problem with your supplies!");
            int event = random.nextInt(3);
            switch (event) {
                case 0:
                    // Select the specific food item you want to decrease
                    food foodToSteal = player.getFood("Hay");  // Assuming player has "Hay" in their inventory
                    if (foodToSteal != null) {
                        System.out.println("Some of your supplies were stolen! You lost 10 food.");
                        player.decreaseFood(foodToSteal, 10);  // Decrease the specific food item
                    } else {
                        System.out.println("You don't have any Hay to lose!");
                    }
                    break;
                case 1:
                    // Select the specific food item you want to decrease
                    food foodToRancid = player.getFood("Grain");  // Assuming player has "Grain" in their inventory
                    if (foodToRancid != null) {
                        System.out.println("Your food has gone rancid! You lost 5 food.");
                        player.decreaseFood(foodToRancid, 5);  // Decrease the specific food item
                    } else {
                        System.out.println("You don't have any Grain to lose!");
                    }
                    break;
                case 2:
                    System.out.println("You lost some supplies! You lost 5 dollars.");
                    player.decreaseCurrency(5);  // Lose money
                    break;
            }
        }
    }


    // Method to simulate weather events
    public void weather() {
        int chance = random.nextInt(100);
        if (chance < 30) {  // 30% chance of bad weather
            System.out.println("A weather event is happening!");
            int event = random.nextInt(2);
            switch (event) {
                case 0:
                    System.out.println("A storm has hit! You lose 10 food to spoilage.");
                    player.decreaseFood(10);  // Food spoilage
                    break;
                case 1:
                    System.out.println("Extreme heat has made your oxen lose health!");
                    player.decreaseOxHealth(15);  // Oxen health decreases
                    break;
            }
        }
    }
}
