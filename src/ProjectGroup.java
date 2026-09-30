import java.util.ArrayList;

public class ProjectGroup {
    private String title;
    private String supervisor;
    private Project project;
    private ArrayList<Student> members;

    public ProjectGroup(Student student, String title,
                        String supervisor, Project project) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }

        if (supervisor == null || supervisor.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Supervisor must not be empty"
            );
        }

        if (project == null) {
            throw new IllegalArgumentException("Project must not be null");
        }

        this.title = title;
        this.supervisor = supervisor;
        this.project = project;
        this.members = new ArrayList<>();

        addMember(student);
    }

    public void addMember(Student student) {
        project.registerGroupMember(student);
        members.add(student);
    }

    public int getMemberCount() {
        return members.size();
    }
}