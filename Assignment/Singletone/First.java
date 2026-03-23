public class First {

    private First() {
        System.out.println("Singleton instance created.");
    }

    private static class FirstHelper {
        private static final First INSTANCE = new First();
    }

    public static First getInstance() {
        return FirstHelper.INSTANCE;
    }

    public static void main(String[] args) {

        First singleton1 = First.getInstance();
        First singleton2 = First.getInstance();
    }
}
