public class health {
    int maxHealth = 100;
    int currentHealth;

    public health(int startingHealth){
        maxHealth = startingHealth;
        currentHealth = startingHealth;
    }

    public void heal(int addHealth){
        currentHealth += addHealth;
        if(currentHealth > maxHealth) currentHealth = maxHealth;
    }

    public void takeDamage(int damage){
        currentHealth -= damage;
        if(currentHealth <= 0) currentHealth = 0;
    }

    public boolean isAlive(){
        return currentHealth > 0;
    }

    public int getCurrentHealth(){
        return currentHealth;
    }

    public int getMaxHeath(){
        return maxHealth;
    }
}
