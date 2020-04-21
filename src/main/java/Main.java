import controller.ConsoleHandler;
import dao.BetDao;
import dao.PersonDao;
import factory.BetDaoFactory;
import factory.PersonDaoFactory;
import lib.Injector;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        handler.handle();

        BetDao betDao = BetDaoFactory.getBetDao();
        System.out.println("All bets: " + betDao.getAll());

        PersonDao personDao = PersonDaoFactory.getPersonDao();
        System.out.println("All persons: " + personDao.getAll());
    }
}
