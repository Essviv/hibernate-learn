package com.cmcc.syw;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by sunyiwei on 2015/10/29.
 */
@Embeddable
public class Name {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    public Name() {
    }

    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
