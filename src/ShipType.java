public enum ShipType {
    CRUISER(5), DESTROYER(4), BOAT(2);

    private int size;
    //CRUISER = 3, DESTROYER = 2, BOAT = 1

    ShipType(int size) {

        this.size = size;
    }

    public int getSize() {

        return size;
    }
}
