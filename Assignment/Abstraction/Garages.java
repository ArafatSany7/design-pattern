
class House {

    private int rooms;
    private int bathrooms;
    private boolean hasGarage;
    private boolean hasSwimmingPool;
    private boolean hasGarden;

    private House(HouseBuilder builder) {
        this.rooms = builder.rooms;
        this.bathrooms = builder.bathrooms;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarden = builder.hasGarden;
    }

    public int getRooms() {
        return rooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public boolean hasGarage() {
        return hasGarage;
    }

    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    public boolean hasGarden() {
        return hasGarden;
    }

    public static class HouseBuilder {

        private final int rooms;
        private final int bathrooms;

        private boolean hasGarage = false;
        private boolean hasSwimmingPool = false;
        private boolean hasGarden = false;

        public HouseBuilder(int rooms, int bathrooms) {
            this.rooms = rooms;
            this.bathrooms = bathrooms;
        }

        public HouseBuilder setHasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;

        }

        public HouseBuilder setHasSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder setHasGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}

public class Garages {

    public static void main(String[] args) {
        House house = new House.HouseBuilder(3, 2)
                .setHasGarage(true)
                .setHasSwimmingPool(true)
                .setHasGarden(true)
                .build();

        System.out.println("House has " + house.getRooms() + " rooms.");
        System.out.println("House has " + house.getBathrooms() + " bathrooms.");
        System.out.println("House has a garage: " + house.hasGarage());
        System.out.println("House has a swimming pool: " + house.hasSwimmingPool());
        System.out.println("House has a garden: " + house.hasGarden());
    }
}
