public class Visitor extends Person {
    private String membershipId;
    private boolean hasTicket;

    public Visitor() {}

    public Visitor(String IDCardNumber, String name, int age, String gender, String phone, String membershipId, boolean hasTicket) {
        super(IDCardNumber, name, age, gender, phone);
        this.membershipId = membershipId;
        this.hasTicket = hasTicket;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public boolean isHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Membership ID: " + membershipId + ", Has Ticket: " + hasTicket);
    }
}
