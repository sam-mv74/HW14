package Q2.util;

import Q2.repository.StudentRepository;
import Q2.repository.TeacherRepository;
import Q2.repository.impl.StudentRepositoryImpl;
import Q2.repository.impl.TeacherRepositoryImpl;
import org.hibernate.Session;
import Q2.repository.PersonRepository;
import Q2.repository.impl.PersonRepositoryImpl;
import Q2.service.PersonService;
import Q2.service.StudentService;
import Q2.service.TeacherService;
import Q2.service.impl.PersonServiceImpl;
import Q2.service.impl.StudentServiceImpl;
import Q2.service.impl.TeacherServiceImpl;

public class ApplicationContext {
    private static  Session SESSION;
    private static final PersonRepository PERSON_REPOSITORY;
    private static final StudentRepository STUDENT_REPOSITORY;
    private static final TeacherRepository TEACHER_REPOSITORY;
    private static final PersonService PERSON_SERVICE;
    private static final StudentService STUDENT_SERVICE;
    private static final TeacherService TEACHER_SERVICE;

    static{
        SESSION =SessionFactoryProvider.getSessionFactory().openSession();
        PERSON_REPOSITORY =new PersonRepositoryImpl(SESSION);
        STUDENT_REPOSITORY =new StudentRepositoryImpl(SESSION);
        TEACHER_REPOSITORY =new TeacherRepositoryImpl(SESSION);

        PERSON_SERVICE =new PersonServiceImpl(PERSON_REPOSITORY);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY);
        TEACHER_SERVICE = new TeacherServiceImpl(TEACHER_REPOSITORY);
    }

    public static PersonService getPersonService() {
        return PERSON_SERVICE;
    }

    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }

    public static TeacherService getTeacherService() {
        return TEACHER_SERVICE;
    }
}
