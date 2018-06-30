
package farmsimulator;

// @author SantGr

import java.util.Collection;

 
public class Barn {
    private final BulkTank tank;
    private MilkingRobot robot;
    
    public Barn(BulkTank tank) {
        this.tank = tank;
        this.robot = null;
    }
    
    public BulkTank getBulkTank() {
        return this.tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.robot = milkingRobot;
        this.robot.setBulkTank(this.tank);
    }
    
    public void takeCareOf(Cow cow) {
        if(this.robot == null) {
            throw new IllegalStateException();
        } else {
            this.robot.milk(cow);
        }
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        for(Cow cow : cows) {
            this.takeCareOf(cow);
        }
    }
    
    @Override
    public String toString() {
        return this.tank.toString();
    }

}
