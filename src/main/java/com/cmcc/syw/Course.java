package com.cmcc.syw;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;

/**
 * Created by sunyiwei on 2015/10/29.
 */
@Entity
@Table(name = "course")
@OptimisticLocking(type = OptimisticLockType.ALL)
@DynamicUpdate
public class Course {
    public Course() {
    }

    public Course(int version, String name, Gender gender, Name testName) {
        this.version = version;
        this.name = name;
        this.gender = gender;
        this.testName = testName;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "age")
    private int version;

    private String name;

    @Embedded
    private Name testName;

//    @Enumerated(value = EnumType.ORDINAL)
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    private long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    private void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Name getTestName() {
        return testName;
    }

    public void setTestName(Name testName) {
        this.testName = testName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", testName=" + testName +
                ", gender=" + gender +
                '}';
    }
}
