package com.hotproperties.web.converter;

import java.util.function.Function;

import com.hotproperties.web.entity.Location;
import com.hotproperties.web.vo.LocationVO;

public class LocationVOToLocationConverter implements Function<LocationVO,Location>
{

    @Override
    public Location apply(LocationVO vo)
    {
        Location location = new Location();
        location.setId(vo.getId());
        location.setCitymunCode(vo.getCitymunCode());
        location.setCitymunDesc(vo.getCitymunDesc());
        location.setProvCode(vo.getProvCode());
        location.setPsgcCode(vo.getPsgcCode());
        location.setRegDesc(vo.getRegDesc());
        return location;
    }

}
