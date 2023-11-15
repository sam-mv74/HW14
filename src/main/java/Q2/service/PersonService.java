package Q2.service;

import Q2.entity.Person;

import java.util.List;

public interface PersonService<T extends Person> {
    T signUp(String firstName, String lastName);

    void save(T person);

    void update(T person, Long id);

    void delete(Long id);

    T load(Long id);

    List<T> loadAll();

    T findById(Long id);

    boolean contains(String firstName, String lastName);
}
