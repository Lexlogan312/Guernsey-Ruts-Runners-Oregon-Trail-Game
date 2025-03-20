public class player {
    private String name;
    private health health;
    private String gender;
    private double lastDamage = 0;
    private double currentDamage = 0;
    private health playerHealth;

    public player() {
        playerHealth = new health(100);
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
}
