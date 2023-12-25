import java.util.*;

class Course{ //Represents the encapsulation of Course essential components
   private String c_title;
    private String c_code;
    private String c_des;
    private int c_cap;
    private String c_shedule;

    private List<Student> registeredStudents;

    public Course(String c_title,String c_code,String c_des,int c_cap,String c_shedule)
    {
        this.c_title=c_title;
        this.c_code=c_code;
        this.c_des=c_des;
        this.c_cap=c_cap;
        this.c_shedule=c_shedule;
        this.registeredStudents=new ArrayList<>();
    }

    public String getC_title() {
        return c_title;
    }

    public void setC_title(String c_title) {
        this.c_title = c_title;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getC_des() {
        return c_des;
    }

    public void setC_des(String c_des) {
        this.c_des = c_des;
    }

    public int getC_cap() {
        return c_cap;
    }

    public void setC_cap(int c_cap) {
        this.c_cap = c_cap;
    }

    public String getC_schedule() {
        return c_shedule;
    }

    public void setC_shedule(String c_shedule) {
        this.c_shedule = c_shedule;
    }

    public int getRegisteredStudents()
    {
        return registeredStudents.size();
    }
    public void addRegisteredStudent(Student student) {
        registeredStudents.add(student);
    }

}
class Student{                //Represents the Student data with registered courses
    private int s_id;
    private String s_name;
    private List<Course> reg_courses;

    public Student(int s_id,String s_name){
        this.s_id=s_id;
        this.s_name=s_name;
        this.reg_courses=new ArrayList<>();

    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public List<Course> getReg_courses() {
        return reg_courses;
    }

    public void setReg_courses(List<Course> reg_courses) {
        this.reg_courses = reg_courses;
    }

    public void registerCourse(Course course)
    {
        if(reg_courses.size()<5)   //Limiting Course Registeration per student
        {
            reg_courses.add(course);
            course.addRegisteredStudent(this);
            System.out.println(s_name+"has registered for "+course.getC_title());
        }
        else{
            System.out.println(s_name+"reached maximum number of registration");
        }
    }

    public  void dropCourse(Course course)
    {
        reg_courses.remove(course);
        System.out.println(s_name+"has dropped course"+course.getC_title());
    }

}

class courseList{    //Represents the list of Available Courses
         private List<Course> avail_course;

         public courseList(List<Course> avail_course){
             this.avail_course=avail_course;
         }
         public void displayCourse(){
             System.out.println("----------Available Courses----------");
             for(Course course:avail_course)
             {
                 System.out.println("Course Code:"+course.getC_code());
                 System.out.println("Course Title:"+course.getC_title());
                 System.out.println("Course Description:"+course.getC_des());
                 System.out.println("Course Capacity:"+(course.getC_cap()-course.getRegisteredStudents()));
                 System.out.println("Course Shedule"+course.getC_schedule());
             }
    }
}




public class Main {
    public static void main(String[] args) {

         //Creating courses
            Course c1=new Course("19MEC2001","Total Quality Management","Learn about quality Management",30,"Mon/Wed:10.00AM");
            Course c2=new Course("20CES2009","Data Structures","Learn About data Structures",10,"Tue/Thu:11.00AM");

            //Creating Course Listing
            List<Course> avail_course=new ArrayList<>();
            avail_course.add(c1);
            avail_course.add(c2);


            courseList c_list=new courseList(avail_course);

            //Creating students
        Student s1 = new Student(1, "John Doe");
        Student s2 = new Student(2, "Jane Smith");

        //Displaying Available Courses
            c_list.displayCourse();

            //Registering courses
            s1.registerCourse(c1);
            s1.registerCourse(c2);

            s2.registerCourse(c2);

            c_list.displayCourse();

            //Course dropping
            s1.dropCourse(c2);

            c_list.displayCourse();

    }
}

















