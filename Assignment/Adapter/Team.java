import java.util.ArrayList;
import java.util.List;

interface TeamMember {
    void showMemberDetails();
}

class TeamLead implements TeamMember {
    private long memberId;
    private String name;
    private String role;

    public TeamLead(long memberId, String name, String role) {
        this.memberId = memberId;
        this.name = name;
        this.role = role;
    }

    @Override
    public void showMemberDetails() {
        System.out.println(memberId + " " + name + " " + role);
    }
}

class Analyst implements TeamMember {
    private long memberId;
    private String name;
    private String role;

    public Analyst(long memberId, String name, String role) {
        this.memberId = memberId;
        this.name = name;
        this.role = role;
    }

    @Override
    public void showMemberDetails() {
        System.out.println(memberId + " " + name + " " + role);
    }
}

class ProjectTeam implements TeamMember {
    private String teamName;
    private List<TeamMember> teamMembers;

    public ProjectTeam(String teamName) {
        this.teamName = teamName;
        this.teamMembers = new ArrayList<>();
    }

    @Override
    public void showMemberDetails() {
        System.out.println("Project Team: " + teamName);
        for (TeamMember member : teamMembers) {
            member.showMemberDetails();
        }
    }

    public void addMember(TeamMember member) {
        teamMembers.add(member);
    }

    public void removeMember(TeamMember member) {
        teamMembers.remove(member);
    }
}


public class Team {
    public static void main(String[] args) {
          Analyst analyst1 = new Analyst(201, "Alice Smith", "Data Analyst");
        Analyst analyst2 = new Analyst(202, "Bob Jones", "Business Analyst");
        TeamLead lead1 = new TeamLead(101, "Charlie Brown", "Lead Developer");

        ProjectTeam projectTeam = new ProjectTeam("Data Migration Team");

        projectTeam.addMember(lead1);
        projectTeam.addMember(analyst1);
        projectTeam.addMember(analyst2);

        projectTeam.showMemberDetails();
    }
}
