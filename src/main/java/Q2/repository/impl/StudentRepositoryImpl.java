package Q2.repository.impl;

import Q2.entity.Student;
import Q2.repository.StudentRepository;
import org.hibernate.Session;

public class StudentRepositoryImpl extends PersonRepositoryImpl<Student> implements StudentRepository {

    public StudentRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public String getEntityTableName() {
        return Student.TABLE_NAME;
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
