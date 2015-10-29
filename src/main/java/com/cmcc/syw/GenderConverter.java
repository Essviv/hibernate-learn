package com.cmcc.syw;

import javax.persistence.AttributeConverter;

/**
 * Created by sunyiwei on 2015/10/29.
 */
public class GenderConverter implements AttributeConverter<Gender, String> {

    public String convertToDatabaseColumn(Gender attribute) {
        if(attribute==null){
            return null;
        }

        return attribute.getCode();
    }

    public Gender convertToEntityAttribute(String dbData) {
        return Gender.fromCode(dbData);
    }
}
