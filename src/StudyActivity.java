public abstract class StudyActivity {
    private String name;
    private int ects;

public StudyActivity(String name, int ects) {
        this.name = name;
        this.ects = ects;
}

public String getName() {
    return name;
}

    public int getEcts() {
        return ects;
    }
}
