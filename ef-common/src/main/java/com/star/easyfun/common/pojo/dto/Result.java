package com.star.easyfun.common.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ：Star
 * @description ：    封装Restful请求的响应结果
 * @date ：2026 2月 24 17:01
 */


@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Object data;
    private String status;
    private String message;
    private String timestamp;

    public Result(Object data) {
        this.data = data;
    }
}