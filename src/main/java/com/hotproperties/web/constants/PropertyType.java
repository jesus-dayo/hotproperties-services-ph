package com.hotproperties.web.constants;

public enum PropertyType
{

    FEATURED(1, "HOUSE AND LOT"),
    DEVELOPMENT(2, "CONDOMINIUM"),
    FEATUREDUNDERDEV(3,"OFFICE SPACE");

    private PropertyType(Integer key, String value)
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
    
    public static String getValueByKey(int key){
        for(PropertyType cat:PropertyType.values()){
            if(cat.key == key){
                return cat.value;
            }
        }
        return "";
    }
    
}
