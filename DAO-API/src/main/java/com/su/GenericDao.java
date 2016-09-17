package com.su;

import java.util.List;

/**
 * Created by bogdan on 17.09.16.
 */
public interface GenericDao<T> {
    List<T> getAll();
    void add(T obj);
    void remove(T obj);
}
