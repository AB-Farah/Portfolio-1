public class Student {
    private String name;
    private BachelorProgramme programme;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BachelorProgramme getProgramme() {
        return programme;
    }

    public void setProgramme(BachelorProgramme programme) {
        if (programme == null || programme.getStudent() != this) {
            throw new IllegalArgumentException("Programme must belong to this student");
        }

        if (this.programme != null && this.programme != programme) {
            throw new IllegalArgumentException("Student already has a programme");
        }

        this.programme = programme;
    }
}