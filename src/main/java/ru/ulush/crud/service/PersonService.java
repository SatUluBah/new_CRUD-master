package ru.ulush.crud.service;

import ru.ulush.crud.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> index();

    void save(Person person);

    void delete(int id);

    void update(Person person);

    Person show(int id);
}
