public class map {
    private String trailType;
    private String startLocation;
    private String endLocation = "Independence Rock"; // or somewhere between there and ft. laramie
    private int totalDistance;

    public map () {

    }

    public void setTrail(String trailType, String startLocation) {
        this.trailType = trailType;
        this.startLocation = startLocation;

        if (trailType.equals("Oregon")) {
            totalDistance = 2170;
            initializeOregonTrail();
        } else if (trailType.equals("California")) {
            totalDistance = 1950;
            initializeCaliforniaTrail();
        } else if (trailType.equals("Mormon")) {
            totalDistance = 1300;
            initializeMormonTrail();

        }
    }

    public void startingPoint() {
        System.out.println("You are starting your journey at " + startLocation + ".");
    }

    public void endingPoint() {
        System.out.println("Your destination is " + endLocation + ".");
    }

    public void initializeOregonTrail() {

    }

    public void initializeCaliforniaTrail() {

    }

    public void initializeMormonTrail() {

    }

    public String getCurrentLocation() {
        return "";
    }

    public int getRemainingDistance() {
        return 0;
    }
}
