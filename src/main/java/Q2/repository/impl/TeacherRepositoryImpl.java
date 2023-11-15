package Q2.repository.impl;

import Q2.entity.Teacher;
import Q2.repository.TeacherRepository;
import org.hibernate.Session;

public class TeacherRepositoryImpl extends PersonRepositoryImpl<Teacher> implements TeacherRepository {
    public TeacherRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public String getEntityTableName() {
        return Teacher.TABLE_NAME;
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }
}
