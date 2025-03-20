public class food extends item {
    public food(String name, int weight, int value) {
        super(name, weight, value);
    }

    public void eat() {
        System.out.println("You eat the " + this.getName() + ".");
    }
}
