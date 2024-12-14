public class AssignmentTwo {
    public static void main(String[] args) {
        Employee employee1 = new Employee("E12345", "John Doe", 30, "Male", "123-456-7890", "Ride Operator", 35000);
        Employee employee2 = new Employee("E67890", "Jane Smith", 28, "Female", "234-567-8901", "Park Attendant", 30000);

        Visitor visitor1 = new Visitor("V123", "Alice", 25, "Female", "987-654-3210", "M456", true);
        Visitor visitor2 = new Visitor("V789", "Bob", 35, "Male", "345-678-9012", "M789", false);

        Ride ride1 = new Ride("Roller Coaster", "Thrill", employee1, 100);
        Ride ride2 = new Ride("Water Slide", "Water", employee2, 200);
        Ride ride3 = new Ride("Ferris Wheel", "Family", employee1, 300);

        System.out.println("Employee 1 Details:");
        employee1.printDetails();
        System.out.println("\nEmployee 2 Details:");
        employee2.printDetails();

        // Print details of Visitors
        System.out.println("\nVisitor 1 Details:");
        visitor1.printDetails();
        System.out.println("\nVisitor 2 Details:");
        visitor2.printDetails();

        // Print details of Rides
        System.out.println("\nRide 1 Details:");
        ride1.printDetails();
        System.out.println("\nRide 2 Details:");
        ride2.printDetails();
        System.out.println("\nRide 3 Details:");
        ride3.printDetails();

        AssignmentTwo assignmentTwo = new AssignmentTwo();
        assignmentTwo.partThree();

        assignmentTwo.partFourA();
        assignmentTwo.partFourB();

        assignmentTwo.partFive();
        assignmentTwo.partSix();
    }

    public void partThree(){
        Employee employee1 = new Employee("E12345", "John Doe", 30, "Male", "123-456-7890", "Ride Operator", 35000);
        Employee employee2 = new Employee("E67890", "Jane Smith", 28, "Female", "234-567-8901", "Park Attendant", 30000);

        Visitor visitor1 = new Visitor("V123", "Alice", 25, "Female", "987-654-3210", "M456", true);
        Visitor visitor2 = new Visitor("V789","Bob", 35, "Male", "345-678-9012",  "M789", false);
        Visitor visitor3 = new Visitor("V111","Charlie", 22, "Male", "564-789-0123",  "M101", true);
        Visitor visitor4 = new Visitor("V222","Diana", 30, "Female", "876-543-2109",  "M102", true);
        Visitor visitor5 = new Visitor("V333","Eva", 26, "Female", "654-321-0987",  "M103", false);

        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", employee1, 100);

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        System.out.println();
        rollerCoaster.printQueue();

        System.out.println();
        rollerCoaster.removeVisitorFromQueue(visitor2);

        System.out.println();
        rollerCoaster.printQueue();
    }
    public void partFourA(){
        Employee employee1 = new Employee("E12345", "John Doe", 30, "Male", "123-456-7890", "Ride Operator", 35000);
        Employee employee2 = new Employee("E67890", "Jane Smith", 28, "Female", "234-567-8901", "Park Attendant", 30000);

        Visitor visitor1 = new Visitor("V123", "Alice", 25, "Female", "987-654-3210", "M456", true);
        Visitor visitor2 = new Visitor("V789","Bob", 35, "Male", "345-678-9012",  "M789", false);
        Visitor visitor3 = new Visitor("V111","Charlie", 22, "Male", "564-789-0123",  "M101", true);
        Visitor visitor4 = new Visitor("V222","Diana", 30, "Female", "876-543-2109",  "M102", true);
        Visitor visitor5 = new Visitor("V333","Eva", 26, "Female", "654-321-0987",  "M103", false);

        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", employee1, 100);

        System.out.println("\nPartFourA");
        if (!rollerCoaster.checkVisitorFromHistory(visitor1)) {
            rollerCoaster.addVisitorToHistory(visitor1);
        }
        if (!rollerCoaster.checkVisitorFromHistory(visitor2)) {
            rollerCoaster.addVisitorToHistory(visitor2);
        }
        if (!rollerCoaster.checkVisitorFromHistory(visitor3)) {
            rollerCoaster.addVisitorToHistory(visitor3);
        }
        if (!rollerCoaster.checkVisitorFromHistory(visitor4)) {
            rollerCoaster.addVisitorToHistory(visitor5);
        }
        if (!rollerCoaster.checkVisitorFromHistory(visitor5)) {
            rollerCoaster.addVisitorToHistory(visitor5);
        }

        System.out.println("\nNumber of visitors who have taken the ride: " + rollerCoaster.numberOfVisitors() + "\n");

        rollerCoaster.printRideHistory();

    }
    public void partFourB(){
        Employee employee1 = new Employee("E12345", "John Doe", 30, "Male", "123-456-7890", "Ride Operator", 35000);
        Employee employee2 = new Employee("E67890", "Jane Smith", 28, "Female", "234-567-8901", "Park Attendant", 30000);

        Visitor visitor1 = new Visitor("V123", "Alice", 25, "Female", "987-654-3210", "M456", true);
        Visitor visitor2 = new Visitor("V789","Bob", 35, "Male", "345-678-9012",  "M789", false);
        Visitor visitor3 = new Visitor("V111","Charlie", 22, "Male", "564-789-0123",  "M101", true);
        Visitor visitor4 = new Visitor("V222","Diana", 30, "Female", "876-543-2109",  "M102", true);
        Visitor visitor5 = new Visitor("V333","Eva", 26, "Female", "654-321-0987",  "M103", false);

        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", employee1, 100);

        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);

        System.out.println("\nBefore Sorting:");
        rollerCoaster.printRideHistory();

        rollerCoaster.sortRideHistory(new VisitorComparator());

        System.out.println("\nAfter Sorting:");
        rollerCoaster.printRideHistory();
    }
    public void partFive(){
        Employee employee1 = new Employee("E12345", "John Doe", 30, "Male", "123-456-7890", "Ride Operator", 35000);

        Visitor visitor1 = new Visitor("V123","Alice", 25, "Female", "987-654-3210",  "M456", true);
        Visitor visitor2 = new Visitor("V789","Bob", 35, "Male", "345-678-9012",  "M789", false);
        Visitor visitor3 = new Visitor("V111","Charlie", 22, "Male", "564-789-0123",  "M101", true);
        Visitor visitor4 = new Visitor("V222","Diana", 30, "Female", "876-543-2109",  "M102", true);
        Visitor visitor5 = new Visitor("V333","Eva", 26, "Female", "654-321-0987",  "M103", false);
        Visitor visitor6 = new Visitor("V444","Frank", 28, "Male", "234-567-8901",  "M104", true);
        Visitor visitor7 = new Visitor("V555","Grace", 40, "Female", "123-456-7891",  "M105", true);
        Visitor visitor8 = new Visitor("V666","Hank", 27, "Male", "987-654-3211",  "M106", false);
        Visitor visitor9 = new Visitor("V777","Ivy", 33, "Female", "876-543-2111",  "M107", true);
        Visitor visitor10 = new Visitor("V888","Jack", 29, "Male", "654-321-0998",  "M108", true);

        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", employee1, 3);

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        rollerCoaster.addVisitorToQueue(visitor6);
        rollerCoaster.addVisitorToQueue(visitor7);
        rollerCoaster.addVisitorToQueue(visitor8);
        rollerCoaster.addVisitorToQueue(visitor9);
        rollerCoaster.addVisitorToQueue(visitor10);

        System.out.println("\nBefore Running Cycle:");
        rollerCoaster.printQueue();

        System.out.println();
        rollerCoaster.runOneCycle();

        System.out.println("\nAfter Running One Cycle:");
        rollerCoaster.printQueue();

        System.out.println();
        rollerCoaster.printRideHistory();
    }
    public void partSix(){
        Employee employee1 = new Employee("E12345", "John Doe", 30, "Male", "123-456-7890", "Ride Operator", 35000);

        Visitor visitor1 = new Visitor("V123","Alice", 25, "Female", "987-654-3210",  "M456", true);
        Visitor visitor2 = new Visitor("V789","Bob", 35, "Male", "345-678-9012",  "M789", false);
        Visitor visitor3 = new Visitor("V111","Charlie", 22, "Male", "564-789-0123",  "M101", true);
        Visitor visitor4 = new Visitor("V222","Diana", 30, "Female", "876-543-2109",  "M102", true);
        Visitor visitor5 = new Visitor("V333","Eva", 26, "Female", "654-321-0987",  "M103", false);
        Visitor visitor6 = new Visitor("V444","Frank", 28, "Male", "234-567-8901",  "M104", true);
        Visitor visitor7 = new Visitor("V555","Grace", 40, "Female", "123-456-7891",  "M105", true);
        Visitor visitor8 = new Visitor("V666","Hank", 27, "Male", "987-654-3211",  "M106", false);
        Visitor visitor9 = new Visitor("V777","Ivy", 33, "Female", "876-543-2111",  "M107", true);
        Visitor visitor10 = new Visitor("V888","Jack", 29, "Male", "654-321-0998",  "M108", true);

        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", employee1, 3);

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        rollerCoaster.addVisitorToQueue(visitor6);
        rollerCoaster.addVisitorToQueue(visitor7);
        rollerCoaster.addVisitorToQueue(visitor8);
        rollerCoaster.addVisitorToQueue(visitor9);
        rollerCoaster.addVisitorToQueue(visitor10);

        rollerCoaster.runOneCycle();
        rollerCoaster.runOneCycle();
        rollerCoaster.exportRideHistory("ride_history.csv");
    }
    public void partSeven(){
    }
}
