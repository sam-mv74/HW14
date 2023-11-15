package Q2.service.impl;

import Q2.entity.Teacher;
import Q2.repository.TeacherRepository;
import Q2.service.TeacherService;

public class TeacherServiceImpl extends PersonServiceImpl<Teacher, TeacherRepository> implements TeacherService {
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        super(teacherRepository);
    }
    @Override
    public Teacher signUp(String firstName, String lastName, String teacherCode) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setTeacherCode(teacherCode);
        personRepository.save(teacher);
        return teacher;
    }
}
