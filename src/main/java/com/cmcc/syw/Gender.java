package com.cmcc.syw;

/**
 * Created by sunyiwei on 2015/10/29.
 */
public enum Gender {
    MALE("M"),
    FEMALE("F");

    private String code;

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static Gender fromCode(String code){
        for (Gender gender : Gender.values()) {
            if(gender.getCode().equalsIgnoreCase(code)){
                return gender;
            }
        }

        return null;
    }
}
