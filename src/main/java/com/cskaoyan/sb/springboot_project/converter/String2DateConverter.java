package com.cskaoyan.sb.springboot_project.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String value) {

        // 8.19 由于日期有 YYYY-MM-dd HH:mm：SS 的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        try {
            Date parse = simpleDateFormat.parse(value);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
