package com.hotproperties.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Alert")
public class Alert implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String phone;
    private String message;
    private String status;
    private long propertyId;
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
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
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
