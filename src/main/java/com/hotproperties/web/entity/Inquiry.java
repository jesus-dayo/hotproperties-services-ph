package com.hotproperties.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inquiry")
public class Inquiry implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String message;
    @Column(name = "property_name")
    private String propertyName;
    @Column(name = "property_id")
    private long propertyId;
    @Column(name = "last_updated")
    private Date lastUpdated;


    /**
     * @return the id
     */
    public long getId()
    {
        return id;
    }


    /**
     * @param id the id to set
     */
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


    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }


    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }


    /**
     * @return the phone
     */
    public String getPhone()
    {
        return phone;
    }


    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }


    /**
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }


    /**
     * @param message the message to set
     */
    public void setMessage(String message)
    {
        this.message = message;
    }


    /**
     * @return the propertyId
     */
    public long getPropertyId()
    {
        return propertyId;
    }


    /**
     * @param propertyId the propertyId to set
     */
    public void setPropertyId(long propertyId)
    {
        this.propertyId = propertyId;
    }


    public String getPropertyName()
    {
        return propertyName;
    }


    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
    }


    /**
     * @return the lastUpdated
     */
    public Date getLastUpdated()
    {
        return lastUpdated;
    }


    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(Date lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

}
