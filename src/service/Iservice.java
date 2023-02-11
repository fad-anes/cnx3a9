package service;

import java.util.List;

public interface Iservice<T> {
    void insert(T t);
    void delete(T t);
    void update(T t);
    List<T> readall();
    T ReadById(int id);

}
