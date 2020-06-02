package com.hotproperties.web.constants;

public enum CategoryType
{

    FEATURED(1, "featured"),
    DEVELOPMENT(2, "newdevelopment"),
    FEATUREDUNDERDEV(3,"FeaturedunderDevelopment");

    private CategoryType(Integer key, String value)
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
        for(CategoryType cat:CategoryType.values()){
            if(cat.key == key){
                return cat.value;
            }
        }
        return "";
    }
    
}
