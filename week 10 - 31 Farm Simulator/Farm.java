package farmsimulator;

// @author SantGr
import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {

    private final String owner;
    private final Barn barn;
    private final List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }

    public void addCow(Cow cow) {
        this.cows.add(cow);
    }

    public String getOwner() {
        return this.owner;
    }

    public void manageCows() {
        this.barn.takeCareOf(this.cows);
    }

    @Override
    public void liveHour() {
        for (Cow cow : this.cows) {
            cow.liveHour();
        }
    }
    
    @Override
    public String toString() {
        String currCows = "";
        if (this.cows.isEmpty()) {
            currCows += "No cows.";
        } else {
            currCows += "Animals:" + "\n";

            for (Cow cow : this.cows) {
                currCows += "        " + cow + "\n";
            }
        }

        return "Farm owner: " + this.owner + "\n"
                + "Barn bulk tank: " + this.barn + "\n"
                + currCows;
    }

    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }

}
