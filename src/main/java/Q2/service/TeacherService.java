package Q2.service;

import Q2.entity.Teacher;

public interface TeacherService extends PersonService<Teacher> {
    Teacher signUp(String firstName, String lastName, String teacherCode);

}
