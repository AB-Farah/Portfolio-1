public abstract class StudyActivity {
    private String name;
    private int ects;
    private StudyProgram programPart;
public StudyActivity(String name, int ects, StudyProgram programPart) {

    if(programPart == null){
        throw new IllegalArgumentException("Program part must not be null");
    }
        this.name = name;
        this.ects = ects;
        this.programPart = programPart;
}

public StudyProgram getProgramPart(){
    return programPart;
}

public String getName() {
    return name;
}

    public int getEcts() {
        return ects;
    }
}
