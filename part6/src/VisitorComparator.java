import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor visitor1, Visitor visitor2) {
        int ageComparison = Integer.compare(visitor1.getAge(), visitor2.getAge());

        if (ageComparison == 0) {
            return visitor1.getName().compareTo(visitor2.getName());
        }

        return ageComparison;
    }
}