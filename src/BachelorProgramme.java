import java.util.ArrayList;

public class BachelorProgramme {
    private Student student;
    private ArrayList<StudyActivity> activities;

    public BachelorProgramme(Student student){
        this.student = student;
        this.activities = new ArrayList<>();
        student.setProgramme(this);
    }
    public int getEctsFor(StudyProgram programPart) {
        int total = 0;

        for (StudyActivity activity : activities) {
            if (activity.getProgramPart() == programPart) {
                total += activity.getEcts();
            }
        }

        return total;
    }

    public void addActivity(StudyActivity activity) {
        activities.add(activity);

    }

    public int getActivityCount() {
        return activities.size();
    }

    public boolean hasActivity(StudyActivity activity) {
        return activities.contains(activity);
    }

    public Student getStudent(){
        return student;
    }
    public String completionStatus(StudyProgram basic, StudyProgram subjectModule1, StudyProgram subjectModule2) {
        if (basic == null || subjectModule1 == null || subjectModule2 == null) {
            throw new IllegalArgumentException("Study programmes must not be null");
        }

        if (!"Basic Studies".equals(basic.getType())
                || !"Subject Module".equals(subjectModule1.getType())
                || !"Subject Module".equals(subjectModule2.getType())) {
            throw new IllegalArgumentException(
                    "Expected one basic studies programme and two subject modules"
            );
        }

        if (subjectModule1 == subjectModule2 || subjectModule1.getName().equals(subjectModule2.getName())) {
            throw new IllegalArgumentException(
                    "The two subject modules must be different"
            );
        }


        String problems = "";

        if (getEctsFor(basic) != 110) {
            problems += "Basic studies must contain 110 ECTS.\n";
        }

        if (getEctsFor(subjectModule1) != 35) {
            problems += subjectModule1.getName() + " must contain 35 ECTS.\n";
        }

        if (getEctsFor(subjectModule2) != 35) {
            problems += subjectModule2.getName() + " must contain 35 ECTS.\n";
        }

        for (StudyActivity activity : activities) {
            StudyProgram part = activity.getProgramPart();

                if (part != basic && part != subjectModule1 && part != subjectModule2) {
                    problems += "Activity belongs to another programme part: " + activity.getName() + "\n";
                }

                if (activity instanceof Project) {
                    Project project = (Project) activity;

                if (!ProjectGroup.hasGroup(student, project)) {
                    problems += "Missing group for: " + project.getName() + "\n";
                }
            }
        }

        if (problems.isEmpty()) {
            return "Bachelor programme completed.";
        }

        return "Bachelor programme not completed:\n" + problems;
    }
}
