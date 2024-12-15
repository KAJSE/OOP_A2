import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor visitor1, Visitor visitor2) {
        // First, compare by age. Integer.compare ensures a proper comparison of integers.
        int ageComparison = Integer.compare(visitor1.getAge(), visitor2.getAge());

        // If the ages are equal, compare by name
        if (ageComparison == 0) {
            // compareTo is used to compare names lexicographically (alphabetically)
            return visitor1.getName().compareTo(visitor2.getName());
        }

        // If ages are not equal, return the result of the age comparison
        return ageComparison;
    }
}