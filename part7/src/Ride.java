import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator;
    private Queue<Visitor> visitorQueue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();
    private int maxRider;
    private int numOfCycles = 0;

    public Ride() {}

    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
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
        if (operator == null) {
            System.out.println("The ride cannot be run. No ride operator assigned.");
            return;
        }

        if (visitorQueue.isEmpty()) {
            System.out.println("The queue is empty. No visitors to take on the ride.");
            return;
        }

        System.out.println("Running one cycle of the ride...");
        int riders = 0;

        while (!visitorQueue.isEmpty() && riders < maxRider) {
            Visitor visitor = visitorQueue.peek();
            removeVisitorFromQueue(visitor);
            if (!checkVisitorFromHistory(visitor)) {
                addVisitorToHistory(visitor);
            }
            riders++;
        }

        numOfCycles++;

        System.out.println("Cycle " + numOfCycles + " completed. " + riders + " visitors have taken the ride.");
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " has been added to the ride history.");
        } else {
            System.out.println("Failed to add visitor to the ride history.");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken this ride.");
        } else {
            System.out.println("Ride History for " + rideName + ":");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                visitor.printDetails();
            }
        }
    }

    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
    }

    public void exportRideHistory(String filename) {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(filename));

            writer.write("IDNumber,Name,Age,Gender,Phone\n");

            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getMembershipId() + "," +
                        visitor.getName() + "," +
                        visitor.getAge() + "," +
                        visitor.getGender() + "," +
                        visitor.getPhone() + "," +
                        visitor.getMembershipId() + "," +
                        visitor.isHasTicket() + "\n");
            }

            System.out.println("Ride history exported successfully to " + filename);

        } catch (IOException e) {
            System.out.println("Exporting error: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Closing the file error: " + e.getMessage());
            }
        }
    }

    public void importRideHistory(String filename) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] visitorData = line.split(",");

                if (visitorData.length == 7) {
                    String idCardNumber = visitorData[0];
                    String name = visitorData[1];
                    int age = Integer.parseInt(visitorData[2]);
                    String gender = visitorData[3];
                    String phone = visitorData[4];
                    String membershipId = visitorData[5];
                    boolean hasTicket = Boolean.parseBoolean(visitorData[6]);

                    Visitor visitor = new Visitor(idCardNumber, name, age, gender, phone, membershipId, hasTicket);
                    rideHistory.add(visitor);
                } else {
                    System.out.println("Invalid data format in file for line: " + line);
                }
            }

            System.out.println("Ride history imported successfully from " + filename);

        } catch (IOException e) {
            System.out.println("Reading the ride history file error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numeric: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Closing the file error: " + e.getMessage());
            }
        }
    }
}
