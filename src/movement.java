import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class movement extends player{
   private final Map<String, int[]> directionMap = new HashMap<>();
   private boolean isMoving = true;
   int movementSpeed = 1;
   private final map gameMap;
   private final Scanner scanner;

    public movement(map map) {
        super();
        this.gameMap = map;
        this.scanner = new Scanner(System.in);

        directionMap.put("north", new int[]{0, 1});
        directionMap.put("south", new int[]{0, -1});
        directionMap.put("east", new int[]{1, 0});
        directionMap.put("west", new int[]{-1, 0});
        directionMap.put("northeast", new int[]{1, 1});
        directionMap.put("northwest", new int[]{-1, 1});
        directionMap.put("southeast", new int[]{1, -1});
        directionMap.put("southwest", new int[]{-1, -1});
    }

    public void fatiquedMovement(){
        if(getFatigue() > .05){
            movementSpeed = Math.max(1, (int)(movementSpeed *  this.getFatigue() + .25)); //preventing movement speed from reaching zero
        }
    }

    public void travel(String direction, int distance) {
        if (!directionMap.containsKey(direction.toLowerCase())) {
            System.out.println("Invalid direction: " + direction);
            return;
        }

        System.out.println("Moving " + direction + " for " + distance + " miles. Type 'stop' to halt.");
        isMoving = true;

        for (int i = 0; i < distance && isMoving; i++) {
            updateLocation(direction.toLowerCase());
            try {
                Thread.sleep(1000 / movementSpeed);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                if (command.equalsIgnoreCase("stop")) {
                    System.out.println("Movement stopped.");
                    isMoving = false;
                }
            }
        }
    }

    private void updateLocation(String direction) {
        int[] movement = directionMap.get(direction);
        if (movement != null) {
            gameMap.updatePosition(movement[0], movement[1]);
            System.out.println("New position: " + gameMap.getPlayerX() + ", " + gameMap.getPlayerY());
        }
    }
}
