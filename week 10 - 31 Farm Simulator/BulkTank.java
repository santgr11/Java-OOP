
package farmsimulator;

// @author SantGr
 
public class BulkTank {
    private final double capacity;
    private double volume;
    
    public BulkTank() {
        this(2000);
    }
    
    public BulkTank(double capacity) {
        this.capacity = capacity;
    }
    
    public double getCapacity() {
        return this.capacity;
    }
    
    public double getVolume() {
        return this.volume;
    }
    
    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }
    
    public void addToTank(double amount) {
        if(amount > this.howMuchFreeSpace()) {
            this.volume = this.capacity;
        } else {
            this.volume += amount;
        }
    }
    
    public double getFromTank(double amount) {
        if(amount > this.volume) {
            double taken = this.volume;
            this.volume = 0;
            return taken;
        }
        
        this.volume -= amount;
        return amount;
    }
    
    @Override
    public String toString() {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
    
    

}
