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
    public String completionStatus(StudyProgram basic, StudyProgram computerScince, StudyProgram informatics) {
        if (basic == null || computerScince == null || informatics == null) {
            throw new IllegalArgumentException("Study programmes must not be null");
        }

        if (!"Basic Studies".equals(basic.getType())
                || !"Subject Module".equals(computerScince.getType())
                || !"Subject Module".equals(informatics.getType())) {
            throw new IllegalArgumentException(
                    "Expected one basic studies programme and two subject modules"
            );
        }

        if (computerScince == informatics || computerScince.getName().equals(informatics.getName())) {
            throw new IllegalArgumentException(
                    "The two subject modules must be different"
            );
        }


        String problems = "";

        if (getEctsFor(basic) != 110) {
            problems += "Basic studies must contain 110 ECTS.\n";
        }

        if (getEctsFor(computerScince) != 35) {
            problems += computerScince.getName() + " must contain 35 ECTS.\n";
        }

        if (getEctsFor(informatics) != 35) {
            problems += informatics.getName() + " must contain 35 ECTS.\n";
        }

        for (StudyActivity activity : activities) {
            StudyProgram part = activity.getProgramPart();

                if (part != basic && part != computerScince && part != informatics) {
                    problems += "Activity belongs to another programme part: " + activity.getName() + "\n";
                }

                if (activity instanceof Project) {
                    Project project = (Project) activity;

                if (!project.hasGroup(student)) {
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
