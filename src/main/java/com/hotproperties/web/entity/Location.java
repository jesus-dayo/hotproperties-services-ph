package com.hotproperties.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Location")
public class Location
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "psgc_code")
    private String psgcCode;
    @Column(name = "citymun_desc")
    private String citymunDesc;
    @Column(name = "reg_desc")
    private String regDesc;
    @Column(name = "prov_code")
    private String provCode;
    @Column(name = "citymun_code")
    private String citymunCode;


    public long getId()
    {
        return id;
    }


    public void setId(long id)
    {
        this.id = id;
    }


    public String getPsgcCode()
    {
        return psgcCode;
    }


    public void setPsgcCode(String psgcCode)
    {
        this.psgcCode = psgcCode;
    }


    public String getCitymunDesc()
    {
        return citymunDesc;
    }


    public void setCitymunDesc(String citymunDesc)
    {
        this.citymunDesc = citymunDesc;
    }


    public String getRegDesc()
    {
        return regDesc;
    }


    public void setRegDesc(String regDesc)
    {
        this.regDesc = regDesc;
    }


    public String getProvCode()
    {
        return provCode;
    }


    public void setProvCode(String provCode)
    {
        this.provCode = provCode;
    }


    public String getCitymunCode()
    {
        return citymunCode;
    }


    public void setCitymunCode(String citymunCode)
    {
        this.citymunCode = citymunCode;
    }

    
    
}
