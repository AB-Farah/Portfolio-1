public class Course extends StudyActivity {
    public Course(String name, int ects){
        super(name, ects);

    }

    @Override
public String toString(){
        return getName();
}

}
