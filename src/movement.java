package termProject;

/**
 * Movement Class of the Perils Along the Platte Game
 * Manages player movement across the game map.
 * Handles travel direction, distance, speed, and fatigue impacts.
 *
 * @author : Alex Randall, Chase McCluskey, Painter Drury, and Domenic Pilla
 * @version : 1.0
 * @date : 03/25/2025
 * @file : movement.java
 */
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class movement extends player{
   private final Map<String, int[]> directionMap = new HashMap<>();
   private boolean isMoving = true;
   int movementSpeed = 1;
   private final map gameMap;
   private final Scanner scanner;

    /**
     * Constructor for the movement system.
     * Initializes the directional movement values and required components.
     * 
     * @param map The game map on which movement occurs
     */
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

    /**
     * Adjusts movement speed based on player fatigue.
     * Higher fatigue results in slower movement.
     */
    public void fatiquedMovement(){
        if(getFatigue() > .05){
            movementSpeed = Math.max(1, (int)(movementSpeed *  this.getFatigue() + .25)); //preventing movement speed from reaching zero
        }
    }

    /**
     * Initiates travel in a specified direction for a set distance.
     * Allows the player to stop movement by typing 'stop'.
     * 
     * @param direction The compass direction to travel (north, south, east, west, etc.)
     * @param distance The number of miles to travel
     */
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

    /**
     * Updates the player's position on the map when moving in a direction.
     * 
     * @param direction The direction of movement (north, south, east, west, etc.)
     */
    private void updateLocation(String direction) {
        int[] movement = directionMap.get(direction);
        if (movement != null) {
            gameMap.updatePosition(movement[0], movement[1]);
            System.out.println("New position: " + gameMap.getPlayerX() + ", " + gameMap.getPlayerY());
        }
    }
}
