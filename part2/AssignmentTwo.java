public class AssignmentTwo {
    public static void main(String[] args) {
        Employee employee1 = new Employee("E12345", "John Doe", 30, "Male", "123-456-7890", "Ride Operator", 35000);
        Employee employee2 = new Employee("E67890", "Jane Smith", 28, "Female", "234-567-8901", "Park Attendant", 30000);

        Visitor visitor1 = new Visitor("V123", "Alice", 25, "Female", "987-654-3210", "M456", true);
        Visitor visitor2 = new Visitor("V789", "Bob", 35, "Male", "345-678-9012", "M789", false);

        Ride ride1 = new Ride("Roller Coaster", "Thrill", employee1);
        Ride ride2 = new Ride("Water Slide", "Water", employee2);
        Ride ride3 = new Ride("Ferris Wheel", "Family", employee1);

        System.out.println("Employee 1: " + employee1.getName() + ", Position: " + employee1.getPosition() + ", Salary: " + employee1.getSalary());
        System.out.println("Employee 2: " + employee2.getName() + ", Position: " + employee2.getPosition() + ", Salary: " + employee2.getSalary());

        System.out.println("Visitor 1: " + visitor1.getName() + ", Membership ID: " + visitor1.getMembershipId() + ", Has Ticket: " + visitor1.isHasTicket());
        System.out.println("Visitor 2: " + visitor2.getName() + ", Membership ID: " + visitor2.getMembershipId() + ", Has Ticket: " + visitor2.isHasTicket());

        System.out.println("Ride 1: " + ride1.getRideName() + ", Type: " + ride1.getRideType() + ", Operator: " + ride1.getOperator().getName());
        System.out.println("Ride 2: " + ride2.getRideName() + ", Type: " + ride2.getRideType() + ", Operator: " + ride2.getOperator().getName());
        System.out.println("Ride 3: " + ride3.getRideName() + ", Type: " + ride3.getRideType() + ", Operator: " + ride3.getOperator().getName());
    }

    public void partThree(){
    }
    public void partFourA(){
    }
    public void partFourB(){
    }
    public void partFive(){
    }
    public void partSix(){
    }
    public void partSeven(){
    }
}
