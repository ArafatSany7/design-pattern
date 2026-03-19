class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Hello, I am a person");
    }
}

class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void introduce() {
        System.out.println("Hello, I am a student");
    }
}

class Teacher extends Person {
    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void introduce() {
        System.out.println("Hello, I am a teacher");
    }
}

public class Persons {
    public static void main(String[] args) {
        Person person1 = new Student("Alice", 30);
        Person person2 = new Teacher("Bob", 25);

        // Call the introduce() method for the Student object
        person1.introduce();

        // Call the introduce() method for the Teacher object
        person2.introduce();
    }
}
