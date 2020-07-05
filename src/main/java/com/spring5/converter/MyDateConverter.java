package com.spring5.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器
 * 实现Spring的Converter接口
 */
public class MyDateConverter implements Converter<String, Date> {
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * 自定义日期格式转换器
     *
     * @param source 代表配置文件中的 时间字符串
     * @return 代表转换后的时间类型
     */
    @Override
    public Date convert(String source) {
        Date birthday = null;
        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // 通过依赖注入（DI）的方式 解耦合
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            birthday = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return birthday;
    }
}
