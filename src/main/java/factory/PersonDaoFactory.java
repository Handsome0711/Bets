package factory;

import dao.PersonDao;
import dao.PersonDaoImpl;

public class PersonDaoFactory {

    private static PersonDao personDao;

    public static PersonDao getPersonDao() {
        if (personDao == null) {
            personDao = new PersonDaoImpl();
        }
        return personDao;
    }
}
