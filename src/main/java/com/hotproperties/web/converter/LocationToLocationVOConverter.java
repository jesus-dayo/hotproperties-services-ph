package com.hotproperties.web.converter;

import java.util.function.Function;

import com.hotproperties.web.entity.Location;
import com.hotproperties.web.vo.LocationVO;

public class LocationToLocationVOConverter implements Function<Location, LocationVO>
{

    @Override
    public LocationVO apply(Location entity)
    {
        LocationVO vo = new LocationVO();
        vo.setId(entity.getId());
        vo.setCitymunCode(entity.getCitymunCode());
        vo.setCitymunDesc(entity.getCitymunDesc());
        vo.setProvCode(entity.getProvCode());
        vo.setPsgcCode(entity.getPsgcCode());
        vo.setRegDesc(entity.getRegDesc());
        return vo;
    }

}
