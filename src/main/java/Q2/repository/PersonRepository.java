package Q2.repository;

import Q2.entity.Person;

import java.util.List;

public interface PersonRepository<T extends Person> {
    void save(T person);

    void update(T person, Long id);

    void delete(Long id);

    T load(Long id);

    List<T> loadAll();

    T findById(Long id);

    boolean contains(String firstName, String lastName);

    String getEntityTableName();

    Class<T> getEntityClass();
}
