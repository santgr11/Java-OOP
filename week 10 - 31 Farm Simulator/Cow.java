package farmsimulator;

// @author SantGr
import java.util.Random;

public class Cow implements Milkable, Alive {

    private final String name;
    private int timeAlive;
    private double milkStored;
    private final double capacity;
    private final Random random;
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this(NAMES[new Random().nextInt(NAMES.length)]);
    }

    public Cow(String name) {
        this.name = name;
        this.random = new Random();
        this.capacity = 15 + this.random.nextInt(26);
        
    }

    @Override
    public double milk() {
        double milked = this.milkStored;
        this.milkStored = 0;
        return milked;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCapacity() {
        return this.capacity;
    }

    @Override
    public void liveHour() {
        double toProduce = 0.7 + (2.0 - 0.7) * this.random.nextDouble();
        if(toProduce > this.capacity - this.milkStored) {
            this.milkStored = this.capacity;
        } else {
            this.milkStored += toProduce;
        }
        
        this.timeAlive ++;
    }
    
    public double getAmount() {
        return this.milkStored;
    }
    
    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.milkStored) + "/" + this.capacity;
    }

}
