package ru.ulush.crud.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ulush.crud.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> index() {
        List<Person> people = entityManager.createQuery("from Person").getResultList();
        return people;
    }

    @Override
    public Person show(int id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void save(Person person) {
       entityManager.persist(person);
    }

    @Override
    public void update(Person updatedPerson) {
        entityManager.merge(updatedPerson);
    }
    @Override
    public void delete(int id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }
}
