import java.util.ArrayList;
import java.util.List;

interface Employees {
    void displayEmployeeInfo();
}

class Tester implements Employees {
    private String testerName;
    private long testerId;
    private String testerPosition;

    public Tester(long testerId, String testerName, String testerPosition) {
        this.testerId = testerId;
        this.testerName = testerName;
        this.testerPosition = testerPosition;
    }

    @Override
    public void displayEmployeeInfo() {
        System.out.println(testerId + " " + testerName + " " + testerPosition);
    }
}

class Designer implements Employees {
    private String designerName;
    private long designerId;
    private String designerPosition;

    public Designer(long designerId, String designerName, String designerPosition) {
        this.designerId = designerId;
        this.designerName = designerName;
        this.designerPosition = designerPosition;
    }

    @Override
    public void displayEmployeeInfo() {
        System.out.println(designerId + " " + designerName + " " + designerPosition);
    }
}

class TeamDirectory implements Employees {
    private String teamName;
    private List<Employees> teamList;

    public TeamDirectory(String teamName) {
        this.teamName = teamName;
        this.teamList = new ArrayList<>();
    }

    @Override
    public void displayEmployeeInfo() {
        System.out.println("Team Directory: " + teamName);
        for (Employees emp : teamList) {
            emp.displayEmployeeInfo();
        }
    }

    public void addEmployee(Employees emp) {
        teamList.add(emp);
    }

    public void removeEmployee(Employees emp) {
        teamList.remove(emp);
    }
}


public class Employee {
    public static void main(String[] args) {

        Tester tester1 = new Tester(300, "Emma Watson", "Lead Tester");
        Tester tester2 = new Tester(301, "Henry Cavill", "Junior Tester");

        Designer designer1 = new Designer(400, "Scarlett Johansson", "Senior Designer");

        TeamDirectory teamDirectory = new TeamDirectory("Quality Team");

        teamDirectory.addEmployee(tester1);
        teamDirectory.addEmployee(tester2);
        teamDirectory.addEmployee(designer1);

        teamDirectory.displayEmployeeInfo();
    }
}
