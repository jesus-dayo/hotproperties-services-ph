package com.hotproperties.web.base.service;

import java.util.List;

public interface BaseService<T,R>
{

    public <S extends R> S save(T vo);
    public List<R> saveAll(List<T> list);
    public List<R> findAll();

}
