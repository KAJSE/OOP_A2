import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator;
    private Queue<Visitor> visitorQueue = new LinkedList<>();

    public Ride() {}

    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public void printDetails() {
        System.out.println("Ride Name: " + rideName + ", Ride Type: " + rideType);
        System.out.print("Operator: ");
        operator.printDetails();
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            visitorQueue.add(visitor);
            System.out.println(visitor.getName() + " has been added to the queue.");
        } else {
            System.out.println("Failed to add visitor to the queue.");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitorQueue.contains(visitor)) {
            visitorQueue.remove(visitor);
            System.out.println(visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("Visitor is not in the queue.");
        }
    }

    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Visitors currently in the queue for " + rideName + ":");
            for (Visitor visitor : visitorQueue) {
                visitor.printDetails();
            }
        }
    }

    @Override
    public void runOneCycle() {

    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {

    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return 0;
    }

    @Override
    public void printRideHistory() {

    }
}
