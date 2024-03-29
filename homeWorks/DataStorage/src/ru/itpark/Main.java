package ru.itpark;

import ru.itpark.dao.HumansDao;
import ru.itpark.dao.HumansDaoIoImpl;
import ru.itpark.generator.IdGenerator;
import ru.itpark.generator.IdGeneratorInMemoryImpl;
import ru.itpark.models.Human;

public class Main {

    public static void main(String[] args) {
        IdGenerator idGenerator =
                new IdGeneratorInMemoryImpl();
        HumansDao humansDao =
                new HumansDaoIoImpl("humans.txt", idGenerator);

        Human human = humansDao.find(3);

        Human ilmir = new Human("Ilmir", 27);
        Human rustam = new Human("Rustam", 33);
        Human andrey = new Human("Andrey", 24);

        System.out.println(humansDao.save(ilmir));
        System.out.println(humansDao.save(rustam));
        System.out.println(humansDao.save(andrey));

    }
}
