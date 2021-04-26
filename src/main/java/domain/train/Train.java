package domain.train;

import domain.train.wagon.Locomotive;
import domain.train.wagon.PassengerWagon;
import domain.train.wagon.Wagon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Preconditions.checkArgument;

public class Train {

    private final Logger logger = LoggerFactory.getLogger(Train.class);

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
        checkArgument(!(wagon instanceof Locomotive),
                "A train can only have one locomotive");

        Node previous = lastNode;
        previous.currentWagon = wagon;
        lastNode = new Node(null, null, previous);
        previous.nextWagon = lastNode;

        trainLength++;
        wagon.setNumber(trainLength);

        logger.debug("{} added to {}", wagon, this);
    }

    public void removeLastWagon() {
        checkArgument(trainLength != 1,
                "It is not possible to remove a locomotive from a train");

        lastNode = lastNode.previousWagon;
        lastNode.currentWagon = null;
        lastNode.nextWagon = null;

        trainLength--;
        logger.debug("The last wagon was removed from the {}", this);
    }

    public void addNewLocomotive(Locomotive locomotive) {
        firstNode.setCurrentWagon(locomotive);
        locomotive.setNumber(1);
        logger.debug("Added new {} to {}", locomotive, this);
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

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber=" + trainNumber +
                '}';
    }

    private static class Node {
        private Wagon currentWagon;
        private Node nextWagon;
        private Node previousWagon;

        public Node(Wagon currentWagon, Node nextWagon, Node previousElement) {
            this.currentWagon = currentWagon;
            this.nextWagon = nextWagon;
            this.previousWagon = previousElement;
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

        public Node getPreviousWagon() {
            return previousWagon;
        }

        public void setPreviousWagon(Node previousWagon) {
            this.previousWagon = previousWagon;
        }

    }

}
