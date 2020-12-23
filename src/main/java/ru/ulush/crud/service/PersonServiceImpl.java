package ru.ulush.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ulush.crud.dao.PersonDAO;
import ru.ulush.crud.model.Person;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonDAO personDAO;

    @Override
    @Transactional
    public List<Person> index() {
        return personDAO.index();
    }

    @Override
    @Transactional
    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    @Transactional
    public void delete(int id) {
        personDAO.delete(id);
    }

    @Override
    @Transactional
    public void update(Person person) {
        personDAO.update(person);
    }

    @Override
    @Transactional
    public Person show(int id) {
        return personDAO.show(id);
    }
}
