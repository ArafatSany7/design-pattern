
public class Singleton {
    private Singleton() {
    }

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello from the Singleton instance!");
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        if (singleton1 == singleton2) {
            System.out.println("Both references point to the same Singleton instance.");
        } else {
            System.out.println(
                    "The references point to different instances (This should not happen in a correct Singleton implementation).");
        }

        singleton1.showMessage();
    }
}
