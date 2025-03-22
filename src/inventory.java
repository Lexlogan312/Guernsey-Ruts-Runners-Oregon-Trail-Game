public class inventory {

    int maxInventorySpace = 30;
    int inventory;
    item[] items = new item[maxInventorySpace];
    item itemInUse;
    food foodInUse;

    public inventory() {
        this.inventory = 0;
    }

    //Not correct, need fixed
    public void addItem(item item) {
        if(inventory < maxInventorySpace){
            for(int i = 0; i < inventory; i++){
                if(items[i] == null || items[i].getName().equals(item.getName())){
                    if(items[i].getQuantity() < items[i].getMaximumQuantity()) {
                        items[i] = item;
                        inventory++;
                    }
                    else{
                        if(items[i+1] == null){
                            items[i+1] = item;
                            inventory++;
                        }
                        else{
                            addItem(item);
                        }
                    }
                }
            }
        }
        else{
            System.out.println("Your inventory is full\nDrop an Item if you want to pick this up");
        }
    }

    public void removeItem(item item) {
        for(int i = 0; i < inventory; i++){
            if(items[i] == item){
                items[i] = null;
                inventory--;
            }
        }
    }

    public void useItem(item item) {
        for(int i = 0; i < inventory; i++){
            if(items[i].isPerishable()) {
                if (!items[i].isExpired()) {
                    if (items[i] == item) {
                        itemInUse = item;
                        items[i].setQuantity(items[i].getQuantity() - 1);
                    }
                } else {
                    removeItem(item);
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

    public item getItemInUse() {
        return itemInUse;
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
}
