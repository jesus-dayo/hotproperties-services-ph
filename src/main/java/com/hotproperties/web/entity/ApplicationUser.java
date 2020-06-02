package com.hotproperties.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Application_User")
public class ApplicationUser
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username; 
    private String password;
    private String status;
    private int deleted;
    @Column(name="last_created")
    private Date createdDt;
    @Column(name="last_updated")
    private Date udpatedDt;


    public long getId()
    {
        return id;
    }


    public void setId(long id)
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getUsername()
    {
        return username;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }


    public String getPassword()
    {
        return password;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }


    public String getStatus()
    {
        return status;
    }


    public void setStatus(String status)
    {
        this.status = status;
    }


    public int getDeleted()
    {
        return deleted;
    }


    public void setDeleted(int deleted)
    {
        this.deleted = deleted;
    }


    public Date getCreatedDt()
    {
        return createdDt;
    }


    public void setCreatedDt(Date createdDt)
    {
        this.createdDt = createdDt;
    }


    public Date getUdpatedDt()
    {
        return udpatedDt;
    }


    public void setUdpatedDt(Date udpatedDt)
    {
        this.udpatedDt = udpatedDt;
    }

}
