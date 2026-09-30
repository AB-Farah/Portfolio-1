public class StudyProgram {
    private String name;
    private String type;

    public StudyProgram(String name, String type){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name must not be empty");
        }

        if (!"Basic Studies".equals(type) && !"Subject Module".equals(type)){
            throw new IllegalArgumentException("Type must be Basic Studies or Subject Module");
        }
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public String getType(){
        return type;
    }
}
