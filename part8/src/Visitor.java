public class Visitor extends Person {
    private String membershipId;
    private boolean hasTicket;

    // Default constructor
    public Visitor() {}

    // Parameterized constructor to initialize an Employee object
    public Visitor(String IDCardNumber, String name, int age, String gender, String phone, String membershipId, boolean hasTicket) {
        super(IDCardNumber, name, age, gender, phone);
        this.membershipId = membershipId;
        this.hasTicket = hasTicket;
    }

    // Getter method for membership ID
    public String getMembershipId() {
        return membershipId;
    }

    // Setter method for membership ID
    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    // Getter method for ticket
    public boolean isHasTicket() {
        return hasTicket;
    }

    // Setter method for has ticket
    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    // Override the printDetails method to print all details
    @Override
    public void printDetails() {
        // Call the printDetails method from the Person class to print inherited fields
        super.printDetails();
        System.out.println("Membership ID: " + membershipId + ", Has Ticket: " + hasTicket);
    }
}
