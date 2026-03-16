public class Persons {
    private String name;
    private int age;

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Persons person = new Persons("Alice", 30);

        person.setName("Bob");
        person.setAge(25);

        System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
    }
}
