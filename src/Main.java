public class Main {
    public static void main(String[] args) {
        StudyProgram basic = new StudyProgram("HumTek", "Basic Studies");
        Course course = new Course("Software Development", 10, basic);
        Project project = new Project("Bachelor Project", 15, basic);

        Student student = new Student("Abdurahman");
        BachelorProgramme programme = new BachelorProgramme(student);

        System.out.println("Activities before registration: " + programme.getActivityCount()); // 0
        System.out.println("Registered before: " + programme.hasActivity(project)); // false

        programme.addActivity(course);
        programme.addActivity(project);

        System.out.println("Activities after registration: " + programme.getActivityCount()); // 2
        System.out.println("Registered after: " + programme.hasActivity(project)); // true
        System.out.println("Programme linked: " + (student.getProgramme() == programme)); // true


        System.out.println("Student: " + programme.getStudent().getName());
        System.out.println("Course: " + course);
        System.out.println("Course ECTS: " + course.getEcts());
        System.out.println("Project: " + project.getName());
        System.out.println("Project ECTS: " + project.getEcts());


        ProjectGroup group = new ProjectGroup(student, "My project", "Adam", project);

        System.out.println("Members before: " + group.getMemberCount());


        Student Helen = new Student("Helen");
        BachelorProgramme HelenProgramme = new BachelorProgramme(Helen);
        HelenProgramme.addActivity(project);

        group.addMember(Helen);

        System.out.println("Members after: " + group.getMemberCount());


        try {
            new ProjectGroup(student, "", "Adam", project);
            System.out.println("FAIL: Empty title accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("Empty title rejected: " + e.getMessage());
        }


        try {
            new ProjectGroup(student, "My project", "", project);
            System.out.println("FAIL: Empty supervisor accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("Empty supervisor rejected: " + e.getMessage());
        }


        try {
            new ProjectGroup(null, "My project", "Adam", project);
            System.out.println("FAIL: Null student accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("Null student rejected: " + e.getMessage());
        }


        try {
            new ProjectGroup(student, "My project", "Adam", null);
            System.out.println("FAIL: Null project accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("Null project rejected: " + e.getMessage());
        }


        try {
            group.addMember(null);
            System.out.println("FAIL: Null member accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("Null member rejected: " + e.getMessage());
        }


        try {
            group.addMember(new Student("No programme"));
            System.out.println("FAIL: Student without programme accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("Missing programme rejected: " + e.getMessage());
        }


        Student thirdStudent = new Student("Sara");
        BachelorProgramme thirdProgramme = new BachelorProgramme(thirdStudent);
        thirdProgramme.addActivity(course);

        try {
            group.addMember(thirdStudent);
            System.out.println("FAIL: Unregistered student accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("Missing registration rejected: " + e.getMessage());
        }

        try {
            group.addMember(Helen);
            System.out.println("FAIL: Duplicate member accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("Duplicate member rejected: " + e.getMessage());
        }


        try {
            new ProjectGroup(student, "Another group", "Adam", project);
            System.out.println("FAIL: Second group accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("Second group rejected: " + e.getMessage());
        }

        System.out.println("Final member count: " + group.getMemberCount());

        System.out.println(basic.getName());
        System.out.println(basic.getType());
        System.out.println(course.getProgramPart().getName());

        System.out.println("Basic Studies ECTS: " + programme.getEctsFor(basic));
        StudyProgram computerScience = new StudyProgram("Computer Science", "Subject Module");

        StudyProgram informatics = new StudyProgram("Informatics", "Subject Module");

        programme.addActivity(new Course("Basic test activity", 85, basic));
        programme.addActivity(new Course("CS test activity", 35, computerScience));
        programme.addActivity(new Course("Informatics test activity", 35, informatics));

        System.out.println(programme.completionStatus(basic, computerScience, informatics));
    }



}