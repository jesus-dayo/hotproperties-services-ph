package com.hotproperties.web.converter;

import java.util.function.Function;

import com.hotproperties.web.entity.Type;
import com.hotproperties.web.vo.TypeVO;

public class TypeVOToTypeConverter implements Function<TypeVO,Type>
{

    @Override
    public Type apply(TypeVO vo)
    {
        Type entity = new Type();
        entity.setId(vo.getId());
        entity.setName(vo.getName());
        return entity;
    }

}
