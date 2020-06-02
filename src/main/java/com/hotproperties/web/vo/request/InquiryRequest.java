package com.hotproperties.web.vo.request;

public class InquiryRequest
{

    private long propertyId;
    private String name;
    private String email;
    private String phone;
    private String message;
    private String propertyName;


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


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getPropertyName()
    {
        return propertyName;
    }


    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
    }

}
