package Q2.service.impl;

import Q2.entity.Person;
import Q2.repository.PersonRepository;
import Q2.service.PersonService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

public class PersonServiceImpl<T extends Person , R extends PersonRepository<T>>
        implements PersonService<T> {

    public final R personRepository;
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = factory.getValidator();
    public PersonServiceImpl(R personRepository) {
        this.personRepository = personRepository;
    }
    public T signUp(String firstName, String lastName) {
        if(!personRepository.contains(firstName,lastName)) {
            Person person = new Person();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            Set<ConstraintViolation<Person>> violations = validator.validate(person);
            if (violations.isEmpty()){
                personRepository.save((T) person);
            }else {
                for (ConstraintViolation<Person> violation : violations) {
                    System.out.println("error: " + violation.getMessage());
                }
            }
            return (T) person;
        }else {
            return null;
        }
    }

    @Override
    public void save(Person person) {
        personRepository.save((T) person);
    }

    @Override
    public void update(Person person, Long id) {
        personRepository.update((T) person,id);
    }

    @Override
    public void delete(Long id) {
        personRepository.delete(id);
    }

    @Override
    public T load(Long id) {
        return (T) personRepository.load(id);
    }

    @Override
    public List<T> loadAll() {
        return personRepository.loadAll();
    }

    @Override
    public T findById(Long id) {
        return (T) personRepository.findById(id);
    }

    @Override
    public boolean contains(String firstName, String lastName) {
        return personRepository.contains(firstName,lastName);
    }
}
