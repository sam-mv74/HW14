package Q2.repository.impl;

import Q2.entity.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import Q2.repository.PersonRepository;

import java.util.List;

public class PersonRepositoryImpl<T extends Person> implements PersonRepository<T> {
    private final Session session;

    public PersonRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(T person) {
        session.getTransaction().begin();
        session.save(person);
        session.getTransaction().commit();
    }

    @Override
    public void update(T person, Long id) {
        String hql = "update " + getEntityTableName() + " p set p.birthDate=:birthdate where p.id=:id";
        try {
            session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("birthdate", person.getBirthDate());
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Long id) {
        T person = load(id);
        if (person != null) {
            session.getTransaction().begin();
            session.remove(person);
            session.getTransaction().commit();
        }
    }

    @Override
    public T load(Long id) {
        return session.get(getEntityClass(), id);
    }

    @Override
    public List<T> loadAll() {
        String hql = "select p from " + getEntityTableName() + " p";
        Query<T> query = session.createQuery(hql, getEntityClass());
        return query.list();
    }

    @Override
    public T findById(Long id) {
        String hql = "select p from " + getEntityTableName() + " p where p.id=:id";
        Query<T> query = session.createQuery(hql, getEntityClass());
        query.setParameter("id", id);
        T singleResult = query.getSingleResult();
        return singleResult;
    }

    @Override
    public boolean contains(String firstName, String lastName) {
        String hql = "select count (p) from " + getEntityTableName() + " p where p.firstName = :firstName and p.lastName = :lastName";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return query.getSingleResult() > 0;
    }

    @Override
    public String getEntityTableName() {
        return Person.TABLE_NAME;
    }

    @Override
    public Class<T> getEntityClass() {
        return (Class<T>) Person.class;
    }
}
