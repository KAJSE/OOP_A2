public interface RideInterface {
    // To add a visitor to the queue. It has a parameter of Visitor
    void addVisitorToQueue(Visitor visitor);

    // To remove a visitor from the queue.
    Visitor removeVisitorFromQueue();

    // To print the list of waiting visitors in the queue
    void printQueue();

    // To run the ride for one cycle
    void runOneCycle();

    // To add a visitor to the ride history. It has a parameter of Visitor
    void addVisitorToHistory(Visitor visitor);

    // To check whether the visitor is in the ride history. It has a parameter of Visitor
    boolean checkVisitorFromHistory(Visitor visitor);

    // To return the number of Visitors in the ride history
    int numberOfVisitors();

    // to print the list of visitors who took the rides
    void printRideHistory();
}
