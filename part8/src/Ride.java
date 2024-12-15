import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator; // The ride operator (Employee)
    private Queue<Visitor> visitorQueue = new LinkedList<>(); // Queue for visitors waiting for the ride
    private LinkedList<Visitor> rideHistory = new LinkedList<>(); // List to store visitors who have taken the ride
    private int maxRider; // Maximum number of visitors the ride can take per cycle
    private int numOfCycles = 0; // Number of times the ride has been run

    // Default constructor
    public Ride() {}

    // Parameterized constructor to initialize ride details and operator
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // Getter and setter methods for ride properties
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

    // Method to print details of the ride
    public void printDetails() {
        System.out.println("Ride Name: " + rideName + ", Ride Type: " + rideType);
        System.out.print("Operator: ");
        operator.printDetails(); // Print operator's details
    }

    // Method to add a visitor to the queue
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            visitorQueue.add(visitor); // Add visitor to the queue
            System.out.println(visitor.getName() + " has been added to the queue.");
        } else {
            System.out.println("Failed to add visitor to the queue.");
        }
    }

    // Method to remove a visitor from the queue and return the visitor
    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor visitor = visitorQueue.poll();  // Poll returns and removes the first element
        System.out.println(visitor.getName() + " has been removed from the queue.");
        return visitor;
    }

    // Method to print the details of all visitors in the queue
    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Visitors currently in the queue for " + rideName + ":");
            for (Visitor visitor : visitorQueue) {
                visitor.printDetails(); // Print each visitor's details in the queue
            }
        }
    }

    // Method to run one cycle of the ride, moving visitors from the queue to the ride history
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

        // Remove up to maxRider visitors from the queue and add them to the ride history
        while (!visitorQueue.isEmpty() && riders < maxRider) {
            Visitor visitor = removeVisitorFromQueue();
            if (!checkVisitorFromHistory(visitor)) {
                addVisitorToHistory(visitor); // Add visitor to history only if they haven't ridden yet
            }
            riders++;
        }

        numOfCycles++; // Increment the cycle count

        System.out.println("Cycle " + numOfCycles + " completed. " + riders + " visitors have taken the ride.");
    }

    // Method to add a visitor to the ride history
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor); // Add visitor to the ride history collection
            System.out.println(visitor.getName() + " has been added to the ride history.");
        } else {
            System.out.println("Failed to add visitor to the ride history.");
        }
    }

    // Method to check if a visitor is already in the ride history
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor); // Returns true if visitor is in the history
    }

    // Method to return the number of visitors in the ride history
    @Override
    public int numberOfVisitors() {
        return rideHistory.size(); // Return the size of the history list
    }

    // Method to print the details of all visitors in the ride history
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken this ride.");
        } else {
            System.out.println("Ride History for " + rideName + ":");
            Iterator<Visitor> iterator = rideHistory.iterator(); // Use Iterator to traverse the history
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                visitor.printDetails(); // Print each visitor's details in the history
            }
        }
    }

    // Method to sort the ride history based on a given comparator
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator); // Sort history using the comparator
    }

    // Method to export ride history to a CSV file
    public void exportRideHistory(String filename) {
        BufferedWriter writer = null;

        try {
            // Open the file for writing
            writer = new BufferedWriter(new FileWriter(filename));

            writer.write("IDNumber,Name,Age,Gender,Phone\n"); // Write header

            // Write each visitor's details to the file
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
                    writer.close(); // Close the file writer
                }
            } catch (IOException e) {
                System.out.println("Closing the file error: " + e.getMessage());
            }
        }
    }

    // Method to import ride history from a CSV file
    public void importRideHistory(String filename) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename)); // Open the file for reading
            String line;

            reader.readLine(); // Skip the header line

            // Read each line from the file and add the visitor to the ride history
            while ((line = reader.readLine()) != null) {
                String[] visitorData = line.split(","); // Split the line by commas

                if (visitorData.length == 7) {
                    String idCardNumber = visitorData[0];
                    String name = visitorData[1];
                    int age = Integer.parseInt(visitorData[2]);
                    String gender = visitorData[3];
                    String phone = visitorData[4];
                    String membershipId = visitorData[5];
                    boolean hasTicket = Boolean.parseBoolean(visitorData[6]);

                    // Create a new Visitor object and add to the history
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
                    reader.close(); // Close the file reader
                }
            } catch (IOException e) {
                System.out.println("Closing the file error: " + e.getMessage());
            }
        }
    }
}
