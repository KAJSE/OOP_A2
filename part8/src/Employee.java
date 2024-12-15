public class Employee extends Person {
    private String position;
    private double salary;

    // Default constructor
    public Employee() {}

    // Parameterized constructor to initialize an Employee object
    public Employee(String IDCardNumber, String name, int age, String gender, String phone, String position, double salary) {
        // Call the superclass (Person) constructor to initialize inherited fields
        super(IDCardNumber, name, age, gender, phone);
        this.position = position; // Set the employee's position
        this.salary = salary; // Set the employee's salary
    }

    // Getter method for position
    public String getPosition() {
        return position;
    }

    // Setter method for position
    public void setPosition(String position) {
        this.position = position;
    }

    // Getter method for salary
    public double getSalary() {
        return salary;
    }

    // Setter method for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Override the printDetails method to print all details
    @Override
    public void printDetails() {
        // Call the printDetails method from the Person class to print inherited fields
        super.printDetails();
        System.out.println("Position: " + position + ", Salary: " + salary);
    }
}
