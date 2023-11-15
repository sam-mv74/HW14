package Q2.service;

import Q2.entity.Student;

public interface StudentService extends PersonService<Student> {
    Student signUp(String firstName, String lastName, String studentCode);
}
