public class randomEvent {
    private int probability;
    String eventMessage;

    public randomEvent() {
        probability = 0;
        eventMessage = "A random event has occurred!";
    }

    public boolean triggerEvent() {
        return Math.random() * 100 < probability;
    }

    public String getEventMessage() {
        return eventMessage;
    }

    public void setProbability(int probability) {
        if (probability >= 0 && probability <= 100) {
            this.probability = probability;
        }
    }
}