package com.hotproperties.web.constants;

public enum StatusType
{

    NEW(1, "new"),
    SOLD(2, "sold"),
    CANCEL(3, "cancel");

    private StatusType(Integer key,String value)
    {
        this.key = key;
        this.value = value;
    }

    private String value;
    private Integer key;


    public String getValue()
    {
        return value;
    }


    public Integer getKey()
    {
        return key;
    }

}
