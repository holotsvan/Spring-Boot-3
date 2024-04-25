package com.luv2code.springdemo.mvc.model;

import jakarta.validation.constraints.*;
import org.springframework.web.bind.annotation.InitBinder;

public class Person {
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 characters/digits")
    private String postalCode;

    @NotNull(message = "is required")
    @Pattern(regexp = "[0-9]+",message = "should be used only numbers!")
    @Min(value=0 ,message="must be greater than 0")
    @Max(value=10 ,message="must be less than 10")
    private Integer freePasses;

    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
