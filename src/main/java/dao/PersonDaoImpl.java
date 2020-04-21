package dao;

import db.Storage;
import lib.Dao;
import model.Person;

import java.util.List;

@Dao
public class PersonDaoImpl implements PersonDao {

    @Override
    public void add(Person person) {
        Storage.persons.add(person);
    }

    @Override
    public List<Person> getAll() {
        return Storage.persons;
    }
}
