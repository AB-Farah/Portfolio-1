import java.util.ArrayList;

public class Project extends StudyActivity {
    private ArrayList<Student> groupedStudents = new ArrayList<>();

    public Project(String name, int ects, StudyProgram ProgramPart) {
        super(name, ects, ProgramPart);
    }

    public boolean hasGroup(Student student) {
        return groupedStudents.contains(student);
    }

    public void registerGroupMember(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student must not be null");
        }

        if (student.getProgramme() == null ||
                !student.getProgramme().hasActivity(this)) {
            throw new IllegalArgumentException(
                    "Student must be registered for the project"
            );
        }

        if (hasGroup(student)) {
            throw new IllegalArgumentException(
                    "Student already belongs to a group for this project"
            );
        }

        groupedStudents.add(student);
    }
}