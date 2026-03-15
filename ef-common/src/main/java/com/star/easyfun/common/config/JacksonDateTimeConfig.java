package com.star.easyfun.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ：李冠良
 * @description ：无描述
 * @date ：2025 4月 30 16:17
 */

@Configuration
@RefreshScope
public class JacksonDateTimeConfig {

    private static final JavaTimeModule javaTimeModule = new JavaTimeModule();
    @Value("${easyfun.format.date}")
    private String dateFormat;
    @Value("${easyfun.format.time}")
    private String timeFormat;
    @Value("${easyfun.format.datetime}")
    private String dateTimeFormat;

    @PostConstruct
    public void init() {
        // 初始化格式化器
        // 日期格式化器
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        // 纯时间格式化器（新增）
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timeFormat);
        // 日期时间格式化器
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        // 配置LocalDate
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));
        // 新增：配置LocalTime
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(timeFormatter));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(timeFormatter));
        // 配置LocalDateTime
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(javaTimeModule);
        // 处理旧版 Date 类型
        objectMapper.setDateFormat(new SimpleDateFormat(dateTimeFormat));
        return objectMapper;
    }
}