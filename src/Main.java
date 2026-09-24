public class Main {
    public static void main(String[] args) {
        Course course = new Course("Software Development", 5);
        Project project = new Project("Bachelor Project", 15);
        Student student = new Student("Oday");
        BachelorProgramme programme = new BachelorProgramme(student);
        ProjectGroup group = new ProjectGroup(student, "My project", "Adam", project);
        System.out.println(group.getMemberCount());

        Student secondStudent = new Student("Helen");
        group.addMember(secondStudent);
        System.out.println(group.getMemberCount());

        System.out.println(programme.getActivityCount());
        System.out.println(programme.hasActivity(project));
        programme.addActivity(course);
        programme.addActivity(project);
        System.out.println(programme.hasActivity(project));
        System.out.println(programme.getActivityCount());

        System.out.println(programme.getStudent().getName());

        System.out.println(course.getName());
        System.out.println(course.getEcts());
        System.out.println(course);

        System.out.println(project.getName());
        System.out.println(project.getEcts());
        System.out.println(student.getName());
    }

}



