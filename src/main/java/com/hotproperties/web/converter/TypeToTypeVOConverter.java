package com.hotproperties.web.converter;

import java.util.function.Function;

import com.hotproperties.web.entity.Type;
import com.hotproperties.web.vo.TypeVO;

public class TypeToTypeVOConverter implements Function<Type,TypeVO>
{

    @Override
    public TypeVO apply(Type entity)
    {
        TypeVO vo = new TypeVO();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        return vo;
    }

}
