public class player {
    private String name;
    private String gender;
    private double lastDamage = 0;
    private double currentDamage = 0;
    private health playerHealth;
    private String causeOfDeath;
    private int hunger;
    private int fatigue;
    private boolean isSick;
    private String illness;

    public player() {
        playerHealth = new health(100);
        hunger = 100;
        fatigue = 0;
        isSick = false;
        illness = "None";
    }

    public player(String name, String gender, double money) {
        this();
        this.name = name;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getDamage(double damageDone){
        lastDamage = currentDamage;
        return currentDamage = damageDone;
    }

    public double getHealth() {
        return playerHealth.getCurrentHealth();
    }

    public double getLastDamage() {
        return lastDamage;
    }

    public void takeDamage(int amount, String cause) {
        playerHealth.takeDamage(amount, cause);
        if (playerHealth.getCurrentHealth() <= 0) {
            causeOfDeath = cause;
        }
        lastDamage = amount;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void heal(int amount) {
        playerHealth.heal(amount);
    }

    public boolean isAlive() {
        return playerHealth.isAlive();
    }

    public int getHunger() {
        return hunger;
    }

    public int getFatigue() {
        return fatigue;
    }

    public boolean isSick() {
        return isSick;
    }

    public String getIllness() {
        return illness;
    }
}
