import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectGroupTest {
    @Test
    void RejectsEmptyTitle() {
        StudyProgram basic =
                new StudyProgram("HumTek", "Basic Studies");

        Project project =
                new Project("Bachelor Project", 15, basic);

        Student student =
                new Student("Abdurahman");

        BachelorProgramme programme =
                new BachelorProgramme(student);

        programme.addActivity(project);

        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectGroup(
                        student,
                        "",
                        "Adam",
                        project
                )
        );
    }
    @Test
    void RejectsEmptySupervisor() {
        StudyProgram basic =
                new StudyProgram("HumTek", "Basic Studies");

        Project project =
                new Project("Bachelor Project", 15, basic);

        Student student =
                new Student("Abdurahman");

        BachelorProgramme programme =
                new BachelorProgramme(student);

        programme.addActivity(project);

        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectGroup(
                        student,
                        "My project",
                        "",
                        project
                )
        );
    }
    @Test
    void CreateGroupWithOneMember() {
        StudyProgram basic =
                new StudyProgram("HumTek", "Basic Studies");

        Project project =
                new Project("Bachelor Project", 15, basic);

        Student student =
                new Student("Abdurahman");

        BachelorProgramme programme =
                new BachelorProgramme(student);

        programme.addActivity(project);

        ProjectGroup group =
                new ProjectGroup(
                        student,
                        "My project",
                        "Adam",
                        project
                );

        assertEquals(1, group.getMemberCount());

    }
    @Test
    void RejectStudentNotRegisteredForProject() {
        StudyProgram basic =
                new StudyProgram("HumTek", "Basic Studies");

        Project project =
                new Project("Bachelor Project", 15, basic);

        Student student =
                new Student("Abdurahman");

        BachelorProgramme programme =
                new BachelorProgramme(student);

        // The student is not registered for project
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectGroup(
                        student,
                        "My project",
                        "Adam",
                        project
                )
        );
    }
    @Test
    void RejectsSecondGroupForSameProject() {
        StudyProgram basic =
                new StudyProgram("HumTek", "Basic Studies");

        Project project =
                new Project("Bachelor Project", 15, basic);

        Student student =
                new Student("Abdurahman");

        BachelorProgramme programme =
                new BachelorProgramme(student);

        programme.addActivity(project);

        new ProjectGroup(
                student,
                "First project",
                "Adam",
                project
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectGroup(
                        student,
                        "Second project",
                        "Adam",
                        project
                )
        );
    }
}