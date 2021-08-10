public class House {
    private final int nTicks;
    private final int nFloors;
    private final int nElevators;

    House(int nTicks, int nFloors, int nElevators) {
        this.nElevators = nElevators;
        this.nFloors = nFloors;
        this.nTicks = nTicks;
    }

    public int getnElevators() {
        return nElevators;
    }

    public int getnTicks() {
        return nTicks;
    }

    public int getnFloors() {
        return nFloors;
    }
}
