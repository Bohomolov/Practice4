package train;

import java.util.List;

public class TrainTask {

    public List<Train> trainSort(List<Train> trains) {
        TrainComparator trainComparator = new TrainComparator();
        trains.sort(trainComparator);
        return trains;
    }
}
