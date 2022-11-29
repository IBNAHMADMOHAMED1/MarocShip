package com.example.marocship.dao;

import java.util.List;

public interface Dao<D> {
    D get(long  id);

    List<D> getAll();

    void save(D d);

    void update(D d,String[] params);

    void delete(D d);
}