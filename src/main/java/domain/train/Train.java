package domain.train;

import domain.train.wagon.Locomotive;
import domain.train.wagon.Wagon;

import static com.google.common.base.Preconditions.checkArgument;

public class Train {

    private Node firstNode;
    private Node lastNode;
    private int trainLength;

    private int trainNumber;

    public Train(Locomotive locomotive, int trainNumber) {
        checkArgument(trainNumber >= 0, "The train number must be positive");

        this.trainNumber = trainNumber;

        lastNode = new Node(null, null, firstNode);
        firstNode = new Node(locomotive, lastNode, null);

        trainLength = 1;
        locomotive.setNumber(trainLength);
    }

    public void addWagon(Wagon wagon) {
        checkArgument(wagon.getClass() != Locomotive.class,
                "A train can only have one locomotive");

        Node previous = lastNode;
        previous.setCurrentWagon(wagon);
        lastNode = new Node(null, null, previous);
        previous.setNextWagon(lastNode);

        trainLength++;
        wagon.setNumber(trainLength);
    }

    public void removeLastWagon() {
        final Node previous = lastNode.getPreviousElement();
        lastNode = previous;
        if (previous == null)
            firstNode = null;
        else
            previous.nextWagon = null;
        trainLength--;
    }

    public void addNewLocomotive(Locomotive locomotive) {
        checkArgument(locomotive.getClass() == Locomotive.class,
                "The object is not a locomotive");
        firstNode.setCurrentWagon(locomotive);
        locomotive.setNumber(1);
    }

    public Wagon getWagonByNumber(int number) {
        checkArgument(trainLength >= number, "There is no such wagon number");
        checkArgument(number > 0, "There is no such wagon number");

        Node node = firstNode;
        for (int i = 1; i < number; i++) {
            node = node.getNextWagon();
        }
        return node.getCurrentWagon();
    }

    public int getTrainLength() {
        return trainLength;
    }

    private static class Node {
        private Wagon currentWagon;
        private Node nextWagon;
        private Node previousElement;

        public Node(Wagon currentWagon, Node nextWagon, Node previousElement) {
            this.currentWagon = currentWagon;
            this.nextWagon = nextWagon;
            this.previousElement = previousElement;
        }

        public Wagon getCurrentWagon() {
            return currentWagon;
        }

        public void setCurrentWagon(Wagon currentWagon) {
            this.currentWagon = currentWagon;
        }

        public Node getNextWagon() {
            return nextWagon;
        }

        public void setNextWagon(Node nextWagon) {
            this.nextWagon = nextWagon;
        }

        public Node getPreviousElement() {
            return previousElement;
        }

        public void setPreviousElement(Node previousElement) {
            this.previousElement = previousElement;
        }

    }

}
