import java.util.ArrayList;

public class BachelorProgramme {
    private Student student;
    private ArrayList<StudyActivity> activities;

    public BachelorProgramme(Student student){
        this.student = student;
        this.activities = new ArrayList<>();
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
}
