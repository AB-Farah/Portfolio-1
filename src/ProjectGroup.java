import java.util.ArrayList;

public class ProjectGroup {
    private String title;
    private String supervisor;
    private Project project;
    private ArrayList<Student> members;
    private static ArrayList<ProjectGroup> allGroups = new ArrayList<>();   // NEW: shared by all groups

    public ProjectGroup(Student student, String title,
                        String supervisor, Project project) {
        String problems = "";

        if (title == null || title.trim().isEmpty()) {
            problems += "Title must not be empty. ";
        }

        if (supervisor == null || supervisor.trim().isEmpty()) {
            problems += "Supervisor must not be empty. ";
        }

        if (!problems.isEmpty()) {
            throw new IllegalArgumentException(problems);
        }

        if (project == null) {
            throw new IllegalArgumentException("Project must not be null");
        }

        this.title = title;
        this.supervisor = supervisor;
        this.project = project;
        this.members = new ArrayList<>();

        addMember(student);
        allGroups.add(this);                                                 // NEW: register the group
    }

    public static boolean hasGroup(Student student, Project project) {
        for (ProjectGroup group : allGroups) {
            if (group.project == project && group.members.contains(student)) {
                return true;
            }
        }
        return false;
    }

    public void addMember(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student must not be null");
        }

        if (student.getProgramme() == null ||
                !student.getProgramme().hasActivity(project)) {
            throw new IllegalArgumentException(
                    "Student must be registered for the project");
        }

        if (hasGroup(student, project)) {
            throw new IllegalArgumentException(
                    "Student already belongs to a group for this project");
        }

        members.add(student);
    }

    public int getMemberCount() {
        return members.size();
    }
}