package com.project.spring_project.services.exceptions;

public class ResourseNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourseNotFoundException(Object id) {
        super("Resourse not found. Id " + id);    
    }
    
}
