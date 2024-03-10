package com.gorbatko.books.converter;

import com.opencsv.bean.AbstractBeanField;
import org.apache.commons.lang3.StringUtils;

public class IntegerConverter extends AbstractBeanField<Integer, String> {

    @Override
    protected Object convert(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        } else if (StringUtils.isNumeric(value)) {
            return Integer.parseInt(value);
        } else {
            return 0;
        }
    }
}
