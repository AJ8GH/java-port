import java.util.ArrayList;
import java.util.List;

class Airport {
    private final List<Plane> hangar;
    private final int DEFAULT_CAPACITY = 50;

    Airport() {
        this.hangar = new ArrayList<>();
    }

    public List<Plane> hangar() {
        return this.hangar;
    }

    public void land(Plane plane) throws CapacityException {
        if (full()) throw new CapacityException();
        hangar.add(plane);
    }

    public void takeOff(Plane plane) throws AirportException {
        if (!contains(plane)) throw new AirportException();
        hangar.remove(plane);
    }

    public boolean contains(Plane plane) {
        return hangar().contains(plane);
    }

    private boolean full() {
        return hangar.size() >= DEFAULT_CAPACITY;
    }
}