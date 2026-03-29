class Smartphone {

    private String brand;
    private String model;
    private boolean hasFrontCamera;
    private boolean hasWirelessCharging;
    private boolean hasExpandableStorage;

    private Smartphone(SmartphoneBuilder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.hasFrontCamera = builder.hasFrontCamera;
        this.hasWirelessCharging = builder.hasWirelessCharging;
        this.hasExpandableStorage = builder.hasExpandableStorage;
    }

    public static class SmartphoneBuilder {

        private final String brand;
        private final String model;
        private boolean hasFrontCamera = false;
        private boolean hasWirelessCharging = false;
        private boolean hasExpandableStorage = false;

        public SmartphoneBuilder(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public SmartphoneBuilder setFrontCamera(boolean hasFrontCamera) {
            this.hasFrontCamera = hasFrontCamera;
            return this;
        }

        public SmartphoneBuilder setWirelessCharging(boolean hasWirelessCharging) {
            this.hasWirelessCharging = hasWirelessCharging;
            return this;
        }

        public SmartphoneBuilder setExpandableStorage(boolean hasExpandableStorage) {
            this.hasExpandableStorage = hasExpandableStorage;
            return this;
        }

        public Smartphone build() {
            return new Smartphone(this);
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean hasFrontCamera() {
        return hasFrontCamera;
    }

    public boolean hasWirelessCharging() {
        return hasWirelessCharging;
    }

    public boolean hasExpandableStorage() {
        return hasExpandableStorage;
    }
}

public class Phones {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone.SmartphoneBuilder("BrandX", "ModelY")
                .setFrontCamera(true)
                .setWirelessCharging(true)
                .setExpandableStorage(true)
                .build();

        System.out.println("Brand: " + phone.getBrand());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Has front camera: " + phone.hasFrontCamera());
        System.out.println("Has wireless charging: " + phone.hasWirelessCharging());
        System.out.println("Has expandable storage: " + phone.hasExpandableStorage());
    }
}
