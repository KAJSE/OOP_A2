public abstract class Person {
    private String IDCardNumber;
    private String name;
    private int age;
    private String gender;
    private String phone;

    // Default constructor
    public Person() {}

    // Parameterized constructor to initialize a Person object
    public Person(String IDCardNumber, String name, int age, String gender, String phone) {
        this.IDCardNumber = IDCardNumber; // Set the person's ID card number
        this.name = name; // Set the person's name
        this.age = age; // Set the person's age
        this.gender = gender; // Set the person's gender
        this.phone = phone; // Set the person's phone
    }

    // Getter method for ID card number
    public String getIDCardNumber() {
        return IDCardNumber;
    }

    // Setter method for ID card number
    public void setIDCardNumber(String IDCardNumber) {
        this.IDCardNumber = IDCardNumber;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Setter method for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter method for gender
    public String getGender() {
        return gender;
    }

    // Setter method for gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter method for phone
    public String getPhone() {
        return phone;
    }

    // Setter method for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Print the person detail information
    public void printDetails() {
        System.out.println("IDCardNumber: " + IDCardNumber + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Phone: " + phone);
    }
}
