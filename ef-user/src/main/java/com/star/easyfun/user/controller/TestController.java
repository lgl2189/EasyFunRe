package com.star.easyfun.user.controller;

import com.star.easyfun.common.pojo.dto.Result;
import com.star.easyfun.common.util.ResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 20 17:55
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    @GetMapping("/get")
    public Result test() {
        return ResultUtil.success_10000(LocalDateTime.now(),"测试成功");
    }

    @PostMapping("/post")
    public Result testPost(@RequestBody String body) {
        System.out.println(body);
        return ResultUtil.success_10000(LocalDateTime.now(),"测试成功");
    }
}