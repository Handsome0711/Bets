package lib;

import dao.BetDao;
import dao.PersonDao;
import dao.PersonDaoImpl;
import factory.BetDaoFactory;
import factory.PersonDaoFactory;
import model.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class
                        && BetDaoFactory.getBetDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, BetDaoFactory.getBetDao());
                }
                if (field.getType() == PersonDao.class
                        && PersonDaoFactory.getPersonDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, PersonDaoFactory.getPersonDao());
                }
            }
        }
        return instance;
    }
}
