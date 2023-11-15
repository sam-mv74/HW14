package Q2;

import Q2.entity.Person;
import Q2.entity.Student;
import Q2.entity.Teacher;
import Q2.service.PersonService;
import Q2.service.StudentService;
import Q2.service.TeacherService;
import Q2.util.ApplicationContext;

import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        PersonService personService = ApplicationContext.getPersonService();
        StudentService studentService = ApplicationContext.getStudentService();
        TeacherService teacherService = ApplicationContext.getTeacherService();

        //person sign up
        Person person1 = personService.signUp("person1","person111");
        Person person2 = personService.signUp("person1","person222");

        //person sign up with wrong input
        Person person3 = personService.signUp("person3","");

        //student sign up
        Student student1= studentService.signUp("student1","student111","100");
        Student student2= studentService.signUp("student2","student222","101");

        //teacher sign up
        Teacher teacher1 = teacherService.signUp("teacher1","teacher111","1000");
        Teacher teacher2 = teacherService.signUp("teacher2","teacher222","10001");

        //student update
        student1.setBirthDate(new Date("2020/10/12"));
        studentService.update(student1,1L);

        //student delete
        studentService.delete(3L);

        //student findById
        Student student = studentService.findById(4L);
        System.out.println(student);

        //student loadAll
        List<Student>students = studentService.loadAll();
        for (Student st:students) {
            System.out.println(st);
        }
        //student load
        Student studentLoad = studentService.load(3L);
        System.out.println(studentLoad);

        //student contains
        boolean containsStudent = studentService.contains("student1","student111");
        System.out.println(containsStudent);

    }
}
