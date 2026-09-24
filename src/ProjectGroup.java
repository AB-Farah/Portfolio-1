import java.util.ArrayList;

public class ProjectGroup {
    private String title;
    private String supervisor;
    private Project project;
    private ArrayList<Student> members;

    public ProjectGroup(Student student, String title,
                        String supervisor, Project project) {
        this.title = title;
        this.supervisor = supervisor;
        this.project = project;
        this.members = new ArrayList<>();
        this.members.add(student);
    }
    public void addMember(Student student) {
        members.add(student);
    }

    public int getMemberCount() {
        return members.size();
    }

}
