package com.hotproperties.web.exception;

public class InvalidPropertyRequest extends Exception
{

    public InvalidPropertyRequest(String message)
    {
        this.message = message;
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String message;
    
    @Override
    public String getMessage()
    {
        return this.message;
    }
}
