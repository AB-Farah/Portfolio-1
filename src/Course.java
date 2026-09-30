public class Course extends StudyActivity {
    public Course(String name, int ects, StudyProgram ProgramPart){
        super(name, ects, ProgramPart);

    }

    @Override
public String toString(){
        return getName();
}

}
