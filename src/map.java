import java.util.*;
public class map {
    private String trailType;
    private String startLocation;
    private String endLocation = "Independence Rock"; // or somewhere between there and ft. laramie
    private int totalDistance;
    private ArrayList<landmark> landmarks;
    private int currentLandmarkIndex;

    public map () {

    }

    public void setTrail(String trailType, String startLocation) {
        this.trailType = trailType;
        this.startLocation = startLocation;
        currentLandmarkIndex = 0;

        if (trailType.equals("Oregon")) {
            totalDistance = 830;
            initializeOregonTrail();
        } else if (trailType.equals("California")) {
            totalDistance = 830;
            initializeCaliforniaTrail();
        } else if (trailType.equals("Mormon")) {
            totalDistance = 965;
            initializeMormonTrail();
        }
    }

    public void startingPoint() {
        System.out.println("You are starting your journey at " + startLocation + ".");
    }

    public void endingPoint() {
        System.out.println("Your destination is " + endLocation + ".");
    }

    private void initializeOregonTrail() {
        landmarks = new ArrayList<>();

        landmarks.add(new landmark("Independence, Missouri", 0, "Starting point for many westward journeys.",
                "This busy frontier town serves as the main outfitting point for wagon trains. Shops are selling everything from wagons and oxen to food supplies at premium prices.",
                false, true));

        landmarks.add(new landmark("Kansas River Crossing", 83, "A challenging river that must be forded, ferried, or crossed by raft.",
                "This river is approximately 200 feet wide and up to 20 feet deep in places. Crossing it poses your first major challenge of the journey.",
                true, false));

        landmarks.add(new landmark("Fort Kearny", 304, "Military post established to protect travelers on the Oregon Trail.",
                "Established in 1848, this fort provides protection, supplies, mail service, and repairs for emigrants. It's your first chance to resupply since Independence.",
                false, true));

        landmarks.add(new landmark("Chimney Rock", 554, "Distinctive rock formation that served as an important landmark.",
                "This unusual natural formation rises nearly 300 feet and was mentioned in many pioneer journals. It meant travelers were making good progress.",
                false, false));

        landmarks.add(new landmark("Fort Laramie", 640, "Major stopping point for pioneers to rest and resupply.",
                "This former fur trading post became a military fort in 1849. It offers protection, supplies, and much-needed rest for weary travelers.",
                false, true));

        landmarks.add(new landmark("Independence Rock", 830, "Travelers tried to reach here by July 4th (Independence Day). This is your final destination.",
                "This large granite rock contains thousands of pioneer names carved into its surface. Reaching it means you have successfully completed your journey along the Platte River portion of the Oregon Trail.",
                false, true));
    }

    private void initializeCaliforniaTrail() {
        landmarks = new ArrayList<>();

        landmarks.add(new landmark("Independence, Missouri", 0, "Starting point for many westward journeys.",
                "This busy frontier town serves as the main outfitting point for wagon trains. Shops are selling everything from wagons and oxen to food supplies at premium prices.",
                false, true));

        landmarks.add(new landmark("Fort Kearny", 304, "Military post on the Platte River.",
                "This fort provides protection and supplies for travelers, as well as mail service to send letters back east.",
                false, true));

        landmarks.add(new landmark("Chimney Rock", 554, "Distinctive rock formation visible for miles.",
                "Rising nearly 300 feet above the North Platte River valley, this landmark let pioneers know they were on the right path.",
                false, false));

        landmarks.add(new landmark("Fort Laramie", 640, "Trading post and military fort.",
                "This fort provides a chance to rest, resupply, and repair equipment before the more difficult terrain ahead.",
                false, true));

        landmarks.add(new landmark("Independence Rock", 830, "Travelers tried to reach here by July 4th. This is your final destination.",
                "This large granite rock contains thousands of pioneer names carved into its surface. Reaching Independence Rock means you have successfully completed your journey along the Platte River portion of the California Trail.",
                false, true));
    }

    private void initializeMormonTrail() {
        landmarks = new ArrayList<>();

        landmarks.add(new landmark("Nauvoo, Illinois", 0, "Starting point for Mormon pioneers fleeing religious persecution.",
                "Once a thriving city of 12,000 Mormons, Nauvoo has been largely abandoned after persecution and the murder of church leader Joseph Smith in 1844.",
                false, false));

        landmarks.add(new landmark("Sugar Creek", 7, "First camp across the Mississippi, where Brigham Young organized the exodus.",
                "This temporary settlement became the gathering place for Mormons after crossing the frozen Mississippi River in February 1846.",
                false, false));

        landmarks.add(new landmark("Garden Grove", 128, "First permanent settlement established to help future travelers.",
                "Mormon pioneers created this settlement to plant crops that would help later emigrants following the same route.",
                false, false));

        landmarks.add(new landmark("Mount Pisgah", 153, "Second way station with farms to supply later pioneers.",
                "Like Garden Grove, this settlement was established to grow food for future Mormon emigrants on their journey west.",
                false, false));

        landmarks.add(new landmark("Council Bluffs", 265, "Winter quarters where many Mormons stayed during 1846-1847.",
                "This settlement on the east bank of the Missouri River became a major staging area for the Mormon migration west.",
                true, false));

        landmarks.add(new landmark("Winter Quarters", 266, "Settlement in present-day Omaha where many died during the harsh winter.",
                "Over 700 temporary log cabins housed Mormons during the difficult winter of 1846-47. Disease claimed many lives here.",
                false, false));

        landmarks.add(new landmark("Fort Kearny", 493, "Military post where trails converged.",
                "Here the Mormon Trail joins the Oregon Trail. The fort provides protection and supplies for travelers.",
                false, true));

        landmarks.add(new landmark("Chimney Rock", 718, "Notable landmark visible for miles.",
                "This distinctive rock formation was a welcome sight indicating good progress on the journey west.",
                false, false));

        landmarks.add(new landmark("Fort Laramie", 788, "Trading post and military fort.",
                "This fort provides a chance to rest, resupply, and repair equipment before the more difficult terrain ahead.",
                false, true));

        landmarks.add(new landmark("Independence Rock", 965, "Large granite outcropping where travelers carved their names. This is your final destination.",
                "Many Mormon pioneers added their names to thousands of others on this 'register of the desert.' Reaching Independence Rock means you have successfully completed your journey along the Platte River portion of the Mormon Trail.",
                false, true));
    }

    public String getCurrentLocation() {
        return getCurrentLandmark();
    }

    public String getCurrentLandmark() {
        if (currentLandmarkIndex < landmarks.size()) {
            return landmarks.get(currentLandmarkIndex).getName();
        }
        return "Unknown location";
    }

    public int getRemainingDistance() {
        if (currentLandmarkIndex < landmarks.size()) {
            return totalDistance - landmarks.get(currentLandmarkIndex).getDistance();
        }
        return 0;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void updateLocation(int distanceTraveled) {
        updateLocationToDistance(distanceTraveled);
    }

    public String getTrailType() {
        return trailType;
    }

    public boolean checkLandmark(int distanceTraveled) {
        int previousIndex = currentLandmarkIndex;
        updateLocationToDistance(distanceTraveled);
        return currentLandmarkIndex > previousIndex;
    }

    public String getLandmarkAtIndex(int index) {
        if (index >= 0 && index < landmarks.size()) {
            return landmarks.get(index).getName();
        }
        return null;
    }

    public int getLandmarkDistanceAtIndex(int index) {
        if (index >= 0 && index < landmarks.size()) {
            return landmarks.get(index).getDistance();
        }
        return 0;
    }

    public int getLandmarkArraySize() {
        return landmarks.size();
    }

    public void updateLocationToDistance(int distanceTraveled) {
        int oldIndex = currentLandmarkIndex;

        for (int i = 0; i < landmarks.size(); i++) {
            if (landmarks.get(i).getDistance() <= distanceTraveled && (i == landmarks.size()-1 || landmarks.get(i+1).getDistance() > distanceTraveled)) {
                currentLandmarkIndex = i;
                break;
            }
        }

        if (oldIndex < currentLandmarkIndex) {
            System.out.println("You have reached " + landmarks.get(currentLandmarkIndex).getName());
        }
    }

    public void displayLandmarkInformation() {
        if (currentLandmarkIndex < landmarks.size()) {
            landmark current = landmarks.get(currentLandmarkIndex);
            System.out.println("\n=====================================================");
            System.out.println("                  " + current.getName());
            System.out.println("=====================================================");
            System.out.println("\n" + current.getDescription());

            System.out.println("\nHistorical Information:");
            System.out.println(current.getHistoricalInfo());

            if (current.hasRiver()) {
                System.out.println("\nThere is a river here that you'll need to cross.");
            }
        }
    }

}
