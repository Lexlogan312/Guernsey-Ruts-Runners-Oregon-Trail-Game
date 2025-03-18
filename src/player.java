public class player {
    double health;
    double lastDamage = 0;
    double currentDamage = 0;
    private boolean Gender; //true if male, false if female

    public player(){
        health = 100;
        this.setGender(Gender);
    }

    public void setGender(boolean select){
        Gender = select;
    }
    public double getDamage(double damageDone){
        lastDamage = currentDamage;
        return currentDamage = damageDone;
    }

    public double getHealth(){
        return health;
    }

    public double getLastDamage() {
        return lastDamage;
    }
}
