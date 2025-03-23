public class inventory{

    int maxInventorySpace = 30;
    int inventory;
    item[] items = new item[maxInventorySpace];
    item itemInUse;
    food foodInUse;

    public inventory() {
        this.inventory = 0;
    }

    //Not correct, need fixed
    public void addItem(item item, int quantity) {
        if (inventory < maxInventorySpace) {
            boolean itemAdded = false;

            // Try to add to existing item stack or find an empty spot
            for (int i = 0; i < inventory; i++) {
                // Check if the item already exists or an empty spot is found
                if (items[i] == null || items[i].getName().equals(item.getName())) {
                    // Check if we can increase quantity of the current item
                    if (items[i].getQuantity() + quantity <= items[i].getMaximumQuantity()) {
                        items[i].setQuantity(items[i].getQuantity() + quantity);
                        itemAdded = true;
                        break;
                    }
                }
            }

            // If item was not added, add it to the next available slot
            if (!itemAdded) {
                // Ensure there's room before trying to add a new item
                if (inventory < maxInventorySpace) {
                    for (int i = 0; i < maxInventorySpace; i++) {
                        // Find the next empty slot
                        if (items[i] == null) {
                            items[i] = item;  // Add item to the empty slot
                            inventory++;
                            break;
                        }
                    }
                } else {
                    System.out.println("No more space in inventory.");
                }
            }
        } else {
            System.out.println("Your inventory is full. Drop an item if you want to pick this up.");
        }
    }

    public void removeItem(item item, int quantity) {
        for(int i = 0; i < inventory; i++){
            if(items[i] == item){
                if(items[i].getQuantity() > quantity){
                    items[i].setQuantity(items[i].getQuantity() - quantity);
                }
                else{
                    items[i] = null;
                    inventory--;
                }
            }
        }
    }

    public void useItem(item item, int quantity) {
        for(int i = 0; i < inventory; i++){
            if(items[i].isPerishable()) {
                if (!items[i].isExpired()) {
                    if (items[i] == item) {
                        itemInUse = item;
                        items[i].setQuantity(items[i].getQuantity() - 1);
                    }
                } else {
                    removeItem(item, quantity);
                }
            }
            //Should subtract one ammo after gun shot
            //if(items[i].isUsable()){
              //  items[i].getName(items[i].setAmmo((items[i].getAmmo())));
            //}
        }
    }

    public void displayInventory() {
        for(int i = 0; i < inventory; i++){
            if(items[i] != null){
                System.out.print("Inventory: " + items[i] + " ");
            }
        }
    }

    public void sortInventory() {
        for(int i = 0; i < inventory; i++){
            if(items[i] != null){
                for(int j = i; j < inventory; j++){
                    if(items[j] != null){
                        if(items[i].getName().compareTo(items[j].getName()) > 0){
                            item temp = items[i];
                            items[i] = items[j];
                            items[j] = temp;
                        }
                    }
                }
            }
        }
    }

    public void selectItem(item item) {
        itemInUse = item;
    }

    public item getItemInUse(String itemName) {
        for(int i = 0; i < inventory; i++){
            if(items[i] != null){
                if(items[i].getName().equals(itemName)){
                    return items[i];
                }
            }
        }
        return null;
    }

    public void displayWeapons() {
        for(int i = 0; i < inventory; i++){
            if(items[i] != null){
                if(items[i].isWeapon()){
                    System.out.print(items[i] + " ");
                }
            }
        }
    }

    public void displayConsumables() {
        for(int i = 0; i < inventory; i++){
            if(items[i] != null){
                if(items[i].isConsumable()){
                    System.out.print(items[i] + " ");
                }
            }
        }
    }

    public void displayWagonParts() {
        for(int i = 0; i < inventory; i++){
            if(items[i] != null){
                if(items[i].isWagonPart()){
                    System.out.print(items[i] + " ");
                }
            }
        }
    }

    public int getFoodAmount() {
        int foodAmount = 0;
        for(int i = 0; i < inventory; i++){
            if(items[i] != null){
                if(items[i].isConsumable()){
                    foodAmount += items[i].getQuantity();
                }
            }
        }
        return foodAmount;
    }

    public int getTotalFoodWeight(){
        int totalFoodWeight = 0;
        for(int i = 0; i < inventory; i++){
            if(items[i] != null){
                if(items[i].isConsumable()){
                    totalFoodWeight += items[i].getWeight() * items[i].getQuantity();
                }
            }
        }
        return totalFoodWeight;
    }

    public void consumeFood(int amount) {
        for(int i = 0; i < inventory; i++){
            if(items[i] != null){
                if(items[i].isConsumable()){
                    if(items[i].getQuantity() > amount){
                        items[i].setQuantity(items[i].getQuantity() - amount);
                    }
                    else{
                        items[i] = null;
                        inventory--;
                    }
                }
            }
        }
    }

    public boolean hasItem(String itemName) {
        for(int i = 0; i < inventory; i++){
            if(items[i] != null){
                if(items[i].getName().equals(itemName)){
                    return true;
                }
            }
        }
        return false;
    }

    public int getItemQuantity(item item){
        for(int i = 0; i < inventory; i++){
            if(items[i] != null){
                if(items[i].getName().equals(item.getName())){
                    return items[i].getQuantity();
                }
            }
        }
        return 0;
    }
}
