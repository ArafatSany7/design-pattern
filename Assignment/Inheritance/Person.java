public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Student extends Person {
    private final String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public void displayMajor() {
        System.out.println("Major: " + major);
    }
}

class Main {
    public static void main(String[] args) {
        Student student = new Student("Bob", 25, "Computer Science");
        student.display();
        student.displayMajor();
    }
}
