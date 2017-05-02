package ru.itpark.dao;

/**
 * CRUD - Create Read Update Delete
 * @param <T>
 */
public interface BaseCrudDao<T> {
    /**
     * Сохранение объекта в хранилище данных
     * @param model объект, который необходимо сохранить
     * @return идентификатор
     */
    int save(T model);

    /**
     * Получить из хранилища модель по его номеру
     * @param id идентификатор модели
     * @return модель
     */
    T find(int id);

    /**
     * Обновление модели. В model новые данные модели с id из model
     * @param model новые данные модели
     */
    void update(T model);

    /**
     * Удаление данных из хранилища по идентификатору
     * @param id идентификатор модели
     */
    void delete(int id);

    /**
     * Достает ВСЕ данные из хранилища
     * @return список людей
     */
    ArrayList<T> findAll();
}