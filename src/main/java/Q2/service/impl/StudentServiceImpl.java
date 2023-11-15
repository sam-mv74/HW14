package Q2.service.impl;

import Q2.entity.Student;
import Q2.repository.StudentRepository;
import Q2.service.StudentService;

public class StudentServiceImpl extends PersonServiceImpl<Student, StudentRepository> implements StudentService {

    public StudentServiceImpl(StudentRepository studentRepository) {
        super(studentRepository);
    }
    @Override
    public Student signUp(String firstName, String lastName, String studentCode) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setStudentCode(studentCode);
        personRepository.save(student);
        return student;
    }
}
